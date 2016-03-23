package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;

@Stateless
@Local
public class TrabalhadorEAO extends AbstractEAO<TrabalhadorEntity, Long> {
       
    public TrabalhadorEAO() {
        super();
        // TODO Auto-generated constructor stub
    }

}
