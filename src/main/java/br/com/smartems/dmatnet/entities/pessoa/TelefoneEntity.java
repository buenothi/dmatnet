package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_telefone")
public class TelefoneEntity implements Serializable, Cloneable, Comparable<TelefoneEntity> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTelefone;
	private String numeroTelefone;

	@ManyToOne
	@JoinColumn(name = "TELEFONETIPO_ID")
	private TelefoneTipoEntity tipoTelefone;
	private static final long serialVersionUID = 1L;

	public TelefoneEntity() {
		super();
	}

	public long getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumeroTelefone() {
		return this.numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public TelefoneTipoEntity getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TelefoneTipoEntity tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idTelefone ^ (idTelefone >>> 32));
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
		TelefoneEntity other = (TelefoneEntity) obj;
		if (idTelefone != other.idTelefone)
			return false;
		return true;
	}

	@Override
	public TelefoneEntity clone() throws CloneNotSupportedException {
		return (TelefoneEntity) super.clone();
	}

	@Override
	public int compareTo(TelefoneEntity outroTelefone) {
		if(outroTelefone.getNumeroTelefone() == this.getNumeroTelefone()) {		
			return 0;
		}
		return -1;
	}
}
