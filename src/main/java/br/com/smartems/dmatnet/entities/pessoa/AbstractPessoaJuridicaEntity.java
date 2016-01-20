package br.com.smartems.dmatnet.entities.pessoa;

import br.com.smartems.dmatnet.entities.pessoa.AbstractPessoaEntity;
import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public class AbstractPessoaJuridicaEntity extends AbstractPessoaEntity implements Serializable {

	private long numCNPJ;
	
	private static final long serialVersionUID = 1L;

	
	public AbstractPessoaJuridicaEntity() {
		super();
	}

	public long getNumCNPJ() {
		return numCNPJ;
	}

	public void setNumCNPJ(long numCNPJ) {
		this.numCNPJ = numCNPJ;
	}
	
}
