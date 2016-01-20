package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Embeddable
public class PessoaFisicaDocumentosEntity implements Serializable {
	
	//registro de identificação civil (para atendimento do eSocial)
	private long numRic; 
	private String ricOrgExpedidor;
	
	@Temporal(TemporalType.DATE)
	private Date ricDataExpedicao;
	
	private String numRG;
	private String rgOrgExpedidor;
	
	@Temporal(TemporalType.DATE)
	private Date rgDataExpedicao;
	
	private long numCPF;
	
	private long numRNE;
	private String rneOrgExpedidor;
	
	@Temporal(TemporalType.DATE)
	private Date rneDataExpedicao;
	
	private long numCNH;
	private String cnhUf;
	
	@Temporal(TemporalType.DATE)
	private Date cnhDataExpedicao;
	
	@Temporal(TemporalType.DATE)
	private Date cnhValidade;
	
	@Temporal(TemporalType.DATE)
	private Date cnhPrimeiraEmissao;
	
	private String cnhCategoria;
	
	private static final long serialVersionUID = 1L;

	
	public PessoaFisicaDocumentosEntity() {
		super();
	}

	public long getNumRic() {
		return numRic;
	}

	public void setNumRic(long numRic) {
		this.numRic = numRic;
	}

	public String getRicOrgExpedidor() {
		return ricOrgExpedidor;
	}

	public void setRicOrgExpedidor(String ricOrgExpedidor) {
		this.ricOrgExpedidor = ricOrgExpedidor;
	}

	public Date getRicDataExpedicao() {
		return ricDataExpedicao;
	}

	public void setRicDataExpedicao(Date ricDataExpedicao) {
		this.ricDataExpedicao = ricDataExpedicao;
	}

	public String getNumRG() {
		return numRG;
	}

	public void setNumRG(String numRG) {
		this.numRG = numRG;
	}

	public String getRgOrgExpedidor() {
		return rgOrgExpedidor;
	}

	public void setRgOrgExpedidor(String rgOrgExpedidor) {
		this.rgOrgExpedidor = rgOrgExpedidor;
	}

	public Date getRgDataExpedicao() {
		return rgDataExpedicao;
	}

	public void setRgDataExpedicao(Date rgDataExpedicao) {
		this.rgDataExpedicao = rgDataExpedicao;
	}

	public long getNumCPF() {
		return numCPF;
	}

	public void setNumCPF(long numCPF) {
		this.numCPF = numCPF;
	}

	public long getNumRNE() {
		return numRNE;
	}

	public void setNumRNE(long numRNE) {
		this.numRNE = numRNE;
	}

	public String getRneOrgExpedidor() {
		return rneOrgExpedidor;
	}

	public void setRneOrgExpedidor(String rneOrgExpedidor) {
		this.rneOrgExpedidor = rneOrgExpedidor;
	}

	public Date getRneDataExpedicao() {
		return rneDataExpedicao;
	}

	public void setRneDataExpedicao(Date rneDataExpedicao) {
		this.rneDataExpedicao = rneDataExpedicao;
	}

	public long getCNH() {
		return numCNH;
	}

	public void setCNH(long numCNH) {
		this.numCNH = numCNH;
	}

	public String getCnhUf() {
		return cnhUf;
	}

	public void setCnhUf(String cnhUf) {
		this.cnhUf = cnhUf;
	}

	public Date getCnhDataExpedicao() {
		return cnhDataExpedicao;
	}

	public void setCnhDataExpedicao(Date cnhDataExpedicao) {
		this.cnhDataExpedicao = cnhDataExpedicao;
	}

	public Date getCnhValidade() {
		return cnhValidade;
	}

	public void setCnhValidade(Date cnhValidade) {
		this.cnhValidade = cnhValidade;
	}

	public Date getCnhPrimeiraEmissao() {
		return cnhPrimeiraEmissao;
	}

	public void setCnhPrimeiraEmissao(Date cnhPrimeiraEmissao) {
		this.cnhPrimeiraEmissao = cnhPrimeiraEmissao;
	}

	public String getCnhCategoria() {
		return cnhCategoria;
	}

	public void setCnhCategoria(String cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
