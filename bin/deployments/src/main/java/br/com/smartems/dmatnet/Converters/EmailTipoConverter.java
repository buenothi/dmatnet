package br.com.smartems.dmatnet.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@FacesConverter("emailTipoConverter")
public class EmailTipoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				return (EmailTipoEntity) uic.getAttributes().get(value);
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid EmailTipo."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uic, Object obj) {
		if (obj instanceof EmailTipoEntity) {
			EmailTipoEntity emailTipo = (EmailTipoEntity) obj;
			if (emailTipo != null && emailTipo instanceof EmailTipoEntity
					&& emailTipo.getTipo() != null) {
				uic.getAttributes().put(emailTipo.getTipo(), emailTipo);
				return emailTipo.getTipo().toString();
			}
		}
		return null;
	}

}
