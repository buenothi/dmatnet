package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_emailTipo")
public class EmailTipoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmailTipo;
	private String tipo;
	private static final long serialVersionUID = 1L;

	public long getIdEmailTipo() {
		return idEmailTipo;
	}

	public void setIdEmailTipo(long idEmailTipo) {
		this.idEmailTipo = idEmailTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
