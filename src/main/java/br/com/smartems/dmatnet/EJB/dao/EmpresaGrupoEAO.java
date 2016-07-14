package br.com.smartems.dmatnet.EJB.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@Stateless
@Local
public class EmpresaGrupoEAO extends AbstractEAO<EmpresaGrupoEntity, Long>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public EmpresaGrupoEAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaGrupoEntity> listarGrupoEmpresas(UsuarioEntity usuarioLogado) throws NoResultException {
		List<EmpresaGrupoEntity> listaGruposEmpresa = new ArrayList<EmpresaGrupoEntity>();
		if (usuarioLogado != null && usuarioLogado.getGrupo().getNomeGrupo() == "MASTER") {
			listaGruposEmpresa = this.findAll();
		} else {
			Query query = entityManager.createNamedQuery("EmpresaGrupo.listarGruposPorUsuario", EmpresaGrupoEntity.class);
			query.setParameter("idUsuario", usuarioLogado.getIdPessoa());
			listaGruposEmpresa = (List<EmpresaGrupoEntity>) query.getResultList();
		}
		return listaGruposEmpresa;
	}
}
