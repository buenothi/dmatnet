package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractMedidaControleEntity implements Serializable, IMedidasControle {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public AbstractMedidaControleEntity() {
		super();
	}   
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
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
   
}
