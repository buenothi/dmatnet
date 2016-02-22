package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Empresa")
public class EmpresaEntity extends AbstractPessoaJuridicaEntity implements Serializable {
	
	private long codESocialEmpresa;
	
	@ManyToOne
	@JoinColumn(name="grupo_ID")
	private EmpresaGrupoEntity grupo;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<EmpresaCadastroEntity> cadastros;
	
	private static final long serialVersionUID = 1L;

	public EmpresaEntity() {
		super();
	}   
	
	
	public long getCodESocialEmpresa() {
		return this.codESocialEmpresa;
	}

	public void setCodESocialEmpresa(long codESocialEmpresa) {
		this.codESocialEmpresa = codESocialEmpresa;
	}
   
}
