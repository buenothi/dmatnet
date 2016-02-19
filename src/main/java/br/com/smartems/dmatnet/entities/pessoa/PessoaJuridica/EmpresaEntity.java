package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.smartems.dmatnet.entities.LocalTrabalho.LocalTrabalhoEntity;

@Entity
@Table(name="tbl_empresa")
@NamedQueries({
	@NamedQuery(name="Empresa.ListarSetoresPorEmpresa", 
			query="SELECT s FROM EmpresaEntity e JOIN e.setores s WHERE e.idPessoa=:idEmpresa")
})
public class EmpresaEntity extends AbstractPessoaJuridicaEntity implements Serializable {

	private long codESocialEmpresa;//código atribuído ao empregado para atendimento do eSocial
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<EmpresaCadastroEntity> cadastrosEmpresa;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<EmpresaSetor> setores;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<LocalTrabalhoEntity> locaisTrabalho;
	
	@ManyToOne
	@JoinColumn(name="grupo_ID")
	private EmpresaGrupoEntity grupo;
	
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

	public List<EmpresaSetor> getSetores() {
		return setores;
	}

	public void setSetores(List<EmpresaSetor> setores) {
		this.setores = setores;
	}

	public List<LocalTrabalhoEntity> getLocaisTrabalho() {
		return locaisTrabalho;
	}

	public void setLocaisTrabalho(List<LocalTrabalhoEntity> locaisTrabalho) {
		this.locaisTrabalho = locaisTrabalho;
	}

	public EmpresaGrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(EmpresaGrupoEntity grupo) {
		this.grupo = grupo;
	}

}
