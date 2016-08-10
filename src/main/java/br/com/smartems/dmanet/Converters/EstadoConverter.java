package br.com.smartems.dmanet.Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@FacesConverter("estadoConventer")
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
