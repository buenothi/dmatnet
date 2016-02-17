package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_CaEPI")
public class CaEPIEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numCA;
	private String nome;
	private String nomeFabricante;
	private String descricao;
	
	@Basic(fetch=FetchType.LAZY)
	private byte[] imagemCA;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioValidade;
	
	@Temporal(TemporalType.DATE)
	private Date dataFimValidade;
	
	@ManyToMany(mappedBy="listaCA")
	private List<EpiEntity> listaEPI;
	
	private static final long serialVersionUID = 1L;

	public CaEPIEntity() {
		super();
	}   
	public long getNumCA() {
		return this.numCA;
	}

	public void setNumCA(long numCA) {
		this.numCA = numCA;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public byte[] getImagemCA() {
		return imagemCA;
	}
	
	public void setImagemCA(byte[] imagemCA) {
		this.imagemCA = imagemCA;
	}
	
	public Date getDataInicioValidade() {
		return dataInicioValidade;
	}
	
	public void setDataInicioValidade(Date dataInicioValidade) {
		this.dataInicioValidade = dataInicioValidade;
	}
	
	public Date getDataFimValidade() {
		return dataFimValidade;
	}
	
	public void setDataFimValidade(Date dataFimValidade) {
		this.dataFimValidade = dataFimValidade;
	}
	
	public List<EpiEntity> getListaEPI() {
		return listaEPI;
	}
	
	public void setListaEPI(List<EpiEntity> listaEPI) {
		this.listaEPI = listaEPI;
	}
   
}
