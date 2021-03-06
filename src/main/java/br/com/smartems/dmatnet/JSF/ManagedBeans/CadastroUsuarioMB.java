package br.com.smartems.dmatnet.JSF.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

import br.com.smartems.dmatnet.Service.UsuarioServiceLocal;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;
import br.com.smartems.dmatnet.util.StringsUtilitarios;

@Named
@ViewScoped
public class CadastroUsuarioMB implements Serializable {

	@Inject
	private UsuarioMB usuarioMB;

	@Inject
	private PrincipalMB principalMB;

	@Inject
	private CadastroEmpresaMB cadastroEmpresaMB;

	@EJB
	private UsuarioServiceLocal usuarioFachada;

	@EJB
	private StringsUtilitarios stringUtils;

	private UsuarioEntity usuario;
	private EnderecoEntity enderecoUsuario;

	// usuário novo dentro de dadosCadastrais

	private UsuarioEntity usuarioAtual;
	private UsuarioEntity usuarioNovo;
	private UsuarioEntity usuarioExcluir;
	private UsuarioEntity usuarioSelecionado;

	private PessoaFisicaDocumentosEntity documentosPessoaisUsuario;
	private PessoaFisicaDocumentosEntity documentosPessoaisUsuarioSelecionado;

	private EnderecoEntity enderecoUsuarioAtual;
	private EnderecoEntity enderecoUsuarioExcluir;
	private EnderecoEntity enderecoUsuarioSelecionado;
	private List<EnderecoEntity> enderecosUsuarioHistorico;

	private TelefoneEntity telefoneUsuario;
	private TelefoneEntity telefoneUsuarioSelecionado;
	private TelefoneEntity telefoneUsuarioExcluir;
	private Set<TelefoneEntity> telefonesUsuario;
	private Set<TelefoneEntity> telefonesUsuarioSelecionado;

	private EmailEntity emailUsuario;
	private EmailEntity emailPrincipalUsuarioSelecionado;
	private EmailEntity emailUsuarioExcluir;
	private Set<EmailEntity> emailsUsuario;
	private Set<EmailEntity> emailsUsuarioSelecionado;

	private Set<EmpresaGrupoEntity> gruposGerenciados;
	private Set<EmpresaGrupoEntity> gruposGerenciadosUsuarioSelecionado;
	private Set<EmpresaEntity> empresasGerenciadas;
	private Set<EmpresaEntity> empresasGerenciadasUsuarioSelecionado;

	private DualListModel<EmpresaEntity> empresasUsuario;
	private DualListModel<EmpresaEntity> empresasUsuarioSelecionado;
	private List<EmpresaEntity> empresasDisponiveisUsuario;
	private List<EmpresaEntity> empresasDisponiveisUsuarioSelecionado;
	private List<EmpresaEntity> empresasAtribuidasUsuario;
	private List<EmpresaEntity> empresasAtribuidasUsuarioSelecionado;

	private boolean isDialogNovoUsuarioRendered = false;
	private boolean isCadastroUsuarioDadosRendered = false;

	private boolean isCadastroUsuarioDoctosRGRendered = false;
	private boolean isCadastroUsuarioDoctosCPFRendered = false;
	private boolean isCadastroUsuarioDoctosRICRendered = false;
	private boolean isCadastroUsuarioDoctosRNERendered = false;
	private boolean isCadastroUsuarioDoctosCNHRendered = false;

	private boolean isCadastroUsuarioEnderecoRendered = false;
	private boolean isCadastroUsuarioEmailRendered = false;
	private boolean isCadastroUsuarioTelefoneRendered = false;
	private boolean isCadastroUsuarioUsuarioRendered = false;
	private boolean isCadastroUsuarioEmpresasRendered = false;
	private boolean isDisabledUsuarioEmpresas = true;

	// botões dados do usuário de dadosCadastrais

	private boolean isDadosUsuariosEditar = false;
	private boolean isDadosUsuariosExibir = true;
	private boolean isMensagemHasUsuario = false;
	private boolean isDisabledSelecaoTabelaUsuarios = false;

	// botões dados do usuário de documentos

	private boolean isMensagemHasRGRendered = false;
	private boolean isMensagemHasCPFRendered = false;
	private boolean isMensagemHasRICRendered = false;
	private boolean isMensagemHasRNERendered = false;
	private boolean isMensagemHasCNHRendered = false;

	// botões endereço de usuarios dentro de dadosCadastrais

	private boolean isEnderecoUsuarioRendered = false;
	private boolean isBtnEnderecoUsuarioEditarDesativado = false;
	private boolean isBtnEnderecoUsuarioCancelarDesativado = true;
	private boolean isBtnEnderecoUsuarioSalvarDesativado = true;
	private boolean isBtnEnderecoUsuarioNovoDesativado = false;
	private boolean isEnderecoUsuarioEditarRender = false;
	private boolean isBtnEnderecoUsuarioExcluirDesativado = true;
	private boolean isMensagemHasEnderecoRendered = false;

	// botões usuarios dentro de dadosCadastrais

	private boolean isBtnUsuarioEditarDesativado = true;
	private boolean isBtnUsuarioCancelarDesativado = true;
	private boolean isBtnUsuarioSalvarDesativado = true;
	private boolean isBtnUsuarioNovoDesativado = false;
	private boolean isBtnUsuarioExcluirDesativado = true;
	private boolean isBtnUsuarioExcluirRender = true;

	// botões usuarios dentro de contatosUsuario

	private boolean isBtnContatosEditarDesativado = true;
	private boolean isBtnContatosCancelarDesativado = true;
	private boolean isBtnContatosNovoDesativado = true;
	private boolean isBtnContatosSalvarDesativado = false;
	private boolean isMensagemHasContatoRendered = false;
	private boolean isMensagemHasEmailRendered = false;
	private boolean isMensagemHasTelefoneRendered = false;
	private boolean isCadastroUsuarioSelecionadoEmailRendered = false;
	private boolean isCadastroUsuarioSelecionadoTelefoneRendered = false;

	private boolean isMensagemSelecionarUsuarioRendered = true;
	private boolean isMensagemHasUsuarioRendered = false;
	private boolean isCadastroUsuarioSelecionadoUsuarioRendered = false;
	
	private boolean isBtnNovoEmail = false;
	private boolean isBtnAdicionarEmail = true;

	// botões endereço de usuários dentro de enderecoUsuario

	private boolean isBtnEnderecoCancelarDesativado;
	private boolean isBtnEnderecoEditarDesativado;
	private boolean isBtnEnderecoNovoDesativado;
	private boolean isBtnEnderecoSalvarDesativado;

	private static final long serialVersionUID = 1L;

	public CadastroUsuarioMB() {
	}

	// início dos getters e setters

	public UsuarioEntity getUsuario() {
		if (usuario == null) {
			this.usuario = new UsuarioEntity();
		}
		return usuario;
	}

	public UsuarioMB getUsuarioMB() {
		return usuarioMB;
	}

	public void setUsuarioMB(UsuarioMB usuarioMB) {
		this.usuarioMB = usuarioMB;
	}

	public PrincipalMB getPrincipalMB() {
		return principalMB;
	}

	public void setPrincipalMB(PrincipalMB principalMB) {
		this.principalMB = principalMB;
	}

	public CadastroEmpresaMB getCadastroEmpresaMB() {
		return cadastroEmpresaMB;
	}

