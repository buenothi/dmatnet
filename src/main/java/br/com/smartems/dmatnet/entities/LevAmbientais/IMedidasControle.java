package br.com.smartems.dmatnet.entities.LevAmbientais;

public interface IMedidasControle {

	long getIdMedida();
	void setIdMedida(long idMedida);
	
	String getNome();
	void setNome(String nome);
	
	String getDescricao();
	void setDescricao(String descricao);
	
}
