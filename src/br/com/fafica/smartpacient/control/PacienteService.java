package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import br.com.fafica.smartpacient.dao.impl.PacienteDao;
import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

public class PacienteService {
	
	private JPAutil simpleEntityManager;
	private PacienteDao pacienteDao;
	
	
	private void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.pacienteDao = new PacienteDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();
	}

	
	

	public void create(Paciente paciente){
		this.instanciaInicia();
		paciente.setStatus(Constants.ATIVADO);
		System.out.println("controlador -> " + paciente);
		try{
			System.out.println(paciente);
			
			
			this.pacienteDao.save(paciente);
			this.simpleEntityManager.commit();
			
		}catch(Exception e){
			e.getStackTrace();
			System.out.println(e);
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		
	}
	
	public boolean update(Paciente paciente){
		this.instanciaInicia();
		boolean resposta = false;
		try{
			System.out.println("Entrou no update o paciente ->" + paciente);
				this.pacienteDao.update(paciente);
				this.simpleEntityManager.commit();
				resposta= true;
			
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			resposta=false;
		}finally {
			this.simpleEntityManager.close();
		}
		return resposta;
		
	}
	
	public boolean  ativar(String id){
		this.instanciaInicia();
		try{
			Paciente paciente = pacienteDao.getById(Long.parseLong(id));
			paciente.setStatus(Constants.ATIVADO);
			this.simpleEntityManager.commit();
			return true;
			
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			return false;
		}finally {
			this.simpleEntityManager.close();
		}
		
	}
	
public Boolean inativar(String id){
	this.instanciaInicia();
		try{
			Paciente paciente = pacienteDao.getById(Long.parseLong(id));
			paciente.setStatus(Constants.INATIVADO);
			this.simpleEntityManager.commit();
			
			return true;
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			return false;
		}finally {
			this.simpleEntityManager.close();
		}
		
	}

	
	public Paciente listForId(String id){
		
		this.instanciaInicia();
		Paciente pacienteProcurado = new Paciente();

		try{
			pacienteProcurado = this.pacienteDao.getById(Long.parseLong(id));
			System.out.println("ACHOU ESSE");
			System.out.println(pacienteProcurado);
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return pacienteProcurado;
	}
	
	public List<Paciente> listAll(){
		this.instanciaInicia();
		List<Paciente> pacientes = new ArrayList<>();
		try{
			pacientes = this.pacienteDao.findAll();
			System.out.println("Service - ListAll");
			System.out.println(pacientes);
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return pacientes;
	}
	
	public List<Paciente> listAllActive(){
		this.instanciaInicia();
		List<Paciente> pacientes = new ArrayList<>();
		try{
			pacientes =  this.pacienteDao.listAllPacienteActive();
			System.out.println("Service - ListAllActive");
			System.out.println(pacientes);
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			System.out.println(e.getMessage());
		}finally {
			this.simpleEntityManager.close();
		}
		return pacientes;
	}
	
	public boolean verificarCpf(String cpf){
		this.instanciaInicia();
		boolean resposta = true;
		try{
			Paciente pac = this.pacienteDao.buscarPacientePorCpf(cpf);
			if(pac == null){
				resposta = false;
			}
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		
		return resposta;
	}
}
