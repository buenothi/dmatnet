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
import br.com.smartems.dmatnet.EJB.Facade.PessoaJuridicaFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@ManagedBean
@ViewScoped
public class CadastroEmpresaMB implements Serializable {

	@ManagedProperty(value = "#{usuarioMB}")
	private UsuarioMB usuarioMB;

	@EJB
	private PessoaJuridicaFacadeLocal pessoaJuridicaFachada;

	@EJB
	private EmpresaGrupoFacadeLocal empresaGrupoFachada;

	private EmpresaGrupoEntity grupoSelecionado;
	private EmpresaEntity empresa;
	private EmpresaCadastroEntity dadosCadastrais;
	private EnderecoEntity endereco;
	private List<EmpresaEntity> empresasDisponiveis;
	private List<EmpresaEntity> empresasAtribuidas;
	private DualListModel<EmpresaEntity> empresas;
	private List<EmpresaGrupoEntity> grupos;

	// botões referentes à Edição do Cadastro de Empresa
	private boolean isBtnEditarDesativado = false;
	private boolean isBtnCancelarDesativado = true;
	private boolean isBtnSalvarDesativado = true;
	private boolean isBtnNovaEmpresaDesativado = false;
	private boolean isListaEmpresa = false;
	private int tipoPessoaJuridicaSelecionada;

	// botões referentes à Edição do Cadastro de Grupo Empresa
	private boolean isBtnGrupoEditarDesativado = true;
	private boolean isTabEditarDesativado = false;
	private boolean isTabExibirDesativado = true;
	private boolean isBtnGrupoCancelarDesativado = true;
	private boolean isBtnGrupoSalvarDesativado = true;
	private boolean isBtnGrupoNovoDesativado = false;

	private String mascaraPessoaJuridica = "99.999.999/9999-99";

	private static final long serialVersionUID = 1L;

	public UsuarioMB getUsuarioMB() {
		return usuarioMB;
	}

