package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@RequestScoped
public class CadastroEmpresaMB implements Serializable{
	
	private boolean isBtnEditarDesativado = false;
	private boolean isBtnCancelarDesativado = true;
	private boolean isBtnSalvarDesativado = true;
	private boolean isBtnNovaEmpresaDesativado = false;
	private int pessoaJuridicaSelecionada;
	private String mascaraPessoaJuridica = "99.999.999/9999-99";
	
	private static final long serialVersionUID = 1L;

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

	public void setBtnNovaEmpresaDesativado(boolean isBtnNovaEmpresaDesativado) {
		this.isBtnNovaEmpresaDesativado = isBtnNovaEmpresaDesativado;
	}

	public void setPessoaJuridicaSelecionada(int pessoaJuridicaSelecionada) {
		this.pessoaJuridicaSelecionada = pessoaJuridicaSelecionada;
	}

	public int getPessoaJuridicaSelecionada() {
		return pessoaJuridicaSelecionada;
	}

	public String getMascaraPessoaJuridica() {
		return mascaraPessoaJuridica;
	}

	public void editarCadastro(ActionEvent e) {
		 this.isBtnCancelarDesativado = false;
		 System.out.println("teste editar Cadastro");
	}
	
	public void alterarMascaraPessoaJuridica(ValueChangeEvent e) {
		switch (this.pessoaJuridicaSelecionada){
		case 1:
			this.mascaraPessoaJuridica = "99.999.999/9999-99";
			System.out.println("1");
			break;
		case 2:
			this.mascaraPessoaJuridica = "999.999.999-99";	
			System.out.println("2");
			break;
		}
	}
}
