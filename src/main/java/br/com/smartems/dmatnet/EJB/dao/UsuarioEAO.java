package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuarios.UsuarioEntity;

@Stateless
public class UsuarioEAO extends AbstractEAO<UsuarioEntity, Long> implements UsuarioEAOLocal {
       
    public UsuarioEAO() {
        super();
        // TODO Auto-generated constructor stub
    }

}
