package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_empresaOrgInternacional")
public class EmpresaOrganismoInternacional implements Serializable, Cloneable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEmpresaOrgInternacional;
	private boolean isAcordoInternacional;
	
	private static final long serialVersionUID = 1L;

	
	public EmpresaOrganismoInternacional() {
		super();
	}

	public long getIdEmpresaOrgInternacional() {
		return idEmpresaOrgInternacional;
	}

	public void setIdEmpresaOrgInternacional(long idEmpresaOrgInternacional) {
		this.idEmpresaOrgInternacional = idEmpresaOrgInternacional;
	}

	public boolean isAcordoInternacional() {
		return isAcordoInternacional;
	}

	public void setAcordoInternacional(boolean isAcordoInternacional) {
		this.isAcordoInternacional = isAcordoInternacional;
	}

	@Override
	public EmpresaOrganismoInternacional clone() throws CloneNotSupportedException {
		return (EmpresaOrganismoInternacional) super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpresaOrgInternacional ^ (idEmpresaOrgInternacional >>> 32));
		result = prime * result + (isAcordoInternacional ? 1231 : 1237);
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
		EmpresaOrganismoInternacional other = (EmpresaOrganismoInternacional) obj;
		if (idEmpresaOrgInternacional != other.idEmpresaOrgInternacional)
			return false;
		if (isAcordoInternacional != other.isAcordoInternacional)
			return false;
		return true;
	}
	
}
