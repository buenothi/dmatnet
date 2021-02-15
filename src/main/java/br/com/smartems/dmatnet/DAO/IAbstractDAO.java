package br.com.smartems.dmatnet.DAO;

public interface IAbstractDAO<T, PK> {

	void create(T t);

	T read(PK id);

	T update(T t);

	void delete(T t);

}
