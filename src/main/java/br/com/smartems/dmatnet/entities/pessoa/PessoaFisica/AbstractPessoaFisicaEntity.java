package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import javax.persistence.*;

import br.com.smartems.dmatnet.entities.pessoa.AbstractPessoaEntity;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractPessoaFisicaEntity extends AbstractPessoaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public AbstractPessoaFisicaEntity() {
		super();
	}

}
