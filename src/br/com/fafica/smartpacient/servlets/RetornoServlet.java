package br.com.fafica.smartpacient.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fafica.smartpacient.control.PacienteService;
import br.com.fafica.smartpacient.control.RetornoService;
import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.entity.impl.Retorno;
import br.com.fafica.smartpacient.util.Constants;


/**
 * Servlet implementation class RetornoServlet
 */
@WebServlet("/RetornoServlet")
public class RetornoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RetornoService retControl = new RetornoService();

	
	public RetornoServlet() {
		super();
	}

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		List<Retorno> retlist;
		Retorno ret;
		String json = null;

		switch (action) {

		case "listar":

			retlist = retControl.listAllActive();

			json = new Gson().toJson(retlist);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;

		case "inativar":
			Boolean retorno = retControl.inativar(request.getParameter("id"));
			// request.getRequestDispatcher("index.html").forward(request,
			// response);
			// Não vai ser enviando para outra página, ele vai apenas imprimir
			// um Json, o ajax
			// do Jquery vai interpretar e me dar o que quero
			json = new Gson().toJson(retorno);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

			break;

		case "ativar":
			retControl.ativar(request.getParameter("id"));
			// request.getRequestDispatcher("index.html").forward(request,
			// response);
			break;

		case "procurar":
			ret = retControl.listForId(request.getParameter("id"));
			// json= new Gson().toJson(med);
			request.setAttribute("ret", ret);

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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (action.equals("cadastrar")) {

			List retornoList = new ArrayList();
			String resposta;
			String json = null;

			try {

				String idpaciente = request.getParameter("paciente");
				String datarecebe = request.getParameter("data");
				String horario = request.getParameter("horario");
					
				
				String[] dataMontada = datarecebe.split("-");

				SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
				Date dataNascimento1 = null;
				try {
					dataNascimento1 = formatador.parse(dataMontada[2] + "-" + dataMontada[1] + "-" + dataMontada[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ID -> " + idpaciente);
				PacienteService ps = new PacienteService();
				Paciente paciente = ps.listForId(idpaciente);
				
				System.out.println(paciente);
				
//				AQUI ESSE PORRA NÃO TA RETORNANDO --^
				
						Retorno r = new Retorno();
						
						r.setData(dataNascimento1);
						r.setHorario(horario);
						r.setPaciente(paciente);
						r.setStatus(Constants.ATIVADO);
			System.out.println(r);
				this.retControl.create(r);
				resposta = "true";
				
				response.sendRedirect("dashboard/retorno.jsp");
				
			} catch (Exception e) {
				resposta = e.getMessage();
				System.out.println(e);
			}

			retornoList.add(0, resposta);

			// request.getRequestDispatcher("index.html").forward(request,
			// response);
			json = new Gson().toJson(retornoList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

		} else if (action.equals("atualizar")) {
			List retornoList = new ArrayList();
			String resposta;
			String json = null;

			
			String datarecebe = request.getParameter("data");
			String[] dataMontada = datarecebe.split("-");

			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			Date dataRetorno = null;
			try {
				dataRetorno = formatador.parse(dataMontada[2] + "-" + dataMontada[1] + "-" + dataMontada[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Retorno ret = retControl.listForId(request.getParameter("id"));
			ret.setHorario(request.getParameter("horario"));
			ret.setData(dataRetorno);

			retControl.update(ret);
			resposta = "true";
			retornoList.add(0, resposta);

			json = new Gson().toJson(retornoList);


			response.sendRedirect("dashboard/retorno.jsp");
			
		} else if (action.equals("buscar")) {
			List<Retorno> retornoList = new ArrayList();

			String json = null;

			retornoList = retControl.listRetornoPorData(request.getParameter("data"));

			json = new Gson().toJson(retornoList);
			
		
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

}

