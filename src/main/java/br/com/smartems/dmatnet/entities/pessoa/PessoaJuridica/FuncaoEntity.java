package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_TrabalhadorFuncao")
public class FuncaoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Long codFuncaoEsocial; // Código eSocial do Cargo
	private String funcaoNome;
	private String funcaoDescricao;
	private Long cbo;

	private static final long serialVersionUID = 1L;

	public FuncaoEntity() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getCodFuncaoEsocial() {
		return codFuncaoEsocial;
	}

	public void setCodFuncaoEsocial(Long codFuncaoEsocial) {
		this.codFuncaoEsocial = codFuncaoEsocial;
	}

	public String getFuncaoNome() {
		return this.funcaoNome;
	}

	public void setFuncaoNome(String funcaoNome) {
		this.funcaoNome = funcaoNome.toUpperCase();
	}

	public String getFuncaoDescricao() {
		return this.funcaoDescricao;
	}

	public void setFuncaoDescricao(String funcaoDescricao) {
		this.funcaoDescricao = funcaoDescricao.toUpperCase();
	}

	public Long getCbo() {
		return cbo;
	}

	public void setCbo(Long cbo) {
		this.cbo = cbo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		FuncaoEntity other = (FuncaoEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
