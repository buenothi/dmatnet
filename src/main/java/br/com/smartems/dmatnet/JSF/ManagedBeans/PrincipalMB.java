package br.com.smartems.dmatnet.JSF.ManagedBeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@SessionScoped
public class PrincipalMB implements Serializable {

	private String classMenuBotaoCadEmpresa = "menuBotao";
	private String classMenuBotaoHome = "menuBotaoSelecionado";
	private String classMenuBotaoCadEmpresaDesativado = "menuBotaoDesativado";
	private boolean isRenderizarCadastroEmpresa = false;

	private static final long serialVersionUID = 1L;

	public PrincipalMB() {
	}

	public String getClassMenuBotaoCadEmpresa() {
		return classMenuBotaoCadEmpresa;
	}

	public String getClassMenuBotaoHome() {
		return classMenuBotaoHome;
	}

	public String getClassMenuBotaoCadEmpresaDesativado() {
		return classMenuBotaoCadEmpresaDesativado;
	}

	public void setClassMenuBotaoCadEmpresaDesativado(String classMenuBotaoCadEmpresaDesativado) {
		this.classMenuBotaoCadEmpresaDesativado = classMenuBotaoCadEmpresaDesativado;
	}

	public boolean isRenderizarCadastroEmpresa() {
		return isRenderizarCadastroEmpresa;
	}

	public void exibirCadastroEmpresa(ActionEvent evt) {
		this.classMenuBotaoCadEmpresa = "menuBotaoSelecionado";
		this.classMenuBotaoHome = "menuBotao";
		this.isRenderizarCadastroEmpresa = true;
	}

	public void exibirHome(ActionEvent evt) {
		this.classMenuBotaoCadEmpresa = "menuBotao";
		this.classMenuBotaoHome = "menuBotaoSelecionado";
		this.isRenderizarCadastroEmpresa = false;
	}
	
	public void sairAplicacao(ActionEvent evt) {
		//RequestContext.getCurrentInstance().execute("PF('dlgSairAplicacao').show()");
		PrimeFaces.current().ajax().update("PF('dlgSairAplicacao').show()");
	}

}
