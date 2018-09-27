package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;

@ManagedBean
@SessionScoped
public class CadastroEmpregadoMB implements Serializable {

	@ManagedProperty(value = "#{usuarioMB}")
	private UsuarioMB usuarioMB;

	@ManagedProperty(value = "#{principalMB}")
	private PrincipalMB principalMB;

	@ManagedProperty(value = "#{cadastroEmpresaMB}")
	private CadastroEmpresaMB cadastroEmpresaMB;

	private static final long serialVersionUID = 1L;

	private List<TrabalhadorEntity> listaEmpregadosEmpresaSelecionada;

	private String filtroEmpregadosEmpresaSelecionada = "Ativo";

	private String nomeEmpregadoProcurado;
	
	private boolean exibirDadosCadastraisEmpregado = true;
	
	private TrabalhadorEntity trabalhadorSelecionado;
	
	private TrabalhadorCadastroEntity trabalhadorSelecionadoCadastroAtual;
	private List<TrabalhadorCadastroEntity> trabalhadorSelecionadoListaCadastroHistorico;


	/* getters e setter */

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<TrabalhadorEntity> getListaEmpregadosEmpresaSelecionada() {
		if (this.listaEmpregadosEmpresaSelecionada == null) {
			this.listaEmpregadosEmpresaSelecionada = new ArrayList<TrabalhadorEntity>();
		}
		return listaEmpregadosEmpresaSelecionada;
	}

	public void setListaEmpregadosEmpresaSelecionada(List<TrabalhadorEntity> listaEmpregadosEmpresaSelecionada) {
		this.listaEmpregadosEmpresaSelecionada = listaEmpregadosEmpresaSelecionada;
	}

	public String getFiltroEmpregadosEmpresaSelecionada() {
		return filtroEmpregadosEmpresaSelecionada;
	}

	public void setFiltroEmpregadosEmpresaSelecionada(String filtroEmpregadosEmpresaSelecionada) {
		this.filtroEmpregadosEmpresaSelecionada = filtroEmpregadosEmpresaSelecionada;
	}
	
	public boolean isExibirDadosCadastraisEmpregado() {
		return exibirDadosCadastraisEmpregado;
	}

	public void setExibirDadosCadastraisEmpregado(boolean exibirDadosCadastraisEmpregado) {
		this.exibirDadosCadastraisEmpregado = exibirDadosCadastraisEmpregado;
	}

	public String getNomeEmpregadoProcurado() {
		return nomeEmpregadoProcurado;
	}

	public void setNomeEmpregadoProcurado(String nomeEmpregadoProcurado) {
		this.nomeEmpregadoProcurado = nomeEmpregadoProcurado;
	}
	
	public TrabalhadorEntity getTrabalhadorSelecionado() {
		return trabalhadorSelecionado;
	}

	public void setTrabalhadorSelecionado(TrabalhadorEntity trabalhadorSelecionado) {
		this.trabalhadorSelecionado = trabalhadorSelecionado;
	}

	public TrabalhadorCadastroEntity getTrabalhadorSelecionadoCadastroAtual() {
		return trabalhadorSelecionadoCadastroAtual;
	}

	public void setTrabalhadorSelecionadoCadastroAtual(TrabalhadorCadastroEntity trabalhadorSelecionadoCadastroAtual) {
		this.trabalhadorSelecionadoCadastroAtual = trabalhadorSelecionadoCadastroAtual;
	}

	public List<TrabalhadorCadastroEntity> getTrabalhadorSelecionadoListaCadastroHistorico() {
		return trabalhadorSelecionadoListaCadastroHistorico;
	}

	public void setTrabalhadorSelecionadoListaCadastroHistorico(
			List<TrabalhadorCadastroEntity> trabalhadorSelecionadoListaCadastroHistorico) {
		this.trabalhadorSelecionadoListaCadastroHistorico = trabalhadorSelecionadoListaCadastroHistorico;
	}

	
	
	
	
	public void mudarTipoFiltroListaEmpregados(AjaxBehaviorEvent evt) {

		// teste abaixo ok
		System.out.println(this.filtroEmpregadosEmpresaSelecionada.toString());
	}

	public void filtrarEmpregados(ActionEvent evt) {

	}

	public void removerFiltroEmpresa(ActionEvent e) {
		this.initEmpregado();
		this.nomeEmpregadoProcurado = null;
		this.listaEmpregadosEmpresaSelecionada = null;
	}
	
	public void onSelectionEmpregado(Object obj) {
		try {
			if (obj instanceof SelectEvent) {
				SelectEvent evt = (SelectEvent) obj;
				this.trabalhadorSelecionado = (TrabalhadorEntity) evt.getObject();
				
			} else if (obj instanceof TrabalhadorEntity) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void initEmpregado() {
		this.usuarioMB = null;
		this.principalMB = null;
		this.cadastroEmpresaMB = null;
		this.listaEmpregadosEmpresaSelecionada = null;
		this.filtroEmpregadosEmpresaSelecionada = "Ativo";
		this.nomeEmpregadoProcurado = null;
		this.exibirDadosCadastraisEmpregado = true;
		this.trabalhadorSelecionado = null;
	}

}
