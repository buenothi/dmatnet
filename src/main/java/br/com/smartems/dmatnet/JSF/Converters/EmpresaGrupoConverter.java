package br.com.smartems.dmatnet.JSF.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@FacesConverter("empresaGrupoConverter")
public class EmpresaGrupoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length() > 0){
			try {
				return (EmpresaGrupoEntity) component.getAttributes().get(value);
			} catch(Exception e) {
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Conversion Error.");
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof EmpresaGrupoEntity) {
			EmpresaGrupoEntity empresaGrupo = (EmpresaGrupoEntity) value;
			if(empresaGrupo != null && empresaGrupo instanceof EmpresaGrupoEntity && empresaGrupo.getNomeGrupo() != null) {
				component.getAttributes().put(empresaGrupo.getNomeGrupo(), empresaGrupo);
				return empresaGrupo.getNomeGrupo().toString();
			}
		}
		return null;
	}

}
