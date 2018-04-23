package br.com.fafica.smartpacient.control;

import java.util.List;
import br.com.fafica.smartpacient.dao.impl.MensagemDao;
import br.com.fafica.smartpacient.entity.impl.Mensagem;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;


public class MensagemService {

	private  JPAutil simpleEntityMananger;
	private MensagemDao mensagemDao;
	
	
	private void instanciaInicia(){
		this.simpleEntityMananger = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.mensagemDao = new MensagemDao(this.simpleEntityMananger.getEntityManager());
		this.simpleEntityMananger.beginTransaction();
	}

	public boolean create(Mensagem mensagem){
		boolean resposta= false;
		this.instanciaInicia();
		try{
			if(mensagem.validadorClasse()== true){
				mensagem.setStatus(Constants.ATIVADO);
				this.mensagemDao.save(mensagem);
				this.simpleEntityMananger.commit();
				resposta = true;
			}else {
				System.out.println("erro -- > administrador nulo ou campos nao preenchidos");
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
	
	public boolean update(Mensagem mensagem){
		boolean resposta= false;
		this.instanciaInicia();
		try{
			if(mensagem.validadorClasse()== true){
				
				this.mensagemDao.update(mensagem);
				this.simpleEntityMananger.commit();
				resposta = true;
			}else {
				System.out.println("erro -- > administrador nulo ou campos nao preenchidos");
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
			Mensagem mensagem = this.mensagemDao.getById(id);
			mensagem.setStatus(Constants.ATIVADO);
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
			
			Mensagem mensagem = this.mensagemDao.getById(id);
			
			this.mensagemDao.delete(mensagem);
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
	public Mensagem listForId(Long id){
		this.instanciaInicia();
		Mensagem mensagem = null;
		try{
			mensagem = this.mensagemDao.getById(id);
			System.out.println("Service");
			System.out.println(mensagem);
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return mensagem;
	}

	public Mensagem listForIdWherePaciente(Long id, Long idpaciente){
		this.instanciaInicia();
		Mensagem mensagem = null;
		try{
			mensagem = this.mensagemDao.listForIdWherePaciente(id, idpaciente);
			System.out.println("Service");
			System.out.println(mensagem);
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return mensagem;
	}
	public List<Mensagem> listAllActive(){
		this.instanciaInicia();
		List<Mensagem> mensagens = null;
		try{
			mensagens = this.mensagemDao.listAllActive();
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return mensagens;
	}

	
	public List<Mensagem> listAllFromPacienteActive(Long id){
		this.instanciaInicia();
		List<Mensagem> mensagens = null;
		try{
			mensagens = this.mensagemDao.listAllFromPacienteActive(id);
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return mensagens;
	}
	
	public List<Mensagem> listAll(){
		this.instanciaInicia();
		List<Mensagem> mensagens = null;
		try{
			mensagens = this.mensagemDao.findAll();
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityMananger.rollBack();
		}finally {
			this.simpleEntityMananger.close();
		}
		return mensagens;
	}
}

