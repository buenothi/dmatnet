package br.com.smartems.dmatnet.DAO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Stateless
@Local
public class LogradouroDAO extends AbstractDAO<EnderecoTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public LogradouroDAO() {
		super(EnderecoTipoEntity.class);
	}

}
