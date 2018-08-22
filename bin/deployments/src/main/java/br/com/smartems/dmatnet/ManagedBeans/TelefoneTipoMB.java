package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.EJB.Facade.TelefoneTipoFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@ManagedBean
@ViewScoped
public class TelefoneTipoMB implements Serializable {

	@EJB
	private TelefoneTipoFacadeLocal telefoneTipoFachada;

	private List<TelefoneTipoEntity> telefonesTipos;

	private static final long serialVersionUID = 1L;

	public TelefoneTipoFacadeLocal getTelefoneTipoFachada() {
		return telefoneTipoFachada;
	}

	public void setTelefoneTipoFachada(TelefoneTipoFacadeLocal telefoneTipoFachada) {
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
