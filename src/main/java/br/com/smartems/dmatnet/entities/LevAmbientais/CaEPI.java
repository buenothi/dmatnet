package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tbl_CaEPI")
public class CaEPI implements Serializable {
	   
	@Id
	private long numCA;
	private String nome;
	private String descricao;
	private byte[] imagemCA;
	private Date dataInicioValidade;
	private static final long serialVersionUID = 1L;

	public CaEPI() {
		super();
	}   
	public long getNumCA() {
		return this.numCA;
	}

	public void setNumCA(long numCA) {
		this.numCA = numCA;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public byte[] getImagemCA() {
		return this.imagemCA;
	}

	public void setImagemCA(byte[] imagemCA) {
		this.imagemCA = imagemCA;
	}   
	public Date getDataInicioValidade() {
		return this.dataInicioValidade;
	}

	public void setDataInicioValidade(Date dataInicioValidade) {
		this.dataInicioValidade = dataInicioValidade;
	}
   
}
