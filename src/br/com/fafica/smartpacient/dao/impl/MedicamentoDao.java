package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Medicamento;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class MedicamentoDao extends GenericDAO<Long, Medicamento>{

	public MedicamentoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<Medicamento>listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Medicamento> query =  entityManagger.createQuery("SELECT m FROM Medicamento m WHERE m.status = :status",Medicamento.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Medicamento> medicamentos = query.getResultList();
		
		return  medicamentos;
		
	}
	@SuppressWarnings("unchecked")
	public List<Medicamento> listMedicamentoPorNome( String nome) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Medicamento> query =  entityManagger.createQuery("SELECT m FROM Medicamento m WHERE m.nome LIKE :nome AND m.status=:status",Medicamento.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("nome", "%"+nome+"%");
		List<Medicamento> medicamentos = query.getResultList();
		
		return  medicamentos;
		
	}

}
