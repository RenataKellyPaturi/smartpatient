package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import br.com.fafica.smartpacient.dao.impl.ExercicioDao;
import br.com.fafica.smartpacient.entity.impl.Exercicio;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;


public class ExercicioService{

	private JPAutil simpleEntityManager;
	private ExercicioDao exercicioDao;

	private void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.exercicioDao = new ExercicioDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();

	}

	public boolean create(Exercicio exercicio) {
		this.instanciaInicia();
		boolean retorno = false;
		try {
			if (exercicio.validadorClasse() == true) {
				exercicio.setStatus(Constants.ATIVADO);
				this.exercicioDao.save(exercicio);
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

	public boolean update(Exercicio exercicio) {
		boolean retorno = false;
		this.instanciaInicia();
		
		try {
			if (exercicio.validadorClasse() == true) {				
				this.exercicioDao.update(exercicio);
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
			Exercicio exercicio = this.exercicioDao.getById(id);
			exercicio.setStatus(Constants.ATIVADO);
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
			Exercicio exercicio = this.exercicioDao.getById(id);
			this.exercicioDao.delete(exercicio);
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

	public Exercicio listForId(Long id) {
		this.instanciaInicia();
		Exercicio exercicio = null;
		try {
			exercicio = this.exercicioDao.getById(id);
			System.out.println("Service");
			System.out.println(exercicio);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return exercicio;
	}
	public Exercicio listForIdWherePaciente(Long id, Long idpaciente){
		this.instanciaInicia();
		Exercicio exercicio = null;
		try{
			exercicio = this.exercicioDao.listForIdWherePaciente(id, idpaciente);
			System.out.println("Service");
			System.out.println(exercicio);
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return exercicio;
	}

	

	public List<Exercicio> listAllActive() {
		this.instanciaInicia();
		List<Exercicio> exercicios = null;
		try {
			exercicios = this.exercicioDao.listAllActive();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return exercicios;

	}

	public List<Exercicio> listExercicioPorNome(String nome) {
		this.instanciaInicia();
		List<Exercicio> exercicios = null;
		try {
			exercicios = this.exercicioDao.listExercicioPorNome(nome);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return exercicios;

	}
	public List<Exercicio> listAllFromPacienteActive(Long id){
		this.instanciaInicia();
		List<Exercicio> exercicios = null;
		try{
			exercicios = this.exercicioDao.listAllFromPacienteActive(id);
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return exercicios;
	}
	public List<Exercicio> listAll() {
		this.instanciaInicia();
		List<Exercicio> exercicios = null;
		try {
			exercicios = exercicioDao.findAll();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return exercicios;
	}
}
