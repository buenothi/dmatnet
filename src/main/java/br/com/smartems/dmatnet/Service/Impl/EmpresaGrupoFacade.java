package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.DAO.EmpresaGrupoDAO;
import br.com.smartems.dmatnet.Service.EmpresaGrupoServiceLocal;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@Stateless
public class EmpresaGrupoFacade implements EmpresaGrupoServiceLocal {

	@EJB
	private EmpresaGrupoDAO empresaGrupoEAO;

	@Override
	public EmpresaGrupoEntity read(long pk) {
		return empresaGrupoEAO.read(pk);
	}

	@Override
	public void create(EmpresaGrupoEntity entity) {
		empresaGrupoEAO.create(entity);
	}

	@Override
	public EmpresaGrupoEntity update(EmpresaGrupoEntity entity) {
		return empresaGrupoEAO.update(entity);
	}

	@Override
	public void delete(EmpresaGrupoEntity entity) {
		empresaGrupoEAO.delete(entity);
	}

	@Override
	public List<EmpresaGrupoEntity> findAll() {
		return empresaGrupoEAO.findAll();
	}

	@Override
	public List<EmpresaGrupoEntity> listarGrupoEmpresas(UsuarioEntity usuarioLogado) {
		return empresaGrupoEAO.listarGrupoEmpresas(usuarioLogado);
	}

}
