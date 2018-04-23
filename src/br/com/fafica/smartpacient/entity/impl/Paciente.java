package br.com.fafica.smartpacient.entity.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
public class Paciente extends User implements IEntity {

	private List<FichaAcompanhamento> fichaAcompanhamento;
	private String cpf;
	private Endereco endereco;
	private String rg;
	private Date dataNascimento;
	private String contatos;
	private List<Dica> dicas;
	private Profissional profissional;
	private List<Mensagem> mensagens;
	private List<Retorno> retornos;

	@ManyToOne
	@JoinColumn(name = "id_profissional")
	public Profissional getProfissional() {
		return profissional;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public List<Retorno> getRetornos() {
		return retornos;
	}

	@OneToMany(mappedBy = "paciente",fetch = FetchType.EAGER)
	public List<FichaAcompanhamento> getProntuarios() {
		return fichaAcompanhamento;
	}

	@Column(nullable = false, length = 11)
	public String getCpf() {
		return cpf;
	}

	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}

	@Column(nullable = false)
	public String getRg() {
		return rg;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	
	public String getContatos() {
		return contatos;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public List<Dica> getDicas() {
		return dicas;
	}

	public void setProntuarios(List<FichaAcompanhamento> fichaAcompanhamento) {
		this.fichaAcompanhamento = fichaAcompanhamento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public void setRetornos(List<Retorno> retornos) {
		this.retornos = retornos;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setContatos(String contatos) {
		this.contatos = contatos;
	}

	public void setDicas(List<Dica> dicas) {
		this.dicas = dicas;
	}

	public Paciente() {
	}

	@Override
	public boolean validadorClasse() {
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [fichaAcompanhamento=" + fichaAcompanhamento + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", contatos=" + contatos + ", dicas=" + dicas
				+ ", profissional=" + profissional + ", mensagens=" + mensagens + ", retornos=" + retornos + "]";
	}
  
	

}