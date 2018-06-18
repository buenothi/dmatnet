package br.com.smartems.dmatnet.Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.util.StringsUtilitarios;

@FacesConverter("stringMinusConverter")
public class StringMinusConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		StringsUtilitarios stringUtil = new StringsUtilitarios();
		return stringUtil.formatarTextoParaMinusculo(value.toString());
	}

}
