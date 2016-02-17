package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="tbl_ExameMedicoIndicado")
public class ExamesMedicosIndicadosEntity implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomeExame;
	private String descricaoExame;
	private String periodicidadeExame;
	private String periodicidadeEspecialExame;
	private static final long serialVersionUID = 1L;

	public ExamesMedicosIndicadosEntity() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNomeExame() {
		return this.nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}   
	public String getDescricaoExame() {
		return this.descricaoExame;
	}

	public void setDescricaoExame(String descricaoExame) {
		this.descricaoExame = descricaoExame;
	}   
	public String getPeriodicidadeExame() {
		return this.periodicidadeExame;
	}

	public void setPeriodicidadeExame(String periodicidadeExame) {
		this.periodicidadeExame = periodicidadeExame;
	}   
	public String getPeriodicidadeEspecialExame() {
		return this.periodicidadeEspecialExame;
	}

	public void setPeriodicidadeEspecialExame(String periodicidadeEspecialExame) {
		this.periodicidadeEspecialExame = periodicidadeEspecialExame;
	}
   
}
