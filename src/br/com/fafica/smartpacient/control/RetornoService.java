package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import br.com.fafica.smartpacient.dao.impl.RetornoDao;
import br.com.fafica.smartpacient.entity.impl.Retorno;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

public class RetornoService {

	private JPAutil simpleEntityManager;
	private RetornoDao retornoDao;

	private void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.retornoDao = new RetornoDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();

	}

	public boolean create(Retorno ret) {
		this.instanciaInicia();
		boolean resposta = false;
System.out.println(ret);
		try {

			ret.setStatus(Constants.ATIVADO);
			if (ret.validadorClasse() == true) {

				retornoDao.save(ret);
				simpleEntityManager.commit();
				resposta = true;
			} else {
				System.out.println("erro -- > profissional nulo ou campos nao preenchidos");
				resposta = false;
			}
//			profissionalDao.save(prof);
//			simpleEntityManager.commit();
//			resposta = true;
			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("RESPOSTA ERRO -> " + e.getMessage());
			System.out.println("RESPOSTA ERRO -> " + e.getStackTrace());
			System.out.println(e.toString());
			this.simpleEntityManager.rollBack();
			resposta = false;
		} finally {
			this.simpleEntityManager.close();
		}
		return resposta;
	}

	public boolean update(Retorno retornoObjeto) {
		this.instanciaInicia();
		boolean retorno = false;
		try {
			
			if (retornoObjeto.validadorClasse() == true) {
				retornoDao.update(retornoObjeto);
				this.simpleEntityManager.commit();
				retorno = true;
			} else {
				System.out.println("erro -- > horario nulo ou campos nao preenchidos");
			}

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			retorno = false;
		} finally {
			this.simpleEntityManager.close();
		}
		return retorno;
	}

	public Boolean ativar(String id) {
		this.instanciaInicia();

		try {
			Retorno retorno = retornoDao.getById(Long.parseLong(id));
			retorno.setStatus(Constants.ATIVADO);
			retornoDao.update(retorno);
			this.simpleEntityManager.commit();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			return false;
		} finally {
			this.simpleEntityManager.close();
		}
		return true;
	}

	public Boolean inativar(String id) {
		this.instanciaInicia();
		try {
			Retorno retorno = retornoDao.getById(Long.parseLong(id));
			retorno.setStatus(Constants.INATIVADO);
			this.simpleEntityManager.commit();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			return false;
		} finally {
			this.simpleEntityManager.close();
		}
		return true;
	}

	public Retorno listForId(String id) {
		this.instanciaInicia();
		Retorno retorno = new Retorno();
		try {
			retorno = retornoDao.getById(Long.parseLong(id));

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return retorno;
	}

	public List<Retorno> listAll() {
		this.instanciaInicia();
		List<Retorno> retorno = new ArrayList<>();
		try {
			retorno = retornoDao.findAll();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return retorno;
	}

	public List<Retorno> listAllActive() {
		this.instanciaInicia();
		List<Retorno> retornos = null;
		try {
			retornos = this.retornoDao.listAllActive();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return retornos;

	}

	public List<Retorno> listAllFromPacienteActive(Long id) {
		this.instanciaInicia();
		List<Retorno> retornos = null;
		try {
			retornos = this.retornoDao.listAllFromPacienteActive(id);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return retornos;

	}

	public List<Retorno> listRetornoPorData(String data) {
		this.instanciaInicia();
		List<Retorno> retornos = null;
		try {
			retornos = this.retornoDao.listRetornoPorData(data);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return retornos;

	}

	
}