package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Exercicio;
import br.com.fafica.smartpacient.entity.impl.Mensagem;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class ExercicioDao extends GenericDAO<Long, Exercicio>{

	public ExercicioDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<Exercicio>listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Exercicio> query =  entityManagger.createQuery("SELECT ex FROM Exercicio ex WHERE ex.status = :status",Exercicio.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Exercicio> exercicios = query.getResultList();
		
		return  exercicios;
		
	}
	@SuppressWarnings("unchecked")
	public List<Exercicio> listExercicioPorNome( String nome) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Exercicio> query =  entityManagger.createQuery("SELECT ex FROM Exercicio ex WHERE ex.nome LIKE :nome AND ex.status=:status",Exercicio.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("nome", "%"+nome+"%");
		List<Exercicio> exercicios = query.getResultList();
		
		return  exercicios;
		
	}
	@SuppressWarnings("unchecked")
	public List<Exercicio>listAllFromPacienteActive(Long id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Exercicio> query =  entityManagger.createQuery("SELECT ex FROM Exercicio ex WHERE ex.status = :status AND paciente_id=:idpaciente",Exercicio.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("idpaciente", id);
		List<Exercicio> exercicios = query.getResultList();
		
		return  exercicios;
		
	}

	@SuppressWarnings("unchecked")
	public Exercicio listForIdWherePaciente(Long id, Long idpaciente) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Exercicio> query =  entityManagger.createQuery("SELECT ex FROM Exercicio ex WHERE ex.status = :status AND id=:id AND paciente_id=:idpaciente",Exercicio.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("id", id);
		query.setParameter("idpaciente", idpaciente);
		Exercicio exercicios = query.getSingleResult();
		
		return  exercicios;
		
	}

}
