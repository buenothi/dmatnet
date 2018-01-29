package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@Stateless
@Local
public class TelefoneTipoEAO extends AbstractEAO<TelefoneTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public TelefoneTipoEAO() {
		super(TelefoneTipoEntity.class);
	}

}
