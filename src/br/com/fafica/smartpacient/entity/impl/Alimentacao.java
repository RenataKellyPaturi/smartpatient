package br.com.fafica.smartpacient.entity.impl;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Alimentacao implements IEntity{

	private Long id;
	private String nome;
	private String descricao;
	private boolean status;
	private Paciente paciente;
	
	
	
	public Alimentacao(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getId() {
		return id;
	}
	
	@Column(nullable = false)
	public String getNome() {
		return nome;
	}

	@Column(nullable = false)
	public String getDescricao() {
		return descricao;
	}
	@ManyToOne
	public Paciente getPaciente() {
		return paciente;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}
	
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@Override
	public String toString() {
		return "Alimentacao [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status + "]";
	}


	@Override
	public boolean validadorClasse() {
		if(getNome()== null || getNome().trim().equals("") ){
			return false;
		}if(getDescricao()==null || getDescricao().trim().equals("")){
			return false;
		}else{
		return true;
		}
	}
	
	
	
	
	

	
}
