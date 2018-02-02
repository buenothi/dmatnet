package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.util.CriptografiaString;

@Stateless
@Local
public class UsuarioEAO extends AbstractEAO<UsuarioEntity, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private CriptografiaString cs;
	private UsuarioEntity usuario;
	private List<UsuarioEntity> usuarios;

	public UsuarioEAO() {
		super(UsuarioEntity.class);
	}

	public UsuarioEntity logarUsuario(String login, String senha) throws NoResultException {
		String senhaCriptograda = cs.obterHashString(senha);
		this.usuario = (UsuarioEntity) entityManager.createNamedQuery("Usuario.logarUsuario").setParameter("login", login)
				.setParameter("senha", senhaCriptograda).getSingleResult();
		return usuario;

	}

	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuario) throws NoResultException {
		this.usuarios = (List<UsuarioEntity>) entityManager.createNamedQuery("Usuario.listarUsuariosFilhos")
				.setParameter("idUsuarioPai", usuario.getIdUsuarioPai()).getResultList();
		return usuarios;
	}

	public String gerarNovaSenha(UsuarioEntity usuario) {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		String senha = "";
		for (int x = 0; x < 10; x++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}
		usuario.setSenha(senha);
		this.entityManager.merge(usuario);
		return senha;
	}

	public UsuarioEntity salvarNovoUsuario(UsuarioEntity usuario) {
		try {
			if (usuario.getIdPessoa() == 0) {
				this.create(usuario);
			}
		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return usuario;
	}
}