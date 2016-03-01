package br.com.smartems.dmatnet.entities.LevAmbientais;

public interface IMedidasControle {

	long getId();
	void setId(long idMedida);
	
	String getNome();
	void setNome(String nome);
	
	String getDescricao();
	void setDescricao(String descricao);
	
}
