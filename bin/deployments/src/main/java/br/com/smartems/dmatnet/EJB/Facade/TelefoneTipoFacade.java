package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.TelefoneTipoEAO;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@Stateless
public class TelefoneTipoFacade implements TelefoneTipoFacadeLocal {
	
	@EJB
	private TelefoneTipoEAO telefoneTipoEAO;

	@Override
	public TelefoneTipoEntity read(long pk) {
		return telefoneTipoEAO.read(pk);
	}

	@Override
	public void create(TelefoneTipoEntity entity) {
		telefoneTipoEAO.create(entity);
	}

	@Override
	public TelefoneTipoEntity update(TelefoneTipoEntity entity) {
		return telefoneTipoEAO.update(entity);
	}

	@Override
	public void delete(TelefoneTipoEntity entity) {
		telefoneTipoEAO.delete(entity);
	}

	@Override
	public List<TelefoneTipoEntity> findAll() {
		return telefoneTipoEAO.findAll();
	}

}
