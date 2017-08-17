package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="tbl_email")
public class EmailEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEmail;
	
	@Pattern(regexp = ".+@.+\\.[a-z]+")
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
		this.nomeEmail = nomeEmail.toUpperCase();
	}   
	
	public String getTipoEmail() {
		return this.tipoEmail;
	}

	public void setTipoEmail(String tipoEmail) {
		this.tipoEmail = tipoEmail.toUpperCase();
	}

	@Override
	public String toString() {
		return "EmailEntity [nomeEmail=" + nomeEmail + ", tipoEmail=" + tipoEmail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmail ^ (idEmail >>> 32));
		result = prime * result + ((nomeEmail == null) ? 0 : nomeEmail.hashCode());
		result = prime * result + ((tipoEmail == null) ? 0 : tipoEmail.hashCode());
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
		EmailEntity other = (EmailEntity) obj;
		if (idEmail != other.idEmail)
			return false;
		if (nomeEmail == null) {
			if (other.nomeEmail != null)
				return false;
		} else if (!nomeEmail.equals(other.nomeEmail))
			return false;
		if (tipoEmail == null) {
			if (other.tipoEmail != null)
				return false;
		} else if (!tipoEmail.equals(other.tipoEmail))
			return false;
		return true;
	}
   
}
