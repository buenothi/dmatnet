package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Stateless
public class TrabalhadorEAO extends AbstractEAO<TrabalhadorEntity, Long> implements TrabalhadorEAOLocal {
    
	@PersistenceContext
    private EntityManager em;
	
    public TrabalhadorEAO() {
        super();
    }
    
    public List<TrabalhadorEntity> trabalhadoresPorEmpresa (EmpresaEntity empresa) {
    	return null;
    }
    
    public List<UsuarioEntity> usuariosFilhos (UsuarioEntity usuario) {
    	return null;
    }

}
