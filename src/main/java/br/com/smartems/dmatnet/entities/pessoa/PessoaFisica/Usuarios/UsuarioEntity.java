package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuarios;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaEntity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_usuarios")
public class UsuarioEntity extends AbstractPessoaFisicaEntity implements Serializable {

	private String login;
	private String senha;
	private int usuarioTipo;

	@ManyToMany
	@JoinTable(name="tbl_usuarioGrupoJoinTable", 
		joinColumns=@JoinColumn(name="usuario_ID"),
		inverseJoinColumns=@JoinColumn(name="grupo_ID"))
	private List<UsuariosGrupoEntity> grupos;

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
		this.senha = senha;
	}

	public int getUsuarioTipo() {
		return usuarioTipo;
	}

	public void setUsuarioTipo(int usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
	}

	public List<UsuariosGrupoEntity> getGrupo() {
		return grupos;
	}

	public void setGrupo(List<UsuariosGrupoEntity> grupos) {
		this.grupos = grupos;
	}

}
