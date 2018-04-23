package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Mensagem implements IEntity {
	private Long id;
	private String assunto;
	private String mensagem;
	private boolean status;
	private Paciente paciente;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public boolean getStatus() {
		return status;
	}

	@Column(nullable = false)
	public String getMensagem() {
		return mensagem;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Mensagem() {
		super();
	}
		
	
	public boolean validadorClasse() {
		
		if(getMensagem()== null ||  getMensagem().trim().equals("")){
			return false;
		}else if (getMensagem()==null || getMensagem().trim().equals("")){
			return false;
		}
		return true;

	
	}
}


