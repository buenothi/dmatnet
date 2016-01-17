package br.com.smartems.dmatnet.EJB.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Session Bean implementation class EntityAccessObject
 */
@Stateless
@LocalBean
@SuppressWarnings("unchecked")
public class AbstractEAO <T, PK> implements IAbstractDAO<T, PK>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public AbstractEAO() {
		
	}

	public T read(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	public void create(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {
		return this.entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		return clazz;
	}

}
