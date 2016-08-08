package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Stateless
@Local
public class EstadosEAO extends AbstractEAO<EstadoEntity, Long>{

	public EstadosEAO() {
		super(EstadoEntity.class);
	}

}
