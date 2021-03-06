package br.com.smartems.dmatnet.JSF.Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cnpjCpfConverter")
public class CNPJCPFConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uic, String value) {
		String numPessoaString = value;
		if (value != null && !value.equals(""))
			if (value.length() == 18) {
				numPessoaString = value.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("/", "");
			} else if (value.length() == 14) {
				numPessoaString = value.replaceAll("\\.", "").replaceAll("\\-", "");
			}
		return numPessoaString;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uic, Object value) {
		String numPessoaString = value.toString();
		if (numPessoaString != null && numPessoaString.length() == 14) {
			numPessoaString = numPessoaString.substring(0, 2) + "." + numPessoaString.substring(2, 5) + "."
					+ numPessoaString.substring(5, 8) + "/" + numPessoaString.substring(8, 12) + "-"
					+ numPessoaString.substring(12, 14);
		} else if (numPessoaString != null && numPessoaString.length() == 11) {
			numPessoaString = numPessoaString.substring(0, 3) + "." + numPessoaString.substring(3, 6) + "."
					+ numPessoaString.substring(6, 9) + "-" + numPessoaString.substring(9, 11);
		}
		return numPessoaString;
	}

}
