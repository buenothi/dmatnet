package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_EmpresaSetores")
public class Setor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSetores;
	private String setorNome;

	private static final long serialVersionUID = 1L;

	public Setor() {
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
		this.setorNome = setorNome.toUpperCase();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idSetores ^ (idSetores >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (idSetores != other.idSetores)
			return false;
		return true;
	}

}
