package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Stateless
public class EmpresaEAO extends AbstractEAO<EmpresaEntity, Long> implements EmpresaEAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    public EmpresaEAO() {
        super();
    }
    
    public List<EmpresaEntity> empresasCriadasPeloUsuario (UsuarioEntity usuario) {
    	return null;
    }

}
