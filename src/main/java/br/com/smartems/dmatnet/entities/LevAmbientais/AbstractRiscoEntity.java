package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Riscos")
public abstract class AbstractRiscoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private Long codFatorRisco_tab21;
	private Long codFatorRisco_tab22;
	private Long codFatorRisco_tab23;
	private String dadosComprometimentoSaude;
	
	@OneToMany
	@JoinColumn(name="risco_ID")
	private List<ExameMedicoEntity> examesMedicos;
	
	@OneToMany
	@JoinColumn(name="risco_ID")
	private List<MetodologiaAvaliacaoEntity> metodologiasAvaliacao;
	
	@OneToMany
	@JoinColumn(name="risco_ID")
	private List<PossiveisDanosSaudeEntity> possiveisDanosSaude;
	
	@OneToMany
	@JoinColumn(name="risco_ID")
	private List<EPIEntity> listaEpis;
	
	@OneToMany
	@JoinColumn(name="risco_ID")
	private List<EPCEntity> listaEpcs;
	
	@OneToMany
	@JoinColumn(name="risco_ID")
	private List<MedidasAdministrativasEntity> medidasAdministrativas;
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodFatorRisco_tab21() {
		return codFatorRisco_tab21;
	}

	public void setCodFatorRisco_tab21(Long codFatorRisco_tab21) {
		this.codFatorRisco_tab21 = codFatorRisco_tab21;
	}

	public Long getCodFatorRisco_tab22() {
		return codFatorRisco_tab22;
	}

	public void setCodFatorRisco_tab22(Long codFatorRisco_tab22) {
		this.codFatorRisco_tab22 = codFatorRisco_tab22;
	}

	public Long getCodFatorRisco_tab23() {
		return codFatorRisco_tab23;
	}

	public void setCodFatorRisco_tab23(Long codFatorRisco_tab23) {
		this.codFatorRisco_tab23 = codFatorRisco_tab23;
	}

	public String getDadosComprometimentoSaude() {
		return dadosComprometimentoSaude;
	}

	public void setDadosComprometimentoSaude(String dadosComprometimentoSaude) {
		this.dadosComprometimentoSaude = dadosComprometimentoSaude.toUpperCase();
	}

	public List<ExameMedicoEntity> getExamesMedicos() {
		return examesMedicos;
	}

	public void setExamesMedicos(List<ExameMedicoEntity> examesMedicos) {
		this.examesMedicos = examesMedicos;
	}

	public List<MetodologiaAvaliacaoEntity> getMetodologiasAvaliacao() {
		return metodologiasAvaliacao;
	}

	public void setMetodologiasAvaliacao(List<MetodologiaAvaliacaoEntity> metodologiasAvaliacao) {
		this.metodologiasAvaliacao = metodologiasAvaliacao;
	}

	public List<PossiveisDanosSaudeEntity> getPossiveisDanosSaude() {
		return possiveisDanosSaude;
	}

	public void setPossiveisDanosSaude(List<PossiveisDanosSaudeEntity> possiveisDanosSaude) {
		this.possiveisDanosSaude = possiveisDanosSaude;
	}

	public List<EPIEntity> getListaEpis() {
		return listaEpis;
	}

	public void setListaEpis(List<EPIEntity> listaEpis) {
		this.listaEpis = listaEpis;
	}

	public List<EPCEntity> getListaEpcs() {
		return listaEpcs;
	}

	public void setListaEpcs(List<EPCEntity> listaEpcs) {
		this.listaEpcs = listaEpcs;
	}

	public List<MedidasAdministrativasEntity> getMedidasAdministrativas() {
		return medidasAdministrativas;
	}

	public void setMedidasAdministrativas(List<MedidasAdministrativasEntity> medidasAdministrativas) {
		this.medidasAdministrativas = medidasAdministrativas;
	}
	
}
