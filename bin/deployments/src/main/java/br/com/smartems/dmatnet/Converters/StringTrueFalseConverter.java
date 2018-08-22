package br.com.smartems.dmatnet.Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("stringTrueFalseConverter")
public class StringTrueFalseConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String retorno = new String();
		if (value.toString() == "true"){
			retorno = "Sim";
		} else {
			retorno = "Não";
		}
		return retorno;
	}

}
