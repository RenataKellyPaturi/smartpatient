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

import br.com.fafica.smartpacient.control.AlimentacaoService;
import br.com.fafica.smartpacient.control.PacienteService;
import br.com.fafica.smartpacient.entity.impl.Alimentacao;
import br.com.fafica.smartpacient.entity.impl.Paciente;

/**
 * Servlet implementation class AlimentacaoServlet
 */
@WebServlet("/alimentacaoServ")
public class AlimentacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlimentacaoService alimentacaoControl = new AlimentacaoService();

	public AlimentacaoServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		List<Alimentacao> alimentacaolist;
		Alimentacao alimentacao;
		String json = null;
		Long idpaciente = null;
		switch (action) {

		case "listar":
			System.out.println("Listar para paciente " + request.getSession().getAttribute("pacienteId").toString());
			idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
			
			alimentacaolist = alimentacaoControl.listAllFromPacienteActive(idpaciente);

			json = new Gson().toJson(alimentacaolist);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;

		case "inativar":
			
			long id = Long.parseLong(request.getParameter("id"));
			alimentacaoControl.inativar(id);
			
			response.sendRedirect("dashboard/alimentacao.jsp");
			
			break;

		case "ativar":
			long idA = Long.parseLong(request.getParameter("id"));
			alimentacaoControl.ativar(idA);
			
			break;

		case "procurar":
			long idP = Long.parseLong(request.getParameter("id"));
			idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
			
			alimentacao = alimentacaoControl.listForId(idP);
			request.setAttribute("alimentacao", alimentacao);

			break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action.equals("cadastrar")) {

			List retornoList = new ArrayList();
			String resposta;
			String json = null;

			try {
				String idpaciente = request.getSession().getAttribute("pacienteId").toString();
				
				Alimentacao alimentacao = new Alimentacao();
				
				alimentacao.setNome(request.getParameter("nome"));
				alimentacao.setDescricao(request.getParameter("descricao"));
				
							
					PacienteService ps = new PacienteService();
					Paciente paciente = ps.listForId(idpaciente);
				
				System.out.println(paciente);
					
						alimentacao.setPaciente(paciente);
					
				alimentacaoControl.create(alimentacao);
				resposta = "true";
				
				response.sendRedirect("dashboard/alimentacao.jsp");

			} catch (Exception e) {
				resposta = e.getMessage();
			}

			retornoList.add(0, resposta);

			json = new Gson().toJson(retornoList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

		} else if (action.equals("atualizar")) {
			String resposta;
			try {
				String idpaciente = request.getSession().getAttribute("pacienteId").toString();
				
				Alimentacao alimentacao = new Alimentacao();
					alimentacao = this.alimentacaoControl.listForId(Long.parseLong(request.getParameter("id")));
			
					System.out.println(alimentacao.toString());
					alimentacao.setNome(request.getParameter("nome"));
					alimentacao.setDescricao(request.getParameter("descricao"));
					
					System.out.println("----");
				System.out.println(alimentacao.toString());
					
				PacienteService ps = new PacienteService();
					Paciente paciente = ps.listForId(idpaciente);
				alimentacao.setPaciente(paciente);
					
					
				System.out.println("----");
					System.out.println(alimentacao.toString());
						
				
			
				this.alimentacaoControl.update(alimentacao);
					
				
				response.sendRedirect("dashboard/alimentacao.jsp");

			} catch (Exception e) {
				resposta = e.getMessage();
			}

		} else if (action.equals("buscar")) {
			Alimentacao alimentacaoProcurada = new Alimentacao();

			String json = null;

			alimentacaoProcurada = alimentacaoControl.listForId(Long.parseLong(request.getParameter("id")));

			json = new Gson().toJson(alimentacaoProcurada);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

}