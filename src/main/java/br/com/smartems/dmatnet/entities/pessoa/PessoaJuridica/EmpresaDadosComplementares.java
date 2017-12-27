package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_empresaDadosComplementares")
public class EmpresaDadosComplementares implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpresaDadosComplementares;
	private int codSitucaoPJ;
	private int codSituacaoPF;
	private boolean possuiRPPS;
	private String ufEnteFederativo;
	private Long codMunicipioIBGE;
	private int tipoPublicoAlvo;
	private String descSegDif;
	private double percAliquotaSeguradoRPPS;
	private double percAliquotaEnteFederativoRPPS;
	private double percAliquotaSuplementar;

	@OneToMany
	@JoinColumn(name = "dadosComplamentares_ID")
	private List<EmpresaInfoComplementarLimiteRemSubteto> infoLimiteRemSubtetos;

	private static final long serialVersionUID = 1L;

	public EmpresaDadosComplementares() {
		super();
	}

	public long getIdEmpresaDadosComplementares() {
		return idEmpresaDadosComplementares;
	}

	public void setIdEmpresaDadosComplementares(long idEmpresaDadosComplementares) {
		this.idEmpresaDadosComplementares = idEmpresaDadosComplementares;
	}

	public int getCodSitucaoPJ() {
		return codSitucaoPJ;
	}

	public void setCodSitucaoPJ(int codSitucaoPJ) {
		this.codSitucaoPJ = codSitucaoPJ;
	}

	public int getCodSituacaoPF() {
		return codSituacaoPF;
	}

	public void setCodSituacaoPF(int codSituacaoPF) {
		this.codSituacaoPF = codSituacaoPF;
	}

	public boolean isPossuiRPPS() {
		return possuiRPPS;
	}

	public void setPossuiRPPS(boolean possuiRPPS) {
		this.possuiRPPS = possuiRPPS;
	}

	public String getUfEnteFederativo() {
		return ufEnteFederativo;
	}

	public void setUfEnteFederativo(String ufEnteFederativo) {
		this.ufEnteFederativo = ufEnteFederativo;
	}

	public Long getCodMunicipioIBGE() {
		return codMunicipioIBGE;
	}

	public void setCodMunicipioIBGE(Long codMunicipioIBGE) {
		this.codMunicipioIBGE = codMunicipioIBGE;
	}

	public int getTipoPublicoAlvo() {
		return tipoPublicoAlvo;
	}

	public void setTipoPublicoAlvo(int tipoPublicoAlvo) {
		this.tipoPublicoAlvo = tipoPublicoAlvo;
	}

	public String getDescSegDif() {
		return descSegDif;
	}

	public void setDescSegDif(String descSegDif) {
		this.descSegDif = descSegDif.toUpperCase();
	}

	public double getPercAliquotaSeguradoRPPS() {
		return percAliquotaSeguradoRPPS;
	}

	public void setPercAliquotaSeguradoRPPS(double percAliquotaSeguradoRPPS) {
		this.percAliquotaSeguradoRPPS = percAliquotaSeguradoRPPS;
	}

	public double getPercAliquotaEnteFederativoRPPS() {
		return percAliquotaEnteFederativoRPPS;
	}

	public void setPercAliquotaEnteFederativoRPPS(double percAliquotaEnteFederativoRPPS) {
		this.percAliquotaEnteFederativoRPPS = percAliquotaEnteFederativoRPPS;
	}

	public double getPercAliquotaSuplementar() {
		return percAliquotaSuplementar;
	}

	public void setPercAliquotaSuplementar(double percAliquotaSuplementar) {
		this.percAliquotaSuplementar = percAliquotaSuplementar;
	}

	public List<EmpresaInfoComplementarLimiteRemSubteto> getInfoLimiteRemSubtetos() {
		return infoLimiteRemSubtetos;
	}

	public void setInfoLimiteRemSubtetos(List<EmpresaInfoComplementarLimiteRemSubteto> infoLimiteRemSubtetos) {
		this.infoLimiteRemSubtetos = infoLimiteRemSubtetos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpresaDadosComplementares ^ (idEmpresaDadosComplementares >>> 32));
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
		EmpresaDadosComplementares other = (EmpresaDadosComplementares) obj;
		if (idEmpresaDadosComplementares != other.idEmpresaDadosComplementares)
			return false;
		return true;
	}

}
