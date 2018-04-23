package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.jandex.ThrowsTypeTarget;

import br.com.fafica.smartpacient.dao.impl.AdministradorDao;
import br.com.fafica.smartpacient.entity.impl.Administrador;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;
import br.com.fafica.smartpacient.util.JSOnutil;
import br.com.fafica.smartpacient.util.ResponseBuildGenerator;

/**
 * @author Maicon / Dieggo
 *
 */
public class AdministradorService {

	private JPAutil simpleEntityManager;
	private AdministradorDao administradorDao;

	// private ResponseBuilder responseBuilder;

	private void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.administradorDao = new AdministradorDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();
		// this.responseBuilder = Response.noContent();

	}

	/**
	 * @param nome
	 * @param email
	 * @param senha
	 * @param tipoAcesso
	 */
	public Boolean create(Administrador adm) {
		this.instanciaInicia();
		Boolean retorno = false;
		try {

			adm.setStatus(Constants.ATIVADO);
			if (adm.validadorClasse() == true) {
				this.administradorDao.save(adm);
				this.simpleEntityManager.commit();
				// this.responseBuilder =
				// ResponseBuildGenerator.createOKResponseTextPlain(responseBuilder);
				retorno = true;
			} else {
				// throw new Exception("administrador nulo ou campos nao
				// preenchidos");
				System.out.println("erro -- > administrador nulo ou campos nao preenchidos");
			}
		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();

			// responseBuilder =
			// ResponseBuildGenerator.createErrorResponse(responseBuilder);
			retorno = false;
		} finally {
			this.simpleEntityManager.close();
		}
		return retorno;

	}

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param senha
	 * @param tipoAcesso
	 */
	public Boolean update(Administrador adm) {

		this.instanciaInicia();
		Boolean retorno = false;
		try {
			if (adm.validadorClasse() == true) {

				this.administradorDao.update(adm);
				this.simpleEntityManager.commit();
				retorno = true;
				// responseBuilder =
				// ResponseBuildGenerator.createOKResponseTextPlain(responseBuilder);
			} else {
				retorno = false;
				System.out.println("erro -- > administrador nulo ou campos nao preenchidos");
			}
		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
			// responseBuilder =
			// ResponseBuildGenerator.createErrorResponse(responseBuilder);
			retorno = false;
		}
		return retorno;
	}

	/**
	 * @param id
	 * @return
	 */
	public Administrador listForId(String id) {

		this.instanciaInicia();
		Administrador adm = null;
		try {

			adm = this.administradorDao.getById(Long.parseLong(id));

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();

		} finally {
			this.simpleEntityManager.close();
		}

		return adm;
	}

	/**
	 * @return
	 */
	public List<Administrador> listAll() {

		this.instanciaInicia();
		List<Administrador> administradores = null;
		try {

			administradores = this.administradorDao.findAll();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();

		} finally {
			this.simpleEntityManager.close();
		}
		return administradores;
	}

	/**
	 * @return List<Administrador> filtro: Status = true
	 */
	public List<Administrador> listAllActive() {
		this.instanciaInicia();
		List<Administrador> administradores = null;
		try {
			administradores = this.administradorDao.listAllActive();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return administradores;
	}

	/**
	 * @param id
	 */
	public Boolean inativar(String id) {
		this.instanciaInicia();
		Boolean retorno = false;
		try {

			Administrador admProcurado = this.administradorDao.getById(Long.parseLong(id));

			admProcurado.setStatus(Constants.INATIVADO);
			this.simpleEntityManager.commit();
			retorno = true;

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			retorno = false;

		} finally {
			this.simpleEntityManager.close();
		}
		return retorno;
	}

	/**
	 * @param id
	 */
	public Boolean ativar(String id) {
		this.instanciaInicia();
		Boolean retorno = false;
		try {

			Administrador admProcurado = this.administradorDao.getById(Long.parseLong(id));
			admProcurado.setStatus(Constants.ATIVADO);
			this.simpleEntityManager.commit();
			retorno = true;

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			retorno = false;
		} finally {
			this.simpleEntityManager.close();
		}
		return retorno;

	}

	public List<Administrador> listAdministradorPorNome(String nome) {
		this.instanciaInicia();

		List<Administrador> administradores = null;
		try {

			administradores = this.administradorDao.listAdministradorPorNome(nome);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return administradores;

	}

	public Administrador logarAdministrador(String email, String senha) {
		this.instanciaInicia();

		Administrador administrador = null;
		try {
			System.out.println("Service" + email + " - " +senha);
			administrador = this.administradorDao.logarAdministrador(email, senha);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return administrador;

	}

}
