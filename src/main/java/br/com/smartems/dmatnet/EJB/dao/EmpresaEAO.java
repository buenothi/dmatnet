package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaSetor;

@Stateless
@Local
public class EmpresaEAO extends AbstractEAO<EmpresaEntity, Long> {

	@PersistenceContext
	private EntityManager em;
	private List<TrabalhadorEntity> trabalhadores;
	private List<EmpresaSetor> setores;
	
    public EmpresaEAO() {
        super();
    }
    
    public List<EmpresaEntity> empresasCriadasPeloUsuario (UsuarioEntity usuario) {
    	return null;
    }
    
    @SuppressWarnings("unchecked")
    public List<TrabalhadorEntity> listarTrabalhadoresPorEmpresa (EmpresaEntity empresa) {
    	this.trabalhadores = (List<TrabalhadorEntity>)em.createNamedQuery("Empresa.listarTrabalhadoresPorEmpresa")
    			.setParameter("idEmpresa", empresa.getIdPessoa())
    			.getResultList();
    	return this.trabalhadores;
    }
    
    @SuppressWarnings("unchecked")
    public List<EmpresaSetor> listarSetoresPorEmpresa (EmpresaEntity empresa) {
    	this.setores = (List<EmpresaSetor>)em.createNamedQuery("Empresa.listarSetoresPorEmpresa")
    			.setParameter("idEmpresa", empresa.getIdPessoa())
    			.getResultList();
    	return this.setores;
    }

}
