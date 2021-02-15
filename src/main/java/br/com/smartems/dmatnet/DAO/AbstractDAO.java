package br.com.smartems.dmatnet.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@SuppressWarnings("unchecked")
public abstract class AbstractDAO <T, PK> implements IAbstractDAO<T, PK>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	private Class<T> persistentClass;

	public AbstractDAO(Class<T> entityClass) {
		this.persistentClass = entityClass;
	}

	public T read(PK pk)  throws NoResultException {
		return (T) entityManager.find(persistentClass, pk);
	}

	public void create(T entity) throws NoResultException {
		entityManager.persist(entity);
	}

	public T update(T entity) throws NoResultException {
		Object c = this.entityManager.merge(entity);
		entityManager.flush();
		return (T)c;
	}

	public void delete(T entity) throws NoResultException {
		Object c = entityManager.merge(entity);
		entityManager.remove(c);
	}

	@SuppressWarnings({ "rawtypes" })
    public List<T> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(persistentClass));
        return entityManager.createQuery(cq).getResultList();
    }

}
