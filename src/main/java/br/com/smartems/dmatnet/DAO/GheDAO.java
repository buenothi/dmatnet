package br.com.smartems.dmatnet.DAO;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.LevAmbientais.GHEEntity;

@Stateless
@Local
public class GheDAO extends AbstractDAO<GHEEntity, Long> {
       
    public GheDAO() {
        super(GHEEntity.class);
    }

}
