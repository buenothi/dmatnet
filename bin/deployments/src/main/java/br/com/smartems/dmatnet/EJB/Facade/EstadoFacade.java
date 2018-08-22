package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.EstadosEAO;
import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Stateless
public class EstadoFacade implements EstadoFacadeLocal {

	@EJB
	private EstadosEAO estadosEAO;

	@Override
	public EstadoEntity read(long pk) {
		return estadosEAO.read(pk);
	}

	@Override
	public void create(EstadoEntity entity) {
		estadosEAO.create(entity);
	}

	@Override
	public EstadoEntity update(EstadoEntity entity) {
		return estadosEAO.update(entity);
	}

	@Override
	public void delete(EstadoEntity entity) {
		estadosEAO.delete(entity);
	}

	@Override
	public List<EstadoEntity> findAll() {
		return estadosEAO.findAll();
	}
	
	public List<CidadeEntity> listarCidadesPorEstado(EstadoEntity estado){
		return estadosEAO.listarCidadesPorEstado(estado);
	}

}
