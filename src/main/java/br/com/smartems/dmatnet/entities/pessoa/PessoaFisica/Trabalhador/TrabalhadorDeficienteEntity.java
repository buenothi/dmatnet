package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_trabalhadorDeficiente")
public class TrabalhadorDeficienteEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPessoa;
	private boolean defFisica;
	private boolean defVisual;
	private boolean defAuditiva;
	private boolean defMental;
	private boolean defIntelectual;
	private boolean reabilitadoReadaptado;
	private String observacao;
	
	@OneToOne(cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private TrabalhadorCadastroEntity trabalhador;
	
	private static final long serialVersionUID = 1L;

	
	public TrabalhadorDeficienteEntity() {
		super();
	}

	public long getIdTrabalhador() {
		return idPessoa;
	}

	public void setIdTrabalhador(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean isDefFisica() {
		return defFisica;
	}

	public void setDefFisica(boolean defFisica) {
		this.defFisica = defFisica;
	}

	public boolean isDefVisual() {
		return defVisual;
	}

	public void setDefVisual(boolean defVisual) {
		this.defVisual = defVisual;
	}

	public boolean isDefAuditiva() {
		return defAuditiva;
	}

	public void setDefAuditiva(boolean defAuditiva) {
		this.defAuditiva = defAuditiva;
	}

	public boolean isDefMental() {
		return defMental;
	}

	public void setDefMental(boolean defMental) {
		this.defMental = defMental;
	}

	public boolean isDefIntelectual() {
		return defIntelectual;
	}

	public void setDefIntelectual(boolean defIntelectual) {
		this.defIntelectual = defIntelectual;
	}

	public boolean isReabilitadoReadaptado() {
		return reabilitadoReadaptado;
	}

	public void setReabilitadoReadaptado(boolean reabilitadoReadaptado) {
		this.reabilitadoReadaptado = reabilitadoReadaptado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TrabalhadorCadastroEntity getTrabalhador() {
		return trabalhador;
	}

	public void setTrabalhador(TrabalhadorCadastroEntity trabalhador) {
		this.trabalhador = trabalhador;
	}
	
}
