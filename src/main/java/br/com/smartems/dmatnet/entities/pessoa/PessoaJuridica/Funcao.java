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
	private long codFuncaoEsocial; //Código eSocial do Cargo 
	private String funcaoNome;
	private String funcaoDescricao;
		
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
	
	public long getCodFuncaoEsocial() {
		return codFuncaoEsocial;
	}
	public void setCodFuncaoEsocial(long codFuncaoEsocial) {
		this.codFuncaoEsocial = codFuncaoEsocial;
	}
	public String getFuncaoNome() {
		return this.funcaoNome;
	}

	public void setFuncaoNome(String funcaoNome) {
		this.funcaoNome = funcaoNome;
	}   
	public String getFuncaoDescricao() {
		return this.funcaoDescricao;
	}

	public void setFuncaoDescricao(String funcaoDescricao) {
		this.funcaoDescricao = funcaoDescricao;
	}

}
