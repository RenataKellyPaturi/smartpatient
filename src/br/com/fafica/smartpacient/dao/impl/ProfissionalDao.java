package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Administrador;
import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class ProfissionalDao extends GenericDAO<Long, Profissional> {

	public ProfissionalDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unchecked")
	public List<Profissional> listAllActive() throws NoSuchAlgorithmException, UnsupportedEncodingException {

		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Profissional> query = entityManagger
				.createQuery("SELECT p FROM Profissional p WHERE p.status = :status", Profissional.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Profissional> profissionais = query.getResultList();

		return profissionais;

	}

	@SuppressWarnings("unchecked")
	public List<Paciente> listPacientePorNome(String nome)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Paciente> query = entityManagger.createQuery("SELECT p FROM Paciente p WHERE p.nome LIKE :nome ",
				Paciente.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Paciente> pacientes = query.getResultList();

		return pacientes;

	}

	@SuppressWarnings("unchecked")
	public Profissional pegaPorCpf(String cpf) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Profissional> query = entityManagger.createQuery(
				"SELECT p FROM Profissional p WHERE p.cpf = :cpf AND p.status = :status", Profissional.class);
		query.setParameter("cpf", cpf);
		query.setParameter("status", Constants.ATIVADO);
		Profissional profissional = query.getSingleResult();

		return profissional;

	}

	@SuppressWarnings("unchecked")
	public Profissional logarProfissional(String email, String senha, String cpf)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println("DAO - " + email + " - " + senha + " - " + cpf);
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Profissional> query = entityManagger.createQuery(
				"SELECT a FROM Profissional a WHERE a.email=:email AND a.senha=:senha AND a.cpf=:cpf AND a.status=:status",
				Profissional.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("email", email.trim());
		query.setParameter("cpf", cpf.trim());
		query.setParameter("senha", senha.trim());
		Profissional profissional = query.getSingleResult();
		System.out.println(profissional);
		return profissional;

	}

	public List<Paciente> listaPacienteVinculadosProfissional(Long id){
		
		EntityManager entityManager = super.getEntityManager();
		TypedQuery<Paciente> query = entityManager.createQuery("SELECT p FROM Paciente p, Profissional pr WHERE p.id = pr.id AND pr.id = :id",Paciente.class);
		query.setParameter("id", id);
		
		return query.getResultList();
		
	}

}
