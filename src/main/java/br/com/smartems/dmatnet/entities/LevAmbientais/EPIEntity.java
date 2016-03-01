package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractMedidaControleEntity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_EPI")
public class EPIEntity extends AbstractMedidaControleEntity implements Serializable {

	@OneToMany
	@JoinColumn(name="epi_ID")
	private List<CaEPIEntity> listaCA;
	
	private static final long serialVersionUID = 1L;

	public EPIEntity() {
		super();
	}

	public List<CaEPIEntity> getListaCA() {
		return listaCA;
	}
	public void setListaCA(List<CaEPIEntity> listaCA) {
		this.listaCA = listaCA;
	}
   
}
