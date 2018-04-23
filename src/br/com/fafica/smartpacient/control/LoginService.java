package br.com.fafica.smartpacient.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginService {
	static HttpServletRequest request;
	private AdministradorService admControl = new AdministradorService();
	static HttpSession session = request.getSession();
	
	public static boolean verificaSessao() {
		 if(session.getAttribute("adm") == null){
		      return true;
		  }
		 return false;
	}
	
}