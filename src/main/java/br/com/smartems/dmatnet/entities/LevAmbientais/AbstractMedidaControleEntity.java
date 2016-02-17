package br.com.smartems.dmatnet.entities.LevAmbientais;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractMedidaControleEntity implements IMedidasControle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idMedida;
	private String nome;
	private String descricao;
	
	@Override
	public long getIdMedida() {
		return idMedida;
	}
	
	@Override
	public void setIdMedida(long idMedida) {
		this.idMedida = idMedida;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
