package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Dica;
import br.com.fafica.smartpacient.entity.impl.Exercicio;
import br.com.fafica.smartpacient.entity.impl.Medicamento;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class DicaDao extends GenericDAO<Long, Dica> {

	public DicaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Dica>listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Dica> query =  entityManagger.createQuery("SELECT d FROM Dica d WHERE d.status = :status",Dica.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Dica> dicas = query.getResultList();
		
		return  dicas;
		
	}
	@SuppressWarnings("unchecked")
	public List<Dica> listDicaPorTitulo( String titulo) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Dica> query =  entityManagger.createQuery("SELECT d FROM Dica d WHERE d.titulo LIKE :titulo AND ex.status=:status",Dica.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("titulo", "%"+titulo+"%");
		List<Dica> dicas = query.getResultList();
		
		return  dicas;
		
	}
	@SuppressWarnings("unchecked")
	public List<Dica>listAllFromPacienteActive(Long id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Dica> query =  entityManagger.createQuery("SELECT d FROM Dica d WHERE d.status = :status AND paciente_id=:idpaciente",Dica.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("idpaciente", id);
		List<Dica> dicas = query.getResultList();
		
		return  dicas;
		
	}

	@SuppressWarnings("unchecked")
	public Dica listForIdWherePaciente(Long id, Long idpaciente) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Dica> query =  entityManagger.createQuery("SELECT d FROM Dica d WHERE d.status = :status AND id=:id AND paciente_id=:idpaciente",Dica.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("id", id);
		query.setParameter("idpaciente", idpaciente);
		Dica dicas = query.getSingleResult();
		
		return  dicas;
		
	}

}
