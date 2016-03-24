package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.AbstractPessoaJuridicaEntity;

@Stateless
@Local
public class PessoaJuridicaEAO extends AbstractEAO<AbstractPessoaJuridicaEntity, Long> {

    public PessoaJuridicaEAO() {
        super();
    }

}
