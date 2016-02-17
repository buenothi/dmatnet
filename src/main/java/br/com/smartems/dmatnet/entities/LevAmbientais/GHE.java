package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_GHE")
public class GHE implements Serializable {
	   
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
	
	@OneToMany
	@JoinColumn(name="ghe_ID")
	private List<LevantamentoAmbientalEntity> levAmbientais;
	
	private static final long serialVersionUID = 1L;

	public GHE() {
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
		this.nomeGHE = nomeGHE;
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
		this.descricaoGHE = descricaoGHE;
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
	   
}
