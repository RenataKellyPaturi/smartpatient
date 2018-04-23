package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

/*
 * Author : Maicon Silva
 * 
 * Esta entidade tem como principio formalizar uma generalizacao.
 */

@MappedSuperclass
public abstract class User implements IEntity{
	
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	private boolean status;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@Column(nullable= false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(nullable= false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(nullable= false)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Column(nullable= false)
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", status=" + status
				+ "]";
	}
	@Override
	public boolean validadorClasse() {
		if (getEmail() == null || getEmail().trim().equals("")) {
			return false;
		} else if (getSenha() == null || getSenha().trim().equals("")) {
			return false;
		} else if (getNome() == null || getNome().trim().equals("")) {
			return false;
		}else{
		return true;
	}
	}

}
