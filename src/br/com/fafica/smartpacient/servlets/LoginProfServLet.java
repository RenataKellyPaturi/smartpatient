package br.com.fafica.smartpacient.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fafica.smartpacient.control.ProfissionalService;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.util.Criptografia;

/**
 * Servlet implementation class LoginServLet
 */
@WebServlet("/loginprof")
public class LoginProfServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfissionalService profControl = new ProfissionalService();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProfServLet() {
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
		
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String password = Criptografia.senha(request.getParameter("senha"));
		
		System.out.println("Servlet" + email + " - " +password + " - " +cpf);
		Profissional prof = profControl.logarProfissional(email, password, cpf);
//		String email, String senha,  String cpf
		System.out.println(prof);

		
		  if(prof != null){
	            HttpSession session = request.getSession();
	            session.setAttribute("prof", prof.getEmail());
	            session.setAttribute("profissionalId", prof.getId());
	            //setting session to expiry in 30 mins
	            session.setMaxInactiveInterval(60*60);
	            Cookie profName = new Cookie("adm", prof.getEmail());
	            response.addCookie(profName);
	            
	            Cookie profId = new Cookie("profissionalId", prof.getId().toString());
	            response.addCookie(profId);
	            
	            //Get the encoded URL string
	            String encodedURL = response.encodeRedirectURL("dashboard/index.jsp");
	            response.sendRedirect(encodedURL);
	        }else{

	        	HttpSession session = request.getSession(false);
	            
	            if(session != null){
	            	session.setAttribute("prof", null);
		            session.setAttribute("profissionalId", null);
		            //setting session to expiry in 30 mins
		            session.setMaxInactiveInterval(0);
	                session.invalidate();
	            }
	        	
	        	String encodedURL = response.encodeRedirectURL("index.jsp");
	            response.sendRedirect(encodedURL);
	        }
		  
		
		  
	}

}
