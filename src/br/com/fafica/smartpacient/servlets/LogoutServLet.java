package br.com.fafica.smartpacient.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fafica.smartpacient.control.AdministradorService;
import br.com.fafica.smartpacient.entity.impl.Administrador;

/**
 * Servlet implementation class LoginServLet
 */
@WebServlet("/logout")
public class LogoutServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministradorService admControl = new AdministradorService();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServLet() {
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
        System.out.println("Admin="+session.getAttribute("adm"));
        if(session != null){
            session.invalidate();
        }
		  
	        
       String encodedURL = response.encodeRedirectURL("admin/login.jsp");
       response.sendRedirect(encodedURL);
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  
	}

}
