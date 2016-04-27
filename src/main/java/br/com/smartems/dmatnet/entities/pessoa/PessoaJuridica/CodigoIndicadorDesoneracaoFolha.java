package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_codigoinddesoneracaofolha database table.
 * 
 */
@Entity
@Table(name="tbl_codigoinddesoneracaofolha")
@NamedQuery(name="CodigoIndicadorDesoneracaoFolha.findAll", query="SELECT c FROM CodigoIndicadorDesoneracaoFolha c")
public class CodigoIndicadorDesoneracaoFolha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String descricao;

	public CodigoIndicadorDesoneracaoFolha() {
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