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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpresaLogotipo ^ (idEmpresaLogotipo >>> 32));
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
		EmpresaLogotipo other = (EmpresaLogotipo) obj;
		if (idEmpresaLogotipo != other.idEmpresaLogotipo)
			return false;
		return true;
	}

}
