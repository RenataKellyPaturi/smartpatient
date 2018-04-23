package br.com.fafica.smartpacient.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.fafica.smartpacient.control.PacienteService;
import br.com.fafica.smartpacient.control.ProfissionalService;
import br.com.fafica.smartpacient.entity.impl.Endereco;
import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.entity.impl.PacienteJson;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.util.CalcularIdade;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.Criptografia;
import br.com.fafica.smartpacient.util.GeradorData;
import br.com.fafica.smartpacient.util.ValidaCpf;

/**
 * Servlet implementation class PacienteServelet
 * 
 */
@WebServlet("/paciente")
public class PacienteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacienteService pacienteControl = new PacienteService();
	private ProfissionalService profissionalControl = new ProfissionalService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PacienteServelet() {
		super();

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		List<Paciente> pacientes;
		Paciente paciente;
		String json = null;
		HttpSession session = request.getSession();
		
 
		switch (action) {

		case "listar":

			pacientes = pacienteControl.listAllActive();
			json = new Gson().toJson(pacientes);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			break;

		case "inativar":
			Boolean retorno = pacienteControl.inativar(request.getParameter("id"));
			System.out.println("RETORNO DA INATIVAÇÃO -> " + retorno);
			String encodedURL = response.encodeRedirectURL("dashboard/paciente.jsp");
			response.sendRedirect(encodedURL);

			break;

		case "ativar":
			retorno = pacienteControl.ativar(request.getParameter("id"));

			json = new Gson().toJson(retorno);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			break;

		case "procurar":

			paciente = pacienteControl.listForId(request.getParameter("id"));
			request.setAttribute("paciente", paciente);
			 encodedURL = response.encodeRedirectURL("dashboard/paciente.jsp");
			response.sendRedirect(encodedURL);
			break;

		case "autoComplete":
			String busca = request.getParameter("term");
			System.out.println(busca);
			PrintWriter out = response.getWriter();

			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			List<PacienteJson> nomes = new ArrayList<PacienteJson>();

			pacientes = pacienteControl.listAllActive();

			busca = busca.toLowerCase();
			PacienteJson pacientejson = new PacienteJson();
			
			for (int i = 0; i < pacientes.size(); i++) {
				String pacienteNome = pacientes.get(i).getNome().toLowerCase();

				if (pacienteNome.startsWith(busca)) {
					pacientejson.setNome(pacientes.get(i).getNome());
					pacientejson.setId(pacientes.get(i).getId());
					pacientejson.setStatus(true);
					nomes.add(pacientejson);
					System.out.println(pacientejson);
				}

			}
			
			System.out.println(nomes);
			
			json = new Gson().toJson(nomes);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;

		case "setSessionPaciente":

			paciente = pacienteControl.listForId(request.getParameter("id"));


			session.setAttribute("pacientenome", paciente.getNome());
			session.setAttribute("pacientecpf", paciente.getCpf());
			session.setAttribute("pacienteId", paciente.getId());
			

			Cookie pacientenome = new Cookie("pacientenome", URLEncoder.encode(paciente.getNome(), "UTF-8"));
			response.addCookie(pacientenome);

			Cookie pacientecpf = new Cookie("pacientecpf", paciente.getCpf());
			response.addCookie(pacientecpf);

			Cookie pacienteid = new Cookie("pacienteId", paciente.getId().toString());
			response.addCookie(pacienteid);

			json = new Gson().toJson("Registrado");

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;

		case "getSessionPaciente":
			
			System.out.println("Verificando se paciente ta selecionado");
			PacienteJson pacientejsonG = new PacienteJson();
			
			if (request.getSession().getAttribute("pacienteId") != null) {
				System.out.println("Se houver selecionado, buscará dados nos registros");
				paciente = pacienteControl.listForId(request.getSession().getAttribute("pacienteId").toString());
				pacientejsonG.setId(paciente.getId());
				pacientejsonG.setNome(paciente.getNome());
				pacientejsonG.setStatus(true);
			} else {
				
				session.setAttribute("pacientenome", null);
				session.setAttribute("pacientecpf", null);
				session.setAttribute("pacienteId", null);
				// setting session to expiry in 30 mins
				session.setMaxInactiveInterval(0);
				
				System.out.println("Caso contrário.... retorna nulo");
				paciente = null;
				pacientejsonG = null;
			}

			json = new Gson().toJson(pacientejsonG);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;
		
		case "inactiveSessionPaciente":
			
			System.out.println("Verificando se paciente ta selecionado");

			
				
				session.setAttribute("pacientenome", null);
				session.setAttribute("pacientecpf", null);
				session.setAttribute("pacienteId", null);
				// setting session to expiry in 30 mins
				session.setMaxInactiveInterval(0);
				
				System.out.println("retornando nulo");
				paciente = null;
			 

			json = new Gson().toJson(paciente);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		int cont = 0;
		List retornoList = new ArrayList();
		String resposta;
		String json = null;
System.out.println("Entrou no doPOst---");
		
		if (action.equals("cadastro")) {
			System.out.println("tem a action---");
			try {
				Paciente pac = new Paciente();

				Date dataNascimento = GeradorData.simpleDateFormat(request.getParameter("datanascimento"));

				Profissional profissional = profissionalControl
						.listForId(request.getSession().getAttribute("profissionalId").toString());
				
				System.out.println("Tem profissional logado " + profissional);
				
				
				
				

				Endereco end = new Endereco();
				end.setRua(request.getParameter("ruapaciente"));
				end.setBairro(request.getParameter("bairropaciente"));
				end.setCep(request.getParameter("ceppaciente"));
				end.setComplemento(request.getParameter("complementopaciente"));
				end.setCidade(request.getParameter("cidadepaciente"));
				end.setNumero(request.getParameter("numeropaciente"));
				end.setEstado(request.getParameter("estadopaciente"));

				System.out.println("Tem endereço " + end);
				
				String cpf = request.getParameter("cpfpaciente").replace("-", "").replace(".", "");
System.out.println("CPF - " + cpf);
				if (ValidaCpf.isCPF(cpf)) {
					System.out.println("Valida CPF");
				
						
						if (pacienteControl.verificarCpf(cpf)) {
							System.out.println("Cpf Válido");
							pac.setNome(request.getParameter("nomepaciente"));
							pac.setEndereco(end);
							pac.setEmail(request.getParameter("emailpaciente"));
							pac.setDataNascimento(dataNascimento);
							pac.setContatos(request.getParameter("contatopaciente"));
							pac.setRg(request.getParameter("rgpaciente"));
							pac.setCpf(cpf);
							pac.setProfissional(profissional);

							pac.setSenha(Criptografia.senha(request.getParameter("senhapaciente")));
							
							System.out.println(pac.getDataNascimento());
							
							System.out.println(pac + "\n esse e  o objeto ");

							pacienteControl.create(pac);
							
							response.sendRedirect("dashboard/paciente.jsp");
							
						} else {
							System.out.println("parou no CPF cadastrado");
//							response.sendError(Constants.CPFJACADASTRADO, Constants.CPFINVALIDO_MSG);
							response.sendRedirect("dashboard/paciente.jsp");
						} // fim IF verificacao cpf
 
				} else {
					System.out.println("parou no Validar CPF");
//					response.sendError(Constants.CPFINVALIDO, Constants.CPFINVALIDO_MSG);
					response.sendRedirect("dashboard/paciente.jsp");
				}

				
			} catch (Exception e) {
				resposta = e.getMessage();
				System.out.println(e.getMessage());
			}

		} else if (action.equals("atualizar")) {
				System.out.println("Entrou no atualizar");
			try {
				
				Paciente pac = pacienteControl.listForId(request.getParameter("id"));
					System.out.println("Paciente para editar = " + pac);
				Date dataNascimento = GeradorData.dateStringToSql(request.getParameter("datanascimento"));
				Profissional profissional = profissionalControl.listForId(request.getSession().getAttribute("profissionalId").toString());
					
					System.out.println("Profissional dele - " + profissional);
				
				Endereco end = new Endereco();
				end.setRua(request.getParameter("ruapaciente"));
				end.setBairro(request.getParameter("bairropaciente"));
				end.setCep(request.getParameter("ceppaciente"));
				end.setComplemento(request.getParameter("complementopaciente"));
				end.setCidade(request.getParameter("cidadepaciente"));
				end.setNumero(request.getParameter("numeropaciente"));
				end.setEstado(request.getParameter("estadopaciente"));
					System.out.println("Endereço - " + end);
				String cpf = request.getParameter("cpfpaciente").replace(".", "").replace("-", "");
					System.out.println("CPF " + cpf);
				if (ValidaCpf.isCPF(cpf)) {
				 System.out.println("passou, CPF válido");
					

						
							pac.setNome(request.getParameter("nomepaciente"));
							pac.setEndereco(end);
							pac.setEmail(request.getParameter("emailpaciente"));
							pac.setDataNascimento(dataNascimento);
							pac.setContatos(request.getParameter("contatopaciente"));
							pac.setRg(request.getParameter("rgpaciente"));
							pac.setCpf(cpf.replace(".", "").replace("-", ""));
							pac.setProfissional(profissional);
							
							String alterarsenha = request.getParameter("alterarsenha");
							
							   if (alterarsenha != null) {
								   pac.setSenha(Criptografia.senha(request.getParameter("senhapaciente")));
							   }
							   
							
							
							System.out.println("PACIENTE EDITADO - " + pac);

							pacienteControl.update(pac);
							response.sendRedirect("dashboard/paciente.jsp");		


					 
				} else {
					System.out.println("CPF INVALIDO");
//					response.sendError(Constants.CPFINVALIDO, Constants.CPFINVALIDO_MSG);
//					response.sendRedirect("dashboard/paciente.jsp");
				}
				

			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

}
