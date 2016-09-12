package br.com.smartems.dmatnet.util;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class StringsUtilitarios {

	public String formatarTextoParaLeitura(String texto) {
		String textoFormatado = texto.toLowerCase().substring(0, 1).toUpperCase().concat(texto.substring(1));
		return textoFormatado;
	}

	public String formatarTextoParaGravacao(String texto) {
		return null;
	}
}
