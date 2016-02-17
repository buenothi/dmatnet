package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractMedidaControleEntity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_EPC")
public class EpcEntity extends AbstractMedidaControleEntity implements Serializable {

	@ManyToMany(mappedBy="epcs")
	private List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados;
	
	private static final long serialVersionUID = 1L;

	public EpcEntity() {
		super();
	}

	public List<RiscoAmbientalIdentificadoEntity> getRiscosAmbientaisIdentificados() {
		return riscosAmbientaisIdentificados;
	}

	public void setRiscosAmbientaisIdentificados(List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados) {
		this.riscosAmbientaisIdentificados = riscosAmbientaisIdentificados;
	}
   
}
