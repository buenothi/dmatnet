package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_telefoneTipo")
public class TelefoneTipoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTelefoneTipo;
	private String tipo;
	private static final long serialVersionUID = 1L;

	public TelefoneTipoEntity() {
		super();
	}

	public long getIdTelefoneTipo() {
		return idTelefoneTipo;
	}

	public void setIdTelefoneTipo(long idTelefoneTipo) {
		this.idTelefoneTipo = idTelefoneTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idTelefoneTipo ^ (idTelefoneTipo >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		TelefoneTipoEntity other = (TelefoneTipoEntity) obj;
		if (idTelefoneTipo != other.idTelefoneTipo)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
