package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.EJB.Facade.EstadoFacadeLocal;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@ManagedBean
@ViewScoped
public class EstadoMB implements Serializable {
	
	@EJB
	private EstadoFacadeLocal estadoFachada;
	
	private List<EstadoEntity> estados;
	private EstadoEntity estadoSelecionado;

	private static final long serialVersionUID = 1L;

	public List<EstadoEntity> getEstados() {
		if (this.estados == null) {
			this.estados = new ArrayList<EstadoEntity>();
		}
		return estados;
	}

	public void setEstados(List<EstadoEntity> estados) {
		this.estados = estados;
	}
	
	public EstadoEntity getEstadoSelecionado() {
		if (this.estadoSelecionado == null) {
			this.estadoSelecionado = new EstadoEntity();
		}
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(EstadoEntity estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	@PostConstruct
	public void initEstadoMB() {
		try {
			try {
				this.estados = estadoFachada.findAll();
			} catch (NoResultException nre) {
				nre.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
