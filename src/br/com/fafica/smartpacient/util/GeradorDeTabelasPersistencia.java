package br.com.fafica.smartpacient.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorDeTabelasPersistencia {
	
	public static void main(String[] arg){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
//		EntityManager entityManager = factory.createEntityManager();
		factory.close();
		
		System.out.println("OK");
	}

}
