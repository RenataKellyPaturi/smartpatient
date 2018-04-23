package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Mensagem;
import br.com.fafica.smartpacient.entity.impl.Retorno;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class RetornoDao extends GenericDAO<Long, Retorno>{

	public RetornoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<Retorno>listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Retorno> query =  entityManagger.createQuery("SELECT m FROM Retorno m WHERE m.status = :status",Retorno.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Retorno> retornos = query.getResultList();
		
		return  retornos;
		
	}
	@SuppressWarnings("unchecked")
	public List<Retorno> listRetornoPorData( String data) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Retorno> query =  entityManagger.createQuery("SELECT m FROM Retorno m WHERE m.data LIKE :data AND m.status:status",Retorno.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("data", "%"+data+"%");
		List<Retorno> retornos = query.getResultList();
		
		return retornos;
		
	}

	@SuppressWarnings("unchecked")
	public List<Retorno>listAllFromPacienteActive(Long id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Retorno> query =  entityManagger.createQuery("SELECT m FROM Retorno m WHERE m.status = :status AND paciente_id=:idpaciente",Retorno.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("idpaciente", id);
		List<Retorno> retornos = query.getResultList();
		
		return  retornos;
		
	}
}
