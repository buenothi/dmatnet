package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="tbl_MetodologiaAvaliacao")
public class MetodologiaAvaliacaoEntity implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private static final long serialVersionUID = 1L;

	public MetodologiaAvaliacaoEntity() {
		super();
	}   
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
   
}
