package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.AbstractPessoaJuridicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Local
public interface PessoaJuridicaFacadeLocal extends AbstractFacade<AbstractPessoaJuridicaEntity> {

	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado);
}
