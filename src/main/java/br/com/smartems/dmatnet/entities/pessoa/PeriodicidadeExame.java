package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_PeriodicidadeExame")
public class PeriodicidadeExame implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPeriodicidade;
	private String descricaoPeriodicidade;
	
	@OneToMany(mappedBy="periodicidadeExame")
	private List<ExameMedicoEntity> examesMedicos;
	
	private static final long serialVersionUID = 1L;

	public PeriodicidadeExame() {
		super();
	}   
	public int getIdPeriodicidade() {
		return this.idPeriodicidade;
	}

	public void setIdPeriodicidade(int idPeriodicidade) {
		this.idPeriodicidade = idPeriodicidade;
	}   
	public String getDescricaoPeriodicidade() {
		return this.descricaoPeriodicidade;
	}

	public void setDescricaoPeriodicidade(String descricaoPeriodicidade) {
		this.descricaoPeriodicidade = descricaoPeriodicidade;
	}
	
	public List<ExameMedicoEntity> getExamesMedicos() {
		return examesMedicos;
	}
	
	public void setExamesMedicos(List<ExameMedicoEntity> examesMedicos) {
		this.examesMedicos = examesMedicos;
	}
   
}
