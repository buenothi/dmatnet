package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Logradouro")
public class EnderecoTipoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNomeLogradouro;
	
	private String siglaLogradouro;

	private String nomeLogradouro;

	private static final long serialVersionUID = 1L;

	public EnderecoTipoEntity() {
		super();
	}

	public int getIdNomeLogradouro() {
		return idNomeLogradouro;
	}

	public void setIdNomeLogradouro(int idNomeLogradouro) {
		this.idNomeLogradouro = idNomeLogradouro;
	}

	public String getSiglaLogradouro() {
		return siglaLogradouro;
	}

	public void setSiglaLogradouro(String siglaLogradouro) {
		this.siglaLogradouro = siglaLogradouro;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNomeLogradouro;
		result = prime * result + ((nomeLogradouro == null) ? 0 : nomeLogradouro.hashCode());
		result = prime * result + ((siglaLogradouro == null) ? 0 : siglaLogradouro.hashCode());
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
		EnderecoTipoEntity other = (EnderecoTipoEntity) obj;
		if (idNomeLogradouro != other.idNomeLogradouro)
			return false;
		if (nomeLogradouro == null) {
			if (other.nomeLogradouro != null)
				return false;
		} else if (!nomeLogradouro.equals(other.nomeLogradouro))
			return false;
		if (siglaLogradouro == null) {
			if (other.siglaLogradouro != null)
				return false;
		} else if (!siglaLogradouro.equals(other.siglaLogradouro))
			return false;
		return true;
	}

}
