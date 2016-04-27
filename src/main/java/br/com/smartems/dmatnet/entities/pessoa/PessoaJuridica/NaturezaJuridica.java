package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_naturezajuridica database table.
 * 
 */
@Entity
@Table(name="tbl_naturezajuridica")
@NamedQuery(name="NaturezaJuridica.findAll", query="SELECT n FROM NaturezaJuridica n")
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

}