package br.com.fafica.smartpacient.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fafica.smartpacient.entity.impl.Profissional;

/**
 * Servlet implementation class DashboardRequisicao
 */
@WebServlet("/dashboardrequisicao")
public class DashboardRequisicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardRequisicao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 AQUI VOCÊS VÃO FAZER TODAS AS REQUISIÇÕES QUE SÃO DE SUAS AUTORIAS...
//		PEÇO QUE AO FAZEREM QUALQUER ALTERAÇÃO, SUBIR, IMPRETERIVELMENTE
//		LEMBRO QUE, ANTES DE FAZER QUALQUER ALTERAÇÃO, BAIXEM O QUE TA NO SERV REMOTO.
//		VALEU!
		
		response.setCharacterEncoding("UTF-8");
		// String user = request.getParameter("user");
		String action = request.getParameter("action");
		String quem = request.getParameter("quem");
		List<Profissional> proflist;
		Profissional prof;
		String json = null;

		List<String> mensagemDeretorno = new ArrayList<String>();

		switch (quem) {

		case "pacientes":

			break;

		case "MensagemDiretas":

			break;

		
		default: 
			
			break;
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
