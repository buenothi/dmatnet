package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="tbl_EmpresaSetores")
public class EmpresaSetores implements Serializable {
	   
	@Id
	private long idSetores;
	private String setorNome;
	private static final long serialVersionUID = 1L;

	public EmpresaSetores() {
		super();
	}   
	public long getIdSetores() {
		return this.idSetores;
	}

	public void setIdSetores(long idSetores) {
		this.idSetores = idSetores;
	}   
	public String getSetorNome() {
		return this.setorNome;
	}

	public void setSetorNome(String setorNome) {
		this.setorNome = setorNome;
	}
   
}
