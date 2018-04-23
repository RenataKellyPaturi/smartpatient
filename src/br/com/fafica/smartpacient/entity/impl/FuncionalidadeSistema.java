package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
@Table(name = "funcionalidade_sistema")
public class FuncionalidadeSistema implements IEntity{

	private Long id;
	private boolean status;
	private String nome;
	private String descricaoFuncionalidade;
	private String icone;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public boolean isStatus() {
		return status;
	}

	@Column(nullable = false)
	public String getNome() {
		return nome;
	}

	@Column(nullable = false)
	public String getDescricaoFuncionalidade() {
		return descricaoFuncionalidade;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricaoFuncionalidade(String descricaoFuncionalidade) {
		this.descricaoFuncionalidade = descricaoFuncionalidade;
	}

	public FuncionalidadeSistema() {
		super();
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return caminho do icone
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * @param icone the icone to set
	 */
	public void setIcone(String icone) {
		this.icone = icone;
	}

	@Override
	public boolean validadorClasse() {
		if(getDescricaoFuncionalidade()== null ||  getDescricaoFuncionalidade().trim().equals("")){
			return false;
		}else if (getNome()==null || getNome().trim().equals("")){
			return false;
		}else if( getIcone()== null|| getIcone().trim().equals("")){
			return false;
		}else{
		return true;
		}
	}

	
}
