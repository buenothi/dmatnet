package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

public interface AbstractFacade <T> {

	public abstract T read(long pk);
	public abstract void create(T entity);
	public abstract UsuarioEntity update (T entity);
	public abstract void delete (T entity);
	public abstract List<T> findAll();
}
