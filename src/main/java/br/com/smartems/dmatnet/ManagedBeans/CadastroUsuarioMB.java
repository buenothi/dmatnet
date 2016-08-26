package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.smartems.dmatnet.EJB.Facade.UsuarioFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@ManagedBean
@ViewScoped
public class CadastroUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioFacadeLocal usuarioFachada;
	
	private UsuarioEntity usuario;
	private EnderecoEntity enderecoUsuario;
	
	
	// botões referentes à Edição do Cadastro de Usuários
	
	private boolean isBtnUsuarioEditarDesativado = false;
	private boolean isBtnUsuarioCancelarDesativado = true;
	private boolean isBtnUsuarioSalvarDesativado = true;
	private boolean isBtnUsuarioNovoDesativado = false;
	
	
	// botões referentes à Edição do Endereço de Usuários
	
	private boolean isBtnEnderecoEditarDesativado = false;
	private boolean isBtnEnderecoCancelarDesativado = true;
	private boolean isBtnEnderecoSalvarDesativado = true;
	private boolean isBtnEnderecoNovoDesativado = false;

	public UsuarioEntity getUsuario() {
		if(usuario == null){
			this.usuario = new UsuarioEntity();
		}
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
	
	// início dos getters e setters

	public boolean isBtnUsuarioEditarDesativado() {
		return isBtnUsuarioEditarDesativado;
	}

	public void setBtnUsuarioEditarDesativado(boolean isBtnUsuarioEditarDesativado) {
		this.isBtnUsuarioEditarDesativado = isBtnUsuarioEditarDesativado;
	}

	public boolean isBtnUsuarioCancelarDesativado() {
		return isBtnUsuarioCancelarDesativado;
	}

	public void setBtnUsuarioCancelarDesativado(boolean isBtnUsuarioCancelarDesativado) {
		this.isBtnUsuarioCancelarDesativado = isBtnUsuarioCancelarDesativado;
	}

	public boolean isBtnUsuarioSalvarDesativado() {
		return isBtnUsuarioSalvarDesativado;
	}

	public void setBtnUsuarioSalvarDesativado(boolean isBtnUsuarioSalvarDesativado) {
		this.isBtnUsuarioSalvarDesativado = isBtnUsuarioSalvarDesativado;
	}

	public boolean isBtnUsuarioNovoDesativado() {
		return isBtnUsuarioNovoDesativado;
	}

	public void setBtnUsuarioNovoDesativado(boolean isBtnUsuarioNovoDesativado) {
		this.isBtnUsuarioNovoDesativado = isBtnUsuarioNovoDesativado;
	}
	
	public boolean isBtnEnderecoEditarDesativado() {
		return isBtnEnderecoEditarDesativado;
	}

	public void setBtnEnderecoEditarDesativado(boolean isBtnEnderecoEditarDesativado) {
		this.isBtnEnderecoEditarDesativado = isBtnEnderecoEditarDesativado;
	}

	public boolean isBtnEnderecoCancelarDesativado() {
		return isBtnEnderecoCancelarDesativado;
	}

	public void setBtnEnderecoCancelarDesativado(boolean isBtnEnderecoCancelarDesativado) {
		this.isBtnEnderecoCancelarDesativado = isBtnEnderecoCancelarDesativado;
	}

	public boolean isBtnEnderecoSalvarDesativado() {
		return isBtnEnderecoSalvarDesativado;
	}

	public void setBtnEnderecoSalvarDesativado(boolean isBtnEnderecoSalvarDesativado) {
		this.isBtnEnderecoSalvarDesativado = isBtnEnderecoSalvarDesativado;
	}

	public boolean isBtnEnderecoNovoDesativado() {
		return isBtnEnderecoNovoDesativado;
	}

	public void setBtnEnderecoNovoDesativado(boolean isBtnEnderecoNovoDesativado) {
		this.isBtnEnderecoNovoDesativado = isBtnEnderecoNovoDesativado;
	}

	public EnderecoEntity getEnderecoUsuario() {
		if(this.enderecoUsuario == null){
			this.enderecoUsuario = new EnderecoEntity();
		}
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(EnderecoEntity enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}
	
	// fim dos getters e setters
	
	
	public String textoGenero (int genero){
		String textoGenero = "masculino";	
		if(genero == 2) {
			textoGenero = "feminino";
		}
		return textoGenero;				
	}
	
	
	// action dos botões de usuário
	
	public void editarUsuario(ActionEvent e) {
		this.isBtnUsuarioEditarDesativado = true;
		this.isBtnUsuarioCancelarDesativado = false;
		this.isBtnUsuarioSalvarDesativado = false;
		this.isBtnUsuarioNovoDesativado = true;
		System.out.println("Teste Editar");
	}
	
	public void cancelarUsuario(ActionEvent e) {
		this.isBtnUsuarioEditarDesativado = false;
		this.isBtnUsuarioCancelarDesativado = true;
		this.isBtnUsuarioSalvarDesativado = true;
		this.isBtnUsuarioNovoDesativado = false;
	}
	
	public void salvarUsuario(ActionEvent e) {
		this.isBtnUsuarioEditarDesativado = false;
		this.isBtnUsuarioCancelarDesativado = true;
		this.isBtnUsuarioSalvarDesativado = true;
		this.isBtnUsuarioNovoDesativado = false;
	}
	
	public void novoUsuario(ActionEvent e) {
		this.isBtnUsuarioEditarDesativado = true;
		this.isBtnUsuarioCancelarDesativado = false;
		this.isBtnUsuarioSalvarDesativado = false;
		this.isBtnUsuarioNovoDesativado = true;
	}
	
	
	// action dos botões de endereçco do usuário
	
	public void editarEnderecoUsuario(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = true;
		this.isBtnEnderecoCancelarDesativado = false;
		this.isBtnEnderecoSalvarDesativado = false;
		this.isBtnEnderecoNovoDesativado = true;
	}
	
	public void cancelarEnderecoUsuario(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = false;
		this.isBtnEnderecoCancelarDesativado = true;
		this.isBtnEnderecoSalvarDesativado = true;
		this.isBtnEnderecoNovoDesativado = false;
	}
	
	public void salvarEnderecoUsuario(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = false;
		this.isBtnEnderecoCancelarDesativado = true;
		this.isBtnEnderecoSalvarDesativado = true;
		this.isBtnEnderecoNovoDesativado = false;
	}
	
	public void novoEnderecoUsuario(ActionEvent e) {
		this.isBtnEnderecoEditarDesativado = true;
		this.isBtnEnderecoCancelarDesativado = false;
		this.isBtnEnderecoSalvarDesativado = false;
		this.isBtnEnderecoNovoDesativado = true;
	}
	
}
