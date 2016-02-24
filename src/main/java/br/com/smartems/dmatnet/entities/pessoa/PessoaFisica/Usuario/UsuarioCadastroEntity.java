package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaCadastro;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_UsuarioCadastro")
public class UsuarioCadastroEntity extends AbstractPessoaFisicaCadastro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public UsuarioCadastroEntity() {
		super();
	}
   
}
