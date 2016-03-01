package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractMedidaControleEntity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_MedidasAdministrativasEntity")
public class MedidasAdministrativasEntity extends AbstractMedidaControleEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public MedidasAdministrativasEntity() {
		super();
	}
   
}
