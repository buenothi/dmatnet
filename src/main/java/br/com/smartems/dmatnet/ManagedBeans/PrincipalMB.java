package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class PrincipalMB implements Serializable {

	private boolean isCadastroEmpresa = false;
	private String classMenuBotaoCadEmpresa = "menuBotao";
	private String classMenuBotaoHome = "menuBotaoSelecionado";

	private static final long serialVersionUID = 1L;

	public boolean isCadastroEmpresa() {
		return isCadastroEmpresa;
	}

	public String getClassMenuBotaoCadEmpresa() {
		return classMenuBotaoCadEmpresa;
	}

	public String getClassMenuBotaoHome() {
		return classMenuBotaoHome;
	}

	public void exibirCadastroEmpresa(ActionEvent evt) {
		this.isCadastroEmpresa = true;
		this.classMenuBotaoCadEmpresa = "menuBotaoSelecionado";
		this.classMenuBotaoHome = "menuBotao";
	}

	public void exibirHome(ActionEvent evt) {
		this.isCadastroEmpresa = false;
		this.classMenuBotaoCadEmpresa = "menuBotao";
		this.classMenuBotaoHome = "menuBotaoSelecionado";
	}
	
}
