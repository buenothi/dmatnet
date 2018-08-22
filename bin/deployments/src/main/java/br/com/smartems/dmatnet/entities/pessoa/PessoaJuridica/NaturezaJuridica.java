package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tbl_naturezajuridica database table.
 * 
 */
@Entity
@Table(name = "tbl_naturezajuridica")
@NamedQuery(name = "NaturezaJuridica.findAll", query = "SELECT n FROM NaturezaJuridica n")
public class NaturezaJuridica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codiigo;

	private String descricao;

	private String titulo;

	public NaturezaJuridica() {
	}

	public int getCodiigo() {
		return this.codiigo;
	}

	public void setCodiigo(int codiigo) {
		this.codiigo = codiigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codiigo;
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
		NaturezaJuridica other = (NaturezaJuridica) obj;
		if (codiigo != other.codiigo)
			return false;
		return true;
	}

}