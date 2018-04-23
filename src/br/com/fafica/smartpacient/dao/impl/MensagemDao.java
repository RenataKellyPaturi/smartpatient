package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Mensagem;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class MensagemDao extends GenericDAO<Long, Mensagem>{

	public MensagemDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<Mensagem>listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Mensagem> query =  entityManagger.createQuery("SELECT m FROM Mensagem m WHERE m.status = :status",Mensagem.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Mensagem> mensagens = query.getResultList();
		
		return  mensagens;
		
	}
	@SuppressWarnings("unchecked")
	public List<Mensagem> listMensagemPorId( Long id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Mensagem> query =  entityManagger.createQuery("SELECT m FROM Mensagem m WHERE m.id =:mensagem AND m.status=:status",Mensagem.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("id", id);
		List<Mensagem> mensagens = query.getResultList();
		
		return  mensagens;
		
	}

	@SuppressWarnings("unchecked")
	public List<Mensagem>listAllFromPacienteActive(Long id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Mensagem> query =  entityManagger.createQuery("SELECT m FROM Mensagem m WHERE m.status = :status AND paciente_id=:idpaciente",Mensagem.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("idpaciente", id);
		List<Mensagem> mensagens = query.getResultList();
		
		return  mensagens;
		
	}

	@SuppressWarnings("unchecked")
	public Mensagem listForIdWherePaciente(Long id, Long idpaciente) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Mensagem> query =  entityManagger.createQuery("SELECT m FROM Mensagem m WHERE m.status = :status AND id=:id AND paciente_id=:idpaciente",Mensagem.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("id", id);
		query.setParameter("idpaciente", idpaciente);
		Mensagem mensagens = query.getSingleResult();
		
		return  mensagens;
		
	}
}

