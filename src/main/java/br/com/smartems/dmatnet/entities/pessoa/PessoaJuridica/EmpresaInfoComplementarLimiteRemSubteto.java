package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tbl_empresaInfoComplementarRemSuteto")
public class EmpresaInfoComplementarLimiteRemSubteto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpresaLimiteRemSubteto;
	private int codSubteto;
	private double valorSubtete;
	private int idadeMaioridade;

	@OneToOne
	@PrimaryKeyJoinColumn
	private EmpresaInfoComplementarLimiteRemSubteto infoComplementares;

	private static final long serialVersionUID = 1L;

	public EmpresaInfoComplementarLimiteRemSubteto() {
		super();
	}

	public long getIdEmpresaLimiteRemSubteto() {
		return idEmpresaLimiteRemSubteto;
	}

	public void setIdEmpresaLimiteRemSubteto(long idEmpresaLimiteRemSubteto) {
		this.idEmpresaLimiteRemSubteto = idEmpresaLimiteRemSubteto;
	}

	public int getCodSubteto() {
		return codSubteto;
	}

	public void setCodSubteto(int codSubteto) {
		this.codSubteto = codSubteto;
	}

	public double getValorSubtete() {
		return valorSubtete;
	}

	public void setValorSubtete(double valorSubtete) {
		this.valorSubtete = valorSubtete;
	}

	public int getIdadeMaioridade() {
		return idadeMaioridade;
	}

	public void setIdadeMaioridade(int idadeMaioridade) {
		this.idadeMaioridade = idadeMaioridade;
	}

	public EmpresaInfoComplementarLimiteRemSubteto getInfoComplementares() {
		return infoComplementares;
	}

	public void setInfoComplementares(EmpresaInfoComplementarLimiteRemSubteto infoComplementares) {
		this.infoComplementares = infoComplementares;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpresaLimiteRemSubteto ^ (idEmpresaLimiteRemSubteto >>> 32));
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
		EmpresaInfoComplementarLimiteRemSubteto other = (EmpresaInfoComplementarLimiteRemSubteto) obj;
		if (idEmpresaLimiteRemSubteto != other.idEmpresaLimiteRemSubteto)
			return false;
		return true;
	}

}
