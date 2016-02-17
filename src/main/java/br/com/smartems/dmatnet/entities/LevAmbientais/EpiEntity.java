package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_EPI")
public class EpiEntity extends AbstractMedidaControleEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable(name="tbl_CA_EPI",
			joinColumns=@JoinColumn(name="epi_ID"),
			inverseJoinColumns=@JoinColumn(name="ca_ID"))
	private List<CaEPIEntity> listaCA;
	
	@ManyToMany(mappedBy="epis")
	private List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados;

	
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
