package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.smartems.dmatnet.EJB.Facade.UsuarioFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	@EJB
	private UsuarioFacadeLocal usuarioFachada;
	private String login;
	private String senha;
	private UsuarioEntity usuarioLogado;

	private static final long serialVersionUID = 1L;

	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public UsuarioEntity getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioEntity usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void verificarUsuario(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean logado = false;

		try {
			this.usuarioLogado = usuarioFachada.logarUsuario(login, senha);
			logado = true;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Inválido", "usuario inválido");
			logado = false;
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", logado);
	}
		
	public String logarUsuario() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean logado = false;
		String outcome = "falha";

		try {
			this.usuarioLogado = usuarioFachada.logarUsuario(login, senha);
			outcome = "sucesso";
			logado = true;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Inválido", "usuario inválido");
			logado = false;
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", logado);
		}

		return outcome;
	}

}
