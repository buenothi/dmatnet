package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_PeriodicidadeExame")
public class PeriodicidadeExame implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		this.descricaoPeriodicidade = descricaoPeriodicidade.toUpperCase();
	}
	
	public List<ExameMedicoEntity> getExamesMedicos() {
		return examesMedicos;
	}
	
	public void setExamesMedicos(List<ExameMedicoEntity> examesMedicos) {
		this.examesMedicos = examesMedicos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoPeriodicidade == null) ? 0 : descricaoPeriodicidade.hashCode());
		result = prime * result + ((examesMedicos == null) ? 0 : examesMedicos.hashCode());
		result = prime * result + idPeriodicidade;
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
		PeriodicidadeExame other = (PeriodicidadeExame) obj;
		if (descricaoPeriodicidade == null) {
			if (other.descricaoPeriodicidade != null)
				return false;
		} else if (!descricaoPeriodicidade.equals(other.descricaoPeriodicidade))
			return false;
		if (examesMedicos == null) {
			if (other.examesMedicos != null)
				return false;
		} else if (!examesMedicos.equals(other.examesMedicos))
			return false;
		if (idPeriodicidade != other.idPeriodicidade)
			return false;
		return true;
	}
   
}
