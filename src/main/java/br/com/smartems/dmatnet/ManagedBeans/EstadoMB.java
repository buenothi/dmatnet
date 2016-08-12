package br.com.smartems.dmatnet.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.EJB.Facade.EstadoFacadeLocal;
import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@ManagedBean
@ViewScoped
public class EstadoMB implements Serializable {

	@EJB
	private EstadoFacadeLocal estadoFachada;

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
		if (this.estadoSelecionado == null) {
			this.estadoSelecionado = new EstadoEntity();
		}
		this.estados = estados;
	}

	public EstadoEntity getEstadoSelecionado() {
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
		this.cidadesPorEstado = this.estadoFachada.listarCidadesPorEstado(estadoSelecionado);
		System.out.println(this.cidadesPorEstado.get(4));
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
