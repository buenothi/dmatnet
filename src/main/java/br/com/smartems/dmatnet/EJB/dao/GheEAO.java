package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.LevAmbientais.GHEEntity;

@Stateless
@Local
public class GheEAO extends AbstractEAO<GHEEntity, Long> {
       
    public GheEAO() {
        super();
        // TODO Auto-generated constructor stub
    }

}
