package br.com.smartems.dmatnet.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@FacesConverter("empresaConverter")
public class EmpresaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length() > 0){
			try {
				return (EmpresaEntity) component.getAttributes().get(value);
			} catch(Exception e) {
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Conversion Error.");
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof EmpresaEntity) {
			EmpresaEntity empresa = (EmpresaEntity) value;
			if(empresa != null && empresa instanceof EmpresaEntity && empresa.getNome() != null) {
				component.getAttributes().put(empresa.getNome(), empresa);
				return empresa.getNome().toString();
			}
		}
		return null;
	}

}
