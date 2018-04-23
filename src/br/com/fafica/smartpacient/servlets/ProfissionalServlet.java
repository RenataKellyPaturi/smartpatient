package br.com.fafica.smartpacient.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fafica.smartpacient.control.ProfissionalService;
import br.com.fafica.smartpacient.entity.impl.Endereco;
import br.com.fafica.smartpacient.entity.impl.Especialidade;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.util.CalcularIdade;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.Criptografia;
import br.com.fafica.smartpacient.util.GeradorSenhas;
import br.com.fafica.smartpacient.util.ValidaCpf;
import br.com.fafica.smartpacient.util.ValidarEmail;


/**
 * Servlet implementation class ProfissionalServlet
 * 
 */
@WebServlet("/Profissional")
public class ProfissionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfissionalService profControl = new ProfissionalService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfissionalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		// String user = request.getParameter("user");
		String action = request.getParameter("action");
		List<Profissional> proflist;
		Profissional prof;
		String json = null;

		List<String> mensagemDeretorno = new ArrayList<String>();

		switch (action) {

			case "listar":
				System.out.println("Vai chamar....");
				proflist = this.profControl.listarTodosAtivos();
				 
	
				json = new Gson().toJson(proflist);
				response.setStatus(200);
					  
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
				break;
	
			case "inativar":
	
				break;
	
			case "ativar":
	
				break;
	
			case "verificarcpf":
				String cpf = request.getParameter("cpf").trim();
				String email = request.getParameter("email").trim();
				// String nome = request.getParameter("nome");
	
				System.out.println("Digitos: " + cpf.length());
	 
	//				System.out.println(Constants.CPFSEMDIGITOS_MSG);
	//				mensagemDeretorno.add(Constants.CPFSEMDIGITOS_MSG);
	//
	//				json = new Gson().toJson(mensagemDeretorno);
	//				
	//				response.setStatus(404);
	
					Profissional profissional = null;
					
				if (!ValidaCpf.isCPF(cpf)) {
			 	
						mensagemDeretorno.add(Constants.CPFINVALIDO_MSG);
	
						json = new Gson().toJson(mensagemDeretorno);
	
	//					response.setStatus(404);
						response.sendError(Constants.CPFINVALIDO, Constants.CPFINVALIDO_MSG);
				}
				
				if (!ValidarEmail.validEmail(email)) {
					mensagemDeretorno.add(Constants.EMAILINVALIDO_MSG);
	
					json = new Gson().toJson(mensagemDeretorno);
	
	//				response.setStatus(404);
					response.sendError(Constants.EMAILINVALIDO, Constants.EMAILINVALIDO_MSG);
					
				}
				
					profissional = this.profControl.verificaCpf(cpf);
					
				if (profissional != null) {
	
					mensagemDeretorno.add(Constants.CPFJACADASTRADO_MSG);
	
					json = new Gson().toJson(mensagemDeretorno);
	
					response.sendError(Constants.CPFJACADASTRADO, Constants.CPFJACADASTRADO_MSG);
	
				}
						
				mensagemDeretorno.add("true");
	
				json = new Gson().toJson(mensagemDeretorno);
				response.setStatus(200);
					  
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
	
				break;
			case "procurar":
	
				break;
				
			case "buscarPorId":
				
				profissional = this.profControl.listForId(request.getParameter("id"));
					json= new Gson().toJson(profissional);
				 
					System.out.println(profissional.getDataNascimento());
				
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
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		RequestDispatcher rd = null;
		Profissional prof;
		String json = null;
		List<String> mensagemDeretorno = new ArrayList<String>();

		switch (action) {
		case "cadastro":

			rd = request.getRequestDispatcher("escolha-funcionalidades.jsp");
			rd.include(request, response);

			break;
		case "verificaRegistro":

			response.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("cadastro-profissional.jsp").forward(request, response);

			break;
		case "cadastroProfissional":
			
			String[] contatosRecebe = request.getParameter("telefoneprofissional").split(",");

			String cpf = request.getParameter("cpfprofissional");
			Date dataNascimento = new Date();
			
			String[] dataMontada = request.getParameter("datanascimentoprofissional").split("-");

			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			Date dataNascimento1 = null;
			try {
				dataNascimento1 = formatador.parse(dataMontada[2] + "-" + dataMontada[1] + "-" + dataMontada[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			System.out.println(CalcularIdade.getIdade(dataNascimento1));
			
			
			try {
				
				if (ValidaCpf.isCPF(cpf)) {
					
					if (CalcularIdade.verificarMaiorIdade(CalcularIdade.getIdade(dataNascimento1))) {
					
							
							prof = this.profControl.verificaCpf(cpf);
		
							if (prof == null) {
									
									prof = new Profissional();
							
							
									
									
									Endereco endereco = new Endereco();
									endereco.setRua(request.getParameter("enderecoprofissional"));
									endereco.setBairro(request.getParameter("bairroprofissional"));
									endereco.setComplemento(request.getParameter("complementoprofissional"));
									endereco.setNumero(request.getParameter("numeroprofissional"));
									endereco.setCep(request.getParameter("cepprofissional"));
									endereco.setCidade(request.getParameter("cidadeprofissional"));
				
									Long espe = Long.parseLong(request.getParameter("especialidadeprofissional"));
				
									Especialidade esp = new Especialidade();
									esp.setId(espe);
				
									List<String> contatos = new ArrayList<String>();
				
									for (int ic = 0; ic < contatosRecebe.length; ic++) {
		//								System.out.println(contatosRecebe[ic]);
										contatos.add(contatosRecebe[ic].trim());
									}
				
									
									prof.setNome(request.getParameter("nomeprofissional"));
									prof.setEmail(request.getParameter("emailprofissional").trim());
									prof.setStatus(Constants.ATIVADO);
									prof.setEndereco(endereco);
									prof.setCpf(cpf);
									prof.setRg(request.getParameter("rgprofissional"));
									prof.setDataNascimento(dataNascimento1);
									prof.setEspecialidade(esp);
									prof.setFuncinalidadeSistemas(null);
									prof.setSenha(Criptografia.senha(request.getParameter("senhaprofissional")));
									prof.setContatos(contatos);
				
									boolean retorno = this.profControl.create(prof);
									System.out.println(prof.toString());
				
									if (retorno == true) {
										response.setStatus(200);
				
										json = new Gson().toJson(prof);
							
									
									} else {
									
										mensagemDeretorno.add("O cadastro não foi realizado");
				
										json = new Gson().toJson(mensagemDeretorno);
										response.sendError(404,Constants.CPFINVALIDO_MSG);
										
									}
		
							 
							} else {
		
								
								mensagemDeretorno.add(Constants.CPFJACADASTRADO_MSG);
		
								json = new Gson().toJson(mensagemDeretorno);
		
								response.sendError(Constants.CPFJACADASTRADO,Constants.CPFJACADASTRADO_MSG);
								
							}
					
					} else {
						
						mensagemDeretorno.add(Constants.IDADEINVALIDA_MSG);
						
						json = new Gson().toJson(mensagemDeretorno);

						response.sendError(Constants.IDADEINVALIDA,Constants.IDADEINVALIDA_MSG);
						
						
					}
				
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				mensagemDeretorno.add(Constants.CPFINVALIDO_MSG);

				json = new Gson().toJson(mensagemDeretorno);
				response.sendError(Constants.CPFINVALIDO,Constants.CPFINVALIDO_MSG);
				
				
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;
			
			case "editarProfissional":
			
			String[] contatRecebe = request.getParameter("telefoneprofissional").split(",");

			String cpfR = request.getParameter("cpfprofissional");
		
			
			String[] dataMontadaR = request.getParameter("datanascimentoprofissional").split("-");

			SimpleDateFormat formatadorR = new SimpleDateFormat("yyyy-MM-dd");
			Date dataNascimento2 = null;
			try {
				dataNascimento2 = formatadorR.parse(dataMontadaR[2] + "-" + dataMontadaR[1] + "-" + dataMontadaR[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			System.out.println(CalcularIdade.getIdade(dataNascimento1));
			
			
			try {
				
				if (ValidaCpf.isCPF(cpfR)) {
					
					if (CalcularIdade.verificarMaiorIdade(CalcularIdade.getIdade(dataNascimento2))) {
					
							
							prof = new Profissional();
							
								prof = this.profControl.listForId(request.getParameter("id"));
		
							if (prof != null) {
									
									Endereco endereco = new Endereco();
									endereco.setRua(request.getParameter("enderecoprofissional"));
									endereco.setBairro(request.getParameter("bairroprofissional"));
									endereco.setComplemento(request.getParameter("complementoprofissional"));
									endereco.setNumero(request.getParameter("numeroprofissional"));
									endereco.setCep(request.getParameter("cepprofissional"));
									endereco.setCidade(request.getParameter("cidadeprofissional"));
									endereco.setEstado(request.getParameter("estadoprofissional"));
				
									Long espe = Long.parseLong(request.getParameter("especialidadeprofissional"));
				
									Especialidade esp = new Especialidade();
									esp.setId(espe);
				
									List<String> contatos = new ArrayList<String>();
				
									for (int ic = 0; ic < contatRecebe.length; ic++) {
		//								System.out.println(contatosRecebe[ic]);
										contatos.add(contatRecebe[ic].trim());
									}
				
									
									prof.setNome(request.getParameter("nomeprofissional"));
									prof.setEmail(request.getParameter("emailprofissional").trim());
									prof.setStatus(Constants.ATIVADO);
									prof.setEndereco(endereco);
									prof.setCpf(cpfR);
									prof.setRg(request.getParameter("rgprofissional"));
									prof.setDataNascimento(dataNascimento2);
									prof.setEspecialidade(esp);
									prof.setFuncinalidadeSistemas(null);
									prof.setSenha(Criptografia.senha(request.getParameter("senhaprofissional")));
									prof.setContatos(contatos);
				
									boolean retorno = this.profControl.update(prof);
									System.out.println(prof.toString());
				
									if (retorno == true) {
										response.setStatus(200);
				
										json = new Gson().toJson(prof);
							
									
									} else {
									
										mensagemDeretorno.add("O cadastro não foi atualizado");
				
										json = new Gson().toJson(mensagemDeretorno);
										response.sendError(404,Constants.CPFINVALIDO_MSG);
										
									}
		
							 
							} else {
		
								
								mensagemDeretorno.add("Registro não encontrado");
		
								json = new Gson().toJson(mensagemDeretorno);
		
								response.sendError(Constants.CPFJACADASTRADO,"Registro não encontrado");
								
							}
					
					} else {
						
						mensagemDeretorno.add(Constants.IDADEINVALIDA_MSG);
						
						json = new Gson().toJson(mensagemDeretorno);

						response.sendError(Constants.IDADEINVALIDA,Constants.IDADEINVALIDA_MSG);
						
						
					}
				
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				mensagemDeretorno.add(Constants.CPFINVALIDO_MSG);

				json = new Gson().toJson(mensagemDeretorno);
				response.sendError(Constants.CPFINVALIDO,Constants.CPFINVALIDO_MSG);
				
				
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;
		}

	}

}
