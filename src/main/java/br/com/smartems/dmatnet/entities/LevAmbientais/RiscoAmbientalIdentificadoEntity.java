package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_RiscoAmbientalIdentificado")
public class RiscoAmbientalIdentificadoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int intensidade;
	private String unidadeAvaliacao;
	private int tempoExposicaoEmHoras;
	
	@ManyToOne
	@JoinColumn(name="riscoAmbiental_ID")
	private RiscoAmbientalEntity riscoAmbiental;
	
	@ManyToMany
	@JoinTable(name="tbl_RiscoAmbientalId_EPI",
			joinColumns=@JoinColumn(name="RiscoAmbientalId_ID"),
			inverseJoinColumns=@JoinColumn(name="EPI_ID"))
	private List<EpiEntity> epis;
	
	@ManyToMany
	@JoinTable(name="tbl_RiscoAmbientalId_EPC",
			joinColumns=@JoinColumn(name="RiscoAmbientalId_ID"),
			inverseJoinColumns=@JoinColumn(name="EPC_ID"))
	private List<EpcEntity> epcs;
	
	@ManyToMany
	@JoinTable(name="tbl_RiscoAmbientalId_MedAdministrativa",
			joinColumns=@JoinColumn(name="RiscoAmbientalId_ID"),
			inverseJoinColumns=@JoinColumn(name="MedidaAdministrativa_ID"))
	private List<MedidaAdministrativaEntity> medidasAdministrativas;
	
	private static final long serialVersionUID = 1L;

	public RiscoAmbientalIdentificadoEntity() {
		super();
	}   
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public int getIntensidade() {
		return this.intensidade;
	}

	public void setIntensidade(int intensidade) {
		this.intensidade = intensidade;
	}   
	
	public String getUnidadeAvaliacao() {
		return this.unidadeAvaliacao;
	}

	public void setUnidadeAvaliacao(String unidadeAvaliacao) {
		this.unidadeAvaliacao = unidadeAvaliacao;
	}   
	
	public int getTempoExposicaoEmHoras() {
		return this.tempoExposicaoEmHoras;
	}

	public void setTempoExposicaoEmHoras(int tempoExposicaoEmHoras) {
		this.tempoExposicaoEmHoras = tempoExposicaoEmHoras;
	}
	
	public RiscoAmbientalEntity getRiscoAmbiental() {
		return riscoAmbiental;
	}

	public void setRiscoAmbiental(RiscoAmbientalEntity riscoAmbiental) {
		this.riscoAmbiental = riscoAmbiental;
	}

	public List<EpiEntity> getEpis() {
		return epis;
	}
	
	public void setEpis(List<EpiEntity> epis) {
		this.epis = epis;
	}
	
	public List<EpcEntity> getEpcs() {
		return epcs;
	}
	
	public void setEpcs(List<EpcEntity> epcs) {
		this.epcs = epcs;
	}

	public List<MedidaAdministrativaEntity> getMedidasAdministrativas() {
		return medidasAdministrativas;
	}

	public void setMedidasAdministrativas(List<MedidaAdministrativaEntity> medidasAdministrativas) {
		this.medidasAdministrativas = medidasAdministrativas;
	}
		  
}
