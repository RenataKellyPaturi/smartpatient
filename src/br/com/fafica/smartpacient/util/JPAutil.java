package br.com.fafica.smartpacient.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fafica.smatpacient.modelo.JPAutil.IJPAutil;

public class JPAutil  implements IJPAutil{
	
	private EntityManager entityManager;
	private EntityManagerFactory factory;
	
	

	public JPAutil(String persistenciaUnitName) {
	factory = Persistence.createEntityManagerFactory(persistenciaUnitName);
	this.entityManager= factory.createEntityManager();
	
	}

	@Override
	public void beginTransaction() {
		this.entityManager.getTransaction().begin();
	}
	@Override
	public void commit() {
		this.entityManager.getTransaction().commit();
	}

	@Override
	public void close() {
		entityManager.clear();
		entityManager.close();
		factory.close();
	}

	@Override
	public void rollBack() {
		this.entityManager.getTransaction().rollback();		
	}

	@Override
	public EntityManager getEntityManager() {
		
		return this.entityManager;
	}

	public void clear(){
		entityManager.clear();
	}
}
