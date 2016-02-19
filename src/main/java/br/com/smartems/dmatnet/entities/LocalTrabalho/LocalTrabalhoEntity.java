package br.com.smartems.dmatnet.entities.LocalTrabalho;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_LocalTrabalho")
public class LocalTrabalhoEntity implements Serializable{

	@Id
	private long idLocalTrabalho;
	private long codAmbienteEsocial;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioValidade;
	
	@Temporal(TemporalType.DATE)
	private Date dataFimValidade;
<<<<<<< master
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="local_ID")
	private List<GHE> ghes;
=======
>>>>>>> a8656b1 Finalização das Entities
	
	private static final long serialVersionUID = 1L;

	public long getIdLocalTrabalho() {
		return idLocalTrabalho;
	}

	public void setIdLocalTrabalho(long idLocalTrabalho) {
		this.idLocalTrabalho = idLocalTrabalho;
	}

	public long getCodAmbienteEsocial() {
		return codAmbienteEsocial;
	}

	public void setCodAmbienteEsocial(long codAmbienteEsocial) {
		this.codAmbienteEsocial = codAmbienteEsocial;
	}

	public Date getDataInicioValidade() {
		return dataInicioValidade;
	}

	public void setDataInicioValidade(Date dataInicioValidade) {
		this.dataInicioValidade = dataInicioValidade;
	}

	public Date getDataFimValidade() {
		return dataFimValidade;
	}

	public void setDataFimValidade(Date dataFimValidade) {
		this.dataFimValidade = dataFimValidade;
	}
	
}
