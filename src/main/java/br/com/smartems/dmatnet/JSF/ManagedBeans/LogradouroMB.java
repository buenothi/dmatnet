package br.com.smartems.dmatnet.JSF.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.Service.LogradourosServiceLocal;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Named
@ViewScoped
public class LogradouroMB implements Serializable {
	
	@EJB
	private LogradourosServiceLocal logradouroFachada;
	
	private List<EnderecoTipoEntity> logradouros;
 
	private static final long serialVersionUID = 1L;

	public List<EnderecoTipoEntity> getLogradouros() {
		if (this.logradouros == null){
			this.logradouros = new ArrayList<EnderecoTipoEntity>();
		}
		return logradouros;
	}

	public void setLogradouros(List<EnderecoTipoEntity> logradouros) {
		this.logradouros = logradouros;
	}
	
	@PostConstruct
	public void initLogradouroMB() {
		try {
			try {
				this.logradouros = logradouroFachada.findAll();
			} catch (NoResultException nre) {
				nre.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
