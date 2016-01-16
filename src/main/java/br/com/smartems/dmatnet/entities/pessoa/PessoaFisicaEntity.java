package br.com.smartems.dmatnet.entities.pessoa;

import br.com.smartems.dmatnet.entities.pessoa.PessoaEntity;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PessoaFisicaEntity
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class PessoaFisicaEntity extends PessoaEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public PessoaFisicaEntity() {
		super();
	}
   
}
