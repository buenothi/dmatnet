package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@ManagedBean
@RequestScoped
public class PrincipalMB implements Serializable {

	private String classMenuBotaoCadEmpresa = "menuBotao";
	private String classMenuBotaoHome = "menuBotaoSelecionado";
	private boolean isRenderizarCadastroEmpresa = false;
	private EmpresaEntity empresaSelecionada;

	private static final long serialVersionUID = 1L;

	public String getClassMenuBotaoCadEmpresa() {
		return classMenuBotaoCadEmpresa;
	}

	public String getClassMenuBotaoHome() {
		return classMenuBotaoHome;
	}

	public boolean isRenderizarCadastroEmpresa() {
		return isRenderizarCadastroEmpresa;
	}
	
	public EmpresaEntity getEmpresaSelecionada() {
		if(this.empresaSelecionada == null){
			this.empresaSelecionada = new EmpresaEntity();
		}
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(EmpresaEntity empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public void exibirCadastroEmpresa(ActionEvent evt) {
		this.classMenuBotaoCadEmpresa = "menuBotaoSelecionado";
		this.classMenuBotaoHome = "menuBotao";
		this.isRenderizarCadastroEmpresa = true;
	}

	public void exibirHome(ActionEvent evt) {
		this.classMenuBotaoCadEmpresa = "menuBotao";
		this.classMenuBotaoHome = "menuBotaoSelecionado";
	}
	
}
