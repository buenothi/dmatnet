package br.com.smartems.dmatnet.EJB.dao;

public interface IAbstractDAO<T, PK> {

	void create(T t);

	T read(PK id);

	T update(T t);

	void delete(T t);

}
