package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_empresaOrgInternacional")
public class EmpresaOrganismoInternacional implements Serializable {

	@Id
	private long idEmpresaOrgInternacional;
	private boolean isAcordoInternacional;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private EmpresaCadastroEntity empresaCadastro;
	
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

	public EmpresaCadastroEntity getEmpresaCadastro() {
		return empresaCadastro;
	}

	public void setEmpresaCadastro(EmpresaCadastroEntity empresaCadastro) {
		this.empresaCadastro = empresaCadastro;
	}

}