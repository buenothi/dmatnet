package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_empresaFAP")
public class EmpresaFAP implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpresaFAP;
	private double valorFAP;
	private int tipoProcessoFAP;
	private Long numProcessoFAP;

	private static final long serialVersionUID = 1L;

	public EmpresaFAP() {
		super();
	}

	public long getIdEmpresaFAP() {
		return idEmpresaFAP;
	}

	public void setIdEmpresaFAP(long idEmpresaFAP) {
		this.idEmpresaFAP = idEmpresaFAP;
	}

	public double getValorFAP() {
		return valorFAP;
	}

	public void setValorFAP(double valorFAP) {
		this.valorFAP = valorFAP;
	}

	public int getTipoProcessoFAP() {
		return tipoProcessoFAP;
	}

	public void setTipoProcessoFAP(int tipoProcessoFAP) {
		this.tipoProcessoFAP = tipoProcessoFAP;
	}

	public Long getNumProcessoFAP() {
		return numProcessoFAP;
	}

	public void setNumProcessoFAP(Long numProcessoFAP) {
		this.numProcessoFAP = numProcessoFAP;
	}

}
