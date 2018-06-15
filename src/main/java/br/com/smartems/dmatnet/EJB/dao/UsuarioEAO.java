package br.com.smartems.dmatnet.EJB.dao;

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
public class UsuarioEAO extends AbstractEAO<UsuarioEntity, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private CriptografiaString cs;
	private UsuarioEntity usuario;
	private List<UsuarioEntity> usuarios;

	public UsuarioEAO() {
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
			PessoaFisicaDocumentosEntity documento, EnderecoEntity endereco, List<EmailEntity> emails,
			List<TelefoneEntity> telefones, List<EmpresaEntity> empresasAtribuidas) {
		try {
			if (usuario.getIdPessoa() == 0) {
				usuario.setIdUsuarioPai(usuarioPai.getIdPessoa());
				usuario.setDocumentosPessoais(documento);
				usuario.setEmails(emails);
				usuario.setTelefones(telefones);
				usuario.setEnderecos(new HashSet<>());
				usuario.getEnderecos().add(endereco);
				try {
					Set<EmpresaEntity> setEmpresas = new HashSet<EmpresaEntity>(empresasAtribuidas);
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
			List<EnderecoEntity> enderecos, List<EmailEntity> emails, List<TelefoneEntity> telefones,
			List<EmpresaEntity> empresasAtribuidas) {
		this.atribuirDocumentosPessoaFisica(documento, usuarioAtual);
		this.atribuirEmailsPessoaFisica(emails, usuarioAtual);
		this.atribuirTelefonesPessoaFisica(telefones, usuarioAtual);
		this.atribuirEnderecosPessoaFisica(enderecos, usuarioAtual);
		this.atribuirEmpresasAtribuidasPessoaFisica(empresasAtribuidas, usuarioAtual);
		return this.update(usuario);
	}

	private void atribuirDocumentosPessoaFisica(PessoaFisicaDocumentosEntity documento, UsuarioEntity usuarioAtual) {
		if (documento != null) {
			PessoaFisicaDocumentosEntity novoDocumentos = new PessoaFisicaDocumentosEntity();
			try {
				novoDocumentos = documento.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			usuarioAtual.setDocumentosPessoais(novoDocumentos);
		}
	}

	private void atribuirEmailsPessoaFisica(List<EmailEntity> emails, UsuarioEntity usuarioAtual) {
		if (emails != null) {
			List<EmailEntity> novoEmailsPessoaFisica = new ArrayList<EmailEntity>();
			try {
				novoEmailsPessoaFisica = emails;
			} catch (Exception e) {
				e.printStackTrace();
			}
			usuarioAtual.setEmails(novoEmailsPessoaFisica);
		}
	}

	private void atribuirTelefonesPessoaFisica(List<TelefoneEntity> telefones, UsuarioEntity usuarioAtual) {
		if (telefones != null) {
			List<TelefoneEntity> novoTelefones = new ArrayList<TelefoneEntity>();
			try {
				novoTelefones = telefones;
			} catch (Exception e) {
				e.printStackTrace();
			}
			usuarioAtual.setTelefones(novoTelefones);
		}
	}

	private void atribuirEnderecosPessoaFisica(List<EnderecoEntity> enderecos, UsuarioEntity usuarioAtual) {
		if (enderecos != null) {
			Set<EnderecoEntity> novoEnderecos = new TreeSet<EnderecoEntity>();
			try {
				for (EnderecoEntity endereco : enderecos) {
					novoEnderecos.add(endereco);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			usuarioAtual.setEnderecos(novoEnderecos);
		}
	}

	private void atribuirEmpresasAtribuidasPessoaFisica(List<EmpresaEntity> empresasAtribuidas,
			UsuarioEntity usuarioAtual) {
		if (empresasAtribuidas != null) {
			Set<EmpresaEntity> novoEmpresasAtribuidas = new TreeSet<EmpresaEntity>();
			try {
				for (EmpresaEntity empresa : empresasAtribuidas) {
					novoEmpresasAtribuidas.add(empresa);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			usuarioAtual.setEmpresasGerenciadas(novoEmpresasAtribuidas);
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
		if (!usuario.getEmails().isEmpty()) {
			for (EmailEntity email : usuarioSelecionado.getEmails()) {
				if (email.isEmailPrincipal()) {
					emailPrincipal = email;
				}
			}
		}
		return emailPrincipal;
	}

	public List<EmailEntity> selecionarEmailsSecundarios(EmailEntity emailPrincipal, UsuarioEntity usuarioSelecionado)
			throws Exception {
		List<EmailEntity> emailsSecundarios = new ArrayList<EmailEntity>();
		if (!usuarioSelecionado.getEmails().isEmpty() && usuarioSelecionado.getEmails().remove(emailPrincipal)){
			emailsSecundarios = usuarioSelecionado.getEmails();
		} else {
			emailsSecundarios = usuarioSelecionado.getEmails();
		}
		return emailsSecundarios;
	}

}