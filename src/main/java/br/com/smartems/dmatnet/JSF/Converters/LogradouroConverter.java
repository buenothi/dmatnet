package br.com.smartems.dmatnet.JSF.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@FacesConverter("logradouroConverter")
public class LogradouroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				return (EnderecoTipoEntity) uic.getAttributes().get(value);
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid EndereçoTipoEntity."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uic, Object obj) {
		if (obj instanceof EnderecoTipoEntity) {
			EnderecoTipoEntity logradouro = (EnderecoTipoEntity) obj;
			if (logradouro != null && logradouro instanceof EnderecoTipoEntity
					&& logradouro.getNomeLogradouro() != null) {
				uic.getAttributes().put(logradouro.getNomeLogradouro(), logradouro);
				return logradouro.getNomeLogradouro().toString();
			}
		}
		return null;
	}

}
