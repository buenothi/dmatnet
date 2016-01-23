package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_empresa")
public class EmpresaEntity extends AbstractPessoaJuridicaEntity implements Serializable {

	private long codESocialEmpresa;//código atribuído ao empregado para atendimento do eSocial
	
	@OneToMany
	@JoinColumn(name="TRABALHADOR_ID")
	private List<EmpresaCadastroEntity> cadastrosEmpresa;
	private static final long serialVersionUID = 1L;

	public EmpresaEntity() {
		super();
	}
	
	
	public long getCodESocialEmpresa() {
		return codESocialEmpresa;
	}

	public void setCodESocialEmpresa(long codESocialEmpresa) {
		this.codESocialEmpresa = codESocialEmpresa;
	}

	public List<EmpresaCadastroEntity> getCadastrosEmpresa() {
		return cadastrosEmpresa;
	}

	public void setCadastrosEmpresa(List<EmpresaCadastroEntity> cadastrosEmpresa) {
		this.cadastrosEmpresa = cadastrosEmpresa;
	}
 
}
