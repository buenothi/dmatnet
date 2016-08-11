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
		this.descricaoAmbiente = descricaoAmbiente.toUpperCase();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAmbienteEsocial == null) ? 0 : codAmbienteEsocial.hashCode());
		result = prime * result + ((dataFimValidade == null) ? 0 : dataFimValidade.hashCode());
		result = prime * result + ((dataInicioValidade == null) ? 0 : dataInicioValidade.hashCode());
		result = prime * result + ((descricaoAmbiente == null) ? 0 : descricaoAmbiente.hashCode());
		result = prime * result + ((funcoes == null) ? 0 : funcoes.hashCode());
		result = prime * result + ((ghes == null) ? 0 : ghes.hashCode());
		result = prime * result + (int) (idLocalTrabalho ^ (idLocalTrabalho >>> 32));
		result = prime * result + localAmbiente;
		result = prime * result + ((numInscricao == null) ? 0 : numInscricao.hashCode());
		result = prime * result + ((setores == null) ? 0 : setores.hashCode());
		result = prime * result + tipoInscricao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalTrabalhoEntity other = (LocalTrabalhoEntity) obj;
		if (codAmbienteEsocial == null) {
			if (other.codAmbienteEsocial != null)
				return false;
		} else if (!codAmbienteEsocial.equals(other.codAmbienteEsocial))
			return false;
		if (dataFimValidade == null) {
			if (other.dataFimValidade != null)
				return false;
		} else if (!dataFimValidade.equals(other.dataFimValidade))
			return false;
		if (dataInicioValidade == null) {
			if (other.dataInicioValidade != null)
				return false;
		} else if (!dataInicioValidade.equals(other.dataInicioValidade))
			return false;
		if (descricaoAmbiente == null) {
			if (other.descricaoAmbiente != null)
				return false;
		} else if (!descricaoAmbiente.equals(other.descricaoAmbiente))
			return false;
		if (funcoes == null) {
			if (other.funcoes != null)
				return false;
		} else if (!funcoes.equals(other.funcoes))
			return false;
		if (ghes == null) {
			if (other.ghes != null)
				return false;
		} else if (!ghes.equals(other.ghes))
			return false;
		if (idLocalTrabalho != other.idLocalTrabalho)
			return false;
		if (localAmbiente != other.localAmbiente)
			return false;
		if (numInscricao == null) {
			if (other.numInscricao != null)
				return false;
		} else if (!numInscricao.equals(other.numInscricao))
			return false;
		if (setores == null) {
			if (other.setores != null)
				return false;
		} else if (!setores.equals(other.setores))
			return false;
		if (tipoInscricao != other.tipoInscricao)
			return false;
		return true;
	}
	
}
