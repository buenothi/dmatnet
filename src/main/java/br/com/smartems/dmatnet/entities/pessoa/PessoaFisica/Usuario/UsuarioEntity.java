package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;
import br.com.smartems.dmatnet.util.CriptografiaString;

@Entity
@Table(name="tbl_usuarios")
@NamedQueries({
	@NamedQuery(name="Usuario.logarUsuario", 
			query="SELECT u FROM UsuarioEntity u WHERE u.login=:login AND u.senha=:senha"),
	@NamedQuery(name="Usuario.listarUsuariosFilhos", 
			query="SELECT u FROM UsuarioEntity u WHERE u.idUsuarioPai=:idUsuarioPai"),
	@NamedQuery(name="Usuario.listarUsuariosMaster", 
			query="SELECT u, g FROM UsuarioEntity u, UsuariosGrupoEntity g WHERE g.nomeGrupo = 'MASTER'")
})
public class UsuarioEntity extends AbstractPessoaFisicaEntity implements Serializable {

	@Column(unique = true)
	private String login;
	private String senha;

	@ManyToOne
	@JoinColumn(name="usuarioGrupo_ID")
	private UsuariosGrupoEntity grupo;
	
	@ManyToMany
	@JoinTable(name="tbl_usuarioEmpresas_joinTable",
		joinColumns=@JoinColumn(name="usuario_ID"),
		inverseJoinColumns=@JoinColumn(name="empresa_ID"))
	private Collection<EmpresaEntity> empresasGerenciadas;
	
	@ManyToMany(mappedBy="usuarios")
	private List<EmpresaGrupoEntity> gruposGerenciados;
	
	private Long idUsuarioPai;

	private static final long serialVersionUID = 1L;

	public UsuarioEntity() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		CriptografiaString senhaCriptografada = new CriptografiaString();
		this.senha = senhaCriptografada.obterHashString(senha);
	}

	public UsuariosGrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(UsuariosGrupoEntity grupo) {
		this.grupo = grupo;
	}

	public Collection<EmpresaEntity> getEmpresasGerenciadas() {
		return empresasGerenciadas;
	}

	public void setEmpresasGerenciadas(Collection<EmpresaEntity> empresasGerenciadas) {
		this.empresasGerenciadas = empresasGerenciadas;
	}

	public Long getIdUsuarioPai() {
		return idUsuarioPai;
	}

	public void setIdUsuarioPai(Long idUsuarioPai) {
		this.idUsuarioPai = idUsuarioPai;
	}

	public List<EmpresaGrupoEntity> getGruposGerenciados() {
		return gruposGerenciados;
	}

	public void setGruposGerenciados(List<EmpresaGrupoEntity> gruposGerenciados) {
		this.gruposGerenciados = gruposGerenciados;
	}
	
}
