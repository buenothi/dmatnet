package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tbl_codigoclassificacaotributaria database
 * table.
 * 
 */
@Entity
@Table(name = "tbl_codigoclassificacaotributaria")
@NamedQuery(name = "CodigoClassificacaoTributaria.findAll", query = "SELECT c FROM CodigoClassificacaoTributaria c")
public class CodigoClassificacaoTributaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String classificacao;

	public CodigoClassificacaoTributaria() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getClassificacao() {
		return this.classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
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
		CodigoClassificacaoTributaria other = (CodigoClassificacaoTributaria) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}