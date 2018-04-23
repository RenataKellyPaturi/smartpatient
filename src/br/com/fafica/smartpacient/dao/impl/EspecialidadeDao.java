package br.com.fafica.smartpacient.dao.impl;

import br.com.fafica.smartpacient.entity.impl.Especialidade;
import br.com.fafica.smartpacient.entity.impl.Especialidade;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class EspecialidadeDao extends GenericDAO<Long, Especialidade> {

	public EspecialidadeDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	public List<Especialidade> listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException {

		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Especialidade> query =  entityManagger.createQuery("SELECT d FROM Especialidade d WHERE d.status = :status",Especialidade.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Especialidade> especialidade = query.getResultList();

		return especialidade;

	}

	public List<Especialidade> listAllActiveSelect() throws NoSuchAlgorithmException,UnsupportedEncodingException {

		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Especialidade> query =  entityManagger.createQuery("SELECT id, nome FROM Especialidade WHERE status = :status",Especialidade.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Especialidade> especialidade = query.getResultList();
	
		return especialidade;

	}


	public List<Especialidade> listEspecialidadePorNome(String nome) throws NoSuchAlgorithmException,UnsupportedEncodingException{

		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Especialidade> query =  entityManagger.createQuery("SELECT ex FROM Especialidade ex WHERE ex.nome LIKE :nome AND ex.status=:status",Especialidade.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("nome", "%"+nome+"%");
		List<Especialidade> especialidade = query.getResultList();

		return  especialidade;

	}
}
