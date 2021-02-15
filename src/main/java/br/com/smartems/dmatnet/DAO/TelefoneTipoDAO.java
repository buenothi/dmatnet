package br.com.smartems.dmatnet.DAO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@Stateless
@Local
public class TelefoneTipoDAO extends AbstractDAO<TelefoneTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public TelefoneTipoDAO() {
		super(TelefoneTipoEntity.class);
	}

}
