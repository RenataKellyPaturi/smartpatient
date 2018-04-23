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


import br.com.fafica.smartpacient.control.MedicamentoService;
import br.com.fafica.smartpacient.entity.impl.Medicamento;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdministradorServelet
 */

@WebServlet("/medicamentoServ")
public class MedicamentoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MedicamentoService medControl = new MedicamentoService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicamentoServlet() {
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
		List<Medicamento> medlist;
		Medicamento med;
		String json = null ;
		
		switch(action){
		
			case "listar":
				
				medlist = medControl.listAllActive();
				
				json= new Gson().toJson(medlist);
				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
				
				break;
				
			case "inativar":
				Boolean retorno = medControl.inativar(request.getParameter("id"));
	//			request.getRequestDispatcher("index.html").forward(request, response);
	//			Não vai ser enviando para outra página, ele vai apenas imprimir um Json, o ajax
	//			do Jquery vai interpretar e me dar o que quero
				json= new Gson().toJson(retorno);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
				break;
				
			case "ativar":
				medControl.ativar(request.getParameter("id"));
	//			request.getRequestDispatcher("index.html").forward(request, response);
				break;
				
			case "procurar":
				med = medControl.listForId(request.getParameter("id"));
//				
				request.setAttribute("med", med);
				request.getRequestDispatcher("medicamento/editar-medicamento.jsp").forward(request, response);
				
				break;
		
			case "buscarPorId":
				med = medControl.listForId(request.getParameter("id"));
				
				json= new Gson().toJson(med);
				
				
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
			
			
			Medicamento med = new Medicamento();
				
			med.setNome(request.getParameter("nome"));
			med.setDescricao(request.getParameter("descricao"));
					 
			
			medControl.create(med);
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
			
			
			Medicamento med = medControl.listForId(request.getParameter("id"));
			med.setNome(request.getParameter("nome"));
			med.setDescricao(request.getParameter("descricao"));
			
			medControl.update(med);
			resposta = "true";
			retornoList.add(0,resposta);
			
			json= new Gson().toJson(retornoList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}else if  (action.equals("buscar")){
			List<Medicamento> retornoList = new ArrayList();
			
			String json = null ;
			
			
			retornoList = medControl.listMedicamentoPorNome(request.getParameter("nome"));
			
			json= new Gson().toJson(retornoList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
	
	
	

}
