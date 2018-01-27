package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name = "tbl_telefone")
public class TelefoneEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTelefone;
	private String numeroTelefone;

	@ManyToOne
	@JoinColumn(name = "TELEFONETIPO_ID")
	private TelefoneEntity tipoTelefone;
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

	public TelefoneEntity getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TelefoneEntity tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TelefoneEntity [idTelefone=" + idTelefone + ", numeroTelefone=" + numeroTelefone + ", tipoTelefone="
				+ tipoTelefone + "]";
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

}
