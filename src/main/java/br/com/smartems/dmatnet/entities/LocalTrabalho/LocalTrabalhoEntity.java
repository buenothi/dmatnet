package br.com.smartems.dmatnet.entities.LocalTrabalho;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.LevAmbientais.GHE;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Funcao;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Setor;

@Entity
@Table(name="tbl_LocalTrabalho")
public class LocalTrabalhoEntity implements Serializable{

	@Id
	private long idLocalTrabalho;
	private long codAmbienteEsocial;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioValidade;
	
	@Temporal(TemporalType.DATE)
	private Date dataFimValidade;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="local_ID")
	private List<GHE> ghes;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<Setor> setores;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<Funcao> funcoes;

	private static final long serialVersionUID = 1L;

	public long getIdLocalTrabalho() {
		return idLocalTrabalho;
	}

	public void setIdLocalTrabalho(long idLocalTrabalho) {
		this.idLocalTrabalho = idLocalTrabalho;
	}

	public long getCodAmbienteEsocial() {
		return codAmbienteEsocial;
	}

	public void setCodAmbienteEsocial(long codAmbienteEsocial) {
		this.codAmbienteEsocial = codAmbienteEsocial;
	}

	public Date getDataInicioValidade() {
		return dataInicioValidade;
	}

	public void setDataInicioValidade(Date dataInicioValidade) {
		this.dataInicioValidade = dataInicioValidade;
	}

	public Date getDataFimValidade() {
		return dataFimValidade;
	}

	public void setDataFimValidade(Date dataFimValidade) {
		this.dataFimValidade = dataFimValidade;
	}

	public List<GHE> getGhes() {
		return ghes;
	}

	public void setGhes(List<GHE> ghes) {
		this.ghes = ghes;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}
	
}