package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@Local
public interface EmpresaGrupoFacadeLocal extends AbstractFacade<EmpresaGrupoEntity> {

	public List<EmpresaGrupoEntity> listarGrupoEmpresas(UsuarioEntity usuarioLogado);
}
