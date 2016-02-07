package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Local
public interface UsuarioFacadeLocal extends AbstractFacade<UsuarioEntity>{

	public abstract UsuarioEntity logarUsuario(String login, String senha);
	public abstract List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuarioPai);
	public abstract String gerarNovaSenha(UsuarioEntity usuario);
}
