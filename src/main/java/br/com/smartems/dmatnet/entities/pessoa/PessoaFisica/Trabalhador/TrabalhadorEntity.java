package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaEntity;

@Entity
@Table(name = "tbl_trabalhador")
public class TrabalhadorEntity extends AbstractPessoaFisicaEntity implements Serializable {

	private long codESocialEmpregado;// código atribuído ao empregado para atendimento do eSocial

	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Temporal(TemporalType.DATE)
	private Date dataDesligamento;

	private String nomeMae;
	private String nomePai;
	private int grauInstrucao;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "trabalhador_ID")
	private List<TrabalhadorCadastroEntity> cadastrosTrabalhador;

	@OneToOne(cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private DeficienciaFisicaEntity deficienciaFisica;

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

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public int getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(int grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public List<TrabalhadorCadastroEntity> getCadastrosTrabalhador() {
		return cadastrosTrabalhador;
	}

	public void setCadastrosTrabalhador(List<TrabalhadorCadastroEntity> cadastrosTrabalhador) {
		this.cadastrosTrabalhador = cadastrosTrabalhador;
	}

	public DeficienciaFisicaEntity getDeficienciaFisica() {
		return deficienciaFisica;
	}

	public void setDeficienciaFisica(DeficienciaFisicaEntity deficienciaFisica) {
		this.deficienciaFisica = deficienciaFisica;
	}

}
