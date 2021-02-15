package br.com.smartems.dmatnet.JSF.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
                return (EstadoEntity) uic.getAttributes().get(value);
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid EstadoEntity."));
            }
        } else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		if (obj instanceof EstadoEntity) {
			EstadoEntity estado = (EstadoEntity) obj;
			if (estado != null && estado instanceof EstadoEntity && estado.getEstadoSigla() != null) {
				uic.getAttributes().put(estado.getEstadoSigla(), estado);
				return estado.getEstadoSigla().toString();
			}
		}
		return null;
	}

}
