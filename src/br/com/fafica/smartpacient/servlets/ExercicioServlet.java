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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.fafica.smartpacient.control.ExercicioService;
import br.com.fafica.smartpacient.control.MedicamentoService;
import br.com.fafica.smartpacient.control.PacienteService;
import br.com.fafica.smartpacient.control.ProfissionalService;
import br.com.fafica.smartpacient.entity.impl.Exercicio;
import br.com.fafica.smartpacient.entity.impl.Medicamento;
import br.com.fafica.smartpacient.entity.impl.Mensagem;
import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.entity.impl.Profissional;



@WebServlet("/exercicioServ")
public class ExercicioServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	private ExercicioService exercicioControl = new ExercicioService();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExercicioServlet() {
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
		List<Exercicio> exerciciolist;
		Exercicio exercicio;
		String json = null ;
		Long idpaciente = null;
		switch(action){
		
			case "listar":
				
				System.out.println("Listar para paciente " + request.getSession().getAttribute("pacienteId").toString());
				idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
				
				
				exerciciolist = exercicioControl.listAllFromPacienteActive(idpaciente);
				
				json= new Gson().toJson(exerciciolist);				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);				
				
				break;
				
			case "inativar":
				
				long id = Long.parseLong(request.getParameter("id"));
				exercicioControl.inativar(id);
	//			
				response.sendRedirect("dashboard/exercicio.jsp");
				
				break;
				
			case "ativar":
				long idA = Long.parseLong(request.getParameter("id"));
				exercicioControl.ativar(idA);
				
				break;
				
			case "procurar":
				long idp = Long.parseLong(request.getParameter("id"));
				idpaciente = Long.parseLong(request.getSession().getAttribute("pacienteId").toString());
				
				exercicio = exercicioControl.listForId(idp);
				request.setAttribute("exercicio", exercicio);
				
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
			
			Exercicio exercicio = new Exercicio();
			
			exercicio.setNome(request.getParameter("nome"));
			exercicio.setDescricao(request.getParameter("descricao"));
					 
			PacienteService ps = new PacienteService();
			Paciente paciente = ps.listForId(idpaciente);
		
			System.out.println(paciente);
			
				exercicio.setPaciente(paciente);
			
			
			exercicioControl.create(exercicio);
			resposta = "true";
			
			response.sendRedirect("dashboard/exercicio.jsp");
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
				
				
				Exercicio exercicios = new Exercicio();
					exercicios = this.exercicioControl.listForId(Long.parseLong(request.getParameter("id")));
			
					System.out.println(exercicios.toString());
					exercicios.setNome(request.getParameter("nome"));
					exercicios.setDescricao(request.getParameter("descricao"));
					
					System.out.println("----");
				System.out.println(exercicios.toString());
					
				PacienteService ps = new PacienteService();
					Paciente paciente = ps.listForId(idpaciente);
				exercicios.setPaciente(paciente);
					
					
				System.out.println("----");
					System.out.println(exercicios.toString());
						
				
			
				this.exercicioControl.update(exercicios);
					
				
				response.sendRedirect("dashboard/exercicio.jsp");

			} catch (Exception e) {
				resposta = e.getMessage();
			}

		} else if (action.equals("buscar")) {
			Exercicio exercicioProcurado = new Exercicio();

			String json = null;

			exercicioProcurado = exercicioControl.listForId(Long.parseLong(request.getParameter("id")));

			json = new Gson().toJson(exercicioProcurado);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

}