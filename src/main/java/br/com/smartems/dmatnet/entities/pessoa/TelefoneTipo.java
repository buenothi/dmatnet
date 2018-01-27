package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_telefoneTipo")
public class TelefoneTipo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTelefoneTipo;
	private String tipo;
	private static final long serialVersionUID = 1L;

	public TelefoneTipo() {
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

}
