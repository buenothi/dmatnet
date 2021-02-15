package br.com.smartems.dmatnet.DAO;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Stateless
@Local
public class EstadosDAO extends AbstractDAO<EstadoEntity, Long>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public EstadosDAO() {
		super(EstadoEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<CidadeEntity> listarCidadesPorEstado(EstadoEntity estado){
		Query query = entityManager.createNamedQuery("Estados.listarTodasCidadesPorEstado", CidadeEntity.class);
		query.setParameter("estado", estado);		
		return (List<CidadeEntity>) query.getResultList();
	}
	
}
