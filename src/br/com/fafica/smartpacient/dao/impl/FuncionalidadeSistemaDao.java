package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.FuncionalidadeSistema;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class FuncionalidadeSistemaDao extends GenericDAO<Long, FuncionalidadeSistema>{

	public FuncionalidadeSistemaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<FuncionalidadeSistema> listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<FuncionalidadeSistema> query =  entityManagger.createQuery("SELECT f FROM FuncionalidadeSistema f WHERE f.status = :status",FuncionalidadeSistema.class);
		query.setParameter("status", Constants.ATIVADO);
		List<FuncionalidadeSistema> funcionalidadeSistemas = query.getResultList();
		
		return  funcionalidadeSistemas;
		
	}

}
