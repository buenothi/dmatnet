package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_EPI")
public class EPIEntity extends AbstractMedidaControleEntity implements Serializable {

	@OneToMany
	@JoinColumn(name="epi_ID")
	private List<CaEPIEntity> listaCA;
	
	@ManyToMany(mappedBy="epis")
	private List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados;
	
	
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

	public List<RiscoAmbientalIdentificadoEntity> getRiscosAmbientaisIdentificados() {
		return riscosAmbientaisIdentificados;
	}

	public void setRiscosAmbientaisIdentificados(List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados) {
		this.riscosAmbientaisIdentificados = riscosAmbientaisIdentificados;
	}
   
}
