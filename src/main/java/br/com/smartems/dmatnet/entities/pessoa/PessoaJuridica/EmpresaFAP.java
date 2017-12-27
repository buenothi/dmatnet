package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_empresaFAP")
public class EmpresaFAP implements Serializable, Cloneable {

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

	@Override
	public EmpresaFAP clone() throws CloneNotSupportedException {
		return (EmpresaFAP) super.clone();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpresaFAP ^ (idEmpresaFAP >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaFAP other = (EmpresaFAP) obj;
		if (idEmpresaFAP != other.idEmpresaFAP)
			return false;
		return true;
	}
}
