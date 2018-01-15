package br.com.smartems.dmatnet.ManagedBeans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.NoResultException;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;

import br.com.smartems.dmatnet.EJB.Facade.EmpresaGrupoFacadeLocal;
import br.com.smartems.dmatnet.EJB.Facade.EstadoFacadeLocal;
import br.com.smartems.dmatnet.EJB.Facade.PessoaJuridicaFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaDadosIsencao;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFAP;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaLogotipo;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaOrganismoInternacional;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaSoftwareHouse;
import br.com.smartems.dmatnet.util.ReportUtil;
import br.com.smartems.dmatnet.util.StringsUtilitarios;

@ManagedBean
@SessionScoped
public class CadastroEmpresaMB implements Serializable {

	@ManagedProperty(value = "#{usuarioMB}")
	private UsuarioMB usuarioMB;

	@ManagedProperty(value = "#{principalMB}")
	private PrincipalMB principalMB;

	@EJB
	private PessoaJuridicaFacadeLocal pessoaJuridicaFachada;

	@EJB
	private EmpresaGrupoFacadeLocal empresaGrupoFachada;

	@EJB
	private EstadoFacadeLocal estadoFachada;

	@EJB
	private StringsUtilitarios stringUtils;

	@EJB
	private ReportUtil reportUtil;

	private EmpresaGrupoEntity grupoSelecionado;
	private EmpresaGrupoEntity grupoEmpresa;

	private EmpresaEntity empresaSelecionada;
	private EmpresaEntity empresa;
	private EmpresaFAP empresaFap;
	private EmpresaDadosIsencao empresaDadosIsencao;
	private EmpresaOrganismoInternacional empresaOrgI8n;
	private EmpresaSoftwareHouse empresaSoftwareHouse;
	private List<EmpresaSoftwareHouse> empresasSoftwareHouse;
	private String empresaOrgI8nString;
	private EmpresaFoto fotografiaFachadaEmpresa;
	private EmpresaFoto fotografiaFachadaAntiga;
	private DefaultStreamedContent fachadaEmpresa;
	private EmpresaLogotipo empresaLogotipo;
	private EmpresaLogotipo empresaLogotipoAntigo;
	private DefaultStreamedContent logotipo;

	private List<EmpresaEntity> empresasDisponiveis;
	private List<EmpresaEntity> empresasNaoAtribuidasGrupo;
	private List<EmpresaEntity> empresasAtribuidas;
	private List<EmpresaEntity> empresasFiltradas;

	private EmpresaCadastroEntity dadosCadastraisAnterior; // é utilizado para
															// adicionar data de
															// término
	private EmpresaCadastroEntity dadosCadastraisAtual;
	private EmpresaCadastroEntity dadosCadastraisExcluir;
	private List<EmpresaCadastroEntity> dadosCadastraisHistorico;

	private EnderecoEntity enderecoAnterior; 	// é utilizado para
												// adicionar data de
												// término

	private EnderecoEntity enderecoAtual;
	private EnderecoEntity enderecoExcluir;
	private List<EnderecoEntity> enderecosHistorico;

	private DualListModel<EmpresaEntity> empresas;
	private List<EmpresaGrupoEntity> grupos;

	// barra das tabs em cadastro de empresa

	private boolean isTabDadosCadastraisDesativado = false;
	private boolean isTabEnderecoDesativado = false;
	private boolean isTabContatoDesativado = false;
	private boolean isTabEmpregadosDesativado = false;
	private boolean isTabEstabelecimentosDesativado = false;

	// botões referentes à Edição do Cadastro de Empresa

	private boolean isListaEmpresa = false;
	private int tipoPessoaJuridicaSelecionada;
	private String nomeEmpresaProcurada;
	private boolean isBtnEmpresaSalvarAlteracoes = true;
	private boolean isBtnExcluirFotoFachada = true;
	private boolean isBtnExcluirFotoLogotipo = true;
	private boolean isFotoAlterada = false;
	private boolean isLogoAlterado = false;
	private boolean isBtnModuloDadosCadastrais = true;

	// botões referentes à Edição do Cadastro de Grupo Empresa

	private boolean isBtnGrupoEditarDesativado = true;
	private boolean isTabEditarDesativado = false;
	private boolean isTabExibirDesativado = true;
	private boolean isBtnGrupoCancelarDesativado = true;
	private boolean isBtnGrupoSalvarDesativado = true;
	private boolean isBtnGrupoNovoDesativado = false;
	private boolean isBtnGrupoExcluirDesativado = true;
	private boolean isBtnSelecionarGrupo = true;
	private boolean isBtnSalvarEmpresasNoGrupo = true;

	// botões referentes à Edição do Cadastro de Dados Cadastrais da Empresa

	private boolean isDadosCadastraisRendered = true;
	private boolean isTextoDadosCadastraisInexistentes = false;
	private boolean isBtnDadosCadastraisEditarDesativado = true;
	private boolean isDadosCadastraisEditarRender = false;
	private boolean isBtnDadosCadastraisCancelarDesativado = true;
	private boolean isBtnDadosCadastraisSalvarDesativado = true;
	private boolean isBtnDadosCadastraisNovaEmpresaDesativado = false;
	private boolean isBtnDadosCadastraisExcluirDesativado = false;
	private boolean isBtnDadosCadastraisExcluirRender = false;
	private String textoTipoInscricaoPJ;

	// botões referentes à Edição do Endereço da Empresa

	private boolean isEnderecoRendered = true;
	private boolean isTextoEnderecosEmpresaInexistentes = false;
	private boolean isBtnEnderecoEditarDesativado = false;
	private boolean isEnderecoEditarRender = false;
	private boolean isBtnEnderecoCancelarDesativado = true;
	private boolean isBtnEnderecoSalvarDesativado = true;
	private boolean isBtnEnderecoNovoDesativado = false;
	private boolean isBtnEnderecoEmpresaExcluirDesativado = false;
	private boolean isBtnEnderecoEmpresaExcluirRender = false;

	private String mascaraPessoaJuridica = "99.999.999/9999-99";

	private static final long serialVersionUID = 1L;

	// inicio dos getters e setters

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

