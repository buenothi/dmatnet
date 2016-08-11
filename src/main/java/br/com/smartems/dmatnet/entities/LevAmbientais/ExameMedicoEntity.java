package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="tbl_exameMedico")
public class ExameMedicoEntity implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="peridicidade_ID")
	private PeriodicidadeExame periodicidadeExame;
	
	private static final long serialVersionUID = 1L;

	public ExameMedicoEntity() {
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
		this.nome = nome.toUpperCase();
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}
	
	public PeriodicidadeExame getPeriodicidadeExame() {
		return periodicidadeExame;
	}
	
	public void setPeriodicidadeExame(PeriodicidadeExame periodicidadeExame) {
		this.periodicidadeExame = periodicidadeExame;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((periodicidadeExame == null) ? 0 : periodicidadeExame.hashCode());
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
		ExameMedicoEntity other = (ExameMedicoEntity) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (periodicidadeExame == null) {
			if (other.periodicidadeExame != null)
				return false;
		} else if (!periodicidadeExame.equals(other.periodicidadeExame))
			return false;
		return true;
	}
	
}
