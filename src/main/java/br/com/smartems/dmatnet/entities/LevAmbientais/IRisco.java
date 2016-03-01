package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.util.List;

public interface IRisco {

	long getId();
	void setId(long id);
	
	String getNome();
	void setNome(String nome);
	
	long getCodFatorRisco_tab21();
	void setCodFatorRisco_tab21(long codTab21);
	
	long getCodFatorRisco_tab22();
	void setCodFatorRisco_tab22(long codTab22);
	
	long getCodFatorRisco_tab23();
	void setCodFatorRisco_tab23(long codTab23);
	
	String getDadosComprometimentoSaude();
	void setDadosComprometimentoSaude(String dadosComprometimentoSaude);
	
	List<ExameMedicoEntity> getExamesMedicos();
	void setExamesMedicos(List<ExameMedicoEntity> examesMedicos);
	
	List<MetodologiaAvaliacaoEntity> getMetodologiasAvaliacao();
	void setMetodologiasAvaliacao(List<MetodologiaAvaliacaoEntity> metodologiasAvaliacao);
	
	List<PossiveisDanosSaudeEntity> getPossiveisDanosSaude();
	void setPossiveisDanosSaude(List<PossiveisDanosSaudeEntity> possiveisDanosSaude);
	
	List<EPIEntity> getListaEpis();
	void setListaEpis(List<EPIEntity> listaEpis);
	
	List<EPCEntity> getListaEpcs();
	void setListaEpcs(List<EPCEntity> listaEpcs);
	
	List<MedidasAdministrativasEntity> getMedidasAdministrativas();
	void setMedidasAdministrativas(List<MedidasAdministrativasEntity> medidasAdministrativas);
}
