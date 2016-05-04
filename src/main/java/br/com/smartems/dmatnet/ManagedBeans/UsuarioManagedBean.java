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
public class UsuarioManagedBean implements Serializable {

	@EJB
	private UsuarioFacadeLocal usuarioFachada;
	private String login;
	private String senha;
	private UsuarioEntity usuarioLogado;
	private boolean isEditarCadastro;
	public boolean isLogado;
	private String outcome;

	private static final long serialVersionUID = 1L;

	public UsuarioManagedBean() {
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

	public void logarUsuario(ActionEvent e) {
		RequestContext context = RequestContext.getCurrentInstance();
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

		context.addCallbackParam("logado", isLogado);
	}

	public String navegar() {
		return this.outcome;
	}

}
