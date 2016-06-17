package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import br.com.smartems.dmatnet.entities.pessoa.AbstractPessoaEntity;
import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractPessoaJuridicaEntity extends AbstractPessoaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nomeFantasia; 
	
	public AbstractPessoaJuridicaEntity() {
		super();
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
}
