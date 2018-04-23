package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Embeddable
public class Endereco  implements IEntity{


	private String rua;
	private String bairro;
	private String complemento;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;

	@Column(nullable = false)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(nullable = false)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(nullable = false)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Endereco() {
		super();
	}

	@Override
	public boolean validadorClasse() {
		if(getRua()==null || getRua().trim().equals("")){
			return false;
		}else if (getBairro() ==null || getBairro().trim().equals("")){
			return false;
		}else if (getNumero() == null || getNumero().trim().equals("")){
			return false;
		}else if (getCidade() ==null || getCidade().trim().equals("")){
			return false;
		}else if (getCep() == null || getCep().trim().equals("")){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", bairro=" + bairro + ", complemento=" + complemento + ", numero=" + numero
				+ ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	


	
	

}
