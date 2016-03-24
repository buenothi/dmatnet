package br.com.smartems.dmatnet.EJB.Facade;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.AbstractPessoaJuridicaEntity;

@Local
public interface PessoaJuridicaFacadeLocal extends AbstractFacade<AbstractPessoaJuridicaEntity> {

}
