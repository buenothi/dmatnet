package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class LocaisTrabalhoEAO extends AbstractEAO<LocaisTrabalhoEAO, Long> {
	
    public LocaisTrabalhoEAO() {
        super();
    }

}
