package br.com.fafica.smartpacient.modelo.interfaces;

import java.util.List;

public interface ControllerInterface<T> {
	public T salvar(T entity);
    public Boolean deletar(T entity);
    public T editar(T entity);
    public T buscar(Long entity);
    public List<T> listar(T entity);
  
}
