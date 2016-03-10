package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

public interface AbstractFacade <T> {

	public abstract T read(long pk);
	public abstract void create(T entity);
	public abstract T update (T entity);
	public abstract void delete (T entity);
	public abstract List<T> findAll();
}
