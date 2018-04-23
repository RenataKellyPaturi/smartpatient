package br.com.fafica.smartpacient.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fafica.smartpacient.control.FichaAcompanhamentoService;
import br.com.fafica.smartpacient.control.PacienteService;
import br.com.fafica.smartpacient.control.ProfissionalService;
import br.com.fafica.smartpacient.entity.impl.FichaAcompanhamento;
import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.util.GeradorData;

/**
 * Servlet implementation class FichaAcompanhamentoServelet
 */
@WebServlet("/fichaAcompanhamento")
public class FichaAcompanhamentoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FichaAcompanhamentoService fichaControl = new FichaAcompanhamentoService();
	private PacienteService pacienteControl = new PacienteService();
	private ProfissionalService profissionalControl = new ProfissionalService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FichaAcompanhamentoServelet() {
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
		String action = request.getParameter("action");

		switch (action) {

		case "inativar":
			fichaControl.inativar(request.getParameter("id"));
			response.sendRedirect("dashboard/ficha.jsp");
			break;

		case "ativar":
			fichaControl.ativar(request.getParameter("id"));
			response.sendRedirect("dashboard/ficha.jsp");
			break;

		case "procurar":
			fichaControl.listForId(request.getParameter("id"));
			response.sendRedirect("dashboard/ficha.jsp");
			break;

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("entrou no Servlet para -> " + action);
		if (action.equals("cadastrar")) {
			System.out.println("Entrou no action cadastrar");
			Profissional 
			profissional = this.profissionalControl.listForId(request.getSession().getAttribute("profissionalId").toString());
			
			System.out.println("profissional ->" + profissional);
			
			Paciente
			paciente = this.pacienteControl.listForId(request.getSession().getAttribute("pacienteId").toString());
			System.out.println("paciente ->" + paciente);
			
			Date dataatendimento = GeradorData.simpleDateFormat(request.getParameter("dataficha"));

			
			FichaAcompanhamento ficha = new FichaAcompanhamento();
		 	ficha.setObservacao(request.getParameter("observacaoficha"));
			ficha.setData(dataatendimento);
			ficha.setProfissional(profissional);
			ficha.setPaciente(paciente);
			
			
			System.out.println("ficha -> " + ficha);
			fichaControl.create(ficha);
			
			response.sendRedirect("dashboard/ficha.jsp");

		} else if (action.equals("atualizar")) {
			
			Profissional 
			profissional = this.profissionalControl.listForId(request.getSession().getAttribute("profissionalId").toString());
			
			System.out.println("profissional ->" + profissional);
			
			Paciente
			paciente = this.pacienteControl.listForId(request.getSession().getAttribute("pacienteId").toString());
			System.out.println("paciente ->" + paciente);
		
			FichaAcompanhamento ficha= fichaControl.listForId(request.getParameter("id"));
			Date dataatendimento = GeradorData.simpleDateFormat(request.getParameter("dataficha"));

		 	ficha.setObservacao(request.getParameter("observacaoficha"));
			ficha.setData(dataatendimento);
			ficha.setProfissional(profissional);
			ficha.setPaciente(paciente);
			
			fichaControl.update(ficha);
			
			response.sendRedirect("dashboard/ficha.jsp");

		}
	}

}
