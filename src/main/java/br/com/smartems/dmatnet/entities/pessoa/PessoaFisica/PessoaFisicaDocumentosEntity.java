package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Embeddable
public class PessoaFisicaDocumentosEntity implements Serializable {
	
	//registro de identificação civil (para atendimento do eSocial)
	private Long numRic; 
	private String ricOrgExpedidor;
	
	@Temporal(TemporalType.DATE)
	private Date ricDataExpedicao;
	
	private String numRG;
	private String rgOrgExpedidor;
	
	@Temporal(TemporalType.DATE)
	private Date rgDataExpedicao;
	
	private Long numCPF;
	
	private Long numRNE;
	private String rneOrgExpedidor;
	
	@Temporal(TemporalType.DATE)
	private Date rneDataExpedicao;
	
	private Long numCNH;
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

	public Long getNumRic() {
		return numRic;
	}

	public void setNumRic(Long numRic) {
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

	public Long getNumCPF() {
		return numCPF;
	}

	public void setNumCPF(Long numCPF) {
		this.numCPF = numCPF;
	}

	public Long getNumRNE() {
		return numRNE;
	}

	public void setNumRNE(Long numRNE) {
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

	public Long getNumCNH() {
		return numCNH;
	}

	public void setNumCNH(Long numCNH) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnhCategoria == null) ? 0 : cnhCategoria.hashCode());
		result = prime * result + ((cnhDataExpedicao == null) ? 0 : cnhDataExpedicao.hashCode());
		result = prime * result + ((cnhPrimeiraEmissao == null) ? 0 : cnhPrimeiraEmissao.hashCode());
		result = prime * result + ((cnhUf == null) ? 0 : cnhUf.hashCode());
		result = prime * result + ((cnhValidade == null) ? 0 : cnhValidade.hashCode());
		result = prime * result + ((numCNH == null) ? 0 : numCNH.hashCode());
		result = prime * result + ((numCPF == null) ? 0 : numCPF.hashCode());
		result = prime * result + ((numRG == null) ? 0 : numRG.hashCode());
		result = prime * result + ((numRNE == null) ? 0 : numRNE.hashCode());
		result = prime * result + ((numRic == null) ? 0 : numRic.hashCode());
		result = prime * result + ((rgDataExpedicao == null) ? 0 : rgDataExpedicao.hashCode());
		result = prime * result + ((rgOrgExpedidor == null) ? 0 : rgOrgExpedidor.hashCode());
		result = prime * result + ((ricDataExpedicao == null) ? 0 : ricDataExpedicao.hashCode());
		result = prime * result + ((ricOrgExpedidor == null) ? 0 : ricOrgExpedidor.hashCode());
		result = prime * result + ((rneDataExpedicao == null) ? 0 : rneDataExpedicao.hashCode());
		result = prime * result + ((rneOrgExpedidor == null) ? 0 : rneOrgExpedidor.hashCode());
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
		PessoaFisicaDocumentosEntity other = (PessoaFisicaDocumentosEntity) obj;
		if (cnhCategoria == null) {
			if (other.cnhCategoria != null)
				return false;
		} else if (!cnhCategoria.equals(other.cnhCategoria))
			return false;
		if (cnhDataExpedicao == null) {
			if (other.cnhDataExpedicao != null)
				return false;
		} else if (!cnhDataExpedicao.equals(other.cnhDataExpedicao))
			return false;
		if (cnhPrimeiraEmissao == null) {
			if (other.cnhPrimeiraEmissao != null)
				return false;
		} else if (!cnhPrimeiraEmissao.equals(other.cnhPrimeiraEmissao))
			return false;
		if (cnhUf == null) {
			if (other.cnhUf != null)
				return false;
		} else if (!cnhUf.equals(other.cnhUf))
			return false;
		if (cnhValidade == null) {
			if (other.cnhValidade != null)
				return false;
		} else if (!cnhValidade.equals(other.cnhValidade))
			return false;
		if (numCNH == null) {
			if (other.numCNH != null)
				return false;
		} else if (!numCNH.equals(other.numCNH))
			return false;
		if (numCPF == null) {
			if (other.numCPF != null)
				return false;
		} else if (!numCPF.equals(other.numCPF))
			return false;
		if (numRG == null) {
			if (other.numRG != null)
				return false;
		} else if (!numRG.equals(other.numRG))
			return false;
		if (numRNE == null) {
			if (other.numRNE != null)
				return false;
		} else if (!numRNE.equals(other.numRNE))
			return false;
		if (numRic == null) {
			if (other.numRic != null)
				return false;
		} else if (!numRic.equals(other.numRic))
			return false;
		if (rgDataExpedicao == null) {
			if (other.rgDataExpedicao != null)
				return false;
		} else if (!rgDataExpedicao.equals(other.rgDataExpedicao))
			return false;
		if (rgOrgExpedidor == null) {
			if (other.rgOrgExpedidor != null)
				return false;
		} else if (!rgOrgExpedidor.equals(other.rgOrgExpedidor))
			return false;
		if (ricDataExpedicao == null) {
			if (other.ricDataExpedicao != null)
				return false;
		} else if (!ricDataExpedicao.equals(other.ricDataExpedicao))
			return false;
		if (ricOrgExpedidor == null) {
			if (other.ricOrgExpedidor != null)
				return false;
		} else if (!ricOrgExpedidor.equals(other.ricOrgExpedidor))
			return false;
		if (rneDataExpedicao == null) {
			if (other.rneDataExpedicao != null)
				return false;
		} else if (!rneDataExpedicao.equals(other.rneDataExpedicao))
			return false;
		if (rneOrgExpedidor == null) {
			if (other.rneOrgExpedidor != null)
				return false;
		} else if (!rneOrgExpedidor.equals(other.rneOrgExpedidor))
			return false;
		return true;
	}
	
}
