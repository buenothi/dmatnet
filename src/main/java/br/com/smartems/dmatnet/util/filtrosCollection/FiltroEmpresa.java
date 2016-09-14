package br.com.smartems.dmatnet.util.filtrosCollection;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

public class FiltroEmpresa implements Filter<EmpresaEntity>{

	public FiltroEmpresa() {
	}
	
	@Override
	public boolean match(EmpresaEntity empresa, String nomeEmpresa) {
		boolean empresaOk = empresa.getNome() != null
				? empresa.getNome().contains(nomeEmpresa) : false;
		return empresaOk;
	}

}
