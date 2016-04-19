package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.smartems.dmatnet.EJB.Facade.UsuarioFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@ManagedBean
public class UsuarioBean implements Serializable {

	@EJB
	private UsuarioFacadeLocal usuarioFachada;
	private String login;
	private String senha;
	private UsuarioEntity usuarioLogado = new UsuarioEntity();

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

	public void logarUsuario(ActionEvent event) {

		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean logado = false;

		try {
			this.usuarioLogado = usuarioFachada.logarUsuario(login, senha);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo", usuarioLogado.getNome());
			logado = true;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Inválido", "usuario inválido");
			logado = false;
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", logado);

	}

}
