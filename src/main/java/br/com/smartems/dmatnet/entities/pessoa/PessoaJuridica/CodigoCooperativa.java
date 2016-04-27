package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_codigocooperativa database table.
 * 
 */
@Entity
@Table(name="tbl_codigocooperativa")
@NamedQuery(name="CodigoCooperativa.findAll", query="SELECT c FROM CodigoCooperativa c")
public class CodigoCooperativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String descricao;

	public CodigoCooperativa() {
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

}