package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	@JoinColumn(name="levAmbiental_ID")
	private List<RiscoAmbientalIdentificadoEntity> riscosAmbientais;
	
	private static final long serialVersionUID = 1L;

	public LevantamentoAmbientalEntity() {
		super();
	}

	public long getIdLevAmbiental() {
		return idLevAmbiental;
	}
	public void setIdLevAmbiental(long idLevAmbiental) {
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
		this.observacoes = observacoes.toUpperCase();
	}

	public List<RiscoAmbientalIdentificadoEntity> getRiscosAmbientais() {
		return riscosAmbientais;
	}
	public void setRiscosAmbientais(List<RiscoAmbientalIdentificadoEntity> riscosAmbientais) {
		this.riscosAmbientais = riscosAmbientais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((dataTermino == null) ? 0 : dataTermino.hashCode());
		result = prime * result + (int) (idLevAmbiental ^ (idLevAmbiental >>> 32));
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((riscosAmbientais == null) ? 0 : riscosAmbientais.hashCode());
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
		LevantamentoAmbientalEntity other = (LevantamentoAmbientalEntity) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (idLevAmbiental != other.idLevAmbiental)
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (riscosAmbientais == null) {
			if (other.riscosAmbientais != null)
				return false;
		} else if (!riscosAmbientais.equals(other.riscosAmbientais))
			return false;
		return true;
	}
   
}
