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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;


@Entity
public class Profissional extends User implements IEntity {

	private Especialidade Especialidade;
	private String cpf;
	private String rg;
	private List<String> contatos;
	private Date dataNascimento;
	private Endereco endereco;
	private List<FuncionalidadeSistema> funcinalidadeSistemas;
	private List<Paciente> pacientes;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_especialidade")
	public Especialidade getEspecialidade() {
		return Especialidade;
	}


	@OneToMany(fetch = FetchType.EAGER)
	public List<Paciente> getPaciente() {
		return this.pacientes;
	}
	
	public String getCpf() {
		return cpf;
	}

	@Column(nullable = false, length = 12)
	public String getRg() {
		return rg;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "profissional_contatos", joinColumns = @JoinColumn(name = "id_profissional") )
	@Column(name = "contatos", length = 20)
	public List<String> getContatos() {
		return contatos;
	}

	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public List<FuncionalidadeSistema> getFuncinalidadeSistemas() {
		return funcinalidadeSistemas;
	}
	


	public void setEspecialidade(Especialidade especialidade) {
		Especialidade = especialidade;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setPaciente(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	
	public void setContatos(List<String> contatos) {
		this.contatos = contatos;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setFuncinalidadeSistemas(List<FuncionalidadeSistema> funcinalidadeSistemas) {
		this.funcinalidadeSistemas = funcinalidadeSistemas;
	}

	
	@Override
	public boolean validadorClasse() {
	if(super.validadorClasse()== false){
		return false;
	} else if(getRg()==null || getRg().trim().equals("")){
		return false;
	}else if(getContatos()==null){
		return false;
	}else if(getEndereco()== null){
		return false;
	}else if(getDataNascimento()== null){
		return false;
	}else if (getCpf()==null || getCpf().trim().equals("")){
		return false;
	}else{
		return true;
	}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "["+super.toString() + "] Profissional [Especialidade=" + Especialidade + ", cpf=" + cpf + ", rg=" + rg + ", contatos=" + contatos
				+ ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", funcinalidadeSistemas="
				+ funcinalidadeSistemas + "]";
	}

}
