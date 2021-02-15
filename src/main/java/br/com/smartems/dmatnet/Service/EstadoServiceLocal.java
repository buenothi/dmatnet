package br.com.smartems.dmatnet.Service;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Local
public interface EstadoServiceLocal extends AbstractService<EstadoEntity>{
	public List<CidadeEntity> listarCidadesPorEstado(EstadoEntity estado);
}
