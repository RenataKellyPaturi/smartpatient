package br.com.fafica.smartpacient.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fafica.smartpacient.entity.impl.Administrador;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;
import br.com.fafica.smartpacient.util.Constants;

public class AdministradorDao extends GenericDAO<Long, Administrador>{

	public AdministradorDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<Administrador>listAllActive() throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Administrador> query =  entityManagger.createQuery("SELECT a FROM Administrador a WHERE a.status = :status",Administrador.class);
		query.setParameter("status", Constants.ATIVADO);
		List<Administrador> admnistradores = query.getResultList();
		
		return  admnistradores;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Administrador> listAdministradorPorNome( String nome) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Administrador> query =  entityManagger.createQuery("SELECT a FROM Administrador a WHERE a.nome LIKE :nome AND a.status=:status",Administrador.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("nome", "%"+nome+"%");
		List<Administrador> administradores = query.getResultList();
		
		return  administradores;
		
	}

	@SuppressWarnings("unchecked")
	public Administrador logarAdministrador(String email, String senha) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		System.out.println("DAO - " + email + " - " +senha);
		EntityManager entityManagger = super.getEntityManager();
		TypedQuery<Administrador> query =  entityManagger.createQuery("SELECT a FROM Administrador a WHERE a.email=:email AND a.senha=:senha AND a.status=:status",Administrador.class);
		query.setParameter("status", Constants.ATIVADO);
		query.setParameter("email", email.trim());
		query.setParameter("senha", senha.trim());
		Administrador administrador = query.getSingleResult();
		
		return  administrador;
		
	}
}
