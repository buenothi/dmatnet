package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractPessoaFisicaEntity extends AbstractPessoaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public AbstractPessoaFisicaEntity() {
		super();
	}

}
