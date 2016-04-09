package br.com.smartems.dmatnet.entities.LevAmbientais;

import br.com.smartems.dmatnet.entities.LevAmbientais.AbstractRiscoEntity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_RiscoAmbiental")
@Inheritance(strategy=InheritanceType.JOINED)
public class RiscoAmbientalEntity extends AbstractRiscoEntity implements Serializable {

	private int limiteTolerancia_NR15;
	private int limiteTolerancia_AE;
	private String tipoClassificacao;
	private boolean isAgenteInsalubre;
	private boolean isAgenteAposentadoria;
	
	private static final long serialVersionUID = 1L;

	public RiscoAmbientalEntity() {
		super();
	}

	public int getLimiteTolerancia_NR15() {
		return limiteTolerancia_NR15;
	}

	public void setLimiteTolerancia_NR15(int limiteTolerancia_NR15) {
		this.limiteTolerancia_NR15 = limiteTolerancia_NR15;
	}

	public int getLimiteTolerancia_AE() {
		return limiteTolerancia_AE;
	}

	public void setLimiteTolerancia_AE(int limiteTolerancia_AE) {
		this.limiteTolerancia_AE = limiteTolerancia_AE;
	}

	public String getTipoClassificacao() {
		return tipoClassificacao;
	}

	public void setTipoClassificacao(String tipoClassificacao) {
		this.tipoClassificacao = tipoClassificacao.toUpperCase();
	}

	public boolean isAgenteInsalubre() {
		return isAgenteInsalubre;
	}

	public void setAgenteInsalubre(boolean isAgenteInsalubre) {
		this.isAgenteInsalubre = isAgenteInsalubre;
	}

	public boolean isAgenteAposentadoria() {
		return isAgenteAposentadoria;
	}

	public void setAgenteAposentadoria(boolean isAgenteAposentadoria) {
		this.isAgenteAposentadoria = isAgenteAposentadoria;
	}
	
}
