package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Dica implements IEntity{

	private Long id;
	private String importancia;
	private String titulo;
	private String descricao;
	private boolean status;
	private Paciente paciente;
	
	public Dica(){
		
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(nullable=false)
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(nullable = false)
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
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
	
	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	@Override
	public String toString() {
		return "Exercicio [id=" + id + ", importancia=" + importancia + ",titulo=" + titulo + ", descricao=" + descricao + ", status=" + status + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	@Override
	public boolean validadorClasse() {
		
		if(getImportancia()==null || getImportancia().trim().equals("")){
			return false;
		}	
		if(getTitulo()== null || getTitulo().trim().equals("") ){
			return false;
		}
		if(getDescricao()==null || getDescricao().trim().equals("")){
			return false;
		}else{
		return true;
		}
	}


	}


	
	
	
	
	

