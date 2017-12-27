package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tbl_codigoopcaoregistroeletronico database
 * table.
 * 
 */
@Entity
@Table(name = "tbl_codigoopcaoregistroeletronico")
@NamedQuery(name = "CodigoOpcaoRegistroEletronico.findAll", query = "SELECT c FROM CodigoOpcaoRegistroEletronico c")
public class CodigoOpcaoRegistroEletronico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String descricao;

	public CodigoOpcaoRegistroEletronico() {
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
		CodigoOpcaoRegistroEletronico other = (CodigoOpcaoRegistroEletronico) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}