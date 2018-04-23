package br.com.fafica.smartpacient.util;

import java.util.regex.Pattern;

public class ValidarEmail {
	/**
	 * Este método verifica se uma {@link String} é um email
	 * 
	 * @param s string que será validada
	 * @return {@link Boolean}
	 */
	public static boolean validEmail(String s)  {
		String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
				+ "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
				+ "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
				+ "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

		return Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE).matcher(s).matches();
	}
	
}
