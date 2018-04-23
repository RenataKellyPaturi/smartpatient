package br.com.fafica.smartpacient.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fafica.smartpacient.modelo.interfaces.IEntity;
@Entity
public class Retorno implements IEntity {
	private Long id;
	private Date data;
	private String horario;
	private Paciente paciente;
	private boolean status;

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
	public String getHorario() {
		return horario;
	}

	public boolean isStatus() {
		return status;
	}

	public void setData(Date data) {
		this.data = data;
	}

	 
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public void setId(Long id) {
		this.id = id;
	}
 

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	@ManyToOne
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public boolean validadorClasse() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public String toString() {
		return "Retorno [id=" + id + ", data=" + data + ", horario=" + horario + ", paciente=" + paciente + ", status="
				+ status + "]";
	}
	
	

}