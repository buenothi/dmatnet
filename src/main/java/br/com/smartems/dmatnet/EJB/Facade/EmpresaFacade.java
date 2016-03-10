package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Stateless
public class EmpresaFacade implements EmpresaFacadeLocal {

    public EmpresaFacade() {
    	
    }

	@Override
	public EmpresaEntity read(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(EmpresaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpresaEntity update(EmpresaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EmpresaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpresaEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
