package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_riscoambientalidentificado")
public class RiscoAmbientalIdentificadoEntity extends RiscoAmbientalEntity implements Serializable {

	private int intensidadeRisco;
	private String unidadeAvaliacao;
	private int tempoExposicao;
	
	@ManyToMany
	@JoinTable(name="tbl_riscoambientalidentificadoepi_jointable",
			joinColumns=@JoinColumn(name="riscoIdentificado_ID"),
			inverseJoinColumns=@JoinColumn(name="epi_ID"))
	private List<EPIEntity> epis;
	
	@ManyToMany
	@JoinTable(name="tbl_riscoambientalidentificadoepc_jointable",
			joinColumns=@JoinColumn(name="riscoIdentificado_ID"),
			inverseJoinColumns=@JoinColumn(name="epc_ID"))
	private List<EPCEntity> epcs;
	
	@ManyToMany
	@JoinTable(name="tbl_riscoambientalidentificadomedidasadm_jointable",
			joinColumns=@JoinColumn(name="riscoIdentificado_ID"),
			inverseJoinColumns=@JoinColumn(name="medidasAdm_ID"))
	private List<MedidasAdministrativasEntity> medidasAdministrativas;
	
	
	private static final long serialVersionUID = 1L;

	public RiscoAmbientalIdentificadoEntity() {
		super();
	}

	public int getIntensidadeRisco() {
		return intensidadeRisco;
	}

	public void setIntensidadeRisco(int intensidadeRisco) {
		this.intensidadeRisco = intensidadeRisco;
	}

	public String getUnidadeAvaliacao() {
		return unidadeAvaliacao;
	}

	public void setUnidadeAvaliacao(String unidadeAvaliacao) {
		this.unidadeAvaliacao = unidadeAvaliacao.toLowerCase();
	}

	public int getTempoExposicao() {
		return tempoExposicao;
	}

	public void setTempoExposicao(int tempoExposicao) {
		this.tempoExposicao = tempoExposicao;
	}

	public List<EPIEntity> getEpis() {
		return epis;
	}

	public void setEpis(List<EPIEntity> epis) {
		this.epis = epis;
	}

	public List<EPCEntity> getEpcs() {
		return epcs;
	}

	public void setEpcs(List<EPCEntity> epcs) {
		this.epcs = epcs;
	}

	public List<MedidasAdministrativasEntity> getMedidasAdministrativas() {
		return medidasAdministrativas;
	}

	public void setMedidasAdministrativas(List<MedidasAdministrativasEntity> medidasAdministrativas) {
		this.medidasAdministrativas = medidasAdministrativas;
	}
   
}
