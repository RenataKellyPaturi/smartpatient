package br.com.fafica.smartpacient.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia{

	public static String senha(String senha) {
		
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte messageDigest[] = null;
		
		try {
			messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	StringBuilder hexString = new StringBuilder();
	for (byte b : messageDigest) {
	  hexString.append(String.format("%02X", 0xFF & b));
	}
	
	String senhaGerada = hexString.toString();
	
	return senhaGerada;
	}

}
