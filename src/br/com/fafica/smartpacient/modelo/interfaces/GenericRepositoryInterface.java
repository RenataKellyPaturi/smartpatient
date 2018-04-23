package br.com.fafica.smartpacient.modelo.interfaces;

import java.util.List;

public interface GenericRepositoryInterface<T> {
	public T save(T entity);
    public Boolean delete(T entity);
    public T edit(T entity);
    public T find(Long entity);
    public List<T> list(T entity);
  
    public abstract void flush();

}
