package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Alimentacao;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class AlimentacaoDAO extends GenericDAO<Long, Alimentacao>{

	
	public AlimentacaoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public List<Alimentacao>listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Alimentacao> query =  entityManagger.createQuery("SELECT al FROM Alimentacao al WHERE al.status = :status",Alimentacao.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Alimentacao> mensagens = query.getResultList();
		
		return  mensagens;
		
	}
	@SuppressWarnings("unchecked")
	public List<Alimentacao> listMensagemPorId( Long id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Alimentacao> query =  entityManagger.createQuery("SELECT al FROM Alimentacao al WHERE al.id =:alimentacao AND al.status=:status",Alimentacao.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("id", id);
		List<Alimentacao> alimentacao = query.getResultList();
		
		return  alimentacao;
		
	}

	@SuppressWarnings("unchecked")
	public List<Alimentacao>listAllFromPacienteActive(Long id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Alimentacao> query =  entityManagger.createQuery("SELECT al FROM Alimentacao al WHERE al.status = :status AND paciente_id=:idpaciente", Alimentacao.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("idpaciente", id);
		List<Alimentacao> alimentacao = query.getResultList();
		
		return  alimentacao;
		
	}

	@SuppressWarnings("unchecked")
	public Alimentacao listForIdWherePaciente(Long id, Long idpaciente) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Alimentacao> query =  entityManagger.createQuery("SELECT al FROM Alimentacao al WHERE al.status = :status AND id=:id AND paciente_id=:idpaciente",Alimentacao.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("id", id);
		query.setParameter("idpaciente", idpaciente);
		Alimentacao alimentacao = query.getSingleResult();
		
		return  alimentacao;
		
	}
}

