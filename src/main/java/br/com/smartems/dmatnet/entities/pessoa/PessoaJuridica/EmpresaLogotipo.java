package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_EmpresaLogotipo")
public class EmpresaLogotipo implements Serializable, Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpresaLogotipo;

	@Lob
	private byte[] logotipo;

	private static final long serialVersionUID = 1L;

	public EmpresaLogotipo() {
	}

	public long getIdEmpresaLogotipo() {
		return idEmpresaLogotipo;
	}

	public void setIdEmpresaLogotipo(long idEmpresaLogotipo) {
		this.idEmpresaLogotipo = idEmpresaLogotipo;
	}

	public byte[] getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(byte[] logotipo) {
		this.logotipo = logotipo;
	}

	@Override
	public EmpresaLogotipo clone() throws CloneNotSupportedException {
		return (EmpresaLogotipo) super.clone();
	}

}
