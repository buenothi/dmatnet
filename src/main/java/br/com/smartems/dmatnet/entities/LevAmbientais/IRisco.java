package br.com.smartems.dmatnet.entities.LevAmbientais;

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
}
