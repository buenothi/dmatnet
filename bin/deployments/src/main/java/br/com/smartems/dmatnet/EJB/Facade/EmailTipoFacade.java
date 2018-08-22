package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.EmailTipoEAO;
import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@Stateless
public class EmailTipoFacade implements EmailTipoFacadeLocal {

	
	@EJB
	private EmailTipoEAO emailTipoEAO;
	
	@Override
	public EmailTipoEntity read(long pk) {
		return emailTipoEAO.read(pk);
	}

	@Override
	public void create(EmailTipoEntity entity) {
		emailTipoEAO.create(entity);
	}

	@Override
	public EmailTipoEntity update(EmailTipoEntity entity) {
		return emailTipoEAO.update(entity);
	}

	@Override
	public void delete(EmailTipoEntity entity) {
		emailTipoEAO.delete(entity);
	}

	@Override
	public List<EmailTipoEntity> findAll() {
		return emailTipoEAO.findAll();
	}

}
