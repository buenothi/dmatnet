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
   
}
