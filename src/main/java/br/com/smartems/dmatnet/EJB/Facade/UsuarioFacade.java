package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;
import java.util.Set;

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
			PessoaFisicaDocumentosEntity documento, EnderecoEntity endereço, Set<EmailEntity> emails,
			Set<TelefoneEntity> telefones, List<EmpresaEntity> empresasAtribuidas) {
		return usuarioEAO.salvarNovoUsuario(usuario, usuarioPai, documento, endereço, emails, telefones,
				empresasAtribuidas);
	}

	@Override
	public UsuarioEntity alterarUsuario(UsuarioEntity usuarioAtual, PessoaFisicaDocumentosEntity documento,
			List<EnderecoEntity> enderecos, Set<EmailEntity> emails, Set<TelefoneEntity> telefones,
			List<EmpresaEntity> empresasAtribuidas) {
		return usuarioEAO.alterarUsuario(usuarioAtual, documento, enderecos, emails, telefones, empresasAtribuidas);
	}

	@Override
	public EnderecoEntity selecionarEnderecoUsuarioAtual(UsuarioEntity usuario) throws Exception {
		return usuarioEAO.selecionarEnderecoUsuarioAtual(usuario);
	}

	@Override
	public List<EnderecoEntity> selecionarEnderecosUsuarioHistorico(EnderecoEntity enderecoAtual,
			UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioEAO.selecionarEnderecosUsuarioHistorico(enderecoAtual, usuarioSelecionado);
	}

	@Override
	public EmailEntity selecionarEmailUsuarioPrincipal(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioEAO.selecionarEmailUsuarioPrincipal(usuarioSelecionado);
	}

	@Override
	public Set<EmailEntity> selecionarEmailsSecundarios(EmailEntity emailPrincipal, UsuarioEntity usuarioSelecionado)
			throws Exception {
		return usuarioEAO.selecionarEmailsSecundarios(emailPrincipal, usuarioSelecionado);
	}

	@Override
	public Set<TelefoneEntity> atribuirTelefoneUsuario(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioEAO.atribuirTelefoneUsuario(usuarioSelecionado);
	}

}
