package br.com.fafica.smartpacient.entity.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;

@Entity
@Table(name = "ficha_acompanhamento")
public class FichaAcompanhamento implements  IEntity {

	private Long id;
	private Date data;
	private String observacao;
	private boolean status;
	private Paciente paciente;
	private Profissional profissional;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	 
	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}

	@Column(nullable = false)
	public String getObservacao() {
		return observacao;
	}

	public boolean isStatus() {
		return status;
	}
 	
	@ManyToOne
	@JoinColumn(name="id_paciente")
	public Paciente getPaciente() {
		return paciente;
	}
	
	@ManyToOne
	@JoinColumn(name="id_profissional")
	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	 
	public void setData(Date data) {
		this.data = data;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
 
	public void setId(Long id) {
		this.id = id;
	}

	public FichaAcompanhamento() {
	}

	@Override
	public boolean validadorClasse() {
		
		if(getData()==null){
			return false;
		}else if (getObservacao()== null || getObservacao().trim().equals("")){
			return false;
		}else{
		return true;
		}
	}


	@Override
	public String toString() {
		return "FichaAcompanhamento [id=" + id + ", data=" + data + ", observacao=" + observacao + ", status=" + status
				+ "]";
	}
 
	
	

}
