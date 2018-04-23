package br.com.fafica.smartpacient.control;

import br.com.fafica.smartpacient.dao.impl.EspecialidadeDao;
import br.com.fafica.smartpacient.entity.impl.Especialidade;
import br.com.fafica.smartpacient.util.Constants;
import br.com.fafica.smartpacient.util.JPAutil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dieggo on 24/04/16.
 */
public class EspecialidadeService  {


    private JPAutil simpleEntityManager;
    private EspecialidadeDao especialidadeDao;


    private void instanciaInicia(){
        this.simpleEntityManager = new JPAutil(Constants.PERSISTENCE_UNIT_NAME);
        this.especialidadeDao = new EspecialidadeDao(this.simpleEntityManager.getEntityManager());
        this.simpleEntityManager.beginTransaction();
    }


    public boolean create(Especialidade Especialidade) {
        this.instanciaInicia();
        boolean retorno = false;
        try {
            if (Especialidade.validadorClasse() == true) {
                Especialidade.setStatus(Constants.ATIVADO);
                this.especialidadeDao.save(Especialidade);
                this.simpleEntityManager.commit();
                retorno = true;

            } else {
                System.out.println("erro -- > Especialidade nulo ou campos nao preenchidos");
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

    public boolean update(Especialidade Especialidade) {
        this.instanciaInicia();
        boolean retorno = false;
        try {

            if (Especialidade.validadorClasse() == true) {
                this.simpleEntityManager.commit();
                retorno = true;
            } else {
                System.out.println("erro -- > Especialidade nulo ou campos nao preenchidos");
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
            Especialidade Especialidade = especialidadeDao.getById(Long.parseLong(id));
            Especialidade.setStatus(Constants.ATIVADO);
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
            Especialidade Especialidade = especialidadeDao.getById(Long.parseLong(id));
            Especialidade.setStatus(Constants.INATIVADO);
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

    public Especialidade listForId(String id) {
        this.instanciaInicia();
        Especialidade Especialidade = new Especialidade();
        try {
            Especialidade = especialidadeDao.getById(Long.parseLong(id));

        } catch (Exception e) {
            e.getStackTrace();
            this.simpleEntityManager.rollBack();
        } finally {
            this.simpleEntityManager.close();
        }
        return Especialidade;
    }

    public List<Especialidade> listAll() {
        this.instanciaInicia();
        List<Especialidade> Especialidade = new ArrayList<>();
        try {
            Especialidade = especialidadeDao.findAll();

        } catch (Exception e) {
            e.getStackTrace();
            this.simpleEntityManager.rollBack();
        } finally {
            this.simpleEntityManager.close();
        }
        return Especialidade;
    }

    public List<Especialidade> listAllActive() {
        this.instanciaInicia();
        List<Especialidade> Especialidades = null;
        try {
            Especialidades = this.especialidadeDao.listAllActive();

        } catch (Exception e) {
            e.getStackTrace();
            this.simpleEntityManager.rollBack();
        } finally {
            this.simpleEntityManager.close();
        }
        return Especialidades;

    }


    public List<Especialidade> listAllActiveSelect() {
        this.instanciaInicia();
        
        List<Especialidade> especialidades = null;
        try {
        	especialidades = this.especialidadeDao.listAllActiveSelect();

        } catch (Exception e) {
            e.getStackTrace();
            this.simpleEntityManager.rollBack();
        } finally {
            this.simpleEntityManager.close();
        }
        System.out.println(especialidades);
        return especialidades;

    }
    
    public List<Especialidade> listEspecialidadePorNome(String nome) {
        this.instanciaInicia();
        List<Especialidade> Especialidades = null;
        try {
            Especialidades = this.especialidadeDao.listEspecialidadePorNome(nome);

        } catch (Exception e) {
            e.getStackTrace();
            this.simpleEntityManager.rollBack();
        } finally {
            this.simpleEntityManager.close();
        }
        return Especialidades;

    }
}
