package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.FichaAcompanhamento;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class FichaAcompanhamentoDao extends GenericDAO<Long, FichaAcompanhamento> {

	public FichaAcompanhamentoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<FichaAcompanhamento> listAllFichasActive()throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		
		TypedQuery<FichaAcompanhamento> query =  entityManagger.createQuery("SELECT f FROM FichaAcompanhamento f WHERE f.status = :status",FichaAcompanhamento.class);
		query.setParameter("status", Constants.ATIVADO);
		List<FichaAcompanhamento> fichaAcompanhamentos = query.getResultList();
		
		return  fichaAcompanhamentos;
		
	}

}
