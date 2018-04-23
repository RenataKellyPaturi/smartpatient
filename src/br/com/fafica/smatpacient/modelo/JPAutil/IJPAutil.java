package br.com.fafica.smatpacient.modelo.JPAutil;

import javax.persistence.EntityManager;

public interface IJPAutil {

	public void beginTransaction();
	public void commit();
	public void close();
	public void rollBack();
	public EntityManager getEntityManager();

}
