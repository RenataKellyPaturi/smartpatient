package br.com.fafica.smartpacient.modelo.dao;
import java.lang.reflect.ParameterizedType;
import java.util.List;
 
import javax.persistence.EntityManager;

/**
 * @author dieggo
 *
 * @param <PK>
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {
	 private EntityManager entityManager;
	 
	    /**
	     * @param entityManager
	     */
	    public GenericDAO(EntityManager entityManager) {
	    	
	    	this.entityManager = entityManager;
	    }
	 
	    /**
	     * @param pk
	     * @return
	     */
	    public T getById(PK pk) {
	        return (T) entityManager.find(getTypeClass(), pk);
	    }
	 
	    /**
	     * @param entity
	     */
	    public void save(T entity) {
	        entityManager.persist(entity);
	    }
	 
	    /**
	     * @param entity
	     */
	    public void update(T entity) {
	        entityManager.merge(entity);
	    }
	 
	    /**
	     * @param entity
	     */
	    public void delete(T entity) {
	        entityManager.remove(entity);
	    }
	 
	    /**
	     * @return
	     */
	    public List<T> findAll() {
	        return entityManager.createQuery(("FROM " + getTypeClass().getName()) )
	        		.getResultList();
	    }

	   /**
	     * @return
	     */
	    private Class<?> getTypeClass() {
	        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
	                .getGenericSuperclass()).getActualTypeArguments()[1];
	        return clazz;
	    }
	    public EntityManager getEntityManager(){
	    	return this.entityManager;
	    }
}
