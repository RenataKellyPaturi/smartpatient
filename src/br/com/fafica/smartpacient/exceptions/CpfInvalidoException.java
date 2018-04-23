package br.com.fafica.smartpacient.exceptions;

public class CpfInvalidoException extends Exception {

	public CpfInvalidoException() {
		super("Cpf Inválido!");
	}
	
	public CpfInvalidoException(String msg) {
		super(msg);
	}
	
	
	
}
