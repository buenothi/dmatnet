package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractRisco;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="tbl_RiscoAmbiental")
public class RiscoAmbientalEntity extends AbstractRisco implements Serializable {

	private int limiteTolerancia;
	private int limiteToleranciaAE;
	private String tipoClassificacao;
	private boolean isAgenteInsalubre;
	private boolean isAgenteAposentadoria;
	private static final long serialVersionUID = 1L;

	public RiscoAmbientalEntity() {
		super();
	}   
	public int getLimiteTolerancia() {
		return this.limiteTolerancia;
	}

	public void setLimiteTolerancia(int limiteTolerancia) {
		this.limiteTolerancia = limiteTolerancia;
	}   
	public int getLimiteToleranciaAE() {
		return this.limiteToleranciaAE;
	}

	public void setLimiteToleranciaAE(int limiteToleranciaAE) {
		this.limiteToleranciaAE = limiteToleranciaAE;
	}   
	public String getTipoClassificacao() {
		return this.tipoClassificacao;
	}

	public void setTipoClassificacao(String tipoClassificacao) {
		this.tipoClassificacao = tipoClassificacao;
	}   
	public boolean getIsAgenteInsalubre() {
		return this.isAgenteInsalubre;
	}

	public void setIsAgenteInsalubre(boolean isAgenteInsalubre) {
		this.isAgenteInsalubre = isAgenteInsalubre;
	}   
	public boolean getIsAgenteAposentadoria() {
		return this.isAgenteAposentadoria;
	}

	public void setIsAgenteAposentadoria(boolean isAgenteAposentadoria) {
		this.isAgenteAposentadoria = isAgenteAposentadoria;
	}
   
}