	public void setUsuarioMB(UsuarioMB usuarioMB) {
		this.usuarioMB = usuarioMB;
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

	public EmpresaCadastroEntity getDadosCadastrais() {
		if (this.dadosCadastrais == null) {
			dadosCadastrais = new EmpresaCadastroEntity();
		}
		return dadosCadastrais;
	}

	public void setDadosCadastrais(EmpresaCadastroEntity dadosCadastrais) {
		this.dadosCadastrais = dadosCadastrais;
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
			endereco = new EnderecoEntity();
		}
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public List<EmpresaEntity> getEmpresasDisponiveis() {
		if (empresasDisponiveis == null) {
			empresasDisponiveis = new ArrayList<EmpresaEntity>();
		}
		return empresasDisponiveis;
	}

	public void setEmpresasDisponiveis(List<EmpresaEntity> empresasDisponiveis) {
		this.empresasDisponiveis = empresasDisponiveis;
	}

	public List<EmpresaEntity> getEmpresasAtribuidas() {
		if (empresasAtribuidas == null) {
			empresasAtribuidas = new ArrayList<EmpresaEntity>();
		}
		return empresasAtribuidas;
	}

	public void setEmpresasAtribuidas(List<EmpresaEntity> empresasAtribuidas) {
		this.empresasAtribuidas = empresasAtribuidas;
	}

	public DualListModel<EmpresaEntity> getEmpresas() {
		if (empresas == null) {
			empresas = new DualListModel<EmpresaEntity>();
		}
		return empresas;
	}

	public void setEmpresas(DualListModel<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}

	public List<EmpresaGrupoEntity> getGrupos() {
		if (grupos == null) {
			grupos = new ArrayList<EmpresaGrupoEntity>();
		}
		return grupos;
	}

	public void setGrupos(List<EmpresaGrupoEntity> grupos) {
		this.grupos = grupos;
	}

	public EmpresaGrupoEntity getGrupoSelecionado() {
		if (grupoSelecionado == null) {
			grupoSelecionado = new EmpresaGrupoEntity();
		}
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(EmpresaGrupoEntity grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public boolean isBtnEditarDesativado() {
		return isBtnEditarDesativado;
	}

	public void setBtnEditarDesativado(boolean isBtnEditarDesativado) {
		this.isBtnEditarDesativado = isBtnEditarDesativado;
	}

	public boolean isBtnCancelarDesativado() {
		return isBtnCancelarDesativado;
	}

	public void setBtnCancelarDesativado(boolean isBtnCancelarDesativado) {
		this.isBtnCancelarDesativado = isBtnCancelarDesativado;
	}

	public boolean isBtnSalvarDesativado() {
		return isBtnSalvarDesativado;
	}

	public void setBtnSalvarDesativado(boolean isBtnSalvarDesativado) {
		this.isBtnSalvarDesativado = isBtnSalvarDesativado;
	}

	public boolean isBtnNovaEmpresaDesativado() {
		return isBtnNovaEmpresaDesativado;
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

	public void setBtnGrupoNovaEmpresaDesativado(boolean isBtnGrupoNovoDesativado) {
		this.isBtnGrupoNovoDesativado = isBtnGrupoNovoDesativado;
	}

	public void setBtnNovaEmpresaDesativado(boolean isBtnNovaEmpresaDesativado) {
		this.isBtnNovaEmpresaDesativado = isBtnNovaEmpresaDesativado;
	}

	public void setTipoPessoaJuridicaSelecionada(int tipoPessoaJuridicaSelecionada) {
		this.tipoPessoaJuridicaSelecionada = tipoPessoaJuridicaSelecionada;
	}

	public int getTipoPessoaJuridicaSelecionada() {
		return tipoPessoaJuridicaSelecionada;
	}

	public String getMascaraPessoaJuridica() {
		return mascaraPessoaJuridica;
	}

	public void alterarMascaraPessoaJuridica() {
		switch (this.tipoPessoaJuridicaSelecionada) {
		case 1:
			this.mascaraPessoaJuridica = "99.999.999/9999-99";
			break;
		case 2:
			this.mascaraPessoaJuridica = "999.999.999-99";
			break;
		}
	}

	// action dos botões de dados cadastrais da empresa
	public void editarCadastro(ActionEvent e) {
		this.isBtnEditarDesativado = true;
		this.isBtnCancelarDesativado = false;
		this.isBtnSalvarDesativado = false;
		this.isBtnNovaEmpresaDesativado = true;
		System.out.println("teste editar Cadastro");
	}

	public void cancelarCadastro(ActionEvent e) {
		System.out.println("teste cancelar Cadastro");
		this.isBtnEditarDesativado = false;
		this.isBtnCancelarDesativado = true;
		this.isBtnSalvarDesativado = true;
		this.isBtnNovaEmpresaDesativado = false;
	}

	public void salvarCadastro(ActionEvent e) {
		System.out.println("teste salvar Cadastro");
		this.isBtnEditarDesativado = false;
		this.isBtnCancelarDesativado = true;
		this.isBtnSalvarDesativado = true;
		this.isBtnNovaEmpresaDesativado = false;
	}

	public void novoCadastro(ActionEvent e) {
		this.isBtnEditarDesativado = true;
		this.isBtnCancelarDesativado = false;
		this.isBtnSalvarDesativado = false;
		this.isBtnNovaEmpresaDesativado = true;
		this.empresa = new EmpresaEntity();
		System.out.println("teste novo Cadastro");
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
		this.isTabEditarDesativado = false;
		this.isTabExibirDesativado = true;
	}

	public void salvarCadastroGrupo(ActionEvent e) {
		this.isBtnGrupoEditarDesativado = false;
		this.isBtnGrupoCancelarDesativado = true;
		this.isBtnGrupoSalvarDesativado = true;
		this.isBtnGrupoNovoDesativado = false;
		this.isTabEditarDesativado = false;
		this.isTabExibirDesativado = true;

		if (this.grupoSelecionado.getIdGrupo() == 0) {
			this.empresaGrupoFachada.create(this.grupoSelecionado);
		} else {
			this.empresaGrupoFachada.update(this.grupoSelecionado);
		}

		FacesMessage msg = new FacesMessage("Sucesso", this.grupoSelecionado.getNomeGrupo() + " Salvo com Sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		this.initGrupo();
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

	@PostConstruct
	public void initGrupo() {
		try {
			this.grupos = empresaGrupoFachada.listarGrupoEmpresas(usuarioMB.getUsuarioLogado());
			try {
				this.empresasDisponiveis = pessoaJuridicaFachada.listarEmpresas(usuarioMB.getUsuarioLogado());
				if(this.empresasDisponiveis != null){
					this.empresas = new DualListModel<EmpresaEntity>(this.empresasDisponiveis, this.empresasAtribuidas);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.isListaEmpresa = false;
		} catch (NoResultException e) {
			e.printStackTrace();
			this.isListaEmpresa = true;
		}
	}

	public void onSelectionGrupo(SelectEvent evt) {
		this.grupoSelecionado = (EmpresaGrupoEntity) evt.getObject();
		this.isBtnGrupoEditarDesativado = false;
	}

}
