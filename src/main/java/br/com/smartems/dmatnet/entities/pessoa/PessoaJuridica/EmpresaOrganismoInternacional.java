package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_empresaOrgInternacional")
public class EmpresaOrganismoInternacional implements Serializable {

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

}
