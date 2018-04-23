package br.com.fafica.smartpacient.exceptions;

public class EmailInvalidoException extends Exception {

	public EmailInvalidoException() {
		super("Email Inválido");
	}
	
	public EmailInvalidoException(String msg) {
		super(msg);
	}
}
