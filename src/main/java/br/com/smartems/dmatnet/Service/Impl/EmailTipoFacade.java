package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.DAO.EmailTipoDAO;
import br.com.smartems.dmatnet.Service.EmailTipoServiceLocal;
import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@Stateless
public class EmailTipoFacade implements EmailTipoServiceLocal {

	
	@EJB
	private EmailTipoDAO emailTipoEAO;
	
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
