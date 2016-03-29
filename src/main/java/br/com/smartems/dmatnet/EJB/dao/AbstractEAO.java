package br.com.smartems.dmatnet.EJB.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@SuppressWarnings("unchecked")
public abstract class AbstractEAO <T, PK> implements IAbstractDAO<T, PK>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public AbstractEAO() {
		
	}

	public T read(PK pk)  throws NoResultException {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	public void create(T entity) throws NoResultException {
		entityManager.persist(entity);
	}

	public T update(T entity) throws NoResultException {
		return this.entityManager.merge(entity);
	}

	public void delete(T entity) throws NoResultException {
		entityManager.remove(entity);
	}

	public List<T> findAll() throws NoResultException {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	private Class<?> getTypeClass() throws NoResultException {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		return clazz;
	}

}
