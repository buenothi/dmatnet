package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.LogradouroEAO;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Stateless
public class LogradourosFacade implements LogradourosFacadeLocal {

	@EJB
	private LogradouroEAO logradourosEAO;
	
	@Override
	public EnderecoTipoEntity read(long pk) {
		return logradourosEAO.read(pk);
	}

	@Override
	public void create(EnderecoTipoEntity entity) {
		logradourosEAO.create(entity);
	}

	@Override
	public EnderecoTipoEntity update(EnderecoTipoEntity entity) {
		return logradourosEAO.update(entity);
	}

	@Override
	public void delete(EnderecoTipoEntity entity) {
		logradourosEAO.delete(entity);
	}

	@Override
	public List<EnderecoTipoEntity> findAll() {
		return logradourosEAO.findAll();
	}

}
