package br.com.fafica.smartpacient.dao.impl;

import javax.persistence.EntityManager;

import br.com.fafica.smartpacient.entity.impl.Endereco;
import br.com.fafica.smartpacient.modelo.dao.GenericDAO;

public class EnderecoDao extends GenericDAO<Long, Endereco>{

	public EnderecoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
