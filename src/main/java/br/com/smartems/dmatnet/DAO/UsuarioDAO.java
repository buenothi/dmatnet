package br.com.smartems.dmatnet.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.util.CriptografiaString;

@Stateless
@Local
public class UsuarioDAO extends AbstractDAO<UsuarioEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	@EJB
	private CriptografiaString cs;
	private UsuarioEntity usuario;
	private List<UsuarioEntity> usuarios;

	public UsuarioDAO() {
		super(UsuarioEntity.class);
	}

	public UsuarioEntity logarUsuario(String login, String senha) throws NoResultException {
		String senhaCriptograda = cs.obterHashString(senha);
		this.usuario = (UsuarioEntity) entityManager.createNamedQuery("Usuario.logarUsuario")
				.setParameter("login", login).setParameter("senha", senhaCriptograda).getSingleResult();
		return usuario;

	}

	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuario) throws NoResultException {
		this.usuarios = (List<UsuarioEntity>) entityManager.createNamedQuery("Usuario.listarUsuariosFilhos")
				.setParameter("idUsuarioPai", usuario.getIdUsuarioPai()).getResultList();
		return usuarios;
	}

	public String gerarNovaSenha(UsuarioEntity usuario) {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		String senha = "";
		for (int x = 0; x < 10; x++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}
		usuario.setSenha(senha);
		this.entityManager.merge(usuario);
		return senha;
	}

	public UsuarioEntity salvarNovoUsuario(UsuarioEntity usuario, UsuarioEntity usuarioPai,
			PessoaFisicaDocumentosEntity documento, EnderecoEntity endereco, Set<EmailEntity> emails,
			Set<TelefoneEntity> telefones, List<EmpresaEntity> empresasAtribuidas) {
		try {
			if (usuario.getIdPessoa() == 0) {
				usuario.setIdUsuarioPai(usuarioPai.getIdPessoa());
				usuario.setDocumentosPessoais(documento);
				usuario.setEmails(emails);
				usuario.setTelefones(telefones);
				usuario.setEnderecos(new HashSet<>());
				usuario.getEnderecos().add(endereco);
				try {
					List<EmpresaEntity> setEmpresas = new ArrayList<EmpresaEntity>(empresasAtribuidas);
					usuario.setEmpresasGerenciadas(setEmpresas);
				} catch (NullPointerException npe) {
					npe.printStackTrace();
				}
				this.create(usuario);
			}
		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return usuario;
	}

	public UsuarioEntity alterarUsuario(UsuarioEntity usuarioAtual, PessoaFisicaDocumentosEntity documento,
			List<EnderecoEntity> enderecos, Set<EmailEntity> emails, Set<TelefoneEntity> telefones,
			List<EmpresaEntity> empresasAtribuidas) {
		this.atribuirDocumentosPessoaFisica(documento, usuarioAtual);
		this.atribuirEmailsPessoaFisica(emails, usuarioAtual);
		this.atribuirTelefonesPessoaFisica(telefones, usuarioAtual);
		this.atribuirEnderecosPessoaFisica(enderecos, usuarioAtual);
		this.atribuirEmpresasAtribuidasPessoaFisica(empresasAtribuidas, usuarioAtual);
		return this.update(usuarioAtual);
	}

	private void atribuirDocumentosPessoaFisica(PessoaFisicaDocumentosEntity documento, UsuarioEntity usuarioAtual) {
		try {
			PessoaFisicaDocumentosEntity novoDocumentos = new PessoaFisicaDocumentosEntity();
			novoDocumentos = documento.clone();
			usuarioAtual.setDocumentosPessoais(novoDocumentos);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private void atribuirEmailsPessoaFisica(Set<EmailEntity> emails, UsuarioEntity usuarioAtual) {
		try {
			Set<EmailEntity> novoEmailsPessoaFisica = new TreeSet<>(emails);
			novoEmailsPessoaFisica = emails;
			usuarioAtual.setEmails(novoEmailsPessoaFisica);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void atribuirTelefonesPessoaFisica(Set<TelefoneEntity> telefones, UsuarioEntity usuarioAtual) {
		try {
			Set<TelefoneEntity> novoTelefones = new TreeSet<>(telefones);
			novoTelefones = telefones;
			usuarioAtual.setTelefones(novoTelefones);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void atribuirEnderecosPessoaFisica(List<EnderecoEntity> enderecos, UsuarioEntity usuarioAtual) {
		try {
			Set<EnderecoEntity> novoEnderecos = new HashSet<EnderecoEntity>();
			novoEnderecos.addAll(enderecos);
			usuarioAtual.setEnderecos(novoEnderecos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void atribuirEmpresasAtribuidasPessoaFisica(List<EmpresaEntity> empresasAtribuidas,
			UsuarioEntity usuarioAtual) {
		try {
			List<EmpresaEntity> novoEmpresasAtribuidas = new ArrayList<EmpresaEntity>();
			novoEmpresasAtribuidas.addAll(empresasAtribuidas);
			usuarioAtual.setEmpresasGerenciadas(novoEmpresasAtribuidas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public EnderecoEntity selecionarEnderecoUsuarioAtual(UsuarioEntity usuario) throws Exception {
		Date dataMaisRecente;
		EnderecoEntity enderecoUsuarioAtual = new EnderecoEntity();
		if (!usuario.getEnderecos().isEmpty()) {
			List<EnderecoEntity> listaEnderecoProvisoria = new ArrayList<EnderecoEntity>();
			for (EnderecoEntity endereco : usuario.getEnderecos()) {
				listaEnderecoProvisoria.add(endereco);
			}
			dataMaisRecente = listaEnderecoProvisoria.get(0).getDataInicioEndereco();
			enderecoUsuarioAtual = listaEnderecoProvisoria.get(0);
			for (EnderecoEntity endereco : usuario.getEnderecos()) {
				if (endereco.getDataInicioEndereco().compareTo(dataMaisRecente) >= 0
						&& endereco.getDataTerminoEndereco() == null) {
					dataMaisRecente = endereco.getDataInicioEndereco();
					enderecoUsuarioAtual = endereco;
				}
			}
		}
		return enderecoUsuarioAtual;
	}

	public List<EnderecoEntity> selecionarEnderecosUsuarioHistorico(EnderecoEntity enderecoAtual,
			UsuarioEntity usuarioSelecionado) throws Exception {
		List<EnderecoEntity> enderecosHistorico = new ArrayList<EnderecoEntity>();
		if (!usuarioSelecionado.getEnderecos().isEmpty()) {
			usuarioSelecionado.getEnderecos().remove(enderecoAtual);
			List<EnderecoEntity> listaEnderecoProvisoria = new ArrayList<EnderecoEntity>();
			for (EnderecoEntity endereco : usuarioSelecionado.getEnderecos()) {
				listaEnderecoProvisoria.add(endereco);
			}
			enderecosHistorico = listaEnderecoProvisoria;
		}
		return enderecosHistorico;
	}

	public EmailEntity selecionarEmailUsuarioPrincipal(UsuarioEntity usuarioSelecionado) throws Exception {
		EmailEntity emailPrincipal = new EmailEntity();
		if (!usuarioSelecionado.getEmails().isEmpty()) {
			for (EmailEntity email : usuarioSelecionado.getEmails()) {
				if (email.isEmailPrincipal()) {
					emailPrincipal = email;
				}
			}
			if (emailPrincipal.getIdEmail() < 1 ) {
				emailPrincipal = usuarioSelecionado.getEmails().iterator().next();
			}
		}
		return emailPrincipal;
	}

	public Set<EmailEntity> selecionarEmailsSecundarios(EmailEntity emailPrincipal, UsuarioEntity usuarioSelecionado)
			throws Exception {
		if (!usuarioSelecionado.getEmails().isEmpty() && usuarioSelecionado.getEmails().remove(emailPrincipal)) {
			return usuarioSelecionado.getEmails();
		} else {
			return usuarioSelecionado.getEmails();
		}
	}

	public Set<TelefoneEntity> obterTelefonesUsuario(UsuarioEntity usuarioSelecionado) throws Exception {
		if (!usuarioSelecionado.getTelefones().isEmpty()) {
			return usuarioSelecionado.getTelefones();
		} else {
			return null;
		}
	}
	
	public UsuarioEntity excluirUsuarioDaEmpresa(UsuarioEntity usuarioSelecionado) throws Exception {
		UsuarioEntity usuarioDeletado = usuarioSelecionado;
		this.delete(usuarioSelecionado);
		return usuarioDeletado;
	}
}