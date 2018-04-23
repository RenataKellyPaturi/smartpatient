package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.jandex.ThrowsTypeTarget;

import br.com.fafica.smartpacient.dao.impl.AdministradorDao;
import br.com.fafica.smartpacient.entity.impl.Administrador;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

/**
 * @author Maicon
 *
 */
public class AdministradorService {

	private JPAutil simpleEntityManager;
	private AdministradorDao administradorDao;

	
	/**
	 * @param nome
	 * @param email
	 * @param senha
	 * @param tipoAcesso
	 */
	public void create(Administrador adm) {
		this.instanciaInicia();
		try {

			adm.setStatus(Constants.ATIVADO);
			if (adm.validadorClasse() == true) {

			 
				this.administradorDao.save(adm);

				this.simpleEntityManager.commit();
				
			} else {
//				throw new Exception("administrador nulo ou campos nao preenchidos");
				System.out.println("erro -- > administrador nulo ou campos nao preenchidos");
			}
		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {

			this.simpleEntityManager.close();
		}

	}

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param senha
	 * @param tipoAcesso
	 */
	public void update(Administrador adm) {

		this.instanciaInicia();
		try {
			if (adm.validadorClasse() == true) {
				
				this.administradorDao.update(adm);
				this.simpleEntityManager.commit();
			} else {
				System.out.println("erro -- > administrador nulo ou campos nao preenchidos");
			}
		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
	}

	/**
	 * @param id
	 * @return
	 */
	public Administrador listForId(String id) {

		this.instanciaInicia();
		
		Administrador adm = new Administrador();

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
		
		List<Administrador> administradores = new ArrayList<Administrador>();
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
	 * @return List<Administrador> 
	 * filtro: Status = true
	 */
	public List<Administrador> listAllActive() {
		
		
		this.instanciaInicia();
		
		List<Administrador> administradores = null;
		try {
//
//			Query query = simpleEntityManager.getEntityManager().createQuery("SELECT a FROM Administrador a WHERE a.status = :status");
//			query.setParameter("status", Constants.ATIVADO);
//			administradores = this.administradorDao.findAll();

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
		
		try {
		 
			Administrador admProcurado = this.administradorDao.getById(Long.parseLong(id));

			admProcurado.setStatus(Constants.INATIVADO);
//			System.out.println(admProcurado.getNome());
			this.simpleEntityManager.commit();

			return true;
			
		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			return false;
		} finally {
			this.simpleEntityManager.close();
		}
		
	}

	/**
	 * @param id
	 */
	public void ativar(String id) {
		this.instanciaInicia();
		try {
			
			Administrador admProcurado = this.administradorDao.getById(Long.parseLong(id));
			admProcurado.setStatus(Constants.ATIVADO);
			this.simpleEntityManager.commit();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}

	}
	
	
	public void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.administradorDao = new AdministradorDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();
	}

}
