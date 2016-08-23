package br.com.smartems.dmatnet.ManagedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import br.com.smartems.dmatnet.EJB.Facade.UsuarioFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@ManagedBean
@RequestScoped
public class CadastroUsuarioMB {

	@EJB
	private UsuarioFacadeLocal usuarioFachada;
	
	private UsuarioEntity usuario;
	
	
	// botões referentes à Edição do Cadastro de Usuários
	
	private boolean isBtnUsuarioEditarDesativado = false;
	private boolean isBtnUsuarioCancelarDesativado = true;
	private boolean isBtnUsuarioSalvarDesativado = true;
	private boolean isBtnUsuarioNovoDesativado = false;

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
	
	// fim dos getters e setters
	
	public String textoGenero (int genero){
		String textoGenero = "masculino";	
		if(genero == 2) {
			textoGenero = "feminino";
		}
		return textoGenero;				
	}
	
	
	// action dos botões de endereço empresa
	
	public void editarUsuario(ActionEvent e) {
		this.isBtnUsuarioEditarDesativado = true;
		this.isBtnUsuarioCancelarDesativado = false;
		this.isBtnUsuarioSalvarDesativado = false;
		this.isBtnUsuarioNovoDesativado = true;
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
	
}
