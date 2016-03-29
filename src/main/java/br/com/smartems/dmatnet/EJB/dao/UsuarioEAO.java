package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Stateless
@Local
public class UsuarioEAO extends AbstractEAO<UsuarioEntity, Long> {

	@PersistenceContext
	private EntityManager em;
	private UsuarioEntity usuario;
	private List<UsuarioEntity> usuarios;

	public UsuarioEAO() {
		super();
	}

	public UsuarioEntity logarUsuario(String login, String senha) throws NoResultException {
		this.usuario = (UsuarioEntity)em.createNamedQuery("Usuario.logarUsuario")
				.setParameter("login", login)
				.setParameter("senha", senha)
				.getSingleResult();
		return usuario;

	}

	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuario) throws NoResultException {
		this.usuarios = (List<UsuarioEntity>)em.createNamedQuery("Usuario.listarUsuariosFilhos")
				.setParameter("idUsuarioPai", usuario.getIdUsuarioPai())
				.getResultList();
		return usuarios;
	}

	public String gerarNovaSenha(UsuarioEntity usuario){
		String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String senha="";
		for (int x=0; x<10; x++){
			int j = (int) (Math.random()*carct.length);
			senha += carct[j];
		}
		usuario.setSenha(senha);
		this.em.merge(usuario);
		return senha;
	}
}