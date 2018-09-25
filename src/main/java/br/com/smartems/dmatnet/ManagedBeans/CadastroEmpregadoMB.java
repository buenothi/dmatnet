package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

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

	/* Fim dos geters e seters */

	public String getNomeEmpregadoProcurado() {
		return nomeEmpregadoProcurado;
	}

	public void setNomeEmpregadoProcurado(String nomeEmpregadoProcurado) {
		this.nomeEmpregadoProcurado = nomeEmpregadoProcurado;
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
	
	@PostConstruct
	public void initEmpregado() {
		
	}

}
