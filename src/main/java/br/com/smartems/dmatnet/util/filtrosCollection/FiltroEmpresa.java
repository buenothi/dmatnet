package br.com.smartems.dmatnet.util.filtrosCollection;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

public class FiltroEmpresa implements Filter<EmpresaEntity>{

	@Override
	public boolean match(EmpresaEntity empresa, String nomeEmpresa) {
		boolean empresaOk = empresa.getNome() != null
				? empresa.getNome().contains(nomeEmpresa.toUpperCase()) : false;
		return empresaOk;
	}

}
