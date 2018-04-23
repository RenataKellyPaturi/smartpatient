package br.com.fafica.smartpacient.entity.impl;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

public class PacienteJson  extends User implements IEntity {

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "PacienteJson [cpf=" + cpf + "]";
	}
	
	
	
}
