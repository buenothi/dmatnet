package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Local
public interface UsuarioFacadeLocal extends AbstractFacade<UsuarioEntity> {

	public abstract UsuarioEntity logarUsuario(String login, String senha);

	public abstract List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuarioPai);

	public abstract String gerarNovaSenha(UsuarioEntity usuario);

	public abstract UsuarioEntity salvarNovoUsuario(UsuarioEntity usuario, UsuarioEntity usuarioPai, PessoaFisicaDocumentosEntity documento,
			EnderecoEntity endereço, List<EmailEntity> emails, List<TelefoneEntity> telefones,
			List<EmpresaEntity> empresasAtribuidas);
}
