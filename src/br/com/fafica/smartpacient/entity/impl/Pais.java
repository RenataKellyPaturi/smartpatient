package br.com.fafica.smartpacient.entity.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Pais implements IEntity {
	private Long id;
	private String nome;
	private String sigla;
	private boolean status;
	private List<Estado> estados;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pais")
	public List<Estado> getEstados() {
		return estados;
	}

	
	public String getNome() {
		return nome;
	}


	public String getSigla() {
		return sigla;
	}

	public boolean getStatus() {
		return status;
	}
	
	public void setEstados (List<Estado> estados) {
		this.estados = estados;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pais() {
		super();
	}
		
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public boolean validadorClasse() {
		
			return true;
	
	}
}


