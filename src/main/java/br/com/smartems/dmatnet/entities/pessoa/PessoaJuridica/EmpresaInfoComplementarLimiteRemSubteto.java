package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_empresaInfoComplementarRemSuteto")
public class EmpresaInfoComplementarLimiteRemSubteto implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
}
