package br.com.smartems.dmatnet.entities.pessoa;

import br.com.smartems.dmatnet.entities.pessoa.AbstractPessoaEntity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractPessoaFisicaEntity extends AbstractPessoaEntity implements Serializable {

	@OneToMany
	private List<PessoaFisicaCadastro> cadastros;
	
	private static final long serialVersionUID = 1L;

	
	public AbstractPessoaFisicaEntity() {
		super();
	}

	public List<PessoaFisicaCadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<PessoaFisicaCadastro> cadastros) {
		this.cadastros = cadastros;
	}
   
}
