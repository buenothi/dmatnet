package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity

public class PessoaEntity implements Serializable {

	@Id
	private long id;
	
	private static final long serialVersionUID = 1L;

	public PessoaEntity() {
		super();
	}
   
}
