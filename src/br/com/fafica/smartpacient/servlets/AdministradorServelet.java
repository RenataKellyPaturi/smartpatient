/**
 * @author Dieggo e Maicon
 *
 * Servlet usado para alimentação do sistema dinamicamente
 */
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


import br.com.fafica.smartpacient.control.AdministradorService;
import br.com.fafica.smartpacient.entity.impl.Administrador;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdministradorServelet
 */

@WebServlet("/administradorServ")
public class AdministradorServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministradorService admControl = new AdministradorService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorServelet() {
        super();
//        admControl= new AdministradorControlService();
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
		List<Administrador> admlist;
		Administrador adm;
		String json = null ;
		
		switch(action){
		
			case "listar":
				
				admlist = admControl.listAllActive();
				
				json= new Gson().toJson(admlist);
				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
				
				break;
				
			case "inativar":
				Boolean retorno = admControl.inativar(request.getParameter("id"));
	//			request.getRequestDispatcher("index.html").forward(request, response);
	//			Não vai ser enviando para outra página, ele vai apenas imprimir um Json, o ajax
	//			do Jquery vai interpretar e me dar o que quero
				json= new Gson().toJson(retorno);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
				break;
				
			case "ativar":
				admControl.ativar(request.getParameter("id"));
	//			request.getRequestDispatcher("index.html").forward(request, response);
				break;
				
			case "procurar":
				adm = admControl.listForId(request.getParameter("id"));
//				json= new Gson().toJson(adm);
				request.setAttribute("adm", adm);
				request.getRequestDispatcher("admin/administradores.editar.jsp").forward(request, response);
				
				break;
		
			case "buscarPorId":
				adm = admControl.listForId(request.getParameter("id"));
				
				json= new Gson().toJson(adm);
				
				
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
			
			
			Administrador adm = new Administrador();
				
			adm.setNome(request.getParameter("nome"));
			adm.setEmail(request.getParameter("email"));
			adm.setSenha(request.getParameter("senha"));
			adm.setTipoAcesso(request.getParameter("tipoAcesso"));
			
		 
			
			admControl.create(adm);
			resposta = "true";
			
		} catch(Exception e) {
			resposta = e.getMessage();
		}
		
		retornoList.add(0,resposta);
		
//		request.getRequestDispatcher("index.html").forward(request, response);
		json= new Gson().toJson(retornoList);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
		
		}else if  (action.equals("atualizar")){
			List retornoList = new ArrayList();
			String resposta;
			String json = null ;
			
			
			Administrador adm = admControl.listForId(request.getParameter("id"));
			adm.setNome(request.getParameter("nome"));
			adm.setEmail(request.getParameter("email"));
			adm.setSenha(request.getParameter("senha"));
			adm.setTipoAcesso(request.getParameter("tipoAcesso"));
			
			admControl.update(adm);
			resposta = "true";
			retornoList.add(0,resposta);
			
			json= new Gson().toJson(retornoList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}else if  (action.equals("buscar")){
			List<Administrador> retornoList = new ArrayList();
			
			String json = null ;
			
			
			retornoList = admControl.listAdministradorPorNome(request.getParameter("nome"));
			
			json= new Gson().toJson(retornoList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
	
	
	

}
