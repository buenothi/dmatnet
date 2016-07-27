package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.AbstractPessoaJuridicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Stateless
@Local
public class PessoaJuridicaEAO extends AbstractEAO<AbstractPessoaJuridicaEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public PessoaJuridicaEAO() {
		super(AbstractPessoaJuridicaEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado) throws NoResultException {
		Query query = entityManager.createNamedQuery("Empresa.listarEmpresasPorUsuario", EmpresaEntity.class);
		query.setParameter("idUsuario", usuarioLogado.getIdPessoa());
		return (List<EmpresaEntity>) query.getResultList();
	}

}
