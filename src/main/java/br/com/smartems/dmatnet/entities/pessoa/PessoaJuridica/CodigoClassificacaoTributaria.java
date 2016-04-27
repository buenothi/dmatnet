package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_codigoclassificacaotributaria database table.
 * 
 */
@Entity
@Table(name="tbl_codigoclassificacaotributaria")
@NamedQuery(name="CodigoClassificacaoTributaria.findAll", query="SELECT c FROM CodigoClassificacaoTributaria c")
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

}