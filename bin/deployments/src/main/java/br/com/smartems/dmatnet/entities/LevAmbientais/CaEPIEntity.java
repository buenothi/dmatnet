package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tbl_CaEPI")
public class CaEPIEntity implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numCA;
	private String nome;
	private String descricao;
	
	@Basic(fetch=FetchType.LAZY)
	private byte[] imagemCA;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioValidade;
	
	@Temporal(TemporalType.DATE)
	private Date dataFimValidade;
	
	private static final long serialVersionUID = 1L;

	public CaEPIEntity() {
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
		this.nome = nome.toUpperCase();
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
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
	
	public Date getDataFimValidade() {
		return dataFimValidade;
	}
	
	public void setDataFimValidade(Date dataFimValidade) {
		this.dataFimValidade = dataFimValidade;
	}
	
	@Override
	public String toString() {
		return "CaEPIEntity [nome=" + nome + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFimValidade == null) ? 0 : dataFimValidade.hashCode());
		result = prime * result + ((dataInicioValidade == null) ? 0 : dataInicioValidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + Arrays.hashCode(imagemCA);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (int) (numCA ^ (numCA >>> 32));
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
		CaEPIEntity other = (CaEPIEntity) obj;
		if (dataFimValidade == null) {
			if (other.dataFimValidade != null)
				return false;
		} else if (!dataFimValidade.equals(other.dataFimValidade))
			return false;
		if (dataInicioValidade == null) {
			if (other.dataInicioValidade != null)
				return false;
		} else if (!dataInicioValidade.equals(other.dataInicioValidade))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (!Arrays.equals(imagemCA, other.imagemCA))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCA != other.numCA)
			return false;
		return true;
	}
   
}
