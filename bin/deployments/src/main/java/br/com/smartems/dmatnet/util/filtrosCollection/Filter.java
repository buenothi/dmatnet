package br.com.smartems.dmatnet.util.filtrosCollection;

public interface Filter<T> {

	public boolean match (T objeto, String criterio);
}
