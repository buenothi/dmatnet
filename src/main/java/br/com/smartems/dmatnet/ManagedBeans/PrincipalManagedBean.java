package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class PrincipalManagedBean implements Serializable{

	private boolean isCadastroEmpresa = false;
	
	private static final long serialVersionUID = 1L;

	public boolean isCadastroEmpresa() {
		return isCadastroEmpresa;
	}
	
	public void exibirCadastroEmpresa (ActionEvent evt) {
		this.isCadastroEmpresa = true;
	}

}
