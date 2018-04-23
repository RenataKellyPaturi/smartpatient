package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import br.com.fafica.smartpacient.dao.impl.DicaDao;
import br.com.fafica.smartpacient.dao.impl.ExercicioDao;
import br.com.fafica.smartpacient.entity.impl.Dica;
import br.com.fafica.smartpacient.entity.impl.Exercicio;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

public class DicaService {

	private JPAutil simpleEntityManager;
	private DicaDao dicaDao;

	private void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.dicaDao = new DicaDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();

	}

	public boolean create(Dica dica) {
		this.instanciaInicia();
		boolean retorno = false;
		try {
			if (dica.validadorClasse() == true) {
				dica.setStatus(Constants.ATIVADO);
				this.dicaDao.save(dica);
				this.simpleEntityManager.commit();
				retorno = true;

			} else {
				System.out.println("erro -- > exercicio nulo ou campos nao preenchidos");
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

	public boolean update(Dica dica) {
		boolean retorno = false;
		this.instanciaInicia();
		
		try {
			if (dica.validadorClasse() == true) {				
				this.dicaDao.update(dica);
				this.simpleEntityManager.commit();
				retorno = true;
			} else {
				System.out.println("erro -- > exercicio nulo ou campos nao preenchidos");
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

	public boolean ativar(Long id) {
		this.instanciaInicia();

		try {
			Dica dica = this.dicaDao.getById(id);
			dica.setStatus(Constants.ATIVADO);
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

	public boolean inativar(Long id) {
		this.instanciaInicia();
		try {
			Dica dica = this.dicaDao.getById(id);
			this.dicaDao.delete(dica);
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

	public Dica listForId(Long id) {
		this.instanciaInicia();
		Dica dica = null;
		try {
			dica = this.dicaDao.getById(id);
			System.out.println("Service");
			System.out.println(dica);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return dica;
	}
	public Dica listForIdWherePaciente(Long id, Long idpaciente){
		this.instanciaInicia();
		Dica dica = null;
		try{
			dica = this.dicaDao.listForIdWherePaciente(id, idpaciente);
			System.out.println("Service");
			System.out.println(dica);
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return dica;
	}

	

	public List<Dica> listAllActive() {
		this.instanciaInicia();
		List<Dica> dicas = null;
		try {
			dicas = this.dicaDao.listAllActive();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return dicas;

	}

	public List<Dica> listExercicioPorTitulo(String titulo) {
		this.instanciaInicia();
		List<Dica> dicas = null;
		try {
			dicas = this.dicaDao.listDicaPorTitulo(titulo);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return dicas;

	}
	public List<Dica> listAllFromPacienteActive(Long id){
		this.instanciaInicia();
		List<Dica> dicas = null;
		try{
			dicas = this.dicaDao.listAllFromPacienteActive(id);
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return dicas;
	}
	public List<Dica> listAll() {
		this.instanciaInicia();
		List<Dica> dicas = null;
		try {
			dicas = dicaDao.findAll();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return dicas;
	}
}
