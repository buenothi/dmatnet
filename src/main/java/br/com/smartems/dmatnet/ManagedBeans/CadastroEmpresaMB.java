package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.smartems.dmatnet.EJB.Facade.PessoaJuridicaFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;

@ManagedBean
@SessionScoped
public class CadastroEmpresaMB implements Serializable {

	@EJB
	private PessoaJuridicaFacadeLocal pessoaJuridicaFachada; 
	
	private EmpresaCadastroEntity dadosCadastrais;
	private EnderecoEntity endereco;
	
	private boolean isBtnEditarDesativado = false;
	private boolean isBtnCancelarDesativado = true;
	private boolean isBtnSalvarDesativado = true;
	private boolean isBtnNovaEmpresaDesativado = false;
	private int tipoPessoaJuridicaSelecionada;
	private String mascaraPessoaJuridica = "99.999.999/9999-99";

	private static final long serialVersionUID = 1L;

	
	
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
	}
	
	public void novoCadastro(ActionEvent e) {
		this.isBtnEditarDesativado = true;
		this.isBtnCancelarDesativado = false;
		this.isBtnSalvarDesativado = false;
		this.isBtnNovaEmpresaDesativado = true;
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
}
