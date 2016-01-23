package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tbl_trabalhadorAfastamentos")
public class TrabalhadorAfastamentoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAfastamento;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	private int codMotivoAfastamento;//informar código da tabela 18 do eSocial
	
	private static final long serialVersionUID = 1L;

	
	public TrabalhadorAfastamentoEntity() {
		super();
	}

	public long getIdAfastamento() {
		return idAfastamento;
	}

	public void setIdAfastamento(long idAfastamento) {
		this.idAfastamento = idAfastamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public int getCodMotivoAfastamento() {
		return codMotivoAfastamento;
	}

	public void setCodMotivoAfastamento(int codMotivoAfastamento) {
		this.codMotivoAfastamento = codMotivoAfastamento;
	}
	
}
