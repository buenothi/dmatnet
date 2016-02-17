package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractMedidaControleEntity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_MedidaAdministrativa")
public class MedidaAdministrativaEntity extends AbstractMedidaControleEntity implements Serializable {

	@ManyToMany(mappedBy="medidasAdministrativas")
	private List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados;
	
	private static final long serialVersionUID = 1L;

	public MedidaAdministrativaEntity() {
		super();
	}

	public List<RiscoAmbientalIdentificadoEntity> getRiscosAmbientaisIdentificados() {
		return riscosAmbientaisIdentificados;
	}

	public void setRiscosAmbientaisIdentificados(List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados) {
		this.riscosAmbientaisIdentificados = riscosAmbientaisIdentificados;
	}
   
}
