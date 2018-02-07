package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.UsuarioEAO;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Stateless
@Local
public class UsuarioFacade implements UsuarioFacadeLocal {

	@EJB
	private UsuarioEAO usuarioEAO;

	public UsuarioFacade() {
	}

	@Override
	public UsuarioEntity read(long pk) {
		return usuarioEAO.read(pk);
	}

	@Override
	public void create(UsuarioEntity usuario) {
		usuarioEAO.create(usuario);
	}

	@Override
	public UsuarioEntity update(UsuarioEntity usuario) {
		return usuarioEAO.update(usuario);
	}

	@Override
	public void delete(UsuarioEntity usuario) {
		usuarioEAO.delete(usuario);
	}

	@Override
	public List<UsuarioEntity> findAll() {
		return usuarioEAO.findAll();
	}

	@Override
	public UsuarioEntity logarUsuario(String login, String senha) {
		return usuarioEAO.logarUsuario(login, senha);
	}

	@Override
	public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuarioPai) {
		return usuarioEAO.listarUsuariosFilhos(usuarioPai);
	}

	@Override
	public String gerarNovaSenha(UsuarioEntity usuario) {
		return usuarioEAO.gerarNovaSenha(usuario);
	}

	@Override
	public UsuarioEntity salvarNovoUsuario(UsuarioEntity usuario, UsuarioEntity usuarioPai,
			PessoaFisicaDocumentosEntity documento, EnderecoEntity endereço, List<EmailEntity> emails,
			List<TelefoneEntity> telefones, List<EmpresaEntity> empresasAtribuidas) {
		return usuarioEAO.salvarNovoUsuario(usuario, usuarioPai, documento, endereço, emails, telefones,
				empresasAtribuidas);
	}

}
