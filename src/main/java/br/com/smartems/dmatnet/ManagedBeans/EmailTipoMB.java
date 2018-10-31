package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.EJB.Facade.EmailTipoFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@Named
@ViewScoped
public class EmailTipoMB implements Serializable {

	@EJB
	private EmailTipoFacadeLocal emailTipoFachada;

	private List<EmailTipoEntity> emailsTipos;

	private static final long serialVersionUID = 1L;

	public EmailTipoFacadeLocal getEmailTipoFachada() {
		return emailTipoFachada;
	}

	public void setEmailTipoFachada(EmailTipoFacadeLocal emailTipoFachada) {
		this.emailTipoFachada = emailTipoFachada;
	}

	public List<EmailTipoEntity> getEmailsTipos() {
		if (this.emailsTipos == null) {
			this.emailsTipos = new ArrayList<EmailTipoEntity>();
		}
		return emailsTipos;
	}

	public void setEmailsTipos(List<EmailTipoEntity> emailsTipos) {
		this.emailsTipos = emailsTipos;
	}

	@PostConstruct
	public void initTelefoneTipoMB() {
		try {
			try {
				this.emailsTipos = emailTipoFachada.findAll();
			} catch (NoResultException nre) {
				nre.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
