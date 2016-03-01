package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_empresaFAP")
public class EmpresaFAP implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEmpresaFAP;
	private double valorFAP;
	private int tipoProcessoFAP;
	private long numProcessoFAP;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private EmpresaCadastroEntity empresaCadastro;
	
	private static final long serialVersionUID = 1L;
	
	public EmpresaFAP() {
		super();
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
	public long getNumProcessoFAP() {
		return numProcessoFAP;
	}
	public void setNumProcessoFAP(long numProcessoFAP) {
		this.numProcessoFAP = numProcessoFAP;
	}
	
}
