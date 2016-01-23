package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_trabalhador")
public class TrabalhadorEntity extends AbstractPessoaFisicaEntity implements Serializable {

	private long codESocialEmpregado;//código atribuído ao empregado para atendimento do eSocial
	
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Temporal(TemporalType.DATE)
	private Date dataDesligamento;

	@OneToMany
	@JoinColumn(name="TRABALHADOR_ID")
	private List<TrabalhadorCadastroEntity> cadastrosTrabalhador;

	private static final long serialVersionUID = 1L;

	public TrabalhadorEntity() {
		super();
	}
	
	public long getCodESocialEmpregado() {
		return codESocialEmpregado;
	}

	public void setCodESocialEmpregado(long codESocialEmpregado) {
		this.codESocialEmpregado = codESocialEmpregado;
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

}
