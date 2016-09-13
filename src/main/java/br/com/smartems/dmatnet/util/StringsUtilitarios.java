package br.com.smartems.dmatnet.util;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class StringsUtilitarios {

	public String formatarTextoParaLeitura(String value) {
		String stringFormatada = new String();
		if (value != null) {
			String stringRecebida = value.toString();
			String[] stringArray = stringRecebida.split(" ");
			for (int i = 0; i < stringArray.length; i++) {
				int tamanho = stringArray[i].length();
				String out = "";
				String espaco = " ";
				out += stringArray[i].substring(0, 1).toUpperCase();
				out += stringArray[i].substring(1, tamanho).toLowerCase();
				if (i < stringArray.length) {
					stringFormatada += out.concat(espaco);
				} else {
					stringFormatada += out;
				}
			}
		}
		return stringFormatada;
	}

	public String formatarTextoParaGravacao(String texto) {
		return null;
	}
}
