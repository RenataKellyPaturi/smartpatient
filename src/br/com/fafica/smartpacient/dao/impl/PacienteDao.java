package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class PacienteDao extends GenericDAO<Long, Paciente>{

	public PacienteDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Paciente> listAllPacienteActive()throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		
		TypedQuery<Paciente> query =  entityManagger.createQuery("SELECT p FROM Paciente p WHERE p.status = :status",Paciente.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Paciente> pacientes = query.getResultList();
		System.out.println("dao - " + pacientes);
		return  pacientes;
		
	}
	
	@SuppressWarnings("unchecked")
	public Paciente buscarPacientePorCpf(String cpf)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Paciente> query = entityManagger.createQuery("SELECT p FROM Paciente p WHERE p.cpf = :cpf ",
				Paciente.class);
		query.setParameter("cpf",cpf );
		Paciente paciente = query.getSingleResult();

		return paciente;

	}
	
	
}
