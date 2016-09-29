package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.EmpresaFotoEAO;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;

@Stateless
public class EmpresaFotoFacade implements EmpresaFotoFacadeLocal {

	@EJB
	private EmpresaFotoEAO empresaFotoEAO;

	@Override
	public EmpresaFoto read(long pk) {
		return empresaFotoEAO.read(pk);
	}

	@Override
	public void create(EmpresaFoto entity) {
		empresaFotoEAO.create(entity);
	}

	@Override
	public EmpresaFoto update(EmpresaFoto entity) {
		return empresaFotoEAO.update(entity);
	}

	@Override
	public void delete(EmpresaFoto entity) {
		empresaFotoEAO.delete(entity);
	}

	@Override
	public List<EmpresaFoto> findAll() {
		return empresaFotoEAO.findAll();
	}

}
