package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaEntity;

@Entity
@Table(name="tbl_usuarios")
@NamedQueries({
	@NamedQuery(name="Usuario.logarUsuario", 
			query="SELECT u FROM UsuarioEntity u WHERE u.login=:login AND u.senha=:senha"),
	@NamedQuery(name="Usuario.listarUsuariosFilhos", 
			query="SELECT u FROM UsuarioEntity u WHERE u.idUsuarioPai=:idUsuarioPai")
})
public class UsuarioEntity extends AbstractPessoaFisicaEntity implements Serializable {

	@Column(unique = true)
	private String login;
	private String senha;

	@ManyToMany
	@JoinTable(name="tbl_usuarioGrupo_JoinTable", 
		joinColumns=@JoinColumn(name="usuario_ID"),
		inverseJoinColumns=@JoinColumn(name="grupo_ID"))
	private List<UsuariosGrupoEntity> grupos;
	
	private long idUsuarioPai;

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
		
		MessageDigest algoritmo;
		try {
			algoritmo = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algoritmo.digest(senha.getBytes());
			StringBuilder hexString = new StringBuilder();
			for(byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}			
			this.senha = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	
	}

	public List<UsuariosGrupoEntity> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<UsuariosGrupoEntity> grupos) {
		this.grupos = grupos;
	}

	public long getIdUsuarioPai() {
		return idUsuarioPai;
	}

	public void setIdUsuarioPai(long idUsuarioPai) {
		this.idUsuarioPai = idUsuarioPai;
	}
		
}
