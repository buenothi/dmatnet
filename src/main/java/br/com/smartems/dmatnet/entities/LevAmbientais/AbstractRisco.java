package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@MappedSuperclass
public class AbstractRisco implements Serializable, IRiscoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	private String nome;
	private long CodFatorRisco_tab21;
	private long CodFatorRisco_tab22;
	private long CodFatorRisco_tab23;
	
	@ManyToMany
	@JoinTable(name="tbl_Risco_Metodologia", 
			joinColumns=@JoinColumn(name="risco_ID"), 
			inverseJoinColumns=@JoinColumn(name="metodologia_ID"))
	private List<MetodologiaAvaliacaoEntity> metodologiasAvaliacao;
	
	@ManyToMany
	@JoinTable(name="tbl_Risco_PossiveisDanos", 
			joinColumns=@JoinColumn(name="risco_ID"), 
			inverseJoinColumns=@JoinColumn(name="possiveisDanos_ID"))
	private List<PossiveisDanosEntity> possiveisDanos;
	
	@ManyToMany
	@JoinTable(name="tbl_Risco_EPI", 
			joinColumns=@JoinColumn(name="risco_ID"), 
			inverseJoinColumns=@JoinColumn(name="epis_ID"))
	private List<EpiEntity> epis;
	
	@ManyToMany
	@JoinTable(name="tbl_Risco_EPC", 
			joinColumns=@JoinColumn(name="risco_ID"), 
			inverseJoinColumns=@JoinColumn(name="epcs_ID"))
	private List<EpcEntity> epcs;
	
	@ManyToMany
	@JoinTable(name="tbl_Risco_MedidasAdministrativas", 
			joinColumns=@JoinColumn(name="risco_ID"), 
			inverseJoinColumns=@JoinColumn(name="medidasAdministrativas_ID"))
	private List<MedidaAdministrativaEntity> medidasAdministrativas;
	
	@ManyToMany
	@JoinTable(name="tbl_Risco_examesMedicosIndicados", 
			joinColumns=@JoinColumn(name="risco_ID"), 
			inverseJoinColumns=@JoinColumn(name="examesMedicosIndicados_ID"))	
	private List<ExamesMedicosIndicadosEntity> examesMedicosIndicados;
	
	private static final long serialVersionUID = 1L;

	public AbstractRisco() {
		super();
	}
	
	@Override
	public long getId() {
		return Id;
	}

	@Override
	public void setId(long id) {
		Id = id;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public long getCodFatorRisco_tab21() {
		return CodFatorRisco_tab21;
	}

	@Override
	public void setCodFatorRisco_tab21(long codFatorRisco_tab21) {
		CodFatorRisco_tab21 = codFatorRisco_tab21;
	}

	@Override
	public long getCodFatorRisco_tab22() {
		return CodFatorRisco_tab22;
	}

	@Override
	public void setCodFatorRisco_tab22(long codFatorRisco_tab22) {
		CodFatorRisco_tab22 = codFatorRisco_tab22;
	}

	@Override
	public long getCodFatorRisco_tab23() {
		return CodFatorRisco_tab23;
	}

	@Override
	public void setCodFatorRisco_tab23(long codFatorRisco_tab23) {
		CodFatorRisco_tab23 = codFatorRisco_tab23;
	}

	@Override
	public List<MetodologiaAvaliacaoEntity> getMetodologiasAvaliacao() {
		return metodologiasAvaliacao;
	}

	@Override
	public void setMetodologiasAvaliacao(List<MetodologiaAvaliacaoEntity> metodologiasAvaliacao) {
		this.metodologiasAvaliacao = metodologiasAvaliacao;
	}

	@Override
	public List<PossiveisDanosEntity> getPossiveisDanos() {
		return possiveisDanos;
	}

	@Override
	public void setPossiveisDanos(List<PossiveisDanosEntity> possiveisDanos) {
		this.possiveisDanos = possiveisDanos;
	}

	@Override
	public List<EpiEntity> getEpis() {
		return epis;
	}

	@Override
	public void setEpis(List<EpiEntity> epis) {
		this.epis = epis;
	}

	@Override
	public List<EpcEntity> getEpcs() {
		return epcs;
	}

	@Override
	public void setEpcs(List<EpcEntity> epcs) {
		this.epcs = epcs;
	}

	@Override
	public List<MedidaAdministrativaEntity> getMedidasAdministrativas() {
		return medidasAdministrativas;
	}

	@Override
	public void setMedidasAdministrativas(List<MedidaAdministrativaEntity> medidasAdministrativas) {
		this.medidasAdministrativas = medidasAdministrativas;
	}

	@Override
	public List<ExamesMedicosIndicadosEntity> getExamesMedicosIndicados() {
		return examesMedicosIndicados;
	}

	@Override
	public void setExamesMedicosIndicados(List<ExamesMedicosIndicadosEntity> examesMedicosIndicados) {
		this.examesMedicosIndicados = examesMedicosIndicados;
	}
   
}
