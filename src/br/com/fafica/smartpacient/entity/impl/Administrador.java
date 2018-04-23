package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Administrador extends User {

	private String tipoAcesso;

	public Administrador() {
		super();
	}

	@Column(nullable = false)
	public String getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	@Override
	public boolean validadorClasse() {
		if(super.validadorClasse() == false){
			return false;
		}else if (getTipoAcesso()== null || getTipoAcesso().trim().equals("")){
			return false;
		}else {
			return true;
		}

	}
	

	@Override
	public String toString() {
		return  "Administrador [tipoAcesso=" + tipoAcesso + "]";
	}

	

}
