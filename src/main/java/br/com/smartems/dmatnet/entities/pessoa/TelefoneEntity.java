package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TelefoneEntity
 *
 */
@Entity

public class TelefoneEntity implements Serializable {
	   
	@Id
	private long idTelefone;
	private String numeroTelefone;
	private String tipoTelefone;
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
	
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	
	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
