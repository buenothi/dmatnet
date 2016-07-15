package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
@LocalBean
@SuppressWarnings("unchecked")
public abstract class AbstractEAO <T, PK> implements IAbstractDAO<T, PK>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	private Class<T> persistentClass;

	public AbstractEAO(Class<T> entityClass) {
		this.persistentClass = entityClass;
	}

	public T read(PK pk)  throws NoResultException {
		return (T) entityManager.find(persistentClass, pk);
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

	@SuppressWarnings({ "rawtypes" })
    public List<T> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(persistentClass));
        return entityManager.createQuery(cq).getResultList();
    }

}
