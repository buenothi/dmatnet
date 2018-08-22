package br.com.smartems.dmatnet.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@FacesConverter("telefoneTipoConverter")
public class TelefoneTipoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				return (TelefoneTipoEntity) uic.getAttributes().get(value);
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid TelefoneTipo."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uic, Object obj) {
		if (obj instanceof TelefoneTipoEntity) {
			TelefoneTipoEntity telefoneTipo = (TelefoneTipoEntity) obj;
			if (telefoneTipo != null && telefoneTipo instanceof TelefoneTipoEntity
					&& telefoneTipo.getTipo() != null) {
				uic.getAttributes().put(telefoneTipo.getTipo(), telefoneTipo);
				return telefoneTipo.getTipo().toString();
			}
		}
		return null;
	}

}
