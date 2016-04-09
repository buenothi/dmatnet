package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_TrabalhadorFuncao")
public class Funcao implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Long codFuncaoEsocial; //Código eSocial do Cargo 
	private String funcaoNome;
	private String funcaoDescricao;
	private Long cbo;
		
	private static final long serialVersionUID = 1L;

	public Funcao() {
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
	
}
