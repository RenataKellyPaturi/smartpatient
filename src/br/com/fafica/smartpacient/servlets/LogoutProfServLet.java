package br.com.fafica.smartpacient.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fafica.smartpacient.control.ProfissionalService;

/**
 * Servlet implementation class LoginServLet
 */
@WebServlet("/logoutprof")
public class LogoutProfServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfissionalService profControl = new ProfissionalService();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutProfServLet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Logout");
		
		  
		
        //invalidate the session if exists
        HttpSession session = request.getSession(false);
        System.out.println("Prof="+session.getAttribute("prof"));
        if(session != null){
            session.invalidate();
        }
		  
	        
       String encodedURL = response.encodeRedirectURL("index.jsp");
       response.sendRedirect(encodedURL);
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  
	}

}
