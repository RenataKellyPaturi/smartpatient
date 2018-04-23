package br.com.fafica.smartpacient.control;

import java.util.ArrayList;
import java.util.List;

import br.com.fafica.smartpacient.dao.impl.ProfissionalDao;
import br.com.fafica.smartpacient.entity.impl.Administrador;
import br.com.fafica.smartpacient.entity.impl.Paciente;
import br.com.fafica.smartpacient.entity.impl.Profissional;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

/**
 * @author Dieggo
 *
 */
public class ProfissionalService {

	private JPAutil simpleEntityManager;
	private ProfissionalDao profissionalDao;

	/**
	 * 
	 */
	private void instanciaInicia() {
		this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
		this.profissionalDao = new ProfissionalDao(this.simpleEntityManager.getEntityManager());
		this.simpleEntityManager.beginTransaction();
	}

	/**
	 * @param nome
	 * @param email
	 * @param senha
	 * @param tipoAcesso
	 */

	public boolean create(Profissional prof) {
		this.instanciaInicia();
		boolean resposta = false;

		try {

			prof.setStatus(Constants.ATIVADO);
			if (prof.validadorClasse() == true) {

				profissionalDao.save(prof);
				simpleEntityManager.commit();
				resposta = true;
			} else {
				System.out.println("erro -- > profissional nulo ou campos nao preenchidos");
				resposta = false;
			}
//			profissionalDao.save(prof);
//			simpleEntityManager.commit();
//			resposta = true;
			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("RESPOSTA ERRO -> " + e.getMessage());
			this.simpleEntityManager.rollBack();
			resposta = false;
		} finally {
			this.simpleEntityManager.close();
		}
		return resposta;
	}

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param senha
	 * @param tipoAcesso
	 */
	public boolean update(Profissional prof) {
		this.instanciaInicia();
		boolean	resposta = false;
		try {
			if (prof.validadorClasse() == true) {
				this.profissionalDao.update(prof);
				this.simpleEntityManager.commit();
				resposta = true;
			} else {
				System.out.println("erro -- > profissional nulo ou campos nao preenchidos");
			}
		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
			resposta = false;
		} finally {
			this.simpleEntityManager.close();
		}
		return resposta;
	}

	/**
	 * @param id
	 * @return
	 */
	public Profissional listForId(String id) {
		this.instanciaInicia();
		Profissional prof = new Profissional();

		try {
			prof = profissionalDao.getById(Long.parseLong(id));

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}

		return prof;
	}

	/**
	 * @return
	 */
	public List<Profissional> listAll() {
		this.instanciaInicia();
		List<Profissional> profissionais = new ArrayList<Profissional>();
		try {

			profissionais = profissionalDao.findAll();

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return profissionais;
	}

	/**
	 * @param id
	 */
	public boolean inativar(String id) {

		this.instanciaInicia();
		try {
			Profissional profProcurado = this.profissionalDao.getById(Long.parseLong(id));

			profProcurado.setStatus(Constants.INATIVADO);
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
	public boolean ativar(String id) {
		this.instanciaInicia();
		try {
			Profissional profProcurado = this.profissionalDao.getById(Long.parseLong(id));
			profProcurado.setStatus(Constants.ATIVADO);
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
	 * @return List<Profissional> filtro: Status = true
	 */
	public List<Profissional> listarTodosAtivos(){
		this.instanciaInicia();
		List<Profissional> profissionais = null;
		try{
			profissionais = this.profissionalDao.listAllActive();
			
		}catch(Exception e ){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		
		return profissionais;
	}

	public List<Paciente> listPacientePorNome(String nome){
		
		this.instanciaInicia();
		List<Paciente> pacientes = null;
		try{
			pacientes = this.profissionalDao.listPacientePorNome(nome);
			
		}catch(Exception e ){
			 e.getStackTrace();
			 this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return pacientes;
	}

	public Profissional verificaCpf(String cpf){
		
		this.instanciaInicia();
		Profissional profissional = null;
		try{
			profissional = this.profissionalDao.pegaPorCpf(cpf);
			
		}catch(Exception e ){
			 e.getStackTrace();
			 this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return profissional;
	}

	
	public Profissional logarProfissional(String email, String senha,  String cpf) {
		this.instanciaInicia();

		Profissional profissional = null;
		try {
			System.out.println("Service" + email + " - " +senha);
			profissional = this.profissionalDao.logarProfissional(email, senha, cpf);

		} catch (Exception e) {
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		} finally {
			this.simpleEntityManager.close();
		}
		return profissional;

	}
	
	/**
	 *Metodo onde busca a lista e pacientes vinculados ao profissional desejando 
	 *sendo buscado atraves de Id
	 *
	 *
	 */
	
	public List<Paciente> listaPacienteVinculadosProfissional(String id){
		
		this.instanciaInicia();
		List<Paciente> pacientes = null;
		
		try{
			pacientes = this.profissionalDao.listaPacienteVinculadosProfissional(Long.parseLong(id));
			
		}catch(Exception e){
			e.getStackTrace();
			this.simpleEntityManager.rollBack();
		}finally {
			this.simpleEntityManager.close();
		}
		return pacientes;
		
	}

}
