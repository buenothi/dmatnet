package br.com.smartems.dmatnet.entities.pessoa;

import br.com.smartems.dmatnet.entities.pessoa.AbstractPessoaFisicaEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_trabalhador")
public class TrabalhadorEntity extends AbstractPessoaFisicaEntity implements Serializable {

	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDesligamento;
	
	@OneToMany
	private List<TrabalhadorCadastroEntity> cadastros;
	
	private static final long serialVersionUID = 1L;

	
	public TrabalhadorEntity() {
		super();
	}
	
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(Date dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public List<TrabalhadorCadastroEntity> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<TrabalhadorCadastroEntity> cadastros) {
		this.cadastros = cadastros;
	}
   
}
