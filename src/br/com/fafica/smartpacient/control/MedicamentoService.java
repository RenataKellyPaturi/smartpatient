package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import br.com.fafica.smartpacient.dao.impl.MedicamentoDao;
import br.com.fafica.smartpacient.entity.impl.Medicamento;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

public class MedicamentoService {

	private JPAutil simpleEntityManager;
	private MedicamentoDao medicamentoDao;

	private void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.medicamentoDao = new MedicamentoDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();

	}

	public boolean create(Medicamento med) {
		this.instanciaInicia();
		boolean retorno = false;
		try {
			if (med.validadorClasse() == true) {
				med.setStatus(Constants.ATIVADO);
				this.medicamentoDao.save(med);
				this.simpleEntityManager.commit();
				retorno = true;

			} else {
				System.out.println("erro -- > medicamento nulo ou campos nao preenchidos");
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

	public Boolean update(Medicamento med) {
		
		this.instanciaInicia();
		Boolean retorno = false;
		try {
			if (med.validadorClasse() == true) {				
				this.medicamentoDao.update(med);
				this.simpleEntityManager.commit();
				retorno = true;
			} else {
				System.out.println("erro -- > medicamento nulo ou campos nao preenchidos");
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
			Medicamento med = medicamentoDao.getById(Long.parseLong(id));
			med.setStatus(Constants.ATIVADO);
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
			Medicamento med = medicamentoDao.getById(Long.parseLong(id));
			med.setStatus(Constants.INATIVADO);
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

	public Medicamento listForId(String id) {
		this.instanciaInicia();
		Medicamento med = new Medicamento();
		try {
			med = medicamentoDao.getById(Long.parseLong(id));

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return med;
	}

	public List<Medicamento> listAll() {
		this.instanciaInicia();
		List<Medicamento> medicamentos = new ArrayList<>();
		try {
			medicamentos = medicamentoDao.findAll();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return medicamentos;
	}

	public List<Medicamento> listAllActive() {
		this.instanciaInicia();
		List<Medicamento> medicamentos = null;
		try {
			medicamentos = this.medicamentoDao.listAllActive();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return medicamentos;

	}

	public List<Medicamento> listMedicamentoPorNome(String nome) {
		this.instanciaInicia();
		List<Medicamento> medicamentos = null;
		try {
			medicamentos = this.medicamentoDao.listMedicamentoPorNome(nome);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return medicamentos;

	}
}
