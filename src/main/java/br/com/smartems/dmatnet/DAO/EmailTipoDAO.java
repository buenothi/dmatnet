package br.com.smartems.dmatnet.DAO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@Stateless
@Local
public class EmailTipoDAO extends AbstractDAO<EmailTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public EmailTipoDAO() {
		super(EmailTipoEntity.class);
	}
}
