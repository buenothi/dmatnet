package br.com.smartems.dmatnet.ManagedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.smartems.dmatnet.EJB.Facade.UsuarioFacadeLocal;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@ManagedBean
@RequestScoped
public class CadastroUsuarioMB {

	@EJB
	private UsuarioFacadeLocal usuarioFachada;
	
	private UsuarioEntity usuario;

	public UsuarioEntity getUsuario() {
		if(usuario == null){
			this.usuario = new UsuarioEntity();
		}
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
	public String textoGenero (int genero){
		String textoGenero = "masculino";	
		if(genero == 2) {
			textoGenero = "feminino";
		}
		return textoGenero;				
	}
	
}
