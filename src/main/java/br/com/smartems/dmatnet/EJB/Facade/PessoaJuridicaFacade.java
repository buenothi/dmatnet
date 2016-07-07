package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.PessoaJuridicaEAO;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.AbstractPessoaJuridicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Stateless
public class PessoaJuridicaFacade implements PessoaJuridicaFacadeLocal {

	@EJB
	private PessoaJuridicaEAO pessoaJuridicaEAO;
	
    public PessoaJuridicaFacade() {
    }

	@Override
	public AbstractPessoaJuridicaEntity read(long pk) {
		return pessoaJuridicaEAO.read(pk);
	}

	@Override
	public void create(AbstractPessoaJuridicaEntity entity) {
		pessoaJuridicaEAO.create(entity);
	}

	@Override
	public AbstractPessoaJuridicaEntity update(AbstractPessoaJuridicaEntity entity) {
		return pessoaJuridicaEAO.update(entity);
	}

	@Override
	public void delete(AbstractPessoaJuridicaEntity entity) {
		pessoaJuridicaEAO.delete(entity);
	}

	@Override
	public List<AbstractPessoaJuridicaEntity> findAll() {
		return pessoaJuridicaEAO.findAll();
	}
	
	public List<EmpresaEntity> empresasDisponiveis(UsuarioEntity usuarioLogado) {
		return pessoaJuridicaEAO.listarEmpresas(usuarioLogado);		
	}

	@Override
	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado) {
		return pessoaJuridicaEAO.listarEmpresas(usuarioLogado);
	}

}
