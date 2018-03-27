package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

import br.com.smartems.dmatnet.EJB.Facade.UsuarioFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;
import br.com.smartems.dmatnet.util.StringsUtilitarios;

@ManagedBean
@ViewScoped
public class CadastroUsuarioMB implements Serializable {

	@ManagedProperty(value = "#{usuarioMB}")
	private UsuarioMB usuarioMB;

	@ManagedProperty(value = "#{principalMB}")
	private PrincipalMB principalMB;

	@ManagedProperty(value = "#{cadastroEmpresaMB}")
	private CadastroEmpresaMB cadastroEmpresaMB;

	@EJB
	private UsuarioFacadeLocal usuarioFachada;
	
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

	private EnderecoEntity enderecoUsuarioAtual;
	private EnderecoEntity enderecoUsuarioExcluir;
	private List<EnderecoEntity> enderecosUsuarioHistorico;

	private TelefoneEntity telefoneUsuario;
	private TelefoneEntity telefoneUsuarioExcluir;
	private List<TelefoneEntity> telefonesUsuario;

	private EmailEntity emailUsuario;
	private EmailEntity emailUsuarioExcluir;
	private List<EmailEntity> emailsUsuario;

	private Set<EmpresaGrupoEntity> gruposGerenciados;
	private Set<EmpresaEntity> empresasGerenciadas;

	private DualListModel<EmpresaEntity> empresasUsuario;
	private List<EmpresaEntity> empresasDisponiveisUsuario;
	private List<EmpresaEntity> empresasAtribuidasUsuario;
	
	private boolean isDialogNovoUsuarioRendered = false;

	// botões endereço de usuarios dentro de dadosCadastrais

	private boolean isEnderecoUsuarioRendered = false;
	private boolean isBtnEnderecoUsuarioEditarDesativado = false;
	private boolean isBtnEnderecoUsuarioCancelarDesativado = true;
	private boolean isBtnEnderecoUsuarioSalvarDesativado = true;
	private boolean isBtnEnderecoUsuarioNovoDesativado = false;
	private boolean isEnderecoUsuarioEditarRender = false;
	private boolean isBtnEnderecoUsuarioExcluirDesativado = true;

	// botões usuarios dentro de dadosCadastrais

	private boolean isBtnUsuarioEditarDesativado;
	private boolean isBtnUsuarioCancelarDesativado;
	private boolean isBtnUsuarioSalvarDesativado;
	private boolean isBtnUsuarioNovoDesativado;

	// botões usuarios dentro de contatosUsuario

	private boolean isBtnContatosCancelarDesativado;
	private boolean isBtnContatosEditarDesativado;
	private boolean isBtnContatosNovoDesativado;
	private boolean isBtnContatosSalvarDesativado;

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

