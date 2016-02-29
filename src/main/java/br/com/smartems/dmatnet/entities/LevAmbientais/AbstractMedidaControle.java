package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractMedidaControle implements Serializable, IMedidasControle {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idMedida;
	private String nome;
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public AbstractMedidaControle() {
		super();
	}   
	public long getIdMedida() {
		return this.idMedida;
	}

	public void setIdMedida(long idMedida) {
		this.idMedida = idMedida;
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
