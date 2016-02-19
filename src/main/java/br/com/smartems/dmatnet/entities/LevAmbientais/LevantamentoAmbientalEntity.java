package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_LevantamentoAmbiental")
public class LevantamentoAmbientalEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	
	private String observacoes;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="LevAmbiental_ID")
	private List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados;
	
	private static final long serialVersionUID = 1L;

	public LevantamentoAmbientalEntity() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}   
	public Date getDataTermino() {
		return this.dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}   
	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public List<RiscoAmbientalIdentificadoEntity> getRiscosAmbientaisIdentificados() {
		return riscosAmbientaisIdentificados;
	}
	
	public void setRiscosAmbientaisIdentificados(List<RiscoAmbientalIdentificadoEntity> riscosAmbientaisIdentificados) {
		this.riscosAmbientaisIdentificados = riscosAmbientaisIdentificados;
	}
   
}
