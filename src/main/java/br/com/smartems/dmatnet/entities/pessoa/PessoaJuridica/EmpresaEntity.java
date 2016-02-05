package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;

@Entity
@Table(name="tbl_empresa")
@NamedQueries({
	@NamedQuery(name="Empresa.listarTrabalhadoresPorEmpresa", 
			query="SELECT t FROM EmpresaEntity e JOIN e.trabalhadores t WHERE e.idPessoa=:idEmpresa"),
	@NamedQuery(name="Empresa.ListarSetoresPorEmpresa", 
			query="SELECT s FROM EmpresaEntity e JOIN e.setores s WHERE e.idPessoa=:idEmpresa")
})
public class EmpresaEntity extends AbstractPessoaJuridicaEntity implements Serializable {

	private long codESocialEmpresa;//código atribuído ao empregado para atendimento do eSocial
	
	@OneToMany
	@JoinColumn(name="EMPRESA_ID")
	private List<EmpresaCadastroEntity> cadastrosEmpresa;
	
	@OneToMany
	@JoinColumn(name="EMPRESA_ID")
	private List<TrabalhadorEntity> trabalhadores;
	
	@OneToMany
	@JoinColumn(name="EMPRESA_ID")
	private List<EmpresaSetores> setores;
	
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

	public List<TrabalhadorEntity> getTrabalhadores() {
		return trabalhadores;
	}

	public void setTrabalhadores(List<TrabalhadorEntity> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}

	public List<EmpresaSetores> getSetores() {
		return setores;
	}

	public void setSetores(List<EmpresaSetores> setores) {
		this.setores = setores;
	}

}
