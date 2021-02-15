package br.com.smartems.dmatnet.JSF.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.Service.TelefoneTipoServiceLocal;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@Named
@ViewScoped
public class TelefoneTipoMB implements Serializable {

	@EJB
	private TelefoneTipoServiceLocal telefoneTipoFachada;

	private List<TelefoneTipoEntity> telefonesTipos;

	private static final long serialVersionUID = 1L;

	public TelefoneTipoServiceLocal getTelefoneTipoFachada() {
		return telefoneTipoFachada;
	}

	public void setTelefoneTipoFachada(TelefoneTipoServiceLocal telefoneTipoFachada) {
		this.telefoneTipoFachada = telefoneTipoFachada;
	}

	public List<TelefoneTipoEntity> getTelefonesTipos() {
		if (this.telefonesTipos == null) {
			this.telefonesTipos = new ArrayList<TelefoneTipoEntity>();
		}
		return telefonesTipos;
	}

	public void setTelefonesTipos(List<TelefoneTipoEntity> telefonesTipos) {
		this.telefonesTipos = telefonesTipos;
	}

	@PostConstruct
	public void initTelefoneTipoMB() {
		try {
			try {
				this.telefonesTipos = telefoneTipoFachada.findAll();
			} catch (NoResultException nre) {
				nre.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
