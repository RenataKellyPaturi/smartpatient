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
@WebServlet("/login")
public class LoginServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministradorService admControl = new AdministradorService();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServLet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("Servlet" + email + " - " +password);
		Administrador adm = admControl.logarAdministrador(email, password);
		
		System.out.println(adm);

		
		  if(adm != null){
	            HttpSession session = request.getSession();
	            session.setAttribute("adm", adm.getEmail());
	            //setting session to expiry in 30 mins
	            session.setMaxInactiveInterval(30*60);
	            Cookie admName = new Cookie("adm", adm.getEmail());
	            response.addCookie(admName);
	            //Get the encoded URL string
	            String encodedURL = response.encodeRedirectURL("admin/index.jsp");
	            response.sendRedirect(encodedURL);
	        }else{
	        	String encodedURL = response.encodeRedirectURL("admin/login.jsp");
	            response.sendRedirect(encodedURL);
	        }
		  
		
		  
	}

}
