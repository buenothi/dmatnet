package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_EPC")
public class EPCEntity extends AbstractMedidaControleEntity implements Serializable {
	
	@ManyToMany(mappedBy="epcs")
	private List<RiscoAmbientalIdentificadoEntity>riscosAmbientais;
	
	
	private static final long serialVersionUID = 1L;

	public EPCEntity() {
		super();
	}

	public List<RiscoAmbientalIdentificadoEntity> getRiscosAmbientais() {
		return riscosAmbientais;
	}

	public void setRiscosAmbientais(List<RiscoAmbientalIdentificadoEntity> riscosAmbientais) {
		this.riscosAmbientais = riscosAmbientais;
	}
   
}
