package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractMedidaControleEntity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_MedidasAdministrativas")
public class MedidasAdministrativasEntity extends AbstractMedidaControleEntity implements Serializable {

	@ManyToMany(mappedBy="medidasAdministrativas")
	private List<RiscoAmbientalIdentificadoEntity>riscosAmbientais;
	
	private static final long serialVersionUID = 1L;

	public MedidasAdministrativasEntity() {
		super();
	}

	public List<RiscoAmbientalIdentificadoEntity> getRiscosAmbientais() {
		return riscosAmbientais;
	}

	public void setRiscosAmbientais(List<RiscoAmbientalIdentificadoEntity> riscosAmbientais) {
		this.riscosAmbientais = riscosAmbientais;
	}
   
}
