
package br.com.fafica.smartpacient.control;

import java.util.List;

import br.com.fafica.smartpacient.dao.impl.AlimentacaoDAO;
import br.com.fafica.smartpacient.entity.impl.Alimentacao;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

public class AlimentacaoService {

	private  JPAutil simpleEntityMananger;
	private AlimentacaoDAO alimentacaoDao;
	
	
	private void instanciaInicia(){
		this.simpleEntityMananger = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.alimentacaoDao = new AlimentacaoDAO(this.simpleEntityMananger.getEntityManager());
		this.simpleEntityMananger.beginTransaction();
	}

	public boolean create(Alimentacao alimentacao){
		boolean resposta= false;
		this.instanciaInicia();
		try{
			if(alimentacao.validadorClasse()== true){
				alimentacao.setStatus(Constants.ATIVADO);
				this.alimentacaoDao.save(alimentacao);
				this.simpleEntityMananger.commit();
				resposta = true;
			}else {
				System.out.println("erro -- > alimentacao nulo ou campos nao preenchidos");
			}
			
		}catch(Exception e){
			e.getStackTrace();
			System.out.println(e.getMessage());
			this.simpleEntityMananger.rollBack();
			resposta = false;
		}finally {
			this.simpleEntityMananger.close();
		}
		return resposta;
	}
	
	public boolean update(Alimentacao alimentacao){
		boolean resposta= false;
		this.instanciaInicia();
		try{
			if(alimentacao.validadorClasse()== true){
				
				this.alimentacaoDao.update(alimentacao);
				this.simpleEntityMananger.commit();
				resposta = true;
			}else {
				System.out.println("erro -- > alimentacao nulo ou campos nao preenchidos");
			}
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
			resposta = false;
		}finally {
			this.simpleEntityMananger.close();
		}
		return resposta;
	}
	
	public boolean ativar(Long id){
		
		this.instanciaInicia();
		try{
			Alimentacao alimentacao = this.alimentacaoDao.getById(id);
			alimentacao.setStatus(Constants.ATIVADO);
			this.simpleEntityMananger.commit();
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
			return false;
		}finally {
			this.simpleEntityMananger.close();
		}
		return true;
	}
	
	public boolean inativar(Long id){
		
		this.instanciaInicia();
		try{
			
			Alimentacao alimentacao = this.alimentacaoDao.getById(id);
			
			this.alimentacaoDao.delete(alimentacao);
			this.simpleEntityMananger.commit();
			
		}catch(Exception e){
			e.getStackTrace();
			System.out.println(e.getMessage());
			this.simpleEntityMananger.rollBack();
			return false;
		}finally {
			this.simpleEntityMananger.close();
		}
		return true;
	}
	public Alimentacao listForId(Long id){
		this.instanciaInicia();
		Alimentacao alimentacao = null;
		try{
			alimentacao = this.alimentacaoDao.getById(id);
			System.out.println("Service");
			System.out.println(alimentacao);
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return alimentacao;
	}

	public Alimentacao listForIdWherePaciente(Long id, Long idpaciente){
		this.instanciaInicia();
		Alimentacao alimentacao = null;
		try{
			alimentacao = this.alimentacaoDao.listForIdWherePaciente(id, idpaciente);
			System.out.println("Service");
			System.out.println(alimentacao);
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return alimentacao;
	}
	public List<Alimentacao> listAllActive(){
		this.instanciaInicia();
		List<Alimentacao> alimentacao = null;
		try{
			alimentacao = this.alimentacaoDao.listAllActive();
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return alimentacao;
	}

	
	public List<Alimentacao> listAllFromPacienteActive(Long id){
		this.instanciaInicia();
		List<Alimentacao> alimentacao = null;
		try{
			alimentacao = this.alimentacaoDao.listAllFromPacienteActive(id);
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return alimentacao;
	}
	
	public List<Alimentacao> listAll(){
		this.instanciaInicia();
		List<Alimentacao> alimentacao = null;
		try{
			alimentacao = this.alimentacaoDao.findAll();
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return alimentacao;
	}
}