	public void setUsuarioFachada(UsuarioFacadeLocal usuarioFachada) {
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
		if (this.usuarioSelecionado == null){
			this.usuarioSelecionado = new UsuarioEntity();			
		}
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(UsuarioEntity usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public PessoaFisicaDocumentosEntity getDocumentosPessoaisUsuario() {
		if (documentosPessoaisUsuario == null) {
			this.documentosPessoaisUsuario = new PessoaFisicaDocumentosEntity();
		}
		return documentosPessoaisUsuario;
	}

	public void setDocumentosPessoaisUsuario(PessoaFisicaDocumentosEntity documentosPessoaisUsuario) {
		this.documentosPessoaisUsuario = documentosPessoaisUsuario;
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
		return enderecoUsuarioExcluir;
	}

	public void setEnderecoUsuarioExcluir(EnderecoEntity enderecoUsuarioExcluir) {
		if (enderecoUsuarioExcluir == null) {
			this.enderecoUsuarioExcluir = new EnderecoEntity();
		}
		this.enderecoUsuarioExcluir = enderecoUsuarioExcluir;
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

	public TelefoneEntity getTelefoneUsuarioExcluir() {
		if (telefoneUsuarioExcluir == null) {
			this.telefoneUsuarioExcluir = new TelefoneEntity();
		}
		return telefoneUsuarioExcluir;
	}

	public void setTelefoneUsuarioExcluir(TelefoneEntity telefoneUsuarioExcluir) {
		this.telefoneUsuarioExcluir = telefoneUsuarioExcluir;
	}

	public List<TelefoneEntity> getTelefonesUsuario() {
		if (telefonesUsuario == null) {
			this.telefonesUsuario = new ArrayList<TelefoneEntity>();
		}
		return telefonesUsuario;
	}

	public void setTelefonesUsuario(List<TelefoneEntity> telefonesUsuario) {
		this.telefonesUsuario = telefonesUsuario;
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

	public List<EmailEntity> getEmailsUsuario() {
		if (emailsUsuario == null) {
			this.emailsUsuario = new ArrayList<EmailEntity>();
		}
		return emailsUsuario;
	}

	public void setEmailsUsuario(List<EmailEntity> emailsUsuario) {
		this.emailsUsuario = emailsUsuario;
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

	public Set<EmpresaEntity> getEmpresasGerenciadas() {
		if (empresasGerenciadas == null) {
			this.empresasGerenciadas = new TreeSet<EmpresaEntity>();
		}
		return empresasGerenciadas;
	}

	public void setEmpresasGerenciadas(Set<EmpresaEntity> empresasGerenciadas) {
		this.empresasGerenciadas = empresasGerenciadas;
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

	public List<EmpresaEntity> getEmpresasDisponiveisUsuario() {
		if (empresasDisponiveisUsuario == null) {
			this.empresasDisponiveisUsuario = new ArrayList<EmpresaEntity>();
		}
		return empresasDisponiveisUsuario;
	}

	public void setEmpresasDisponiveisUsuario(List<EmpresaEntity> empresasDisponiveisUsuario) {
		this.empresasDisponiveisUsuario = empresasDisponiveisUsuario;
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

	public boolean isDialogNovoUsuarioRendered() {
		return isDialogNovoUsuarioRendered;
	}

	public void setDialogNovoUsuarioRendered(boolean isDialogNovoUsuarioRendered) {
		this.isDialogNovoUsuarioRendered = isDialogNovoUsuarioRendered;
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

	public UsuarioFacadeLocal getUsuarioFachada() {
		return usuarioFachada;
	}

	public void novoUsuarioNaEmpresaSelecionada(ActionEvent evt) {
		this.initUsuario();
		this.isDialogNovoUsuarioRendered = true;
	}

	public void salvarUsuario(ActionEvent evt) {
		this.empresasAtribuidasUsuario = this.empresasUsuario.getTarget();
		this.usuarioNovo = this.usuarioFachada.salvarNovoUsuario(this.usuarioNovo, this.usuarioMB.getUsuarioLogado(),
				this.documentosPessoaisUsuario, this.enderecoUsuarioAtual, this.emailsUsuario, this.telefonesUsuario,
				this.empresasAtribuidasUsuario);
		this.fecharDialogNovoUsuario();
		FacesMessage msg = new FacesMessage("Sucesso",
				stringUtils.formatarTextoParaLeitura(this.usuarioNovo.getNome().toString())
						+ " Atualizado com Sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.initUsuario();
	}
	
	public void fecharDialogNovoUsuario() {
		this.isDialogNovoUsuarioRendered = false;
	}
	
	public void onSelectionUsuario(SelectEvent evt) {
		this.usuarioSelecionado = (UsuarioEntity) evt.getObject();
	}

	public void editarUsuarioNaEmpresaSelecionada(ActionEvent evt) {

	}

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

	// action dos botões dentro de dadosUsuario

	public void editarUsuario(ActionEvent evt) {

	}

	public void cancelarUsuario(ActionEvent evt) {

	}

	public void excluirUsuario(ActionEvent evt) {

	}

	public void novoUsuario(ActionEvent evt) {

	}

	// action dos botões usuários dentro de contatosUsuario

	public void cancelarContatoUsuario(ActionEvent evt) {

	}

	public void editarContatoUsuario(ActionEvent evt) {

	}

	public void novoContatoUsuario(ActionEvent evt) {

	}

	public void salvarContatoUsuario(ActionEvent evt) {

	}

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
		this.empresasDisponiveisUsuario = null;
		this.empresasAtribuidasUsuario = null;
		
		try {
			this.empresasAtribuidasUsuario = new ArrayList<EmpresaEntity>();
			this.dualListEmpresasUsuario(this.cadastroEmpresaMB.getEmpresasDisponiveis(),
					this.empresasAtribuidasUsuario);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
