package br.com.fafica.smartpacient.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fafica.smartpacient.control.MensagemService;
import br.com.fafica.smartpacient.control.PacienteService;
import br.com.fafica.smartpacient.entity.impl.Mensagem;
import br.com.fafica.smartpacient.entity.impl.Paciente;

/**
 * Servlet implementation class MensagemServlet
 */
@WebServlet("/mensagemServlet")
public class MensagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MensagemService mensControl = new MensagemService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MensagemServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		List<Mensagem> menslist;
		Mensagem mens;
		String json = null;
		Long idpaciente = null;
		switch (action) {

		case "listar":
			System.out.println("Listar para paciente " + request.getSession().getAttribute("pacienteId").toString());
			idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
			
			menslist = mensControl.listAllFromPacienteActive(idpaciente);

			json = new Gson().toJson(menslist);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;

		case "inativar":
			
			long id = Long.parseLong(request.getParameter("id"));
			mensControl.inativar(id);
			
			response.sendRedirect("dashboard/mensagem.jsp");
			
			break;

		case "ativar":
			long idA = Long.parseLong(request.getParameter("id"));
			mensControl.ativar(idA);
			// request.getRequestDispatcher("index.html").forward(request,
			// response);
			break;

		case "procurar":
			long idP = Long.parseLong(request.getParameter("id"));
			idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
			
			mens = mensControl.listForId(idP);
			// json= new Gson().toJson(med);
			request.setAttribute("mensagem", mens);

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
		response.setContentType("text/html; charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
			
		if (action.equals("cadastrar")) {

			List retornoList = new ArrayList();
			String resposta;
			String json = null;

			try {
				String idpaciente = request.getSession().getAttribute("pacienteId").toString();
				
				Mensagem mens = new Mensagem();
				mens.setAssunto(request.getParameter("assunto"));
				mens.setMensagem(request.getParameter("mensagem"));
				
					PacienteService ps = new PacienteService();
					Paciente paciente = ps.listForId(idpaciente);
				
				System.out.println(paciente);
					
						mens.setPaciente(paciente);
					
				mensControl.create(mens);
				resposta = "true";
				
				response.sendRedirect("dashboard/mensagem.jsp");

			} catch (Exception e) {
				resposta = e.getMessage();
			}

			retornoList.add(0, resposta);

			// request.getRequestDispatcher("index.html").forward(request,
			// response);
			json = new Gson().toJson(retornoList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

		} else if (action.equals("atualizar")) {
			String resposta;
			try {
				String idpaciente = request.getSession().getAttribute("pacienteId").toString();
				
				
				Mensagem mens = new Mensagem();
					mens = this.mensControl.listForId(Long.parseLong(request.getParameter("id")));
			
					System.out.println(mens.toString());
				mens.setAssunto(request.getParameter("assunto"));
				mens.setMensagem(request.getParameter("mensagem"));
					System.out.println("----");
				System.out.println(mens.toString());
				
				PacienteService ps = new PacienteService();
					Paciente paciente = ps.listForId(idpaciente);
				mens.setPaciente(paciente);
					
					
				System.out.println("----");
					System.out.println(mens.toString());
						
				
			
				this.mensControl.update(mens);
					
				
				response.sendRedirect("dashboard/mensagem.jsp");

			} catch (Exception e) {
				resposta = e.getMessage();
			}

//			response.setContentType("application/json");
//			response.setCharacterEncoding("UTF-8");
//			response.getWriter().write(json);
		} else if (action.equals("buscar")) {
			Mensagem mensagemProcurada = new Mensagem();

			String json = null;

			mensagemProcurada = mensControl.listForId(Long.parseLong(request.getParameter("id")));

			json = new Gson().toJson(mensagemProcurada);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

}