package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import br.com.fafica.smartpacient.dao.impl.FichaAcompanhamentoDao;
import br.com.fafica.smartpacient.entity.impl.FichaAcompanhamento;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

public class FichaAcompanhamentoService {
	
	private JPAutil simpleEntityManager;
	private FichaAcompanhamentoDao fichaAcompanhamentoDao;
	
	
	private void instanciaInicia(){
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.fichaAcompanhamentoDao = new FichaAcompanhamentoDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();
		
	}
		
		
	public boolean create(FichaAcompanhamento  ficha){
		this.instanciaInicia();
		boolean retorno = false;
		System.out.println("create---");
		try{
			System.out.println("validar---");
			if ( ficha.validadorClasse() == true){
				System.out.println("Registro válido---");
				ficha.setStatus(Constants.ATIVADO);
				this.fichaAcompanhamentoDao.save(ficha);
				this.simpleEntityManager.commit();
				retorno = true;
				
			}else {
				System.out.println("erro -- > ficha nulo ou campos nao preenchidos");
			}
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			retorno =false;
		}finally {
			this.simpleEntityManager.close();
		}
		return retorno;
	}
	
	public boolean update(FichaAcompanhamento ficha){
		this.instanciaInicia();
		boolean retorno = false;
		try{
			if(ficha.validadorClasse()==true){
				this.fichaAcompanhamentoDao.update(ficha);
				this.simpleEntityManager.commit();
				retorno =  true;
			}else{
				System.out.println("erro -- > paciente nulo ou campos nao preenchidos");
			}
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			retorno = false;
		}finally {
			this.simpleEntityManager.close();
		}
		return retorno;
	}
	
	public Boolean ativar(String id){
		this.instanciaInicia();
		try{
			FichaAcompanhamento ficha = fichaAcompanhamentoDao.getById(Long.parseLong(id));
			ficha.setStatus(Constants.ATIVADO);
			this.simpleEntityManager.commit();
			
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			return false;
		}finally {
			this.simpleEntityManager.close();
		}
		return true;
	}
	
public boolean inativar(String id){
		this.instanciaInicia();
	try{
		FichaAcompanhamento ficha = fichaAcompanhamentoDao.getById(Long.parseLong(id));
		ficha.setStatus(Constants.INATIVADO);
		this.simpleEntityManager.commit();
		
	}catch(Exception e ){
		e.getStackTrace();
		this.simpleEntityManager.rollBack();
		return false;
	}finally {
		this.simpleEntityManager.close();
	}
	return true;
		
	}

	
	public FichaAcompanhamento listForId(String id){
		FichaAcompanhamento ficha = new FichaAcompanhamento();
		this.instanciaInicia();
			try{
			ficha= fichaAcompanhamentoDao.getById(Long.parseLong(id));
			
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return ficha;
	}
	
	public List<FichaAcompanhamento> listAll(){
		this.instanciaInicia();
		List<FichaAcompanhamento> fichas = new ArrayList<>();
		try{
			
			fichas=fichaAcompanhamentoDao.findAll();
			
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return fichas;
	}	
	
	public List<FichaAcompanhamento> listAllFichasActive(){
		this.instanciaInicia();
		List<FichaAcompanhamento> fichas = new ArrayList<>();
		try{
			
			fichas=fichaAcompanhamentoDao.listAllFichasActive();
			
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return fichas;
	}	


}
