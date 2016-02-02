package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tbl_trabalhadorEstrangeiro")
public class TrabalhadorEstrangeiroEntity implements Serializable {

	@Id
	private long idTrabalhador;
	
	@Temporal(TemporalType.DATE)
	private Date dataChegada;
	private int codClassTrabEstrangeiro;
	private boolean casadoBR;
	private boolean filhosBR;
	@OneToOne
	@PrimaryKeyJoinColumn
	private TrabalhadorCadastroEntity trabalhador;
	
	private static final long serialVersionUID = 1L;

	
	public TrabalhadorEstrangeiroEntity() {
		super();
	}

	public long getIdTrabalhador() {
		return idTrabalhador;
	}

	public void setIdTrabalhador(long idTrabalhador) {
		this.idTrabalhador = idTrabalhador;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public int getCodClassTrabEstrangeiro() {
		return codClassTrabEstrangeiro;
	}

	public void setCodClassTrabEstrangeiro(int codClassTrabEstrangeiro) {
		this.codClassTrabEstrangeiro = codClassTrabEstrangeiro;
	}

	public boolean isCasadoBR() {
		return casadoBR;
	}

	public void setCasadoBR(boolean casadoBR) {
		this.casadoBR = casadoBR;
	}

	public boolean isFilhosBR() {
		return filhosBR;
	}

	public void setFilhosBR(boolean filhosBR) {
		this.filhosBR = filhosBR;
	}

	public TrabalhadorCadastroEntity getTrabalhador() {
		return trabalhador;
	}

	public void setTrabalhador(TrabalhadorCadastroEntity trabalhador) {
		this.trabalhador = trabalhador;
	}
	
}
