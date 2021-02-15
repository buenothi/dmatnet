package br.com.smartems.dmatnet.JSF.Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.util.StringsUtilitarios;

@FacesConverter("stringConverter")
public class StringConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		StringsUtilitarios stringUtil = new StringsUtilitarios();
		return stringUtil.formatarTextoParaLeitura(value.toString());
	}

}
