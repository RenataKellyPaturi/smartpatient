package br.com.fafica.smartpacient.entity.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Estado implements IEntity {
	private Long 			id;
	private String 			nome;
	private String 			sigla;
	private Pais 			pais;
	private boolean 		status;
	private List<Cidade> 	cidades;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	@ManyToOne
	@JoinColumn(name = "id_pais")
	public Pais getPais() {
		return pais;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "estado")
	public List<Cidade> getCidades() {
		return cidades;
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
	

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}


	public Estado() {
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


