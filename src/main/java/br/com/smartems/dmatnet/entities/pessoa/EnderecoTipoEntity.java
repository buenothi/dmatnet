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

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro.toUpperCase();
	}
}
