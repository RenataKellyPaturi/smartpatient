package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;
@Entity
public class Especialidade implements IEntity {
	
	private Long id;
	private String nome;
	private String tipoCodigo;
	private boolean status;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;         
	}
	@Column(nullable=false)
	public String getNome() {
		return nome;
	}
	@Column(nullable=false)
	public String getTipoCodigo() {
		return tipoCodigo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTipoCodigo(String tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public boolean validadorClasse() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Especialidade() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Especialidade [id=" + id + ", nome=" + nome + ", tipoCodigo=" + tipoCodigo + ", status=" + status + "]";
	}
	
	

}