	public void setCadastroEmpresaMB(CadastroEmpresaMB cadastroEmpresaMB) {
		this.cadastroEmpresaMB = cadastroEmpresaMB;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public void setUsuarioFachada(UsuarioServiceLocal usuarioFachada) {
		this.usuarioFachada = usuarioFachada;
	}

	public EnderecoEntity getEnderecoUsuario() {
		if (enderecoUsuario == null) {
			this.enderecoUsuario = new EnderecoEntity();
		}
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(EnderecoEntity enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public UsuarioEntity getUsuarioAtual() {
		if (usuarioAtual == null) {
			this.usuarioAtual = new UsuarioEntity();
		}
		return usuarioAtual;
	}

	public void setUsuarioAtual(UsuarioEntity usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

	public UsuarioEntity getUsuarioNovo() {
		if (usuarioNovo == null) {
			this.usuarioNovo = new UsuarioEntity();
		}
		return usuarioNovo;
	}

	public void setUsuarioNovo(UsuarioEntity usuarioNovo) {
		this.usuarioNovo = usuarioNovo;
	}

	public UsuarioEntity getUsuarioExcluir() {
		if (usuarioExcluir == null) {
			this.usuarioExcluir = new UsuarioEntity();
		}
		return usuarioExcluir;
	}

	public void setUsuarioExcluir(UsuarioEntity usuarioExcluir) {
		this.usuarioExcluir = usuarioExcluir;
	}

	public UsuarioEntity getUsuarioSelecionado() {
		if (this.usuarioSelecionado == null) {
			this.usuarioSelecionado = new UsuarioEntity();
			this.usuarioSelecionado.setDocumentosPessoais(new PessoaFisicaDocumentosEntity());
		}
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(UsuarioEntity usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public void setDocumentosPessoaisUsuario(PessoaFisicaDocumentosEntity documentosPessoaisUsuario) {
		this.documentosPessoaisUsuario = documentosPessoaisUsuario;
	}

	public PessoaFisicaDocumentosEntity getDocumentosPessoaisUsuario() {
		if (documentosPessoaisUsuario == null) {
			this.documentosPessoaisUsuario = new PessoaFisicaDocumentosEntity();
		}
		return documentosPessoaisUsuario;
	}

	public PessoaFisicaDocumentosEntity getDocumentosPessoaisUsuarioSelecionado() {
		if (documentosPessoaisUsuarioSelecionado == null) {
			documentosPessoaisUsuarioSelecionado = new PessoaFisicaDocumentosEntity();
		}
		return documentosPessoaisUsuarioSelecionado;
	}

	public void setDocumentosPessoaisUsuarioSelecionado(PessoaFisicaDocumentosEntity documentosPessoaisUsuario) {
		this.documentosPessoaisUsuarioSelecionado = documentosPessoaisUsuario;
	}

	public EnderecoEntity getEnderecoUsuarioAtual() {
		if (enderecoUsuarioAtual == null) {
			this.enderecoUsuarioAtual = new EnderecoEntity();
		}
		return enderecoUsuarioAtual;
	}

	public void setEnderecoUsuarioAtual(EnderecoEntity enderecoUsuarioAtual) {
		this.enderecoUsuarioAtual = enderecoUsuarioAtual;
	}

	public EnderecoEntity getEnderecoUsuarioExcluir() {
		if (enderecoUsuarioExcluir == null) {
			this.enderecoUsuarioExcluir = new EnderecoEntity();
		}
		return enderecoUsuarioExcluir;
	}

	public void setEnderecoUsuarioExcluir(EnderecoEntity enderecoUsuarioExcluir) {
		this.enderecoUsuarioExcluir = enderecoUsuarioExcluir;
	}

	public EnderecoEntity getEnderecoUsuarioSelecionado() {
		if (enderecoUsuarioSelecionado == null) {
			this.enderecoUsuarioSelecionado = new EnderecoEntity();
		}
		return enderecoUsuarioSelecionado;
	}

	public void setEnderecoUsuarioSelecionado(EnderecoEntity enderecoUsuarioSelecionado) {
		this.enderecoUsuarioSelecionado = enderecoUsuarioSelecionado;
	}

	public List<EnderecoEntity> getEnderecosUsuarioHistorico() {
		if (enderecosUsuarioHistorico == null) {
			this.enderecosUsuarioHistorico = new ArrayList<EnderecoEntity>();
		}
		return enderecosUsuarioHistorico;
	}

	public void setEnderecosUsuarioHistorico(List<EnderecoEntity> enderecosUsuarioHistorico) {
		this.enderecosUsuarioHistorico = enderecosUsuarioHistorico;
	}

	public TelefoneEntity getTelefoneUsuario() {
		if (telefoneUsuario == null) {
			this.telefoneUsuario = new TelefoneEntity();
		}
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(TelefoneEntity telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public TelefoneEntity getTelefoneUsuarioSelecionado() {
		if (telefoneUsuarioSelecionado == null) {
			this.telefoneUsuarioSelecionado = new TelefoneEntity();
		}
		return telefoneUsuarioSelecionado;
	}

	public void setTelefoneUsuarioSelecionado(TelefoneEntity telefoneUsuarioSelecionado) {
		this.telefoneUsuarioSelecionado = telefoneUsuarioSelecionado;
	}

	public TelefoneEntity getTelefoneUsuarioExcluir() {
		if (telefoneUsuarioExcluir == null) {
			this.telefoneUsuarioExcluir = new TelefoneEntity();
		}
		return telefoneUsuarioExcluir;
	}

	public void setTelefoneUsuarioExcluir(TelefoneEntity telefoneUsuarioExcluir) {
		this.telefoneUsuarioExcluir = telefoneUsuarioExcluir;
	}

	public Set<TelefoneEntity> getTelefonesUsuario() {
		if (telefonesUsuario == null) {
			this.telefonesUsuario = new TreeSet<TelefoneEntity>();
		}
		return telefonesUsuario;
	}

	public void setTelefonesUsuario(Set<TelefoneEntity> telefonesUsuario) {
		this.telefonesUsuario = telefonesUsuario;
	}

	public Set<TelefoneEntity> getTelefonesUsuarioSelecionado() {
		if (telefonesUsuarioSelecionado == null) {
			this.telefonesUsuarioSelecionado = new TreeSet<TelefoneEntity>();
		}
		return telefonesUsuarioSelecionado;
	}

	public void setTelefonesUsuarioSelecionado(Set<TelefoneEntity> telefonesUsuarioSelecionado) {
		this.telefonesUsuarioSelecionado = telefonesUsuarioSelecionado;
	}

	public EmailEntity getEmailUsuario() {
		if (emailUsuario == null) {
			this.emailUsuario = new EmailEntity();
		}
		return emailUsuario;
	}

	public void setEmailUsuario(EmailEntity emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public EmailEntity getEmailUsuarioExcluir() {
		if (emailUsuarioExcluir == null) {
			this.emailUsuarioExcluir = new EmailEntity();
		}
		return emailUsuarioExcluir;
	}

	public void setEmailUsuarioExcluir(EmailEntity emailUsuarioExcluir) {
		this.emailUsuarioExcluir = emailUsuarioExcluir;
	}

	public Set<EmailEntity> getEmailsUsuario() {
		if (emailsUsuario == null) {
			this.emailsUsuario = new TreeSet<EmailEntity>();
		}
		return emailsUsuario;
	}

	public void setEmailsUsuario(Set<EmailEntity> emailsUsuario) {
		this.emailsUsuario = emailsUsuario;
	}

	public Set<EmailEntity> getEmailsUsuarioSelecionado() {
		if (emailsUsuarioSelecionado == null) {
			this.emailsUsuarioSelecionado = new TreeSet<EmailEntity>();
		}
		return emailsUsuarioSelecionado;
	}

	public void setEmailsUsuarioSelecionado(Set<EmailEntity> emailsUsuarioSelecionado) {
		this.emailsUsuarioSelecionado = emailsUsuarioSelecionado;
	}

	public EmailEntity getEmailPrincipalUsuarioSelecionado() {
		if (this.emailPrincipalUsuarioSelecionado == null) {
			this.emailPrincipalUsuarioSelecionado = new EmailEntity();
		}
		return emailPrincipalUsuarioSelecionado;
	}

	public void setEmailPrincipalUsuarioSelecionado(EmailEntity emailPrincipalUsuarioSelecionado) {
		this.emailPrincipalUsuarioSelecionado = emailPrincipalUsuarioSelecionado;
	}

	public Set<EmpresaGrupoEntity> getGruposGerenciados() {
		if (gruposGerenciados == null) {
			this.gruposGerenciados = new TreeSet<EmpresaGrupoEntity>();
		}
		return gruposGerenciados;
	}

	public void setGruposGerenciados(Set<EmpresaGrupoEntity> gruposGerenciados) {
		this.gruposGerenciados = gruposGerenciados;
	}

	public Set<EmpresaGrupoEntity> getGruposGerenciadosUsuarioSelecionado() {
		if (gruposGerenciadosUsuarioSelecionado == null) {
			this.gruposGerenciadosUsuarioSelecionado = new TreeSet<EmpresaGrupoEntity>();
		}
		return gruposGerenciadosUsuarioSelecionado;
	}

	public void setGruposGerenciadosUsuarioSelecionado(Set<EmpresaGrupoEntity> gruposGerenciadosUsuarioSelecionado) {
		this.gruposGerenciadosUsuarioSelecionado = gruposGerenciadosUsuarioSelecionado;
	}

	public Set<EmpresaEntity> getEmpresasGerenciadas() {
		if (empresasGerenciadas == null) {
			this.empresasGerenciadas = new TreeSet<EmpresaEntity>();
		}
		return empresasGerenciadas;
	}

	public void setEmpresasGerenciadas(Set<EmpresaEntity> empresasGerenciadas) {
		this.empresasGerenciadas = empresasGerenciadas;
	}

	public Set<EmpresaEntity> getEmpresasGerenciadasUsuarioSelecionado() {
		if (empresasGerenciadasUsuarioSelecionado == null) {
			this.empresasGerenciadasUsuarioSelecionado = new TreeSet<EmpresaEntity>();
		}
		return empresasGerenciadasUsuarioSelecionado;
	}

	public void setEmpresasGerenciadasUsuarioSelecionado(Set<EmpresaEntity> empresasGerenciadasUsuarioSelecionado) {
		this.empresasGerenciadasUsuarioSelecionado = empresasGerenciadasUsuarioSelecionado;
	}

	public DualListModel<EmpresaEntity> getEmpresasUsuario() {
		if (empresasUsuario == null) {
			this.empresasUsuario = new DualListModel<EmpresaEntity>();
		}
		return empresasUsuario;
	}

	public void setEmpresasUsuario(DualListModel<EmpresaEntity> empresasUsuario) {
		this.empresasUsuario = empresasUsuario;
	}

	public DualListModel<EmpresaEntity> getEmpresasUsuarioSelecionado() {
		if (this.empresasUsuarioSelecionado == null) {
			this.empresasUsuarioSelecionado = new DualListModel<EmpresaEntity>();
		}
		return empresasUsuarioSelecionado;
	}

	public void setEmpresasUsuarioSelecionado(DualListModel<EmpresaEntity> empresasUsuarioSelecionado) {
		this.empresasUsuarioSelecionado = empresasUsuarioSelecionado;
	}

	public List<EmpresaEntity> getEmpresasDisponiveisUsuario() {
		if (empresasDisponiveisUsuario == null) {
			this.empresasDisponiveisUsuario = new ArrayList<EmpresaEntity>();
		}
		return empresasDisponiveisUsuario;
	}

	public void setEmpresasDisponiveisUsuario(List<EmpresaEntity> empresasDisponiveisUsuario) {
		this.empresasDisponiveisUsuario = empresasDisponiveisUsuario;
	}

	public List<EmpresaEntity> getEmpresasDisponiveisUsuarioSelecionado() {
		if (empresasDisponiveisUsuarioSelecionado == null) {
			this.empresasDisponiveisUsuarioSelecionado = new ArrayList<EmpresaEntity>();
		}
		return empresasDisponiveisUsuarioSelecionado;
	}

	public void setEmpresasDisponiveisUsuarioSelecionado(List<EmpresaEntity> empresasDisponiveisUsuarioSelecionado) {
		this.empresasDisponiveisUsuarioSelecionado = empresasDisponiveisUsuarioSelecionado;
	}

	public List<EmpresaEntity> getEmpresasAtribuidasUsuario() {
		if (empresasAtribuidasUsuario == null) {
			this.empresasAtribuidasUsuario = new ArrayList<EmpresaEntity>();
		}
		return empresasAtribuidasUsuario;
	}

	public void setEmpresasAtribuidasUsuario(List<EmpresaEntity> empresasAtribuidasUsuario) {
		this.empresasAtribuidasUsuario = empresasAtribuidasUsuario;
	}

	public List<EmpresaEntity> getEmpresasAtribuidasUsuarioSelecionado() {
		if (empresasAtribuidasUsuarioSelecionado == null) {
			this.empresasAtribuidasUsuarioSelecionado = new ArrayList<EmpresaEntity>();
		}
		return empresasAtribuidasUsuarioSelecionado;
	}

	public void setEmpresasAtribuidasUsuarioSelecionado(List<EmpresaEntity> empresasAtribuidasUsuarioSelecionado) {
		this.empresasAtribuidasUsuarioSelecionado = empresasAtribuidasUsuarioSelecionado;
	}

	public boolean isDialogNovoUsuarioRendered() {
		return isDialogNovoUsuarioRendered;
	}

	public void setDialogNovoUsuarioRendered(boolean isDialogNovoUsuarioRendered) {
		this.isDialogNovoUsuarioRendered = isDialogNovoUsuarioRendered;
	}

	public boolean isCadastroUsuarioDadosRendered() {
		return isCadastroUsuarioDadosRendered;
	}

	public void setCadastroUsuarioDadosRendered(boolean isCadastroUsuarioDadosRendered) {
		this.isCadastroUsuarioDadosRendered = isCadastroUsuarioDadosRendered;
	}

	public boolean isCadastroUsuarioDoctosRGRendered() {
		return isCadastroUsuarioDoctosRGRendered;
	}

	public void setCadastroUsuarioDoctosRGRendered(boolean isCadastroUsuarioDoctosRGRendered) {
		this.isCadastroUsuarioDoctosRGRendered = isCadastroUsuarioDoctosRGRendered;
	}

	public boolean isCadastroUsuarioDoctosCPFRendered() {
		return isCadastroUsuarioDoctosCPFRendered;
	}

	public void setCadastroUsuarioDoctosCPFRendered(boolean isCadastroUsuarioDoctosCPFRendered) {
		this.isCadastroUsuarioDoctosCPFRendered = isCadastroUsuarioDoctosCPFRendered;
	}

	public boolean isCadastroUsuarioDoctosRICRendered() {
		return isCadastroUsuarioDoctosRICRendered;
	}

	public void setCadastroUsuarioDoctosRICRendered(boolean isCadastroUsuarioDoctosRICRendered) {
		this.isCadastroUsuarioDoctosRICRendered = isCadastroUsuarioDoctosRICRendered;
	}

	public boolean isCadastroUsuarioDoctosRNERendered() {
		return isCadastroUsuarioDoctosRNERendered;
	}

	public void setCadastroUsuarioDoctosRNERendered(boolean isCadastroUsuarioDoctosRNERendered) {
		this.isCadastroUsuarioDoctosRNERendered = isCadastroUsuarioDoctosRNERendered;
	}

	public boolean isCadastroUsuarioDoctosCNHRendered() {
		return isCadastroUsuarioDoctosCNHRendered;
	}

	public void setCadastroUsuarioDoctosCNHRendered(boolean isCadastroUsuarioDoctosCNHRendered) {
		this.isCadastroUsuarioDoctosCNHRendered = isCadastroUsuarioDoctosCNHRendered;
	}

	public boolean isCadastroUsuarioEnderecoRendered() {
		return isCadastroUsuarioEnderecoRendered;
	}

	public void setCadastroUsuarioEnderecoRendered(boolean isCadastroUsuarioEnderecoRendered) {
		this.isCadastroUsuarioEnderecoRendered = isCadastroUsuarioEnderecoRendered;
	}

	public boolean isCadastroUsuarioEmailRendered() {
		return isCadastroUsuarioEmailRendered;
	}

	public void setCadastroUsuarioEmailRendered(boolean isCadastroUsuarioEmailRendered) {
		this.isCadastroUsuarioEmailRendered = isCadastroUsuarioEmailRendered;
	}

	public boolean isCadastroUsuarioTelefoneRendered() {
		return isCadastroUsuarioTelefoneRendered;
	}

	public void setCadastroUsuarioTelefoneRendered(boolean isCadastroUsuarioTelefoneRendered) {
		this.isCadastroUsuarioTelefoneRendered = isCadastroUsuarioTelefoneRendered;
	}

	public boolean isCadastroUsuarioUsuarioRendered() {
		return isCadastroUsuarioUsuarioRendered;
	}

	public void setCadastroUsuarioUsuarioRendered(boolean isCadastroUsuarioUsuarioRendered) {
		this.isCadastroUsuarioUsuarioRendered = isCadastroUsuarioUsuarioRendered;
	}

	public boolean isCadastroUsuarioEmpresasRendered() {
		return isCadastroUsuarioEmpresasRendered;
	}

	public void setCadastroUsuarioEmpresasRendered(boolean isCadastroUsuarioEmpresasRendered) {
		this.isCadastroUsuarioEmpresasRendered = isCadastroUsuarioEmpresasRendered;
	}

	public boolean isDisabledUsuarioEmpresas() {
		return isDisabledUsuarioEmpresas;
	}

	public void setDisabledUsuarioEmpresas(boolean isDisabledUsuarioEmpresas) {
		this.isDisabledUsuarioEmpresas = isDisabledUsuarioEmpresas;
	}

	public boolean isMensagemSelecionarUsuarioRendered() {
		return isMensagemSelecionarUsuarioRendered;
	}

	public void setMensagemSelecionarUsuarioRendered(boolean isMensagemSelecionarUsuarioRendered) {
		this.isMensagemSelecionarUsuarioRendered = isMensagemSelecionarUsuarioRendered;
	}

	public boolean isCadastroUsuarioSelecionadoTelefoneRendered() {
		return isCadastroUsuarioSelecionadoTelefoneRendered;
	}

	public void setCadastroUsuarioSelecionadoTelefoneRendered(boolean isCadastroUsuarioSelecionadoTelefoneRendered) {
		this.isCadastroUsuarioSelecionadoTelefoneRendered = isCadastroUsuarioSelecionadoTelefoneRendered;
	}

	public boolean isMensagemHasUsuarioRendered() {
		return isMensagemHasUsuarioRendered;
	}

	public void setMensagemHasUsuarioRendered(boolean isMensagemHasUsuarioRendered) {
		this.isMensagemHasUsuarioRendered = isMensagemHasUsuarioRendered;
	}

	public boolean isCadastroUsuarioSelecionadoUsuarioRendered() {
		return isCadastroUsuarioSelecionadoUsuarioRendered;
	}

	public void setCadastroUsuarioSelecionadoUsuarioRendered(boolean isCadastroUsuarioSelecionadoUsuarioRendered) {
		this.isCadastroUsuarioSelecionadoUsuarioRendered = isCadastroUsuarioSelecionadoUsuarioRendered;
	}

	public boolean isBtnNovoEmail() {
		return isBtnNovoEmail;
	}

	public void setBtnNovoEmail(boolean isBtnNovoEmail) {
		this.isBtnNovoEmail = isBtnNovoEmail;
	}

	public boolean isBtnAdicionarEmail() {
		return isBtnAdicionarEmail;
	}

	public void setBtnAdicionarEmail(boolean isBtnAdicionarEmail) {
		this.isBtnAdicionarEmail = isBtnAdicionarEmail;
	}

	public boolean isDadosUsuariosEditar() {
		return isDadosUsuariosEditar;
	}

	public void setDadosUsuariosEditar(boolean isDadosUsuariosEditar) {
		this.isDadosUsuariosEditar = isDadosUsuariosEditar;
	}

	public boolean isDadosUsuariosExibir() {
		return isDadosUsuariosExibir;
	}

	public void setDadosUsuariosExibir(boolean isDadosUsuariosExibir) {
		this.isDadosUsuariosExibir = isDadosUsuariosExibir;
	}

	public boolean isMensagemHasUsuario() {
		return isMensagemHasUsuario;
	}

	public void setMensagemHasUsuario(boolean isMensagemHasUsuario) {
		this.isMensagemHasUsuario = isMensagemHasUsuario;
	}

	public boolean isDisabledSelecaoTabelaUsuarios() {
		return isDisabledSelecaoTabelaUsuarios;
	}

	public void setDisabledSelecaoTabelaUsuarios(boolean isDisabledSelecaoTabelaUsuarios) {
		this.isDisabledSelecaoTabelaUsuarios = isDisabledSelecaoTabelaUsuarios;
	}

	public boolean isMensagemHasRGRendered() {
		return isMensagemHasRGRendered;
	}

	public void setMensagemHasRGRendered(boolean isMensagemHasRGRendered) {
		this.isMensagemHasRGRendered = isMensagemHasRGRendered;
	}

	public boolean isMensagemHasCPFRendered() {
		return isMensagemHasCPFRendered;
	}

	public void setMensagemHasCPFRendered(boolean isMensagemHasCPFRendered) {
		this.isMensagemHasCPFRendered = isMensagemHasCPFRendered;
	}

	public boolean isMensagemHasRICRendered() {
		return isMensagemHasRICRendered;
	}

	public void setMensagemHasRICRendered(boolean isMensagemHasRICRendered) {
		this.isMensagemHasRICRendered = isMensagemHasRICRendered;
	}

	public boolean isMensagemHasRNERendered() {
		return isMensagemHasRNERendered;
	}

	public void setMensagemHasRNERendered(boolean isMensagemHasRNERendered) {
		this.isMensagemHasRNERendered = isMensagemHasRNERendered;
	}

	public boolean isMensagemHasCNHRendered() {
		return isMensagemHasCNHRendered;
	}

	public void setMensagemHasCNHRendered(boolean isMensagemHasCNHRendered) {
		this.isMensagemHasCNHRendered = isMensagemHasCNHRendered;
	}

	public boolean isEnderecoUsuarioRendered() {
		return isEnderecoUsuarioRendered;
	}

	public void setEnderecoUsuarioRendered(boolean isEnderecoUsuarioRendered) {
		this.isEnderecoUsuarioRendered = isEnderecoUsuarioRendered;
	}

	public boolean isBtnEnderecoUsuarioEditarDesativado() {
		return isBtnEnderecoUsuarioEditarDesativado;
	}

	public void setBtnEnderecoUsuarioEditarDesativado(boolean isBtnEnderecoUsuarioEditarDesativado) {
		this.isBtnEnderecoUsuarioEditarDesativado = isBtnEnderecoUsuarioEditarDesativado;
	}

	public boolean isBtnEnderecoUsuarioCancelarDesativado() {
		return isBtnEnderecoUsuarioCancelarDesativado;
	}

	public void setBtnEnderecoUsuarioCancelarDesativado(boolean isBtnEnderecoUsuarioCancelarDesativado) {
		this.isBtnEnderecoUsuarioCancelarDesativado = isBtnEnderecoUsuarioCancelarDesativado;
	}

	public boolean isBtnEnderecoUsuarioSalvarDesativado() {
		return isBtnEnderecoUsuarioSalvarDesativado;
	}

	public void setBtnEnderecoUsuarioSalvarDesativado(boolean isBtnEnderecoUsuarioSalvarDesativado) {
		this.isBtnEnderecoUsuarioSalvarDesativado = isBtnEnderecoUsuarioSalvarDesativado;
	}

	public boolean isBtnEnderecoUsuarioNovoDesativado() {
		return isBtnEnderecoUsuarioNovoDesativado;
	}

	public void setBtnEnderecoUsuarioNovoDesativado(boolean isBtnEnderecoUsuarioNovoDesativado) {
		this.isBtnEnderecoUsuarioNovoDesativado = isBtnEnderecoUsuarioNovoDesativado;
	}

	public boolean isEnderecoUsuarioEditarRender() {
		return isEnderecoUsuarioEditarRender;
	}

	public void setEnderecoUsuarioEditarRender(boolean isEnderecoUsuarioEditarRender) {
		this.isEnderecoUsuarioEditarRender = isEnderecoUsuarioEditarRender;
	}

	public boolean isBtnEnderecoUsuarioExcluirDesativado() {
		return isBtnEnderecoUsuarioExcluirDesativado;
	}

	public void setBtnEnderecoUsuarioExcluirDesativado(boolean isBtnEnderecoUsuarioExcluirDesativado) {
		this.isBtnEnderecoUsuarioExcluirDesativado = isBtnEnderecoUsuarioExcluirDesativado;
	}

	public boolean isMensagemHasEnderecoRendered() {
		return isMensagemHasEnderecoRendered;
	}

	public void setMensagemHasEnderecoRendered(boolean isMensagemHasEnderecoRendered) {
		this.isMensagemHasEnderecoRendered = isMensagemHasEnderecoRendered;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isBtnUsuarioEditarDesativado() {
		return isBtnUsuarioEditarDesativado;
	}

	public void setBtnUsuarioEditarDesativado(boolean isBtnUsuarioEditarDesativado) {
		this.isBtnUsuarioEditarDesativado = isBtnUsuarioEditarDesativado;
	}

	public boolean isBtnUsuarioCancelarDesativado() {
		return isBtnUsuarioCancelarDesativado;
	}

	public void setBtnUsuarioCancelarDesativado(boolean isBtnUsuarioCancelarDesativado) {
		this.isBtnUsuarioCancelarDesativado = isBtnUsuarioCancelarDesativado;
	}

	public boolean isBtnUsuarioSalvarDesativado() {
		return isBtnUsuarioSalvarDesativado;
	}

	public void setBtnUsuarioSalvarDesativado(boolean isBtnUsuarioSalvarDesativado) {
		this.isBtnUsuarioSalvarDesativado = isBtnUsuarioSalvarDesativado;
	}

	public boolean isBtnUsuarioNovoDesativado() {
		return isBtnUsuarioNovoDesativado;
	}

	public void setBtnUsuarioNovoDesativado(boolean isBtnUsuarioNovoDesativado) {
		this.isBtnUsuarioNovoDesativado = isBtnUsuarioNovoDesativado;
	}

	public boolean isBtnUsuarioExcluirDesativado() {
		return isBtnUsuarioExcluirDesativado;
	}

	public void setBtnUsuarioExcluirDesativado(boolean isBtnUsuarioExcluirDesativado) {
		this.isBtnUsuarioExcluirDesativado = isBtnUsuarioExcluirDesativado;
	}

	public boolean isBtnUsuarioExcluirRender() {
		return isBtnUsuarioExcluirRender;
	}

	public void setBtnUsuarioExcluirRender(boolean isBtnUsuarioExcluirRender) {
		this.isBtnUsuarioExcluirRender = isBtnUsuarioExcluirRender;
	}

	public boolean isBtnContatosCancelarDesativado() {
		return isBtnContatosCancelarDesativado;
	}

	public void setBtnContatosCancelarDesativado(boolean isBtnContatosCancelarDesativado) {
		this.isBtnContatosCancelarDesativado = isBtnContatosCancelarDesativado;
	}

	public boolean isBtnContatosEditarDesativado() {
		return isBtnContatosEditarDesativado;
	}

	public void setBtnContatosEditarDesativado(boolean isBtnContatosEditarDesativado) {
		this.isBtnContatosEditarDesativado = isBtnContatosEditarDesativado;
	}

	public boolean isBtnContatosNovoDesativado() {
		return isBtnContatosNovoDesativado;
	}

	public void setBtnContatosNovoDesativado(boolean isBtnContatosNovoDesativado) {
		this.isBtnContatosNovoDesativado = isBtnContatosNovoDesativado;
	}

	public boolean isBtnContatosSalvarDesativado() {
		return isBtnContatosSalvarDesativado;
	}

	public void setBtnContatosSalvarDesativado(boolean isBtnContatosSalvarDesativado) {
		this.isBtnContatosSalvarDesativado = isBtnContatosSalvarDesativado;
	}

	public boolean isMensagemHasContatoRendered() {
		return isMensagemHasContatoRendered;
	}

	public void setMensagemHasContatoRendered(boolean isMensagemHasContatoRendered) {
		this.isMensagemHasContatoRendered = isMensagemHasContatoRendered;
	}

	public boolean isCadastroUsuarioSelecionadoEmailRendered() {
		return isCadastroUsuarioSelecionadoEmailRendered;
	}

	public boolean isMensagemHasEmailRendered() {
		return isMensagemHasEmailRendered;
	}

	public void setMensagemHasEmailRendered(boolean isMensagemHasEmailRendered) {
		this.isMensagemHasEmailRendered = isMensagemHasEmailRendered;
	}

	public boolean isMensagemHasTelefoneRendered() {
		return isMensagemHasTelefoneRendered;
	}

	public void setMensagemHasTelefoneRendered(boolean isMensagemHasTelefoneRendered) {
		this.isMensagemHasTelefoneRendered = isMensagemHasTelefoneRendered;
	}

	public void setCadastroUsuarioSelecionadoEmailRendered(boolean isCadastroUsuarioSelecionadoEmailRendered) {
		this.isCadastroUsuarioSelecionadoEmailRendered = isCadastroUsuarioSelecionadoEmailRendered;
	}

	public boolean isBtnEnderecoCancelarDesativado() {
		return isBtnEnderecoCancelarDesativado;
	}

	public void setBtnEnderecoCancelarDesativado(boolean isBtnEnderecoCancelarDesativado) {
		this.isBtnEnderecoCancelarDesativado = isBtnEnderecoCancelarDesativado;
	}

	public boolean isBtnEnderecoEditarDesativado() {
		return isBtnEnderecoEditarDesativado;
	}

	public void setBtnEnderecoEditarDesativado(boolean isBtnEnderecoEditarDesativado) {
		this.isBtnEnderecoEditarDesativado = isBtnEnderecoEditarDesativado;
	}

	public boolean isBtnEnderecoNovoDesativado() {
		return isBtnEnderecoNovoDesativado;
	}

	public void setBtnEnderecoNovoDesativado(boolean isBtnEnderecoNovoDesativado) {
		this.isBtnEnderecoNovoDesativado = isBtnEnderecoNovoDesativado;
	}

	public boolean isBtnEnderecoSalvarDesativado() {
		return isBtnEnderecoSalvarDesativado;
	}

	public void setBtnEnderecoSalvarDesativado(boolean isBtnEnderecoSalvarDesativado) {
		this.isBtnEnderecoSalvarDesativado = isBtnEnderecoSalvarDesativado;
	}

	// fim dos getters e setters

	public String textoGenero(int genero) {
		String textoGenero = "masculino";
		if (genero == 2) {
			textoGenero = "feminino";
		}
		return textoGenero;
	}

	// action dos botões Novo Usuário (cadastroNovoUsuario) dentro de
	// dadosCadastrais

	public UsuarioServiceLocal getUsuarioFachada() {
		return usuarioFachada;
	}

	public void novoUsuarioNaEmpresaSelecionada(ActionEvent evt) {
		this.isDialogNovoUsuarioRendered = true;
	}

	public void fecharDialogNovoUsuario(CloseEvent evt) {
		this.isDialogNovoUsuarioRendered = false;
	}

	public void salvarUsuario(ActionEvent evt) {
		try {
			this.empresasAtribuidasUsuario = this.empresasUsuario.getTarget();
			this.usuarioNovo = this.usuarioFachada.salvarNovoUsuario(this.usuarioNovo,
					this.usuarioMB.getUsuarioLogado(), this.documentosPessoaisUsuario, this.enderecoUsuarioAtual,
					this.emailsUsuario, this.telefonesUsuario, this.empresasAtribuidasUsuario);
			FacesMessage msg = new FacesMessage("Sucesso",
					stringUtils.formatarTextoParaLeitura(this.usuarioNovo.getNome().toString())
							+ " Cadastrado com Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.cadastroEmpresaMB.onSelectionEmpresa(this.cadastroEmpresaMB.getEmpresaSelecionada());
			this.initUsuario();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}

	public void salvarAlteracoesUsuario(ActionEvent evt) {
		try {
			this.empresasAtribuidasUsuario = this.empresasUsuarioSelecionado.getTarget();
			List<EnderecoEntity> enderecos = new ArrayList<EnderecoEntity>();
			try {
				enderecos.add(this.enderecoUsuarioSelecionado);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			try {
				this.emailsUsuarioSelecionado.add(emailPrincipalUsuarioSelecionado);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

			UsuarioEntity usuarioAlterado = this.usuarioFachada.alterarUsuario(this.usuarioSelecionado,
					this.documentosPessoaisUsuarioSelecionado, enderecos, this.emailsUsuarioSelecionado,
					this.telefonesUsuarioSelecionado, this.empresasAtribuidasUsuario);

			FacesMessage msg = new FacesMessage("Sucesso",
					stringUtils.formatarTextoParaLeitura(usuarioAlterado.getNome().toString())
							+ " Atualizado com Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			this.alterarViewParaExibir();

			this.cadastroEmpresaMB.onSelectionEmpresa(this.cadastroEmpresaMB.getEmpresaSelecionada());
			this.initUsuario();
			this.onSelectionUsuario(usuarioAlterado);

		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}

	public void editarUsuario(ActionEvent evt) {
		this.isCadastroUsuarioSelecionadoEmailRendered = true;
		this.isCadastroUsuarioSelecionadoTelefoneRendered = true;

		this.isDadosUsuariosEditar = true;
		this.isDadosUsuariosExibir = false;
		this.isDisabledSelecaoTabelaUsuarios = true;

		this.exibirCadastroAlterarStatusMensagens();

		this.isBtnUsuarioCancelarDesativado = false;
		this.isBtnUsuarioEditarDesativado = true;
		this.isBtnUsuarioSalvarDesativado = false;
		this.isBtnUsuarioNovoDesativado = true;
		this.isBtnUsuarioExcluirDesativado = true;

		this.cadastroEmpresaMB.setTabDadosCadastraisDesativado(true);
		this.cadastroEmpresaMB.setTabEnderecoDesativado(true);
		this.cadastroEmpresaMB.setTabContatoDesativado(false);
		this.cadastroEmpresaMB.setTabEmpregadosDesativado(true);
		this.cadastroEmpresaMB.setTabEstabelecimentosDesativado(true);

		isDisabledUsuarioEmpresas = false;

	}

	public void cancelarUsuario(ActionEvent evt) {
		this.onSelectionUsuario(null);
		this.alterarViewParaExibir();
	}

	private void alterarViewParaExibir() {
		this.isDadosUsuariosEditar = false;
		this.isDadosUsuariosExibir = true;
		this.isDisabledSelecaoTabelaUsuarios = false;

		this.isBtnUsuarioCancelarDesativado = true;
		this.isBtnUsuarioEditarDesativado = false;
		this.isBtnUsuarioSalvarDesativado = true;
		this.isBtnUsuarioNovoDesativado = false;
		this.isBtnUsuarioExcluirDesativado = false;
		
		this.isBtnNovoEmail = false;
		this.isBtnAdicionarEmail = true;

		this.cadastroEmpresaMB.setTabDadosCadastraisDesativado(false);
		this.cadastroEmpresaMB.setTabEnderecoDesativado(false);
		this.cadastroEmpresaMB.setTabContatoDesativado(false);
		this.cadastroEmpresaMB.setTabEmpregadosDesativado(false);
		this.cadastroEmpresaMB.setTabEstabelecimentosDesativado(false);

		isDisabledUsuarioEmpresas = true;
	}

	public void excluirUsuario(ActionEvent evt) {
		try {
			this.usuarioFachada.excluirUsuarioDaEmpresa(usuarioSelecionado);

			FacesMessage msg = new FacesMessage("Sucesso",
					stringUtils.formatarTextoParaLeitura(usuarioSelecionado.getNome().toString())
							+ " Excluído com Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.initUsuario();
	}

	public void imprimirUsuario(ActionEvent evt) {

	}

	public void adicionarEmailContatoUsuarioSelecionado(ActionEvent evt) {
		this.isBtnNovoEmail = false;
		this.emailsUsuarioSelecionado.add(emailPrincipalUsuarioSelecionado);
	}
	
	public void novoEmailContatoUsuarioSelecionado(ActionEvent evt) {
		this.emailsUsuarioSelecionado.add(emailPrincipalUsuarioSelecionado);
		this.emailPrincipalUsuarioSelecionado = new EmailEntity();
		this.isBtnNovoEmail = true;
		this.isBtnAdicionarEmail = false;
	}

	public void adicionarTelefoneContatoUsuarioSelecionado(ActionEvent evt) {
		TelefoneEntity novoTelefone = new TelefoneEntity();
		novoTelefone = this.telefoneUsuarioSelecionado;
		this.telefonesUsuarioSelecionado.add(novoTelefone);
		this.telefoneUsuarioSelecionado = null;
	}

	public void onSelectionUsuario(Object usuario) {

		if (usuario instanceof SelectEvent) {
			this.usuarioSelecionado = (UsuarioEntity) ((SelectEvent) usuario).getObject();
		} else if (usuario instanceof UsuarioEntity) {
			this.usuarioSelecionado = (UsuarioEntity) usuario;
		}

		try {
			if (this.usuarioSelecionado.getDocumentosPessoais() != null) {
				this.documentosPessoaisUsuarioSelecionado = this.usuarioSelecionado.getDocumentosPessoais();
			}

			this.ocultarMensagemSelecionarUsuario();

			this.ocultarCadastroAlterarStatusMensagens();

			this.separarEnderecoUsuarioAtualDoHistorico(this.usuarioSelecionado);

			this.separarEmailUsuarioPrincipalDoSecudario(this.usuarioSelecionado);

			this.exibirTelefoneUsuario(this.usuarioSelecionado);

			this.exibirUsuario(this.usuarioSelecionado);

			this.exibirEmpresasDualList(this.usuarioSelecionado);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void separarEnderecoUsuarioAtualDoHistorico(UsuarioEntity usuario) {
		this.usuarioSelecionado = usuarioFachada.read(usuario.getIdPessoa());
		try {
			this.enderecoUsuarioSelecionado = this.usuarioFachada
					.selecionarEnderecoUsuarioAtual(this.usuarioSelecionado);
			this.enderecosUsuarioHistorico = this.usuarioFachada
					.selecionarEnderecosUsuarioHistorico(this.enderecoUsuarioSelecionado, this.usuarioSelecionado);
		} catch (NullPointerException np) {
			np.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (this.enderecoUsuarioSelecionado.getIdEndereco() > 0) {
				this.isCadastroUsuarioEnderecoRendered = true;
				this.isMensagemHasEnderecoRendered = false;
			} else {
				this.isCadastroUsuarioEnderecoRendered = false;
				this.isMensagemHasEnderecoRendered = true;
				this.isCadastroUsuarioEnderecoRendered = false;
			}

		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isCadastroUsuarioEnderecoRendered = false;
			this.isMensagemHasEnderecoRendered = true;
			this.isCadastroUsuarioEnderecoRendered = false;
		}
	}

	private void separarEmailUsuarioPrincipalDoSecudario(UsuarioEntity usuarioSelecionado) {
		try {
			this.emailPrincipalUsuarioSelecionado = usuarioFachada.selecionarEmailUsuarioPrincipal(usuarioSelecionado);
			this.emailsUsuarioSelecionado = usuarioFachada.selecionarEmailsSecundarios(emailPrincipalUsuarioSelecionado,
					usuarioSelecionado);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (this.emailPrincipalUsuarioSelecionado.getIdEmail() > 0) {
				this.isCadastroUsuarioEmailRendered = true;
				this.isMensagemHasEmailRendered = false;
			} else {
				this.isCadastroUsuarioEmailRendered = false;
				this.isMensagemHasEmailRendered = true;
				this.isCadastroUsuarioSelecionadoEmailRendered = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.isCadastroUsuarioEmailRendered = false;
			this.isMensagemHasEmailRendered = true;
			this.isCadastroUsuarioSelecionadoEmailRendered = false;
		}

	}

	private void exibirTelefoneUsuario(UsuarioEntity usuarioSelecionado) {
		try {
			this.telefonesUsuarioSelecionado = usuarioFachada.obterTelefonesUsuario(usuarioSelecionado);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (this.usuarioSelecionado.getTelefones().size() > 0) {
				this.isCadastroUsuarioTelefoneRendered = true;
				this.isMensagemHasTelefoneRendered = false;
			} else {
				this.isCadastroUsuarioTelefoneRendered = false;
				this.isMensagemHasTelefoneRendered = true;
				this.isCadastroUsuarioSelecionadoTelefoneRendered = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.isCadastroUsuarioTelefoneRendered = false;
			this.isMensagemHasTelefoneRendered = true;
			this.isCadastroUsuarioSelecionadoTelefoneRendered = false;
		}
	}

	private void exibirUsuario(UsuarioEntity usuarioSelecionado) {
		try {
			if (this.usuarioSelecionado.getLogin().length() > 0) {
				this.isMensagemHasUsuarioRendered = false;
				this.isCadastroUsuarioSelecionadoUsuarioRendered = true;
			}
		} catch (Exception e) {
			this.isMensagemHasUsuarioRendered = true;
			this.isCadastroUsuarioSelecionadoUsuarioRendered = false;
		}
	}

	private void exibirEmpresasDualList(UsuarioEntity usuarioSelecionado) {
		this.empresasAtribuidasUsuarioSelecionado = new ArrayList<EmpresaEntity>();
		this.empresasDisponiveisUsuarioSelecionado = new ArrayList<EmpresaEntity>();
		try {

			for (EmpresaEntity empresa : usuarioSelecionado.getEmpresasGerenciadas()) {
				this.empresasAtribuidasUsuarioSelecionado.add(empresa);
			}

			for (EmpresaEntity empresa : this.cadastroEmpresaMB.getEmpresasDisponiveis()) {
				this.empresasDisponiveisUsuarioSelecionado.add(empresa);
			}

			for (EmpresaEntity empresa : this.empresasAtribuidasUsuarioSelecionado) {
				this.empresasDisponiveisUsuarioSelecionado.remove(empresa);
			}

			this.empresasUsuarioSelecionado = new DualListModel<EmpresaEntity>(
					this.empresasDisponiveisUsuarioSelecionado, this.empresasAtribuidasUsuarioSelecionado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ocultarMensagemSelecionarUsuario() {
		this.isMensagemSelecionarUsuarioRendered = false;
		this.isBtnUsuarioEditarDesativado = false;
		this.isBtnUsuarioExcluirDesativado = false;
	}

	private void exibirCadastroAlterarStatusMensagens() {
		this.isCadastroUsuarioDadosRendered = true;
		this.isCadastroUsuarioDoctosRGRendered = true;
		this.isCadastroUsuarioDoctosCPFRendered = true;
		this.isCadastroUsuarioDoctosRICRendered = true;
		this.isCadastroUsuarioDoctosRNERendered = true;
		this.isCadastroUsuarioDoctosCNHRendered = true;
		this.isCadastroUsuarioEnderecoRendered = true;

		this.isMensagemSelecionarUsuarioRendered = false;

		this.isMensagemHasUsuario = false;
		this.isMensagemHasRGRendered = false;
		this.isMensagemHasCPFRendered = false;
		this.isMensagemHasRICRendered = false;
		this.isMensagemHasRNERendered = false;
		this.isMensagemHasCNHRendered = false;

		this.isMensagemHasEnderecoRendered = false;

		this.isMensagemHasTelefoneRendered = false;
	}

	private void ocultarCadastroAlterarStatusMensagens() {

		this.ocultarMensagemSelecionarUsuario();

		try {
			if (this.usuarioSelecionado.getNome().length() > 0) {
				this.isCadastroUsuarioDadosRendered = true;
				this.isMensagemHasUsuario = false;
			} else {
				this.isCadastroUsuarioDadosRendered = false;
				this.isMensagemHasUsuario = true;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isCadastroUsuarioDadosRendered = false;
			this.isMensagemHasUsuario = true;
		}

		try {
			if (this.usuarioSelecionado.getDocumentosPessoais().getNumCPF() > 0) {
				this.isCadastroUsuarioDoctosCPFRendered = true;
				this.isMensagemHasCPFRendered = false;
			} else {
				this.isCadastroUsuarioDoctosCPFRendered = false;
				this.isMensagemHasCPFRendered = true;
			}

		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isCadastroUsuarioDoctosCPFRendered = false;
			this.isMensagemHasCPFRendered = true;
		}

		try {
			if (this.usuarioSelecionado.getDocumentosPessoais().getNumRG().length() > 0) {
				this.isCadastroUsuarioDoctosRGRendered = true;
				this.isMensagemHasRGRendered = false;
			} else {
				this.isCadastroUsuarioDoctosRGRendered = false;
				this.isMensagemHasRGRendered = true;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isCadastroUsuarioDoctosRGRendered = false;
			this.isMensagemHasRGRendered = true;
		}

		try {
			if (this.usuarioSelecionado.getDocumentosPessoais().getNumRic() > 0) {
				this.isCadastroUsuarioDoctosRICRendered = true;
				this.isMensagemHasRICRendered = false;
			} else {
				this.isCadastroUsuarioDoctosRICRendered = false;
				this.isMensagemHasRICRendered = true;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isCadastroUsuarioDoctosRICRendered = false;
			this.isMensagemHasRICRendered = true;
		}

		try {
			if (this.usuarioSelecionado.getDocumentosPessoais().getNumRNE() > 0) {
				this.isCadastroUsuarioDoctosRNERendered = true;
				this.isMensagemHasRNERendered = false;
			} else {
				this.isCadastroUsuarioDoctosRNERendered = false;
				this.isMensagemHasRNERendered = true;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isCadastroUsuarioDoctosRNERendered = false;
			this.isMensagemHasRNERendered = true;
		}

		try {
			if (this.usuarioSelecionado.getDocumentosPessoais().getNumCNH() > 0) {
				this.isCadastroUsuarioDoctosCNHRendered = true;
				this.isMensagemHasCNHRendered = false;
			} else {
				this.isCadastroUsuarioDoctosCNHRendered = false;
				this.isMensagemHasCNHRendered = true;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isCadastroUsuarioDoctosCNHRendered = false;
			this.isMensagemHasCNHRendered = true;
		}

		try {
			if (this.usuarioSelecionado.getEmails().size() > 0) {
				this.isMensagemHasEmailRendered = false;
				this.isCadastroUsuarioSelecionadoEmailRendered = true;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isMensagemHasEmailRendered = true;
		}

		try {
			if (this.usuarioSelecionado.getTelefones().size() > 0) {
				this.isMensagemHasTelefoneRendered = false;
				this.isCadastroUsuarioSelecionadoTelefoneRendered = true;
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			this.isMensagemHasEmailRendered = true;
		}

	}

	/*
	 * public void editarUsuarioNaEmpresaSelecionada(ActionEvent evt) {
	 * 
	 * }
	 */

	public void cancelarUsuarioNaEmpresaSelecionada(ActionEvent evt) {

	}

	public void adicionarTelefoneContato(ActionEvent evt) {
		TelefoneEntity novoTelefone = new TelefoneEntity();
		novoTelefone = this.telefoneUsuario;
		this.telefonesUsuario.add(novoTelefone);
	}

	public void removerTelefoneContatoDaLista(TelefoneEntity telefoneUsuario) {
		try {
			this.telefonesUsuario.remove(telefoneUsuario);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public void removerTelefoneContatoDaListaUsuarioSelecionado(TelefoneEntity telefoneUsuario) {
		try {
			this.telefonesUsuarioSelecionado.remove(telefoneUsuario);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	public void adicionarEmailContato(ActionEvent evt) {
		EmailEntity novoEmail = new EmailEntity();
		novoEmail = this.emailUsuario;
		this.emailsUsuario.add(novoEmail);
	}

	public void removerEmailContatoDaLista(EmailEntity emailUsuario) {
		try {
			this.emailsUsuario.remove(emailUsuario);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public void removerEmailContatoDaListaUsuarioSelecionado(EmailEntity emailUsuario) {
		try {
			this.emailsUsuarioSelecionado.remove(emailUsuario);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	public void editarEnderecoUsuario(ActionEvent evt) {
		this.isBtnEnderecoUsuarioEditarDesativado = true;
		this.isBtnEnderecoUsuarioSalvarDesativado = false;
		this.isBtnEnderecoUsuarioNovoDesativado = true;
		this.isEnderecoUsuarioEditarRender = true;
		this.isBtnEnderecoUsuarioExcluirDesativado = true;
	}

	public void cancelarEnderecoUsuario(ActionEvent evt) {
		this.isBtnEnderecoUsuarioEditarDesativado = false;
		this.isBtnEnderecoUsuarioCancelarDesativado = true;
		this.isBtnEnderecoUsuarioSalvarDesativado = true;
		this.isBtnEnderecoUsuarioNovoDesativado = false;
		this.isEnderecoUsuarioEditarRender = false;
		this.isBtnEnderecoUsuarioExcluirDesativado = false;
		this.renderizarEnderecoUsuario();
		this.renderizarBtnEnderecoUsuarioExcluir();
	}

	public void salvarEnderecoUsuario(ActionEvent evt) {
		this.isBtnEnderecoUsuarioEditarDesativado = false;
		this.isBtnEnderecoUsuarioCancelarDesativado = true;
		this.isBtnEnderecoUsuarioSalvarDesativado = true;
		this.isBtnEnderecoUsuarioNovoDesativado = false;
		this.isEnderecoUsuarioEditarRender = false;
		this.isBtnEnderecoUsuarioExcluirDesativado = false;
		this.renderizarEnderecoUsuario();
		this.renderizarBtnEnderecoUsuarioExcluir();
	}

	public void novoEnderecoUsuario(ActionEvent evt) {
		this.usuarioAtual = new UsuarioEntity();
		this.isEnderecoUsuarioRendered = true;
		this.isBtnEnderecoUsuarioEditarDesativado = true;
		this.isBtnEnderecoUsuarioCancelarDesativado = false;
		this.isBtnEnderecoUsuarioSalvarDesativado = false;
		this.isBtnEnderecoUsuarioNovoDesativado = true;
		this.isEnderecoUsuarioEditarRender = true;
		this.isBtnEnderecoUsuarioExcluirDesativado = true;
	}

	private void renderizarEnderecoUsuario() {
		try {
			if (this.usuarioAtual.getIdPessoa() > 0) {
				this.isEnderecoUsuarioRendered = true;
			} else {
				this.isEnderecoUsuarioRendered = false;
			}
		} catch (NullPointerException excp) {
			this.isEnderecoUsuarioRendered = false;
		}
	}

	private void renderizarBtnEnderecoUsuarioExcluir() {
		try {
			if (this.usuarioAtual.getEnderecos().isEmpty()) {
				this.isBtnEnderecoUsuarioExcluirDesativado = true;
			} else {
				this.isBtnEnderecoUsuarioExcluirDesativado = false;
			}
		} catch (NullPointerException excp) {
			this.isBtnEnderecoUsuarioExcluirDesativado = true;
		}
	}

	public void excluirEnderecoUsuario(ActionEvent evt) {
		this.isEnderecoUsuarioRendered = true;
	}

	public void excluirEnderecoDoHistoricoUsuario(EnderecoEntity endereco) {

	}

	public void dualListEmpresasUsuario(List<EmpresaEntity> empresasDisponiveis,
			List<EmpresaEntity> empresasAtribuidas) {
		try {
			this.empresasUsuario = new DualListModel<EmpresaEntity>(empresasDisponiveis, empresasAtribuidas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------------------
	// action dos botões dentro de dadosUsuario

	@PostConstruct
	public void initUsuario() {

		// neste ponto as variáveis devem ser limpas

		this.usuarioAtual = null;
		this.usuarioNovo = null;
		this.usuarioExcluir = null;

		this.documentosPessoaisUsuario = null;

		this.enderecoUsuarioAtual = null;
		this.enderecoUsuarioExcluir = null;
		this.enderecosUsuarioHistorico = null;

		this.telefoneUsuario = null;
		this.telefoneUsuarioExcluir = null;
		this.telefonesUsuario = null;

		this.emailUsuario = null;
		this.emailUsuarioExcluir = null;
		this.emailsUsuario = null;

		this.gruposGerenciados = null;
		this.empresasGerenciadas = null;

		this.empresasUsuario = null;
		this.empresasUsuarioSelecionado = null;
		this.empresasDisponiveisUsuario = null;
		this.empresasAtribuidasUsuario = null;
		this.empresasDisponiveisUsuarioSelecionado = null;
		this.empresasAtribuidasUsuarioSelecionado = null;
		this.isDisabledUsuarioEmpresas = true;

		this.isDisabledSelecaoTabelaUsuarios = false;
		this.isDialogNovoUsuarioRendered = false;
		this.isCadastroUsuarioDadosRendered = false;
		this.isCadastroUsuarioDoctosRGRendered = false;
		this.isCadastroUsuarioDoctosCPFRendered = false;
		this.isCadastroUsuarioDoctosRICRendered = false;
		this.isCadastroUsuarioDoctosRNERendered = false;
		this.isCadastroUsuarioDoctosCNHRendered = false;
		this.isCadastroUsuarioEnderecoRendered = false;
		this.isCadastroUsuarioEmailRendered = false;
		this.isCadastroUsuarioTelefoneRendered = false;
		this.isCadastroUsuarioUsuarioRendered = false;
		this.isCadastroUsuarioEmpresasRendered = false;
		this.isCadastroUsuarioSelecionadoEmailRendered = false;
		this.isCadastroUsuarioSelecionadoTelefoneRendered = false;
		this.isCadastroUsuarioSelecionadoUsuarioRendered = false;

		this.isMensagemSelecionarUsuarioRendered = true;
		this.isMensagemHasUsuario = false;
		this.isMensagemHasRGRendered = false;
		this.isMensagemHasCPFRendered = false;
		this.isMensagemHasRICRendered = false;
		this.isMensagemHasRNERendered = false;
		this.isMensagemHasCNHRendered = false;
		this.isMensagemHasEnderecoRendered = false;
		this.isMensagemHasContatoRendered = false;
		this.isCadastroUsuarioEmailRendered = false;
		this.isMensagemHasEmailRendered = false;
		this.isCadastroUsuarioTelefoneRendered = false;
		this.isMensagemHasTelefoneRendered = false;
		this.isBtnNovoEmail = false;
		this.isBtnAdicionarEmail = true;

		try {
			this.empresasAtribuidasUsuario = new ArrayList<EmpresaEntity>();
			this.dualListEmpresasUsuario(this.cadastroEmpresaMB.getEmpresasDisponiveis(),
					this.empresasAtribuidasUsuario);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
