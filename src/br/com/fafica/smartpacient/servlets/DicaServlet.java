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
//import javax.ws.rs.core.Response;


import br.com.fafica.smartpacient.control.DicaService;
import br.com.fafica.smartpacient.control.PacienteService;
import br.com.fafica.smartpacient.entity.impl.Dica;
import br.com.fafica.smartpacient.entity.impl.Exercicio;
import br.com.fafica.smartpacient.entity.impl.Paciente;

import com.google.gson.Gson;

/**
 * Servlet implementation class AdministradorServelet
 */

@WebServlet("/dicaServ")
public class DicaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DicaService dicaControl = new DicaService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DicaServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		List<Dica> dicalist;
		Dica dica;
		String json = null ;
		Long idpaciente = null;
		switch(action){
		
			case "listar":
				
				System.out.println("Listar para paciente " + request.getSession().getAttribute("pacienteId").toString());
				idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
				
				
				dicalist = dicaControl.listAllFromPacienteActive(idpaciente);
				
				json= new Gson().toJson(dicalist);				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);				
				
				break;
				
			case "inativar":
				
				long id = Long.parseLong(request.getParameter("id"));
				dicaControl.inativar(id);
	//			

				json= new Gson().toJson("Dica Excluída com sucesso");				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);		
				break;
				
			case "ativar":
				long idA = Long.parseLong(request.getParameter("id"));
				dicaControl.ativar(idA);
				
				break;
				
			case "procurar":
				
				long idp = Long.parseLong(request.getParameter("id"));
				idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
				
				dica = dicaControl.listForId(idp);
				

				json= new Gson().toJson(dica);				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);				
				
				break;
		
			
		}
		

		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		
		if ( action.equals("cadastrar")){
			
			List retornoList = new ArrayList();
			String resposta;
			String json = null ;
		
		try{
						
			String idpaciente = request.getSession().getAttribute("pacienteId").toString();
			
			Dica dica = new Dica();
			dica.setImportancia(request.getParameter("importancia"));
			dica.setTitulo(request.getParameter("titulo"));
			dica.setDescricao(request.getParameter("descricao"));
					 
			PacienteService ps = new PacienteService();
			Paciente paciente = ps.listForId(idpaciente);
		
			System.out.println(paciente);
			
				dica.setPaciente(paciente);
			
			
			dicaControl.create(dica);
			resposta = "true";
			
			response.sendRedirect("dashboard/dica.jsp");
		} catch(Exception e) {
			resposta = e.getMessage();
		}
		
		retornoList.add(0,resposta);
		
//		request.getRequestDispatcher("index.html").forward(request, response);
		json= new Gson().toJson(retornoList);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
		
		} else if (action.equals("atualizar")) {
			String resposta;
			try {
				String idpaciente = request.getSession().getAttribute("pacienteId").toString();
				
				
				Dica dicas = new Dica();
					dicas = this.dicaControl.listForId(Long.parseLong(request.getParameter("id")));
			
					System.out.println(dicas.toString());
					dicas.setImportancia(request.getParameter("importancia"));
					dicas.setTitulo(request.getParameter("titulo"));
					dicas.setDescricao(request.getParameter("descricao"));
					
					System.out.println("----");
				System.out.println(dicas.toString());
					
				PacienteService ps = new PacienteService();
					Paciente paciente = ps.listForId(idpaciente);
				dicas.setPaciente(paciente);
					
					
				System.out.println("----");
					System.out.println(dicas.toString());
						
				
			
				this.dicaControl.update(dicas);
					
				
				response.sendRedirect("dashboard/dica.jsp");

			} catch (Exception e) {
				resposta = e.getMessage();
			}

		} else if (action.equals("buscar")) {
			Dica dicaProcurado = new Dica();

			String json = null;

			dicaProcurado = dicaControl.listForId(Long.parseLong(request.getParameter("id")));

			json = new Gson().toJson(dicaProcurado);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

}