package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;

@Stateless
@Local
public class TrabalhadorEAO extends AbstractEAO<TrabalhadorEntity, Long> {
    
	@PersistenceContext
    private EntityManager em;
	
    public TrabalhadorEAO() {
        super();
    }
    
}
