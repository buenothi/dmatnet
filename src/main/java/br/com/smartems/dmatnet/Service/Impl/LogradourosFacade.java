package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.DAO.LogradouroDAO;
import br.com.smartems.dmatnet.Service.LogradourosServiceLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Stateless
public class LogradourosFacade implements LogradourosServiceLocal {

	@EJB
	private LogradouroDAO logradourosEAO;
	
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
