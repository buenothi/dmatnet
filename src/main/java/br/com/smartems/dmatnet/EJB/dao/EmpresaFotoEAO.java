package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;

@Stateless
@Local
public class EmpresaFotoEAO extends AbstractEAO<EmpresaFoto, Long> {

	public EmpresaFotoEAO() {
		super(EmpresaFoto.class);
	}

}
