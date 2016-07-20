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

import br.com.smartems.dmatnet.EJB.Facade.EmpresaGrupoFacadeLocal;
import br.com.smartems.dmatnet.EJB.Facade.PessoaJuridicaFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@ManagedBean
@ViewScoped
public class CadastroEmpresaMB implements Serializable {
	
	@ManagedProperty(value="#{usuarioMB}")
	private UsuarioMB usuarioMB;
	
	@EJB
	private PessoaJuridicaFacadeLocal pessoaJuridicaFachada; 
	
	@EJB
	private EmpresaGrupoFacadeLocal empresaGrupoFachada;
	
	private EmpresaGrupoEntity grupo;
	private EmpresaGrupoEntity grupoSelecionado;
	private EmpresaEntity empresa;
	private EmpresaCadastroEntity dadosCadastrais;
	private EnderecoEntity endereco;
	private List<EmpresaEntity> empresas;
	private List<EmpresaGrupoEntity> grupos; 
	
	private boolean isBtnEditarDesativado = false;
	private boolean isBtnCancelarDesativado = true;
	private boolean isBtnSalvarDesativado = true;
	private boolean isBtnNovaEmpresaDesativado = false;
	private boolean isListaEmpresa = false; 
	private int tipoPessoaJuridicaSelecionada;
	private String mascaraPessoaJuridica = "99.999.999/9999-99";

	private static final long serialVersionUID = 1L;


	public UsuarioMB getUsuarioMB() {
		return usuarioMB;
	}

	public void setUsuarioMB(UsuarioMB usuarioMB) {
		this.usuarioMB = usuarioMB;
	}

	public EmpresaGrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(EmpresaGrupoEntity grupo) {
		this.grupo = grupo;
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public EmpresaCadastroEntity getDadosCadastrais() {
		if(this.dadosCadastrais == null) {
			dadosCadastrais = new EmpresaCadastroEntity();
		}
		return dadosCadastrais;
	}

	public void setDadosCadastrais(EmpresaCadastroEntity dadosCadastrais) {
		this.dadosCadastrais = dadosCadastrais;
	}
	
	public String tipoInscricaoPJ(int tipoInscricao) {
		String textoInscricao = "CNPJ";
		if(tipoInscricao == 2) {
			textoInscricao = "CPF";
		}
		return textoInscricao;
	}

	public EnderecoEntity getEndereco() {
		if(this.endereco == null) {
			endereco = new EnderecoEntity(); 
		}
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}

	public List<EmpresaGrupoEntity> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<EmpresaGrupoEntity> grupos) {
		this.grupos = grupos;
	}

	public EmpresaGrupoEntity getGrupoSelecionado() {
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
		this.pessoaJuridicaFachada.create(this.empresa);
	}
	
	public void novoCadastro(ActionEvent e) {
		this.isBtnEditarDesativado = true;
		this.isBtnCancelarDesativado = false;
		this.isBtnSalvarDesativado = false;
		this.isBtnNovaEmpresaDesativado = true;
		this.grupo = new EmpresaGrupoEntity();
		this.empresa = new EmpresaEntity();
		this.dadosCadastrais = new EmpresaCadastroEntity();
		this.endereco = new EnderecoEntity();
		this.empresas = new ArrayList<EmpresaEntity>();
		System.out.println("teste novo Cadastro");
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
	
	@PostConstruct
	public void listarEmpresasDisponiveis(){
		try {
			this.grupos = empresaGrupoFachada.listarGrupoEmpresas(usuarioMB.getUsuarioLogado());
			this.isListaEmpresa = false;
		} catch (NoResultException e) {
			e.printStackTrace();
			this.isListaEmpresa = true;
		}
	}
	
	public void onSelectionGrupo(SelectEvent evt){
		FacesMessage msg = new FacesMessage("Teste", ((EmpresaGrupoEntity)evt.getObject()).getNomeGrupo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.grupoSelecionado = (EmpresaGrupoEntity)evt.getObject();
	}
	
}
