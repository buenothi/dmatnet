package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tbl_codigoconstrucaocivil database table.
 * 
 */
@Entity
@Table(name = "tbl_codigoconstrucaocivil")
@NamedQuery(name = "CodigoConstrucaoCivil.findAll", query = "SELECT c FROM CodigoConstrucaoCivil c")
public class CodigoConstrucaoCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String descricao;

	public CodigoConstrucaoCivil() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		CodigoConstrucaoCivil other = (CodigoConstrucaoCivil) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}