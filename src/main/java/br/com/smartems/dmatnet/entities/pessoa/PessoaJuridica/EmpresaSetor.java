package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorCadastroEntity;

@Entity
@Table(name="tbl_EmpresaSetores")
public class EmpresaSetor implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSetores;
	private String setorNome;
	
	@OneToMany(mappedBy="setor")
	private List<TrabalhadorCadastroEntity> trabalhadores;
	
	private static final long serialVersionUID = 1L;

	public EmpresaSetor() {
		super();
	}   
	public long getIdSetores() {
		return this.idSetores;
	}

	public void setIdSetores(long idSetores) {
		this.idSetores = idSetores;
	}   
	public String getSetorNome() {
		return this.setorNome;
	}

	public void setSetorNome(String setorNome) {
		this.setorNome = setorNome;
	}
	public List<TrabalhadorCadastroEntity> getTrabalhadores() {
		return trabalhadores;
	}
	public void setTrabalhadores(List<TrabalhadorCadastroEntity> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}
   
}
