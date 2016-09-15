package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.NoResultException;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

import br.com.smartems.dmatnet.EJB.Facade.EmpresaGrupoFacadeLocal;
import br.com.smartems.dmatnet.EJB.Facade.EstadoFacadeLocal;
import br.com.smartems.dmatnet.EJB.Facade.PessoaJuridicaFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFAP;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;
import br.com.smartems.dmatnet.util.filtrosCollection.Filter;
import br.com.smartems.dmatnet.util.filtrosCollection.FiltroEmpresa;

@ManagedBean
@ViewScoped
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

	private EmpresaGrupoEntity grupoSelecionado;
	private EmpresaGrupoEntity grupoEmpresa;
	private EmpresaEntity empresaSelecionada;
	private EmpresaEntity empresa;
	private EmpresaCadastroEntity dadosCadastrais;
	private EmpresaFAP empresaFap;
	private EnderecoEntity endereco;
	private List<EmpresaEntity> empresasDisponiveis;
	private List<EmpresaEntity> empresasNaoAtribuidasGrupo;
	private List<EmpresaEntity> empresasAtribuidas;
	private List<EmpresaEntity> empresasFiltradas;
	private DualListModel<EmpresaEntity> empresas;
	private List<EmpresaGrupoEntity> grupos;

	// botões referentes à Edição do Cadastro de Empresa

	private boolean isListaEmpresa = false;
	private int tipoPessoaJuridicaSelecionada;
	private String nomeEmpresaProcurada;

	// botões referentes à Edição do Cadastro de Grupo Empresa

	private boolean isBtnGrupoEditarDesativado = true;
	private boolean isTabEditarDesativado = false;
	private boolean isTabExibirDesativado = true;
	private boolean isBtnGrupoCancelarDesativado = true;
	private boolean isBtnGrupoSalvarDesativado = true;
	private boolean isBtnGrupoNovoDesativado = false;
	private boolean isBtnGrupoExcluirDesativado = true;
	private boolean isBtnSelecionarGrupo = true;

	// botões referentes à Edição do Cadastro de Dados Cadastrais da Empresa

	private boolean isBtnDadosCadastraisEditarDesativado = false;
	private boolean isBtnDadosCadastraisCancelarDesativado = true;
	private boolean isBtnDadosCadastraisSalvarDesativado = true;
	private boolean isBtnDadosCadastraisNovaEmpresaDesativado = false;

	// botões referentes à Edição do Endereço da Empresa

	private boolean isBtnEnderecoEditarDesativado = false;
	private boolean isBtnEnderecoCancelarDesativado = true;
	private boolean isBtnEnderecoSalvarDesativado = true;
	private boolean isBtnEnderecoNovoDesativado = false;

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

	public void setEmpresaSelecionada(EmpresaEntity empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public EmpresaCadastroEntity getDadosCadastrais() {
		if (this.dadosCadastrais == null) {
			dadosCadastrais = new EmpresaCadastroEntity();
		}
		return dadosCadastrais;
	}

	public void setDadosCadastrais(EmpresaCadastroEntity dadosCadastrais) {
		this.dadosCadastrais = dadosCadastrais;
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

	public String tipoInscricaoPJ(int tipoInscricao) {
		String textoInscricao = "CNPJ";
		if (tipoInscricao == 2) {
			textoInscricao = "CPF";
		}
		return textoInscricao;
	}

	public EnderecoEntity getEndereco() {
		if (this.endereco == null) {
			this.endereco = new EnderecoEntity();
		}
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
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

	public void setBtnGrupoNovaEmpresaDesativado(boolean isBtnGrupoNovoDesativado) {
		this.isBtnGrupoNovoDesativado = isBtnGrupoNovoDesativado;
	}

	public boolean isBtnDadosCadastraisEditarDesativado() {
		return isBtnDadosCadastraisEditarDesativado;
	}

	public void setBtnDadosCadastraisEditarDesativado(boolean isBtnDadosCadastraisEditarDesativado) {
		this.isBtnDadosCadastraisEditarDesativado = isBtnDadosCadastraisEditarDesativado;
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

	public boolean isBtnEnderecoEditarDesativado() {
		return isBtnEnderecoEditarDesativado;
	}

	public void setBtnEnderecoEditarDesativado(boolean isBtnEnderecoEditarDesativado) {
		this.isBtnEnderecoEditarDesativado = isBtnEnderecoEditarDesativado;
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
		switch (this.dadosCadastrais.getTipoInscricao()) {
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

	}

	public void salvarCadastroEmpresa(ActionEvent e) {
		if (this.empresa != null) {
			if (this.empresa.getIdPessoa() == 0) {
				this.empresa.setUsuarioCriador(this.usuarioMB.getUsuarioLogado());
				this.pessoaJuridicaFachada.create(this.empresa);
				this.initEmpresa();
				FacesMessage msg = new FacesMessage("Sucesso",
						this.empresa.getNome().toString() + " Salvo com Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				this.empresa = null;
			} else {
				this.empresa.setUsuarioCriador(this.usuarioMB.getUsuarioLogado());
				this.pessoaJuridicaFachada.update(this.empresa);
				this.initEmpresa();
				FacesMessage msg = new FacesMessage("Sucesso",
						this.empresa.getNome().toString() + " Atualizado com Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				this.empresa = null;
			}
		}
	}

	public void excluirCadastroEmpresa(EmpresaEntity empresa) {
		if (this.empresa != null) {
			this.pessoaJuridicaFachada.delete(empresa);
			this.initEmpresa();
			this.empresa = null;
		}

	}

	public void novoCadastroEmpresa(ActionEvent e) {
		this.empresa = new EmpresaEntity();
	}

	public void filtrarEmpresa(ActionEvent e) {
		if (!this.nomeEmpresaProcurada.isEmpty()) {
			this.initEmpresa();
			this.filtrarEmpresas();
			this.empresasDisponiveis = this.empresasFiltradas;
		} else {
			this.initEmpresa();
		}
	}

	public void removerFiltroEmpresa(ActionEvent e) {
		this.initEmpresa();
		this.nomeEmpresaProcurada = null;
		this.empresasFiltradas = null;
	}

	// action dos botões dados cadastrais da empresa

	public void editarDadosCadastraisEmpresa(ActionEvent e) {
		this.isBtnDadosCadastraisEditarDesativado = true;
		this.isBtnDadosCadastraisCancelarDesativado = false;
		this.isBtnDadosCadastraisSalvarDesativado = false;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = true;
	}

	public void cancelarDadosCadastraisEmpresa(ActionEvent e) {
		this.isBtnDadosCadastraisEditarDesativado = false;
		this.isBtnDadosCadastraisCancelarDesativado = true;
		this.isBtnDadosCadastraisSalvarDesativado = true;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = false;
	}

	public void salvarDadosCadastraisEmpresa(ActionEvent e) {
		this.isBtnDadosCadastraisEditarDesativado = false;
		this.isBtnDadosCadastraisCancelarDesativado = true;
		this.isBtnDadosCadastraisSalvarDesativado = true;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = false;
	}

	public void novoDadosCadastraisEmpresa(ActionEvent e) {
		this.isBtnDadosCadastraisEditarDesativado = true;
		this.isBtnDadosCadastraisCancelarDesativado = false;
		this.isBtnDadosCadastraisSalvarDesativado = false;
		this.isBtnDadosCadastraisNovaEmpresaDesativado = true;
	}

	// action dos botões de endereco empresa

	public void editarEnderecoEmpresa(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = true;
		this.isBtnEnderecoCancelarDesativado = false;
		this.isBtnEnderecoSalvarDesativado = false;
		this.isBtnEnderecoNovoDesativado = true;
	}

	public void cancelarEnderecoEmpresa(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = false;
		this.isBtnEnderecoCancelarDesativado = true;
		this.isBtnEnderecoSalvarDesativado = true;
		this.isBtnEnderecoNovoDesativado = false;
	}

	public void salvarEnderecoEmpresa(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = false;
		this.isBtnEnderecoCancelarDesativado = true;
		this.isBtnEnderecoSalvarDesativado = true;
		this.isBtnEnderecoNovoDesativado = false;
	}

	public void novoEnderecoEmpresa(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = true;
		this.isBtnEnderecoCancelarDesativado = false;
		this.isBtnEnderecoSalvarDesativado = false;
		this.isBtnEnderecoNovoDesativado = true;
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

		FacesMessage msg = new FacesMessage("Sucesso", this.grupoSelecionado.getNomeGrupo() + " Salvo com Sucesso");
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

		FacesMessage msg = new FacesMessage("Sucesso", this.grupoSelecionado.getNomeGrupo() + " Excluído com Sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		this.initEmpresa();
		this.grupoSelecionado = new EmpresaGrupoEntity();
	}

	public void editarEmpresaSelecionada(ActionEvent e) {
		System.out.println("teste");
	}

	@PostConstruct
	public void initEmpresa() {
		try {
			this.grupos = empresaGrupoFachada.listarGrupoEmpresas(usuarioMB.getUsuarioLogado());
			this.empresasDisponiveis = pessoaJuridicaFachada.listarEmpresas(usuarioMB.getUsuarioLogado());
			if (this.empresasAtribuidas == null) {
				this.empresasAtribuidas = new ArrayList<>();
			}
			this.dualListEmpresasDisponiveis(this.empresasDisponiveis, this.empresasAtribuidas);
		} catch (NoResultException e) {
			e.printStackTrace();
			this.isListaEmpresa = true;
		}
	}

	public void onSelectionGrupo(SelectEvent evt) {
		this.isBtnGrupoEditarDesativado = false;
		this.isBtnSelecionarGrupo = false;
		this.isBtnGrupoExcluirDesativado = false;
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

		FacesMessage msg = new FacesMessage("Sucesso", this.grupoSelecionado.getNomeGrupo() + " Alterado com Sucesso");
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

	// filtros para buscas diversas

	public void filtrarEmpresas() {
		Filter<EmpresaEntity> filtroEmpresa = new FiltroEmpresa();
		if (this.nomeEmpresaProcurada != null) {
			this.empresasFiltradas = new ArrayList<EmpresaEntity>();
			for (EmpresaEntity empresa : this.empresasDisponiveis)
				if (filtroEmpresa.match(empresa, this.nomeEmpresaProcurada))
					this.empresasFiltradas.add(empresa);

		}
	}

}
