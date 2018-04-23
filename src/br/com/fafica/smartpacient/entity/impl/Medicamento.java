package br.com.fafica.smartpacient.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Medicamento implements IEntity {

	private Long id;
	private String nome;
	private String descricao;
	private Integer quantidade;
	private boolean status;
	private FichaAcompanhamento prontuario;

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
	@JoinColumn(name="id_ficha_acompanhamento")
	public FichaAcompanhamento getProntuario() {
		return prontuario;
	}

	public boolean isStatus() {
		return status;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setProntuario(FichaAcompanhamento prontuario) {
		this.prontuario = prontuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medicamento() {
	
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

	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", status=" + status + ", prontuario=" + prontuario + "]";
	}

	 
	
}
