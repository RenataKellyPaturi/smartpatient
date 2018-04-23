package br.com.fafica.smartpacient.control;

import java.util.List;

import br.com.fafica.smartpacient.dao.impl.FuncionalidadeSistemaDao;
import br.com.fafica.smartpacient.entity.impl.FuncionalidadeSistema;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

public class FuncionalidadeSistemaService {

	private JPAutil simpleEntityMananger;
	private FuncionalidadeSistemaDao funcionalidadeSistemaDao;

	private void instaciaInicia() {
		this.simpleEntityMananger = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.funcionalidadeSistemaDao = new FuncionalidadeSistemaDao(this.simpleEntityMananger.getEntityManager());
		this.simpleEntityMananger.beginTransaction();
	}

	public boolean create(FuncionalidadeSistema func) {
		this.instaciaInicia();
		boolean retorno = false;
		try {
			if (func.validadorClasse() == true) {
				func.setStatus(Constants.ATIVADO);
				this.funcionalidadeSistemaDao.save(func);
				this.simpleEntityMananger.commit();
				retorno = true;
			} else {
				System.out.println("erro -- > Funcinalidade  nula ou campos nao preenchidos");

			}

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
			retorno = false;
		} finally {
			this.simpleEntityMananger.close();
		}
		return retorno;
	}

	public boolean update(FuncionalidadeSistema func) {
		this.instaciaInicia();
		boolean retorno = false;
		try {
			if (func.validadorClasse() == true) {
				this.funcionalidadeSistemaDao.save(func);
				this.simpleEntityMananger.commit();
				retorno = true;
			} else {
				System.out.println("erro -- > Funcinalidade  nula ou campos nao preenchidos");

			}

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
			retorno = false;
		} finally {
			this.simpleEntityMananger.close();
		}
		return retorno;
	}

	public FuncionalidadeSistema listForId(String id) {

		this.instaciaInicia();
		FuncionalidadeSistema funcionalidade = null;

		try {
			funcionalidade = this.funcionalidadeSistemaDao.getById(Long.parseLong(id));

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		} finally {
			this.simpleEntityMananger.close();
		}
		return funcionalidade;

	}

	public List<FuncionalidadeSistema> listAll() {

		this.instaciaInicia();
		List<FuncionalidadeSistema> funcionalidadeSistemas = null;
		try {
			funcionalidadeSistemas = this.funcionalidadeSistemaDao.listAllActive();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		} finally {
			this.simpleEntityMananger.close();
		}
		return funcionalidadeSistemas;

	}
	public boolean ativar ( String id){
		this.instaciaInicia();
		
		try {
			FuncionalidadeSistema
			funcionalidade = this.funcionalidadeSistemaDao.getById(Long.parseLong(id));
			funcionalidade.setStatus(Constants.ATIVADO);
			this.simpleEntityMananger.commit();
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
			return false;
		}finally {
			this.simpleEntityMananger.close();
		}
		return true;
	}
	
	public boolean inativar ( String id){
		this.instaciaInicia();
		
		try {
			FuncionalidadeSistema
			funcionalidade = this.funcionalidadeSistemaDao.getById(Long.parseLong(id));
			funcionalidade.setStatus(Constants.INATIVADO);
			this.simpleEntityMananger.commit();
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
			return false;
		}finally {
			this.simpleEntityMananger.close();
		}
		return true;
	}

}
