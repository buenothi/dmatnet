package br.com.smartems.dmatnet.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;

@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				return (CidadeEntity) uic.getAttributes().get(value);
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid CidadeEntity."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		if (obj instanceof CidadeEntity) {
			CidadeEntity cidade = (CidadeEntity) obj;
			if (cidade != null && cidade instanceof CidadeEntity && cidade.getCidadeNome() != null) {
				uic.getAttributes().put(cidade.getCidadeNome(), cidade);
				return cidade.getCidadeNome().toString();
			}
		}
		return null;
	}

}
