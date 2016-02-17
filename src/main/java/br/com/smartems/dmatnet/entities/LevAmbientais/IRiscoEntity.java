package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.util.List;

public interface IRiscoEntity {

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
	
	List<MetodologiaAvaliacaoEntity> getMetodologiasAvaliacao();
	void setMetodologiasAvaliacao(List<MetodologiaAvaliacaoEntity> metodologias);
	
	List<PossiveisDanosEntity> getPossiveisDanos();
	void setPossiveisDanos(List<PossiveisDanosEntity> possiveisDanos);
	
	List<EpiEntity> getEpis();
	void setEpis(List<EpiEntity> epis);
	
	List<EpcEntity> getEpcs();
	void setEpcs(List<EpcEntity> epcs);
	
	List<MedidaAdministrativaEntity> getMedidasAdministrativas();
	void setMedidasAdministrativas(List<MedidaAdministrativaEntity> medidasAdministrativas);
	
	List<ExamesMedicosIndicadosEntity> getExamesMedicosIndicados();
	void setExamesMedicosIndicados(List<ExamesMedicosIndicadosEntity> examesMedicosIndicados);
	
}
