package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Stateless
public class UsuarioEAO extends AbstractEAO<UsuarioEntity, Long> implements UsuarioEAOLocal {
    
	@PersistenceContext
    private EntityManager em;
	
    public UsuarioEAO() {
        super();
    }
    
    public UsuarioEntity logarUsuario(String login, String senha) {
    	return null;
    }
    
    public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuario){
    	return null;
    }

}
