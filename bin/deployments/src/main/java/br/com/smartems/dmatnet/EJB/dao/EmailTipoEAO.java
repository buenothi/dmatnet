package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@Stateless
@Local
public class EmailTipoEAO extends AbstractEAO<EmailTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public EmailTipoEAO() {
		super(EmailTipoEntity.class);
	}
}
