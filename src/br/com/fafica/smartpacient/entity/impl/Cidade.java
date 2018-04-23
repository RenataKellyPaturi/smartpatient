package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Cidade implements IEntity {
	private Long 	id;
	private String 	nome;
	
	private Estado 	estado;
	private boolean status;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	@ManyToOne
	@JoinColumn(name="id_estado")
	public Estado getEstado() {
		return estado;
	}	
	
	public String getNome() {
		return nome;
	}

	public boolean getStatus() {
		return status;
	}
	

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cidade() {
		super();
	}
		
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean validadorClasse() {
		
			return true;
	
	}
}


