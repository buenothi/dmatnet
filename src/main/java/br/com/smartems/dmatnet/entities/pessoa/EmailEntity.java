package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tbl_email")
public class EmailEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmail;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String nomeEmail;
	
	@ManyToOne
	@JoinColumn(name = "EMAILTIPO_ID")
	private EmailTipoEntity tipoEmail;
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

	public EmailTipoEntity getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(EmailTipoEntity tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return true;
	}

}
