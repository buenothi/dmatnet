package br.com.smartems.dmatnet.JSF.ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import br.com.smartems.dmatnet.Service.UsuarioServiceLocal;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Named
@SessionScoped
public class UsuarioMB implements Serializable {

	@EJB
	private UsuarioServiceLocal usuarioFachada;
	private String login;
	private String senha;
	private UsuarioEntity usuarioLogado;
	private boolean isEditarCadastro;
	private boolean isLogado;
	private String outcome;

	private static final long serialVersionUID = 1L;

	public UsuarioMB() {
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

	public boolean isEditarCadastro() {
		return isEditarCadastro;
	}

	public void setEditarCadastro(boolean isEditarCadastro) {
		this.isEditarCadastro = isEditarCadastro;
	}

	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}

	public void logarUsuario(ActionEvent e) {
		PrimeFaces context = PrimeFaces.current();
		FacesMessage message = null;
		isLogado = false;

		this.outcome = null;

		try {
			isLogado = true;
			this.usuarioLogado = usuarioFachada.logarUsuario(login, senha);
			this.outcome = "sucesso";
		} catch (Exception ex) {
			isLogado = false;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Inválido",
					"O login ou a senha informado está incorreto");
			FacesContext.getCurrentInstance().addMessage(null, message);
			this.outcome = "falha";
		}

		context.ajax().addCallbackParam("logado", isLogado);
	}
	
	public String logout() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "logout";
	}

	public String navegar() {
		return this.outcome;
	}
	
}
