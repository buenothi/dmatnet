package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_usuariosGrupo")
public class UsuariosGrupoEntity implements Serializable {

	@Id
	private int idGrupo;
	private String nomeGrupo;
	
	@ManyToMany(mappedBy="grupos")
	private List<UsuarioEntity> usuarios;
	
	private static final long serialVersionUID = 1L;

	public UsuariosGrupoEntity() {
		super();
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idGrupo;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
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
		UsuariosGrupoEntity other = (UsuariosGrupoEntity) obj;
		if (idGrupo != other.idGrupo)
			return false;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuariosGrupoEntity [nomeGrupo=" + nomeGrupo + "]";
	}
    
}
