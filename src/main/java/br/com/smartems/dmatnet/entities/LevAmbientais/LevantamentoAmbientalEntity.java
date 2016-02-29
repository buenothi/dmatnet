package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_LevantamentoAmbiental")
public class LevantamentoAmbientalEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idLevAmbiental;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	
	private String observacoes;
	
//	private List<RiscoAmbientalIdentificado> RiscosAmbientaisIdentificados;
	
	private static final long serialVersionUID = 1L;

	public LevantamentoAmbientalEntity() {
		super();
	}
	
	public long getId() {
		return this.idLevAmbiental;
	}

	public void setId(long idLevAmbiental) {
		this.idLevAmbiental = idLevAmbiental;
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
   
}
