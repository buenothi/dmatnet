package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.smartems.dmatnet.entities.LocalTrabalho.LocalTrabalhoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Entity
@Table(name = "tbl_Empresa")
@NamedQueries({
		@NamedQuery(name = "Empresa.listarEmpresasPorUsuario", query = "SELECT empresa FROM EmpresaEntity empresa inner join empresa.usuarioCriador usuario WHERE usuario.idPessoa in :idUsuario") })
public class EmpresaEntity extends AbstractPessoaJuridicaEntity implements Serializable {

	private long codESocialEmpresa;

	@ManyToOne
	@JoinColumn(name = "grupo_ID")
	private EmpresaGrupoEntity grupo;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "empresa_ID")
	private List<EmpresaCadastroEntity> cadastros;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "empresa_ID")
	private List<LocalTrabalhoEntity> locais;

	@ManyToMany(mappedBy = "empresasGerenciadas")
	private List<UsuarioEntity> usuarios;

	@ManyToOne
	@JoinColumn(name = "usuarioCriador_ID")
	private UsuarioEntity usuarioCriador;

	private String tipoEstabelecimento;

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

	public EmpresaGrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(EmpresaGrupoEntity grupo) {
		this.grupo = grupo;
	}

	public List<EmpresaCadastroEntity> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<EmpresaCadastroEntity> cadastros) {
		this.cadastros = cadastros;
	}

	public List<LocalTrabalhoEntity> getLocais() {
		return locais;
	}

	public void setLocais(List<LocalTrabalhoEntity> locais) {
		this.locais = locais;
	}

	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioEntity getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(UsuarioEntity usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

}
