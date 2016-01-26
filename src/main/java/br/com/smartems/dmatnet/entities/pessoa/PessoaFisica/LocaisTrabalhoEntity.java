package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_locaisTrabalho")
public class LocaisTrabalhoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int tpInscricao; //informar código conforme tabela 5 do eSocial
	private long numerInscricao;
	private String descricaoComplementar;
	
	private static final long serialVersionUID = 1L;

	
	public LocaisTrabalhoEntity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTpInscricao() {
		return tpInscricao;
	}

	public void setTpInscricao(int tpInscricao) {
		this.tpInscricao = tpInscricao;
	}

	public long getNumerInscricao() {
		return numerInscricao;
	}

	public void setNumerInscricao(long numerInscricao) {
		this.numerInscricao = numerInscricao;
	}

	public String getDescricaoComplementar() {
		return descricaoComplementar;
	}

	public void setDescricaoComplementar(String descricaoComplementar) {
		this.descricaoComplementar = descricaoComplementar;
	}
	
}
