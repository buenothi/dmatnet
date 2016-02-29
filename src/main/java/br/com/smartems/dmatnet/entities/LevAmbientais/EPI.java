package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractMedidaControle;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_EPI")
public class EPI extends AbstractMedidaControle implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public EPI() {
		super();
	}
   
}
