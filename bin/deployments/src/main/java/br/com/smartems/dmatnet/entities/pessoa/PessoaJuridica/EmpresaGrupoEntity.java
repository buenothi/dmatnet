package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Entity
@Table(name = "tbl_EmpresaGrupo")
@NamedQueries({
		@NamedQuery(name = "EmpresaGrupo.listarGruposPorUsuario", query = "SELECT grupo FROM EmpresaGrupoEntity grupo "
				+ "inner join grupo.usuarios usuario WHERE usuario.idPessoa in :idUsuario") })
public class EmpresaGrupoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGrupo;
	private String nomeGrupo;
	private String descricaoGrupo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "grupo")
	private List<EmpresaEntity> empresas;

	@ManyToMany
	@JoinTable(name = "tbl_usuarioGruposEmpresas_joinTable", joinColumns = @JoinColumn(name = "usuario_ID"), inverseJoinColumns = @JoinColumn(name = "grupo_ID"))
	private List<UsuarioEntity> usuarios;

	private static final long serialVersionUID = 1L;

	public EmpresaGrupoEntity() {
		super();
	}

	public long getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo.toUpperCase();
	}

	public String getDescricaoGrupo() {
		return this.descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo.toUpperCase();
	}

	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idGrupo ^ (idGrupo >>> 32));
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
		EmpresaGrupoEntity other = (EmpresaGrupoEntity) obj;
		if (idGrupo != other.idGrupo)
			return false;
		return true;
	}

}
