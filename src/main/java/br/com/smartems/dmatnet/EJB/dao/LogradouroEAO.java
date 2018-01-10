package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Stateless
@Local
public class LogradouroEAO extends AbstractEAO<EnderecoTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public LogradouroEAO() {
		super(EnderecoTipoEntity.class);
	}

}
