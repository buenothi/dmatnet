package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_deficienciafisica")
public class DeficienciaFisicaEntity implements Serializable {

	@Id
	private long idDeficienciaFisica;

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeficiencia;

	private boolean isDeficienciaFisica;
	private boolean isDeficienciaVisual;
	private boolean isDeficienciaAuditiva;
	private boolean isDeficienciaMental;
	private boolean isDeficienciaIntelectual;
	private boolean isReabilitadoReadaptado;
	private String observacao;

	public long getIdDeficienciaFisica() {
		return idDeficienciaFisica;
	}

	public void setIdDeficienciaFisica(long idDeficienciaFisica) {
		this.idDeficienciaFisica = idDeficienciaFisica;
	}

	public Date getDataDeficiencia() {
		return dataDeficiencia;
	}

	public void setDataDeficiencia(Date dataDeficiencia) {
		this.dataDeficiencia = dataDeficiencia;
	}

	public boolean isDeficienciaFisica() {
		return isDeficienciaFisica;
	}

	public void setDeficienciaFisica(boolean isDeficienciaFisica) {
		this.isDeficienciaFisica = isDeficienciaFisica;
	}

	public boolean isDeficienciaVisual() {
		return isDeficienciaVisual;
	}

	public void setDeficienciaVisual(boolean isDeficienciaVisual) {
		this.isDeficienciaVisual = isDeficienciaVisual;
	}

	public boolean isDeficienciaAuditiva() {
		return isDeficienciaAuditiva;
	}

	public void setDeficienciaAuditiva(boolean isDeficienciaAuditiva) {
		this.isDeficienciaAuditiva = isDeficienciaAuditiva;
	}

	public boolean isDeficienciaMental() {
		return isDeficienciaMental;
	}

	public void setDeficienciaMental(boolean isDeficienciaMental) {
		this.isDeficienciaMental = isDeficienciaMental;
	}

	public boolean isDeficienciaIntelectual() {
		return isDeficienciaIntelectual;
	}

	public void setDeficienciaIntelectual(boolean isDeficienciaIntelectual) {
		this.isDeficienciaIntelectual = isDeficienciaIntelectual;
	}

	public boolean isReabilitadoReadaptado() {
		return isReabilitadoReadaptado;
	}

	public void setReabilitadoReadaptado(boolean isReabilitadoReadaptado) {
		this.isReabilitadoReadaptado = isReabilitadoReadaptado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeficiencia == null) ? 0 : dataDeficiencia.hashCode());
		result = prime * result + (int) (idDeficienciaFisica ^ (idDeficienciaFisica >>> 32));
		result = prime * result + (isDeficienciaAuditiva ? 1231 : 1237);
		result = prime * result + (isDeficienciaFisica ? 1231 : 1237);
		result = prime * result + (isDeficienciaIntelectual ? 1231 : 1237);
		result = prime * result + (isDeficienciaMental ? 1231 : 1237);
		result = prime * result + (isDeficienciaVisual ? 1231 : 1237);
		result = prime * result + (isReabilitadoReadaptado ? 1231 : 1237);
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
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
		DeficienciaFisicaEntity other = (DeficienciaFisicaEntity) obj;
		if (dataDeficiencia == null) {
			if (other.dataDeficiencia != null)
				return false;
		} else if (!dataDeficiencia.equals(other.dataDeficiencia))
			return false;
		if (idDeficienciaFisica != other.idDeficienciaFisica)
			return false;
		if (isDeficienciaAuditiva != other.isDeficienciaAuditiva)
			return false;
		if (isDeficienciaFisica != other.isDeficienciaFisica)
			return false;
		if (isDeficienciaIntelectual != other.isDeficienciaIntelectual)
			return false;
		if (isDeficienciaMental != other.isDeficienciaMental)
			return false;
		if (isDeficienciaVisual != other.isDeficienciaVisual)
			return false;
		if (isReabilitadoReadaptado != other.isReabilitadoReadaptado)
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}

}