	public EmpresaEntity getEmpresa() {
		if (empresa == null) {
			empresa = new EmpresaEntity();
		}
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public EmpresaEntity getEmpresaSelecionada() {
		if (this.empresaSelecionada == null) {
			this.empresaSelecionada = new EmpresaEntity();
		}
		return empresaSelecionada;
	}

	public String getTextoTipoInscricaoPJ() {
		if (this.dadosCadastraisAtual.getTipoInscricao() == 1) {
			textoTipoInscricaoPJ = "CNPJ";
		} else {
			textoTipoInscricaoPJ = "CPF";
		}
		return textoTipoInscricaoPJ;
	}

	public void setTextoTipoInscricaoPJ(String textoTipoInscricaoPJ) {
		this.textoTipoInscricaoPJ = textoTipoInscricaoPJ;
	}

	public void setEmpresaSelecionada(EmpresaEntity empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public EmpresaCadastroEntity getDadosCadastraisAtual() {
		if (this.dadosCadastraisAtual == null) {
			dadosCadastraisAtual = new EmpresaCadastroEntity();
		}
		return dadosCadastraisAtual;
	}

	public void setDadosCadastraisAtual(EmpresaCadastroEntity dadosCadastraisAtual) {
		this.dadosCadastraisAtual = dadosCadastraisAtual;
	}

	public EmpresaCadastroEntity getDadosCadastraisExcluir() {
		return dadosCadastraisExcluir;
	}

	public void setDadosCadastraisExcluir(EmpresaCadastroEntity dadosCadastraisExcluir) {
		this.dadosCadastraisExcluir = dadosCadastraisExcluir;
	}

	public List<EmpresaCadastroEntity> getDadosCadastraisHistorico() {
		if (this.dadosCadastraisHistorico == null) {
			this.dadosCadastraisHistorico = new ArrayList<EmpresaCadastroEntity>();
		}
		return dadosCadastraisHistorico;
	}

	public void setDadosCadastraisHistorico(List<EmpresaCadastroEntity> dadosCadastraisHistorico) {
		this.dadosCadastraisHistorico = dadosCadastraisHistorico;
	}

	public EmpresaFAP getEmpresaFap() {
		if (this.empresaFap == null) {
			this.empresaFap = new EmpresaFAP();
		}
		return empresaFap;
	}

	public void setEmpresaFap(EmpresaFAP empresaFap) {
		this.empresaFap = empresaFap;
	}

	public EmpresaDadosIsencao getEmpresaDadosIsencao() {
		if (this.empresaDadosIsencao == null) {
			this.empresaDadosIsencao = new EmpresaDadosIsencao();
		}
		return empresaDadosIsencao;
	}

	public void setEmpresaDadosIsencao(EmpresaDadosIsencao empresaDadosIsencao) {
		this.empresaDadosIsencao = empresaDadosIsencao;
	}

	public EmpresaOrganismoInternacional getEmpresaOrgI8n() {
		if (this.empresaOrgI8n == null) {
			this.empresaOrgI8n = new EmpresaOrganismoInternacional();
		}
		return empresaOrgI8n;
	}

	public void setEmpresaOrgI8n(EmpresaOrganismoInternacional empresaOrgI8n) {
		this.empresaOrgI8n = empresaOrgI8n;
	}

	public String getEmpresaOrgI8nString() {
		try {
			if (this.empresaOrgI8n.isAcordoInternacional() == true) {
				this.empresaOrgI8nString = "Sim";
			} else {
				this.empresaOrgI8nString = "Não";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			this.empresaOrgI8nString = "Não";
		}
		return empresaOrgI8nString;
	}

	public void setEmpresaOrgI8nString(String empresaOrgI8nString) {
		this.empresaOrgI8nString = empresaOrgI8nString;
	}

	public EmpresaSoftwareHouse getEmpresaSoftwareHouse() {
		if (this.empresaSoftwareHouse == null) {
			this.empresaSoftwareHouse = new EmpresaSoftwareHouse();
		}
		return empresaSoftwareHouse;
	}

	public void setEmpresaSoftwareHouse(EmpresaSoftwareHouse empresaSoftwareHouse) {
		this.empresaSoftwareHouse = empresaSoftwareHouse;
	}

	public List<EmpresaSoftwareHouse> getEmpresasSoftwareHouse() {
		if (this.empresasSoftwareHouse == null) {
			this.empresasSoftwareHouse = new ArrayList<EmpresaSoftwareHouse>();
		}
		return empresasSoftwareHouse;
	}

	public void setEmpresasSoftwareHouse(List<EmpresaSoftwareHouse> empresasSoftwareHouse) {
		this.empresasSoftwareHouse = empresasSoftwareHouse;
	}

	public DefaultStreamedContent getFachadaEmpresa() {
		return fachadaEmpresa;
	}

	public void setFachadaEmpresa(DefaultStreamedContent fachadaEmpresa) {
		this.fachadaEmpresa = fachadaEmpresa;
	}

	public EmpresaLogotipo getEmpresaLogotipo() {
		return empresaLogotipo;
	}

	public void setEmpresaLogotipo(EmpresaLogotipo empresaLogotipo) {
		this.empresaLogotipo = empresaLogotipo;
	}

	public DefaultStreamedContent getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(DefaultStreamedContent logotipo) {
		this.logotipo = logotipo;
	}

	public String tipoInscricaoPJ(int tipoInscricao) {
		String textoInscricao = "CNPJ";
		if (tipoInscricao == 2) {
			textoInscricao = "CPF";
		}
		return textoInscricao;
	}

	public EnderecoEntity getEnderecoAtual() {
		if (this.enderecoAtual == null) {
			this.enderecoAtual = new EnderecoEntity();
		}
		return enderecoAtual;
	}

	public void setEnderecoAtual(EnderecoEntity enderecoAtual) {
		this.enderecoAtual = enderecoAtual;
	}

	public EnderecoEntity getEnderecoExcluir() {
		return enderecoExcluir;
	}

	public void setEnderecoExcluir(EnderecoEntity enderecoExcluir) {
		this.enderecoExcluir = enderecoExcluir;
	}

	public List<EnderecoEntity> getEnderecosHistorico() {
		return enderecosHistorico;
	}

	public void setEnderecosHistorico(List<EnderecoEntity> enderecosHistorico) {
		this.enderecosHistorico = enderecosHistorico;
	}

	public List<EmpresaEntity> getEmpresasDisponiveis() {
		if (this.empresasDisponiveis == null) {
			this.empresasDisponiveis = new ArrayList<EmpresaEntity>();
		}
		return empresasDisponiveis;
	}

	public void setEmpresasDisponiveis(List<EmpresaEntity> empresasDisponiveis) {
		this.empresasDisponiveis = empresasDisponiveis;
	}

	public List<EmpresaEntity> getEmpresasNaoAtribuidasGrupo() {
		if (this.empresasNaoAtribuidasGrupo == null) {
			this.empresasNaoAtribuidasGrupo = new ArrayList<EmpresaEntity>();
		}
		return empresasNaoAtribuidasGrupo;
	}

	public void setEmpresasNaoAtribuidasGrupo(List<EmpresaEntity> empresasNaoAtribuidasGrupo) {
		this.empresasNaoAtribuidasGrupo = empresasNaoAtribuidasGrupo;
	}

	public List<EmpresaEntity> getEmpresasAtribuidas() {
		if (this.empresasAtribuidas == null) {
			this.empresasAtribuidas = new ArrayList<EmpresaEntity>();
		}
		return empresasAtribuidas;
	}

	public void setEmpresasAtribuidas(List<EmpresaEntity> empresasAtribuidas) {
		this.empresasAtribuidas = empresasAtribuidas;
	}

	public List<EmpresaEntity> getEmpresasFiltradas() {
		if (this.empresasFiltradas == null) {
			this.empresasFiltradas = new ArrayList<EmpresaEntity>();
		}
		return empresasFiltradas;
	}

	public void setEmpresasFiltradas(List<EmpresaEntity> empresasFiltradas) {
		this.empresasFiltradas = empresasFiltradas;
	}

	public DualListModel<EmpresaEntity> getEmpresas() {
		if (this.empresas == null) {
			this.empresas = new DualListModel<EmpresaEntity>();
		}
		return empresas;
	}

	public void setEmpresas(DualListModel<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}

	public List<EmpresaGrupoEntity> getGrupos() {
		if (this.grupos == null) {
			this.grupos = new ArrayList<EmpresaGrupoEntity>();
		}
		return grupos;
	}

	public void setGrupos(List<EmpresaGrupoEntity> grupos) {
		this.grupos = grupos;
	}

	public boolean isTabDadosCadastraisDesativado() {
		return isTabDadosCadastraisDesativado;
	}

	public void setTabDadosCadastraisDesativado(boolean isTabDadosCadastraisDesativado) {
		this.isTabDadosCadastraisDesativado = isTabDadosCadastraisDesativado;
	}

	public boolean isTabEnderecoDesativado() {
		return isTabEnderecoDesativado;
	}

	public void setTabEnderecoDesativado(boolean isTabEnderecoDesativado) {
		this.isTabEnderecoDesativado = isTabEnderecoDesativado;
	}

	public boolean isTabContatoDesativado() {
		return isTabContatoDesativado;
	}

	public void setTabContatoDesativado(boolean isTabContatoDesativado) {
		this.isTabContatoDesativado = isTabContatoDesativado;
	}

	public boolean isTabEmpregadosDesativado() {
		return isTabEmpregadosDesativado;
	}

	public void setTabEmpregadosDesativado(boolean isTabEmpregadosDesativado) {
		this.isTabEmpregadosDesativado = isTabEmpregadosDesativado;
	}

	public boolean isTabEstabelecimentosDesativado() {
		return isTabEstabelecimentosDesativado;
	}

	public void setTabEstabelecimentosDesativado(boolean isTabEstabelecimentosDesativado) {
		this.isTabEstabelecimentosDesativado = isTabEstabelecimentosDesativado;
	}

	public EmpresaGrupoEntity getGrupoSelecionado() {
		if (this.grupoSelecionado == null) {
			this.grupoSelecionado = new EmpresaGrupoEntity();
		}
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(EmpresaGrupoEntity grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public EmpresaGrupoEntity getGrupoEmpresa() {
		if (this.grupoEmpresa == null) {
			this.grupoEmpresa = new EmpresaGrupoEntity();
		}
		return grupoEmpresa;
	}

	public void setGrupoEmpresa(EmpresaGrupoEntity grupoEmpresa) {
		this.grupoEmpresa = grupoEmpresa;
	}

	public boolean isListaEmpresa() {
		return isListaEmpresa;
	}

	public boolean isBtnEmpresaSalvarAlteracoes() {
		try {
			if (this.empresa.getNome().length() > 0) {
				isBtnEmpresaSalvarAlteracoes = false;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			isBtnEmpresaSalvarAlteracoes = true;
		}
		return isBtnEmpresaSalvarAlteracoes;
	}

	public void setBtnEmpresaSalvarAlteracoes(boolean isBtnEmpresaSalvarAlteracoes) {
		this.isBtnEmpresaSalvarAlteracoes = isBtnEmpresaSalvarAlteracoes;
	}

	public boolean isBtnExcluirFotoFachada() {
		try {
			if (this.empresa.getEmpresaFotoFachada().getFotoFachada().length <= 0) {
				isBtnExcluirFotoFachada = true;
			} else {
				isBtnExcluirFotoFachada = false;
			}
		} catch (NullPointerException e) {
			isBtnExcluirFotoFachada = true;
			e.printStackTrace();
		}
		return isBtnExcluirFotoFachada;
	}

	public void setBtnExcluirFotoFachada(boolean isBtnExcluirFotoFachada) {
		this.isBtnExcluirFotoFachada = isBtnExcluirFotoFachada;
	}

	public boolean isBtnExcluirFotoLogotipo() {
		try {
			if (this.empresa.getEmpresaLogotipo().getLogotipo().length <= 0) {
				isBtnExcluirFotoLogotipo = true;
			} else {
				isBtnExcluirFotoLogotipo = false;
			}
		} catch (NullPointerException e) {
			isBtnExcluirFotoLogotipo = true;
			e.printStackTrace();
		}
		return isBtnExcluirFotoLogotipo;
	}

	public void setBtnExcluirFotoLogotipo(boolean isBtnExcluirFotoLogotipo) {
		this.isBtnExcluirFotoLogotipo = isBtnExcluirFotoLogotipo;
	}

	public boolean isFotoAlterada() {
		try {
			if (this.fotografiaFachadaAntiga.equals(this.empresa.getEmpresaFotoFachada())) {
				this.isFotoAlterada = false;
			} else {
				this.isFotoAlterada = true;
			}
		} catch (NullPointerException e) {
			this.isFotoAlterada = false;
		}
		return isFotoAlterada;
	}

	public void setFotoAlterada(boolean isFotoAlterada) {
		this.isFotoAlterada = isFotoAlterada;
	}

	public boolean isLogoAlterado() {
		try {
			if (this.empresaLogotipoAntigo.equals(this.empresa.getEmpresaLogotipo())) {
				this.isLogoAlterado = false;
			} else {
				this.isLogoAlterado = true;
			}
		} catch (NullPointerException e) {
			this.isLogoAlterado = false;
		}
		return isLogoAlterado;
	}

	public void setLogoAlterado(boolean isLogoAlterado) {
		this.isLogoAlterado = isLogoAlterado;
	}

	public boolean isBtnModuloDadosCadastrais() {
		try {
			if (this.empresaSelecionada.getIdPessoa() > 0) {
				this.isBtnModuloDadosCadastrais = false;
			} else {
				this.isBtnModuloDadosCadastrais = true;
			}
		} catch (Exception e) {
			this.isBtnModuloDadosCadastrais = false;
			e.printStackTrace();
		}
		return isBtnModuloDadosCadastrais;
	}

	public void setBtnModuloDadosCadastrais(boolean isBtnModuloDadosCadastrais) {
		this.isBtnModuloDadosCadastrais = isBtnModuloDadosCadastrais;
	}

	public boolean isBtnGrupoEditarDesativado() {
		return isBtnGrupoEditarDesativado;
	}

	public void setBtnGrupoEditarDesativado(boolean isBtnGrupoEditarDesativado) {
		this.isBtnGrupoEditarDesativado = isBtnGrupoEditarDesativado;
	}

	public boolean isTabEditarDesativado() {
		return isTabEditarDesativado;
	}

	public void setTabEditarDesativado(boolean isTabEditarDesativado) {
		this.isTabEditarDesativado = isTabEditarDesativado;
	}

	public boolean isTabExibirDesativado() {
		return isTabExibirDesativado;
	}

	public void setTabExibirDesativado(boolean isTabExibirDesativado) {
		this.isTabExibirDesativado = isTabExibirDesativado;
	}

	public boolean isBtnGrupoCancelarDesativado() {
		return isBtnGrupoCancelarDesativado;
	}

	public void setBtnGrupoCancelarDesativado(boolean isBtnGrupoCancelarDesativado) {
		this.isBtnGrupoCancelarDesativado = isBtnGrupoCancelarDesativado;
	}

	public boolean isBtnGrupoSalvarDesativado() {
		return isBtnGrupoSalvarDesativado;
	}

	public void setBtnGrupoSalvarDesativado(boolean isBtnGrupoSalvarDesativado) {
		this.isBtnGrupoSalvarDesativado = isBtnGrupoSalvarDesativado;
	}

	public boolean isBtnGrupoNovoDesativado() {
		return isBtnGrupoNovoDesativado;
	}

	public boolean isBtnGrupoExcluirDesativado() {
		return isBtnGrupoExcluirDesativado;
	}

	public void setBtnGrupoExcluirDesativado(boolean isBtnGrupoExcluirDesativado) {
		this.isBtnGrupoExcluirDesativado = isBtnGrupoExcluirDesativado;
	}

	public boolean isBtnSelecionarGrupo() {
		return isBtnSelecionarGrupo;
	}

	public void setBtnSelecionarGrupo(boolean isBtnSelecionarGrupo) {
		this.isBtnSelecionarGrupo = isBtnSelecionarGrupo;
	}

	public boolean isBtnSalvarEmpresasNoGrupo() {
		return isBtnSalvarEmpresasNoGrupo;
	}

	public void setBtnSalvarEmpresasNoGrupo(boolean isBtnSalvarEmpresasNoGrupo) {
		this.isBtnSalvarEmpresasNoGrupo = isBtnSalvarEmpresasNoGrupo;
	}

	public void setBtnGrupoNovaEmpresaDesativado(boolean isBtnGrupoNovoDesativado) {
		this.isBtnGrupoNovoDesativado = isBtnGrupoNovoDesativado;
	}

	public boolean isDadosCadastraisRendered() {
		return isDadosCadastraisRendered;
	}

	public void setDadosCadastraisRendered(boolean isDadosCadastraisRendered) {
		this.isDadosCadastraisRendered = isDadosCadastraisRendered;
	}

	public boolean isBtnDadosCadastraisEditarDesativado() {
		return isBtnDadosCadastraisEditarDesativado;
	}

	public void setBtnDadosCadastraisEditarDesativado(boolean isBtnDadosCadastraisEditarDesativado) {
		this.isBtnDadosCadastraisEditarDesativado = isBtnDadosCadastraisEditarDesativado;
	}

	public boolean isTextoDadosCadastraisInexistentes() {
		if (this.isDadosCadastraisRendered) {
			isTextoDadosCadastraisInexistentes = false;
		} else {
			isTextoDadosCadastraisInexistentes = true;
		}
		return isTextoDadosCadastraisInexistentes;
	}

	public void setTextoDadosCadastraisInexistentes(boolean isTextoDadosCadastraisInexistentes) {
		this.isTextoDadosCadastraisInexistentes = isTextoDadosCadastraisInexistentes;
	}

	public boolean isDadosCadastraisEditarRender() {
		return isDadosCadastraisEditarRender;
	}

	public void setDadosCadastraisEditarRender(boolean isDadosCadastraisEditarRender) {
		this.isDadosCadastraisEditarRender = isDadosCadastraisEditarRender;
	}

	public boolean isBtnDadosCadastraisCancelarDesativado() {
		return isBtnDadosCadastraisCancelarDesativado;
	}

	public void setBtnDadosCadastraisCancelarDesativado(boolean isBtnDadosCadastraisCancelarDesativado) {
		this.isBtnDadosCadastraisCancelarDesativado = isBtnDadosCadastraisCancelarDesativado;
	}

	public boolean isBtnDadosCadastraisSalvarDesativado() {
		return isBtnDadosCadastraisSalvarDesativado;
	}

	public void setBtnDadosCadastraisSalvarDesativado(boolean isBtnDadosCadastraisSalvarDesativado) {
		this.isBtnDadosCadastraisSalvarDesativado = isBtnDadosCadastraisSalvarDesativado;
	}

	public boolean isBtnDadosCadastraisNovaEmpresaDesativado() {
		return isBtnDadosCadastraisNovaEmpresaDesativado;
	}

	public void setBtnDadosCadastraisNovaEmpresaDesativado(boolean isBtnDadosCadastraisNovaEmpresaDesativado) {
		this.isBtnDadosCadastraisNovaEmpresaDesativado = isBtnDadosCadastraisNovaEmpresaDesativado;
	}

	public boolean isBtnDadosCadastraisExcluirDesativado() {
		return isBtnDadosCadastraisExcluirDesativado;
	}

	public void setBtnDadosCadastraisExcluirDesativado(boolean isBtnDadosCadastraisExcluirDesativado) {
		this.isBtnDadosCadastraisExcluirDesativado = isBtnDadosCadastraisExcluirDesativado;
	}

	public boolean isBtnDadosCadastraisExcluirRender() {
		if (usuarioMB.getUsuarioLogado().getGrupo().getNomeGrupo().equals("MASTER")) {
			this.isBtnDadosCadastraisExcluirRender = true;
		} else {
			this.isBtnDadosCadastraisExcluirRender = false;
		}
		return isBtnDadosCadastraisExcluirRender;
	}

	public void setBtnDadosCadastraisExcluirRender(boolean isBtnDadosCadastraisExcluirRender) {
		this.isBtnDadosCadastraisExcluirRender = isBtnDadosCadastraisExcluirRender;
	}

	public boolean isEnderecoRendered() {
		return isEnderecoRendered;
	}

	public void setEnderecoRendered(boolean isEnderecoRendered) {
		this.isEnderecoRendered = isEnderecoRendered;
	}

	public boolean isBtnEnderecoEditarDesativado() {
		return isBtnEnderecoEditarDesativado;
	}

	public boolean isTextoEnderecosEmpresaInexistentes() {
		if (this.isEnderecoRendered) {
			isTextoEnderecosEmpresaInexistentes = false;
		} else {
			isTextoEnderecosEmpresaInexistentes = true;
		}
		return isTextoEnderecosEmpresaInexistentes;
	}

	public void setTextoEnderecosEmpresaInexistentes(boolean isTextoEnderecosEmpresaInexistentes) {
		this.isTextoEnderecosEmpresaInexistentes = isTextoEnderecosEmpresaInexistentes;
	}

	public void setBtnEnderecoEditarDesativado(boolean isBtnEnderecoEditarDesativado) {
		this.isBtnEnderecoEditarDesativado = isBtnEnderecoEditarDesativado;
	}

	public boolean isEnderecoEditarRender() {
		return isEnderecoEditarRender;
	}

	public void setEnderecoEditarRender(boolean isEnderecoEditarRender) {
		this.isEnderecoEditarRender = isEnderecoEditarRender;
	}

	public boolean isBtnEnderecoCancelarDesativado() {
		return isBtnEnderecoCancelarDesativado;
	}

	public void setBtnEnderecoCancelarDesativado(boolean isBtnEnderecoCancelarDesativado) {
		this.isBtnEnderecoCancelarDesativado = isBtnEnderecoCancelarDesativado;
	}

	public boolean isBtnEnderecoSalvarDesativado() {
		return isBtnEnderecoSalvarDesativado;
	}

	public void setBtnEnderecoSalvarDesativado(boolean isBtnEnderecoSalvarDesativado) {
		this.isBtnEnderecoSalvarDesativado = isBtnEnderecoSalvarDesativado;
	}

	public boolean isBtnEnderecoNovoDesativado() {
		return isBtnEnderecoNovoDesativado;
	}

	public void setBtnEnderecoNovoDesativado(boolean isBtnEnderecoNovoDesativado) {
		this.isBtnEnderecoNovoDesativado = isBtnEnderecoNovoDesativado;
	}

	public boolean isBtnEnderecoEmpresaExcluirDesativado() {
		return isBtnEnderecoEmpresaExcluirDesativado;
	}

	public void setBtnEnderecoEmpresaExcluirDesativado(boolean isBtnEnderecoEmpresaExcluirDesativado) {
		this.isBtnEnderecoEmpresaExcluirDesativado = isBtnEnderecoEmpresaExcluirDesativado;
	}

	public boolean isBtnEnderecoEmpresaExcluirRender() {
		if (usuarioMB.getUsuarioLogado().getGrupo().getNomeGrupo().equals("MASTER")) {
			this.isBtnEnderecoEmpresaExcluirRender = true;
		} else {
			this.isBtnEnderecoEmpresaExcluirRender = false;
		}
		return isBtnEnderecoEmpresaExcluirRender;
	}

	public void setBtnEnderecoEmpresaExcluirRender(boolean isBtnEnderecoEmpresaExcluirRender) {
		this.isBtnEnderecoEmpresaExcluirRender = isBtnEnderecoEmpresaExcluirRender;
	}

	public void setTipoPessoaJuridicaSelecionada(int tipoPessoaJuridicaSelecionada) {
		this.tipoPessoaJuridicaSelecionada = tipoPessoaJuridicaSelecionada;
	}

	public int getTipoPessoaJuridicaSelecionada() {
		return tipoPessoaJuridicaSelecionada;
	}

	public String getNomeEmpresaProcurada() {
		if (this.nomeEmpresaProcurada == null) {
			this.nomeEmpresaProcurada = new String();
		}
		return nomeEmpresaProcurada;
	}

	public void setNomeEmpresaProcurada(String nomeEmpresaProcurada) {
		this.nomeEmpresaProcurada = nomeEmpresaProcurada;
	}

	public String getMascaraPessoaJuridica() {
		return mascaraPessoaJuridica;
	}

	// fim dos getters e setters

	public void alterarMascaraPessoaJuridica() {
		switch (this.dadosCadastraisAtual.getTipoInscricao()) {
		case 1:
			this.mascaraPessoaJuridica = "99.999.999/9999-99";
			break;
		case 2:
			this.mascaraPessoaJuridica = "999.999.999-99";
			break;
		}
	}

	// action dos botões de cadastro de empresa

	public void editarCadastroEmpresa(ActionEvent e) {

	}

	public void cancelarCadastroEmpresa(ActionEvent e) {
		this.initEmpresa();
		this.exibirImagem(this.empresa.getEmpresaFotoFachada());
		this.exibirImagem(this.empresa.getEmpresaLogotipo());
		FacesMessage msg = new FacesMessage("Cancelado",
				stringUtils.formatarTextoParaLeitura("A empresa \" " + this.empresa.getNome().toString())
						+ " \" não foi alterada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void salvarCadastroEmpresa(ActionEvent e) {
		try {
			if (this.empresa.getIdPessoa() == 0) {
				this.pessoaJuridicaFachada.salvarNovoCadastroEmpresa(this.empresa, this.fotografiaFachadaEmpresa,
						this.empresaLogotipo, this.usuarioMB.getUsuarioLogado());
				FacesMessage msg = new FacesMessage("Sucesso",
						stringUtils.formatarTextoParaLeitura(this.empresa.getNome().toString()) + " Salvo com Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				this.pessoaJuridicaFachada.alterarCadastroEmpresa(this.empresa, this.usuarioMB.getUsuarioLogado(),
						this.empresaFap, this.empresaDadosIsencao, this.empresaOrgI8n, this.empresasSoftwareHouse,
						this.dadosCadastraisAtual);
				FacesMessage msg = new FacesMessage("Sucesso",
						stringUtils.formatarTextoParaLeitura(this.empresa.getNome().toString())
								+ " Atualizado com Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			this.initEmpresa();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void excluirCadastroEmpresa(EmpresaEntity empresa) {
		try {
			this.pessoaJuridicaFachada.excluirCadastroEmpresa(empresa);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		this.initEmpresa();
	}

	public void novoCadastroEmpresa(ActionEvent e) {
		this.empresa = new EmpresaEntity();
	}

	public void filtrarEmpresa(ActionEvent e) {
		try {
			if (!this.nomeEmpresaProcurada.isEmpty()) {
				this.initEmpresa();
				this.empresasFiltradas = this.pessoaJuridicaFachada.filtrarEmpresas(nomeEmpresaProcurada,
						this.empresasDisponiveis);
				this.empresasDisponiveis = this.empresasFiltradas;
			} else {
				this.initEmpresa();
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}

	public void removerFiltroEmpresa(ActionEvent e) {
		this.initEmpresa();
		this.nomeEmpresaProcurada = null;
		this.empresasFiltradas = null;
	}

	public void onSelectionEmpresa(SelectEvent evt) {
		try {
			this.separarDadosCadastraisAtualDoHistorico((EmpresaEntity) evt.getObject());
			this.separarEnderecoAtualDoHistorico((EmpresaEntity) evt.getObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// action dos botões dados cadastrais da empresa

	public void editarDadosCadastraisEmpresa(ActionEvent e) {

		this.isBtnDadosCadastraisEditarDesativado = true;
		this.isDadosCadastraisEditarRender = true;
		this.isBtnDadosCadastraisCancelarDesativado = false;
		this.isBtnDadosCadastraisSalvarDesativado = false;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = true;
		this.isBtnDadosCadastraisExcluirDesativado = true;

		this.isTabDadosCadastraisDesativado = false;
		this.isTabEnderecoDesativado = true;
		this.isTabContatoDesativado = true;
		this.isTabEmpregadosDesativado = true;
		this.isTabEstabelecimentosDesativado = true;

		this.exibirImagem(this.fotografiaFachadaEmpresa);
		this.empresaFap = this.dadosCadastraisAtual.getEmpresaFAP();
		this.empresaDadosIsencao = this.dadosCadastraisAtual.getEmpresaDadosIsencao();
		this.empresaOrgI8n = this.dadosCadastraisAtual.getOrganismoInternacional();
	}

	public void cancelarDadosCadastraisEmpresa(ActionEvent e) {

		this.isDadosCadastraisEditarRender = false;
		this.isBtnDadosCadastraisCancelarDesativado = true;
		this.isBtnDadosCadastraisSalvarDesativado = true;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = false;
		this.isBtnDadosCadastraisExcluirDesativado = false;

		this.isTabDadosCadastraisDesativado = false;
		this.isTabEnderecoDesativado = false;
		this.isTabContatoDesativado = false;
		this.isTabEmpregadosDesativado = false;
		this.isTabEstabelecimentosDesativado = false;

		this.empresaSelecionada = pessoaJuridicaFachada.read(this.empresaSelecionada.getIdPessoa());
		this.exibirImagem(this.fotografiaFachadaEmpresa);
		this.dadosCadastraisAtual = null;
		this.separarDadosCadastraisAtualDoHistorico(this.empresaSelecionada);
	}

	public void salvarDadosCadastraisEmpresa(ActionEvent evt) {

		this.isDadosCadastraisEditarRender = false;
		this.isBtnDadosCadastraisCancelarDesativado = true;
		this.isBtnDadosCadastraisSalvarDesativado = true;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = false;
		this.isBtnDadosCadastraisExcluirDesativado = false;

		this.isTabDadosCadastraisDesativado = false;
		this.isTabEnderecoDesativado = false;
		this.isTabContatoDesativado = false;
		this.isTabEmpregadosDesativado = false;
		this.isTabEstabelecimentosDesativado = false;

		try {
			if (dadosCadastraisAnterior == null || dadosCadastraisAtual.getDataInicioCadastro()
					.compareTo(dadosCadastraisAnterior.getDataInicioCadastro()) >= 0) {
				this.pessoaJuridicaFachada.salvarDadosCadastraisEmpresa(this.dadosCadastraisAtual,
						this.dadosCadastraisAnterior, this.empresaFap, this.empresaDadosIsencao, this.empresaOrgI8n,
						this.empresasSoftwareHouse, this.empresaSelecionada);
				this.exibirImagem(this.fotografiaFachadaEmpresa);
				this.separarDadosCadastraisAtualDoHistorico(empresaSelecionada);
			} else {
				FacesMessage msg = new FacesMessage("Erro",
						"A data de início do Cadastro deverá ser igual ou superior à data de início do cadastro anterior");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				this.separarDadosCadastraisAtualDoHistorico(empresaSelecionada);

			}
		} catch (NullPointerException exc) {
			exc.printStackTrace();
			this.atribuirEmpresaFAP(this.empresaFap);
			this.atribuirEmpresaDadosIsencao(this.empresaDadosIsencao);
			this.atribuirEmpresaOrgI8n(this.empresaOrgI8n);
			this.empresaSelecionada.getCadastros().add(this.dadosCadastraisAtual);
			this.empresaSelecionada = this.pessoaJuridicaFachada.update(this.empresaSelecionada);
			this.separarDadosCadastraisAtualDoHistorico(empresaSelecionada);
		} catch (Exception exc) {
			this.fotografiaFachadaEmpresa = null;
			exc.printStackTrace();
		}
	}

	private void atribuirEmpresaFAP(EmpresaFAP empresaFap) {
		if (empresaFap != null) {
			EmpresaFAP novoFap = new EmpresaFAP();
			try {
				novoFap = empresaFap.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			novoFap.setIdEmpresaFAP(0);
			this.dadosCadastraisAtual.setEmpresaFAP(novoFap);
		}
	}

	private void atribuirEmpresaDadosIsencao(EmpresaDadosIsencao empresaDadosIsencao) {
		if (empresaDadosIsencao != null) {
			EmpresaDadosIsencao novoDadosIsencao = new EmpresaDadosIsencao();
			try {
				novoDadosIsencao = empresaDadosIsencao.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			novoDadosIsencao.setIdEmpresaDadosIsencao(0);
			this.dadosCadastraisAtual.setEmpresaDadosIsencao(novoDadosIsencao);
		}
	}

	private void atribuirEmpresaOrgI8n(EmpresaOrganismoInternacional empresaOrgI8n) {
		if (empresaOrgI8n != null) {
			EmpresaOrganismoInternacional novoOrgI8n = new EmpresaOrganismoInternacional();
			try {
				novoOrgI8n = empresaOrgI8n.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			novoOrgI8n.setIdEmpresaOrgInternacional(0);
			this.dadosCadastraisAtual.setOrganismoInternacional(novoOrgI8n);
		}
	}

	public void novoDadosCadastraisEmpresaEmBranco(ActionEvent e) {
		try {
			this.dadosCadastraisAnterior = this.dadosCadastraisAtual.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		this.dadosCadastraisAtual = new EmpresaCadastroEntity();
		this.dadosCadastraisAtual.setId(0);
		this.dadosCadastraisTrocaStatusBotoes();
		RequestContext.getCurrentInstance().execute("PF('dlgPerguntaDadosCadastrais').hide()");
	}

	public void novoDadosCadastraisEmpresaPreenchido(ActionEvent e) {
		try {
			this.dadosCadastraisAnterior = this.dadosCadastraisAtual.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		this.empresaFap = this.dadosCadastraisAtual.getEmpresaFAP();
		this.empresaDadosIsencao = this.dadosCadastraisAtual.getEmpresaDadosIsencao();
		this.empresaOrgI8n = this.dadosCadastraisAtual.getOrganismoInternacional();
		this.dadosCadastraisAtual.setId(0);
		this.dadosCadastraisTrocaStatusBotoes();
		RequestContext.getCurrentInstance().execute("PF('dlgPerguntaDadosCadastrais').hide()");
	}

	public void novoDadosCadastraisEmpresa(ActionEvent evt) {
		this.isDadosCadastraisRendered = true;
		try {
			if (this.dadosCadastraisAtual.getId() >= 1) {
				RequestContext.getCurrentInstance().execute("PF('dlgPerguntaDadosCadastrais').show()");
			} else {
				this.dadosCadastraisTrocaStatusBotoes();
			}
		} catch (NullPointerException e) {
			this.dadosCadastraisTrocaStatusBotoes();
			e.printStackTrace();
		}
	}

	public void dadosCadastraisTrocaStatusBotoes() {

		this.isBtnDadosCadastraisEditarDesativado = true;
		this.isDadosCadastraisEditarRender = true;
		this.isBtnDadosCadastraisCancelarDesativado = false;
		this.isBtnDadosCadastraisSalvarDesativado = false;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = true;
		this.isBtnDadosCadastraisExcluirDesativado = true;

		this.isTabDadosCadastraisDesativado = false;
		this.isTabEnderecoDesativado = true;
		this.isTabContatoDesativado = true;
		this.isTabEmpregadosDesativado = true;
		this.isTabEstabelecimentosDesativado = true;
	}

	public void novoCadastroEmpresaSoftware(ActionEvent evt) {
		try {
			this.empresasSoftwareHouse.add(this.empresaSoftwareHouse);
		} catch (NullPointerException np) {
			np.printStackTrace();
		}
	}

	public void gravarImagemFachada(FileUploadEvent evt) {
		fotografiaFachadaEmpresa = new EmpresaFoto();
		fotografiaFachadaEmpresa.setFotoFachada(evt.getFile().getContents());
		try {
			this.fotografiaFachadaAntiga = this.empresa.getEmpresaFotoFachada().clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.empresa.setEmpresaFotoFachada(fotografiaFachadaEmpresa);
		this.exibirImagem(fotografiaFachadaEmpresa);
	}

	public void gravarLogotipo(FileUploadEvent evt) {
		empresaLogotipo = new EmpresaLogotipo();
		empresaLogotipo.setLogotipo(evt.getFile().getContents());
		try {
			this.empresaLogotipoAntigo = this.empresa.getEmpresaLogotipo().clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.empresa.setEmpresaLogotipo(empresaLogotipo);
		this.exibirImagem(empresaLogotipo);
	}

	public void separarDadosCadastraisAtualDoHistorico(EmpresaEntity empresa) {
		this.empresaSelecionada = pessoaJuridicaFachada.read(empresa.getIdPessoa());
		this.fotografiaFachadaEmpresa = this.empresaSelecionada.getEmpresaFotoFachada();
		this.exibirImagem(fotografiaFachadaEmpresa);
		try {
			this.dadosCadastraisAtual = this.pessoaJuridicaFachada
					.selecionarDadosCadastraisAtual(this.empresaSelecionada);
			this.dadosCadastraisHistorico = pessoaJuridicaFachada
					.selecionarDadosCadastraisHistorico(this.dadosCadastraisAtual, this.empresaSelecionada);
			this.empresasSoftwareHouse = this.dadosCadastraisAtual.getEmpresaSoftwareHouse();
			this.empresaOrgI8n = this.dadosCadastraisAtual.getOrganismoInternacional();
			if (this.dadosCadastraisAtual.getId() != 0) {
				this.isBtnDadosCadastraisEditarDesativado = false;
				this.isBtnDadosCadastraisExcluirDesativado = false;
				this.isDadosCadastraisRendered = true;
			} else {
				this.isBtnDadosCadastraisEditarDesativado = true;
				this.isBtnDadosCadastraisExcluirDesativado = true;
				this.isDadosCadastraisRendered = false;
			}
			this.isDadosCadastraisEditarRender = false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			this.isBtnDadosCadastraisEditarDesativado = true;
			this.isDadosCadastraisEditarRender = false;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void excluirDadosCadastraisEmpresa(ActionEvent e) {
		try {
			pessoaJuridicaFachada.excluirDadoCadastral(this.dadosCadastraisAtual, this.empresaSelecionada);
			this.exibirImagem(this.fotografiaFachadaEmpresa);
			this.separarDadosCadastraisAtualDoHistorico(empresaSelecionada);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void excluirDadosCadastraisDoHistoricoEmpresa(EmpresaCadastroEntity dadosCadastrais) {
		try {
			pessoaJuridicaFachada.excluirDadoCadastral(dadosCadastrais, this.empresaSelecionada);

			this.isDadosCadastraisEditarRender = false;
			this.isBtnDadosCadastraisCancelarDesativado = true;
			this.isBtnDadosCadastraisSalvarDesativado = true;
			this.isBtnDadosCadastraisNovaEmpresaDesativado = false;
			this.isBtnDadosCadastraisExcluirDesativado = false;

			this.isTabDadosCadastraisDesativado = false;
			this.isTabEnderecoDesativado = false;
			this.isTabContatoDesativado = false;
			this.isTabEmpregadosDesativado = false;
			this.isTabEstabelecimentosDesativado = false;

			this.exibirImagem(this.fotografiaFachadaEmpresa);
			this.separarDadosCadastraisAtualDoHistorico(empresaSelecionada);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void imprimirDadosCadastrais(ActionEvent evt) {
		pessoaJuridicaFachada.imprimirDadosCadastrais(this.empresasDisponiveis);
	}

	public void exibirImagem(Serializable imagem) {
		if (imagem instanceof EmpresaFoto) {
			try {
				InputStream streamFachada = new ByteArrayInputStream(((EmpresaFoto) imagem).getFotoFachada());
				this.fachadaEmpresa = new DefaultStreamedContent(streamFachada, "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (imagem instanceof EmpresaLogotipo) {
			try {
				InputStream streamLogotipo = new ByteArrayInputStream(((EmpresaLogotipo) imagem).getLogotipo());
				this.logotipo = new DefaultStreamedContent(streamLogotipo, "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void excluirImagemFachadaEmpresa(ActionEvent evt) {
		try {
			this.fachadaEmpresa = null;
			this.empresa.getEmpresaFotoFachada().setFotoFachada(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluirImagemLogotipo(ActionEvent evt) {
		try {
			this.logotipo = null;
			this.empresa.getEmpresaLogotipo().setLogotipo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// action dos botões de endereco empresa

	public void editarEnderecoEmpresa(ActionEvent e) {

		this.isBtnEnderecoEditarDesativado = true;
		this.isBtnEnderecoCancelarDesativado = false;
		this.isBtnEnderecoSalvarDesativado = false;
		this.isBtnEnderecoNovoDesativado = true;
		this.isEnderecoEditarRender = true;
		this.isBtnEnderecoEmpresaExcluirDesativado = true;

		this.isTabDadosCadastraisDesativado = true;
		this.isTabEnderecoDesativado = false;
		this.isTabContatoDesativado = true;
		this.isTabEmpregadosDesativado = true;
		this.isTabEstabelecimentosDesativado = true;
	}

	public void cancelarEnderecoEmpresa(ActionEvent e) {

		this.isBtnEnderecoEditarDesativado = false;
		this.isBtnEnderecoCancelarDesativado = true;
		this.isBtnEnderecoSalvarDesativado = true;
		this.isBtnEnderecoNovoDesativado = false;
		this.isEnderecoEditarRender = false;
		this.isBtnEnderecoEmpresaExcluirDesativado = false;

		this.isTabDadosCadastraisDesativado = false;
		this.isTabEnderecoDesativado = false;
		this.isTabContatoDesativado = false;
		this.isTabEmpregadosDesativado = false;
		this.isTabEstabelecimentosDesativado = false;

		this.empresaSelecionada = pessoaJuridicaFachada.read(this.empresaSelecionada.getIdPessoa());
		this.exibirImagem(this.fotografiaFachadaEmpresa);
		this.enderecoAtual = null;
		this.separarEnderecoAtualDoHistorico(this.empresaSelecionada);

	}

	public void salvarEnderecoEmpresa(ActionEvent e) {

		this.isBtnEnderecoEditarDesativado = false;
		this.isBtnEnderecoCancelarDesativado = true;
		this.isBtnEnderecoSalvarDesativado = true;
		this.isBtnEnderecoNovoDesativado = false;
		this.isEnderecoEditarRender = false;
		this.isBtnEnderecoEmpresaExcluirDesativado = false;

		this.isTabDadosCadastraisDesativado = false;
		this.isTabEnderecoDesativado = false;
		this.isTabContatoDesativado = false;
		this.isTabEmpregadosDesativado = false;
		this.isTabEstabelecimentosDesativado = false;

		try {
			if (enderecoAnterior == null
					|| enderecoAtual.getDataInicioEndereco().compareTo(enderecoAnterior.getDataInicioEndereco()) >= 0) {
				this.pessoaJuridicaFachada.salvarEnderecoEmpresa(this.empresaSelecionada, this.enderecoAtual,
						this.enderecoAnterior);
				this.separarEnderecoAtualDoHistorico(empresaSelecionada);
			} else {
				FacesMessage msg = new FacesMessage("Erro",
						"A data de início do Cadastro deverá ser igual ou superior à data de início do cadastro anterior");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				this.separarEnderecoAtualDoHistorico(empresaSelecionada);

			}
		} catch (NullPointerException exc) {
			exc.printStackTrace();
			this.empresaSelecionada.getEnderecos().add(this.enderecoAtual);
			this.empresaSelecionada = this.pessoaJuridicaFachada.update(this.empresaSelecionada);
			this.exibirImagem(this.fotografiaFachadaEmpresa);
			this.separarEnderecoAtualDoHistorico(empresaSelecionada);
		} catch (Exception exc) {
			this.fotografiaFachadaEmpresa = null;
			exc.printStackTrace();
		}

	}

	public void novoEnderecoEmpresa(ActionEvent e) {
		this.isEnderecoRendered = true;
		try {
			if (this.enderecoAtual.getIdEndereco() >= 1) {
				RequestContext.getCurrentInstance().execute("PF('dlgPerguntaEndereco').show()");
			} else {
				this.enderecoTrocaStatusBotoes();
			}
		} catch (NullPointerException exc) {
			this.enderecoTrocaStatusBotoes();
			exc.printStackTrace();
		}
	}

	public void novoEnderecoEmpresaEmBranco(ActionEvent e) {
		try {
			this.enderecoAnterior = this.enderecoAtual.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		this.enderecoAtual = new EnderecoEntity();
		this.enderecoAtual.setIdEndereco(0);
		this.enderecoTrocaStatusBotoes();
		RequestContext.getCurrentInstance().execute("PF('dlgPerguntaEndereco').hide()");
	}

	public void novoEnderecoEmpresaPreenchido(ActionEvent e) {
		try {
			this.enderecoAnterior = this.enderecoAtual.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		this.enderecoAtual.setIdEndereco(0);
		this.enderecoTrocaStatusBotoes();
		RequestContext.getCurrentInstance().execute("PF('dlgPerguntaEndereco').hide()");
	}

	public void enderecoTrocaStatusBotoes() {
		this.isBtnEnderecoEditarDesativado = true;
		this.isEnderecoEditarRender = true;
		this.isBtnEnderecoCancelarDesativado = false;
		this.isBtnEnderecoSalvarDesativado = false;
		this.isBtnEnderecoNovoDesativado = true;
		this.isBtnEnderecoEmpresaExcluirDesativado = true;

		this.isTabDadosCadastraisDesativado = true;
		this.isTabEnderecoDesativado = false;
		this.isTabContatoDesativado = true;
		this.isTabEmpregadosDesativado = true;
		this.isTabEstabelecimentosDesativado = true;
	}

	public void separarEnderecoAtualDoHistorico(EmpresaEntity empresa) {
		this.empresaSelecionada = pessoaJuridicaFachada.read(empresa.getIdPessoa());
		this.fotografiaFachadaEmpresa = this.empresaSelecionada.getEmpresaFotoFachada();
		this.exibirImagem(fotografiaFachadaEmpresa);
		try {
			this.enderecoAtual = this.pessoaJuridicaFachada.selecionarEnderecoAtual(this.empresaSelecionada);
			this.enderecosHistorico = pessoaJuridicaFachada.selecionarEnderecosHistorico(this.enderecoAtual,
					this.empresaSelecionada);
			if (this.enderecoAtual.getIdEndereco() != 0) {
				this.isBtnEnderecoEditarDesativado = false;
				this.isBtnEnderecoEmpresaExcluirDesativado = false;
				this.isEnderecoRendered = true;
			} else {
				this.isBtnEnderecoEditarDesativado = true;
				this.isBtnEnderecoEmpresaExcluirDesativado = true;
				this.isEnderecoRendered = false;
			}
			this.isEnderecoEditarRender = false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			this.isBtnEnderecoEditarDesativado = true;
			this.isEnderecoEditarRender = false;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void excluirEnderecoEmpresa(ActionEvent e) {
		try {
			pessoaJuridicaFachada.excluirEnderecoEmpresa(this.enderecoAtual, this.empresaSelecionada);
			this.exibirImagem(this.fotografiaFachadaEmpresa);
			this.separarEnderecoAtualDoHistorico(empresaSelecionada);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void excluirEnderecoDoHistoricoEmpresa(EnderecoEntity endereco) {
		try {
			System.out.println("teste excluir endereço do histórico");
			pessoaJuridicaFachada.excluirEnderecoEmpresa(endereco, this.empresaSelecionada);

			this.isBtnEnderecoEditarDesativado = false;
			this.isBtnEnderecoCancelarDesativado = true;
			this.isBtnEnderecoSalvarDesativado = true;
			this.isBtnEnderecoNovoDesativado = false;
			this.isEnderecoEditarRender = false;
			this.isBtnEnderecoEmpresaExcluirDesativado = false;

			this.isTabDadosCadastraisDesativado = false;
			this.isTabEnderecoDesativado = false;
			this.isTabContatoDesativado = false;
			this.isTabEmpregadosDesativado = false;
			this.isTabEstabelecimentosDesativado = false;

			this.exibirImagem(this.fotografiaFachadaEmpresa);
			this.separarDadosCadastraisAtualDoHistorico(empresaSelecionada);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// action dos botões de grupos-empresa

	public void editarCadastroGrupo(ActionEvent e) {
		this.isBtnGrupoEditarDesativado = true;
		this.isBtnGrupoCancelarDesativado = false;
		this.isBtnGrupoSalvarDesativado = false;
		this.isBtnGrupoNovoDesativado = true;
		this.isTabEditarDesativado = true;
		this.isTabExibirDesativado = false;
	}

	public void cancelarCadastroGrupo(ActionEvent e) {
		this.isBtnGrupoEditarDesativado = true;
		this.isBtnGrupoCancelarDesativado = true;
		this.isBtnGrupoSalvarDesativado = true;
		this.isBtnGrupoNovoDesativado = false;
		this.isBtnGrupoExcluirDesativado = true;
		this.isBtnSelecionarGrupo = true;
		this.isTabEditarDesativado = false;
		this.isTabExibirDesativado = true;
		this.grupoSelecionado = new EmpresaGrupoEntity();
	}

	public void salvarCadastroGrupo(ActionEvent e) {
		this.isBtnGrupoEditarDesativado = true;
		this.isBtnGrupoCancelarDesativado = true;
		this.isBtnGrupoSalvarDesativado = true;
		this.isBtnGrupoNovoDesativado = false;
		this.isBtnGrupoExcluirDesativado = true;

		this.isTabEditarDesativado = false;
		this.isTabExibirDesativado = true;

		if (this.grupoSelecionado.getIdGrupo() == 0) {
			this.empresaGrupoFachada.create(this.grupoSelecionado);
		} else {
			this.empresaGrupoFachada.update(this.grupoSelecionado);
		}

		FacesMessage msg = new FacesMessage("Sucesso",
				stringUtils.formatarTextoParaLeitura(this.grupoSelecionado.getNomeGrupo()) + " Salvo com Sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		this.initEmpresa();
		this.grupoSelecionado = new EmpresaGrupoEntity();
	}

	public void novoCadastroGrupo(ActionEvent e) {
		this.isBtnGrupoEditarDesativado = true;
		this.isBtnGrupoCancelarDesativado = false;
		this.isBtnGrupoSalvarDesativado = false;
		this.isBtnGrupoNovoDesativado = true;
		this.isTabEditarDesativado = true;
		this.isTabExibirDesativado = false;
		this.grupoSelecionado = new EmpresaGrupoEntity();
	}

	public void excluirCadastroGrupo(ActionEvent e) {
		this.isBtnGrupoEditarDesativado = true;
		this.isBtnGrupoExcluirDesativado = true;

		if (this.grupoSelecionado != null) {
			this.empresaGrupoFachada.delete(this.grupoSelecionado);
		}

		FacesMessage msg = new FacesMessage("Sucesso",
				stringUtils.formatarTextoParaLeitura(this.grupoSelecionado.getNomeGrupo()) + " Excluído com Sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		this.initEmpresa();
		this.grupoSelecionado = new EmpresaGrupoEntity();
	}

	public void editarEmpresaSelecionada(ActionEvent e) {
		System.out.println("teste");
	}

	public void onSelectionGrupo(SelectEvent evt) {
		this.isBtnGrupoEditarDesativado = false;
		this.isBtnSelecionarGrupo = false;
		this.isBtnGrupoExcluirDesativado = false;
		this.isBtnSalvarEmpresasNoGrupo = false;
		this.grupoSelecionado = (EmpresaGrupoEntity) evt.getObject();
		this.empresasNaoAtribuidasGrupo = pessoaJuridicaFachada.listarEmpresas(usuarioMB.getUsuarioLogado());
		if (this.empresasAtribuidas == null) {
			this.empresasAtribuidas = new ArrayList<>();
		}
		this.empresasAtribuidas = this.grupoSelecionado.getEmpresas();
		for (EmpresaEntity empresa : this.empresasAtribuidas) {
			if (this.empresasNaoAtribuidasGrupo.contains(empresa)) {
				this.empresasNaoAtribuidasGrupo.remove(empresa);
			}
		}
		this.dualListEmpresasDisponiveis(this.empresasNaoAtribuidasGrupo, this.empresasAtribuidas);
	}

	private void dualListEmpresasDisponiveis(List<EmpresaEntity> empresasNaoAtribuidas,
			List<EmpresaEntity> empresasAtribuidas) {
		try {
			this.empresas = new DualListModel<EmpresaEntity>(empresasNaoAtribuidas, empresasAtribuidas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvarEmpresasNoGrupoSelecionado(ActionEvent evt) {
		if (!this.empresas.getTarget().isEmpty()) {
			for (EmpresaEntity empresa : this.empresas.getTarget()) {
				empresa.setGrupo(this.grupoSelecionado);
				this.pessoaJuridicaFachada.update(empresa);
			}
		}
		if (!this.empresas.getSource().isEmpty()) {
			for (EmpresaEntity empresa : this.empresas.getSource()) {
				if (empresa.getGrupo().equals(this.grupoSelecionado)) {
					empresa.setGrupo(null);
					this.pessoaJuridicaFachada.update(empresa);
				}
			}
		}
		this.initEmpresa();
		if (this.empresasAtribuidas == null) {
			this.empresasAtribuidas = new ArrayList<>();
		}
		this.empresasNaoAtribuidasGrupo = pessoaJuridicaFachada.listarEmpresas(usuarioMB.getUsuarioLogado());
		this.grupoSelecionado = this.empresaGrupoFachada.read(this.grupoSelecionado.getIdGrupo());
		this.empresasAtribuidas = this.grupoSelecionado.getEmpresas();
		for (EmpresaEntity empresa : this.empresasAtribuidas) {
			if (this.empresasNaoAtribuidasGrupo.contains(empresa)) {
				this.empresasNaoAtribuidasGrupo.remove(empresa);
			}
		}
		this.dualListEmpresasDisponiveis(this.empresasNaoAtribuidasGrupo, this.empresasAtribuidas);

		FacesMessage msg = new FacesMessage("Sucesso",
				stringUtils.formatarTextoParaLeitura(this.grupoSelecionado.getNomeGrupo()) + " Alterado com Sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void cancelarEmpresasNoGrupoSelecionado(ActionEvent evt) {
		initEmpresa();
		this.empresasNaoAtribuidasGrupo = this.empresasDisponiveis;
		if (this.empresasAtribuidas == null) {
			this.empresasAtribuidas = new ArrayList<>();
		}
		if (!this.empresasAtribuidas.isEmpty()) {
			this.grupoSelecionado = this.empresaGrupoFachada.read(this.grupoSelecionado.getIdGrupo());
			this.empresasAtribuidas = this.grupoSelecionado.getEmpresas();
			for (EmpresaEntity empresa : this.empresasAtribuidas) {
				if (this.empresasNaoAtribuidasGrupo.contains(empresa)) {
					this.empresasNaoAtribuidasGrupo.remove(empresa);
				}
			}
			for (EmpresaEntity empresa : this.empresasNaoAtribuidasGrupo) {
				if (this.empresasAtribuidas.contains(empresa)) {
					this.empresasAtribuidas.remove(empresa);
				}
			}
		}
		this.dualListEmpresasDisponiveis(this.empresasNaoAtribuidasGrupo, this.empresasAtribuidas);
	}

	@PostConstruct
	public void initEmpresa() {
		try {

			// neste ponto as variáveis devem ser limpas
			this.empresa = null;
			this.fotografiaFachadaEmpresa = null;
			this.empresa = null;
			this.empresaFap = null;
			this.empresaDadosIsencao = null;
			this.empresaOrgI8n = null;
			this.empresaSoftwareHouse = null;
			this.empresasSoftwareHouse = null;
			this.fachadaEmpresa = null;
			this.logotipo = null;
			this.fotografiaFachadaAntiga = null;
			this.empresaLogotipoAntigo = null;
			this.empresasDisponiveis = null;
			this.empresasFiltradas = null;
			this.dadosCadastraisAnterior = null;
			this.dadosCadastraisAtual = null;
			this.dadosCadastraisHistorico = null;
			this.enderecoAtual = null;
			this.enderecoAnterior = null;
			this.enderecosHistorico = null;
			this.empresas = null;
			this.grupos = null;

			this.grupos = empresaGrupoFachada.listarGrupoEmpresas(usuarioMB.getUsuarioLogado());
			this.empresasDisponiveis = pessoaJuridicaFachada.listarEmpresas(usuarioMB.getUsuarioLogado());
			if (this.empresasAtribuidas == null || this.empresasAtribuidas.isEmpty()) {
				this.empresasAtribuidas = new ArrayList<>();
			}
			this.dualListEmpresasDisponiveis(this.empresasDisponiveis, this.empresasAtribuidas);
		} catch (NoResultException e) {
			e.printStackTrace();
			this.isListaEmpresa = true;
		}
	}

}
