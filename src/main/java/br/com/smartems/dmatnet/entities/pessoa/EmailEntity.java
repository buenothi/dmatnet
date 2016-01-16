package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmailEntity
 *
 */
@Entity

public class EmailEntity implements Serializable {

	@Id
	private long idEmail;
	private String nomeEmail;
	private String tipoEmail;
	private static final long serialVersionUID = 1L;

	public EmailEntity() {
		super();
	}   
	
	public long getIdEmail() {
		return this.idEmail;
	}

	public void setIdEmail(long idEmail) {
		this.idEmail = idEmail;
	}   
	
	public String getNomeEmail() {
		return this.nomeEmail;
	}

	public void setNomeEmail(String nomeEmail) {
		this.nomeEmail = nomeEmail;
	}   
	
	public String getTipoEmail() {
		return this.tipoEmail;
	}

	public void setTipoEmail(String tipoEmail) {
		this.tipoEmail = tipoEmail;
	}
   
}
