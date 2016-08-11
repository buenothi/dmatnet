package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_GHE")
public class GHEEntity implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idGHE;
	private String nomeGHE;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioGHE;
	
	@Temporal(TemporalType.DATE)
	private Date dataTerminoGHE;
	
	private String descricaoGHE;
	
	@Basic(fetch=FetchType.LAZY)
	private byte[] fotoParadigma;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="ghe_ID")
	private List<LevantamentoAmbientalEntity> levAmbientais;
	
	private static final long serialVersionUID = 1L;

	public GHEEntity() {
		super();
	}   
	
	public long getIdGHE() {
		return this.idGHE;
	}
	public void setIdGHE(long idGHE) {
		this.idGHE = idGHE;
	}   
	
	public String getNomeGHE() {
		return this.nomeGHE;
	}
	public void setNomeGHE(String nomeGHE) {
		this.nomeGHE = nomeGHE.toUpperCase();
	}   
	
	public Date getDataInicioGHE() {
		return this.dataInicioGHE;
	}
	public void setDataInicioGHE(Date dataInicioGHE) {
		this.dataInicioGHE = dataInicioGHE;
	}   
	
	public Date getDataTerminoGHE() {
		return this.dataTerminoGHE;
	}
	public void setDataTerminoGHE(Date dataTerminoGHE) {
		this.dataTerminoGHE = dataTerminoGHE;
	}
	
	public String getDescricaoGHE() {
		return this.descricaoGHE;
	}
	public void setDescricaoGHE(String descricaoGHE) {
		this.descricaoGHE = descricaoGHE.toUpperCase();
	}
	
	public byte[] getFotoParadigma() {
		return fotoParadigma;
	}
	public void setFotoParadigma(byte[] fotoParadigma) {
		this.fotoParadigma = fotoParadigma;
	}
	
	public List<LevantamentoAmbientalEntity> getLevAmbientais() {
		return levAmbientais;
	}
	public void setLevAmbientais(List<LevantamentoAmbientalEntity> levAmbientais) {
		this.levAmbientais = levAmbientais;
	}

	@Override
	public String toString() {
		return nomeGHE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicioGHE == null) ? 0 : dataInicioGHE.hashCode());
		result = prime * result + ((dataTerminoGHE == null) ? 0 : dataTerminoGHE.hashCode());
		result = prime * result + ((descricaoGHE == null) ? 0 : descricaoGHE.hashCode());
		result = prime * result + Arrays.hashCode(fotoParadigma);
		result = prime * result + (int) (idGHE ^ (idGHE >>> 32));
		result = prime * result + ((levAmbientais == null) ? 0 : levAmbientais.hashCode());
		result = prime * result + ((nomeGHE == null) ? 0 : nomeGHE.hashCode());
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
		GHEEntity other = (GHEEntity) obj;
		if (dataInicioGHE == null) {
			if (other.dataInicioGHE != null)
				return false;
		} else if (!dataInicioGHE.equals(other.dataInicioGHE))
			return false;
		if (dataTerminoGHE == null) {
			if (other.dataTerminoGHE != null)
				return false;
		} else if (!dataTerminoGHE.equals(other.dataTerminoGHE))
			return false;
		if (descricaoGHE == null) {
			if (other.descricaoGHE != null)
				return false;
		} else if (!descricaoGHE.equals(other.descricaoGHE))
			return false;
		if (!Arrays.equals(fotoParadigma, other.fotoParadigma))
			return false;
		if (idGHE != other.idGHE)
			return false;
		if (levAmbientais == null) {
			if (other.levAmbientais != null)
				return false;
		} else if (!levAmbientais.equals(other.levAmbientais))
			return false;
		if (nomeGHE == null) {
			if (other.nomeGHE != null)
				return false;
		} else if (!nomeGHE.equals(other.nomeGHE))
			return false;
		return true;
	}
	
}
