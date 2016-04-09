package br.com.smartems.dmatnet.entities.LocalTrabalho;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.LevAmbientais.GHEEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Funcao;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Setor;

@Entity
@Table(name="tbl_LocalTrabalho")
public class LocalTrabalhoEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idLocalTrabalho;
	private Long codAmbienteEsocial;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioValidade;
	
	@Temporal(TemporalType.DATE)
	private Date dataFimValidade;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="local_ID")
	private List<GHEEntity> ghes;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<Setor> setores;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="empresa_ID")
	private List<Funcao> funcoes;
	
	private String descricaoAmbiente;
	
	private int localAmbiente;//conforme eSocial
	
	private int tipoInscricao;//conforme eSocial
	
	private Long numInscricao;

	private static final long serialVersionUID = 1L;

	public long getIdLocalTrabalho() {
		return idLocalTrabalho;
	}

	public void setIdLocalTrabalho(long idLocalTrabalho) {
		this.idLocalTrabalho = idLocalTrabalho;
	}

	public Long getCodAmbienteEsocial() {
		return codAmbienteEsocial;
	}

	public void setCodAmbienteEsocial(Long codAmbienteEsocial) {
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

	public List<GHEEntity> getGhes() {
		return ghes;
	}

	public void setGhes(List<GHEEntity> ghes) {
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

	public String getDescricaoAmbiente() {
		return descricaoAmbiente;
	}

	public void setDescricaoAmbiente(String descricaoAmbiente) {
		this.descricaoAmbiente = descricaoAmbiente;
	}

	public int getLocalAmbiente() {
		return localAmbiente;
	}

	public void setLocalAmbiente(int localAmbiente) {
		this.localAmbiente = localAmbiente;
	}

	public int getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(int tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public Long getNumInscricao() {
		return numInscricao;
	}

	public void setNumInscricao(Long numInscricao) {
		this.numInscricao = numInscricao;
	}
	
}
