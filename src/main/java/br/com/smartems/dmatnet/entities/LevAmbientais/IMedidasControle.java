package br.com.smartems.dmatnet.entities.LevAmbientais;

public interface IMedidasControle {
	
	void setIdMedida(long id);
	long getIdMedida();
	
	void setNome(String nome);
	String getNome();
	
	void setDescricao(String descricao);
	String getDescricao();
	
}
