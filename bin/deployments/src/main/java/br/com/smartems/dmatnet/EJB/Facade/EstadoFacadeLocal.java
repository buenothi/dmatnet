package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Local
public interface EstadoFacadeLocal extends AbstractFacade<EstadoEntity>{
	public List<CidadeEntity> listarCidadesPorEstado(EstadoEntity estado);
}
