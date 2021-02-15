package br.com.smartems.dmatnet.JSF.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.Service.EstadoServiceLocal;
import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Named
@ViewScoped
public class EstadoMB implements Serializable {

	@EJB
	private EstadoServiceLocal estadoFachada;

	private List<EstadoEntity> estados;
	private EstadoEntity estadoSelecionado;
	private List<CidadeEntity> cidadesPorEstado;

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

	public List<CidadeEntity> getCidadesPorEstado() {
		if (this.cidadesPorEstado == null) {
			this.cidadesPorEstado = new ArrayList<CidadeEntity>();
		}
		return cidadesPorEstado;
	}

	public void setCidadesPorEstado(List<CidadeEntity> cidadesPorEstado) {
		this.cidadesPorEstado = cidadesPorEstado;
	}

	public void onSelectionEstado(AjaxBehaviorEvent evt) {
		this.estadoSelecionado = ((EstadoEntity) evt.getComponent().getAttributes().get("value"));
		this.cidadesPorEstado = this.estadoFachada.listarCidadesPorEstado(this.estadoSelecionado);
	}
	
	public void onValueChangeEstado(EstadoEntity estado) {
		this.cidadesPorEstado = this.estadoFachada.listarCidadesPorEstado(estado);
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
