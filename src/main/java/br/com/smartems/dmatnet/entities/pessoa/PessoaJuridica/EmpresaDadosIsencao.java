package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tbl_empresaDadosIsencao")
public class EmpresaDadosIsencao implements Serializable, Cloneable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEmpresaDadosIsencao;
	private String siglaMinisterio;
	private Long numCertificado;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissaoCertificado;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimentoCertificado;
	
	private Long numProtocoloRenovacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataRenovacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDOU;
	
	private int paginaDOU;	
	private String nomeResponsavel;	
	private Long cpfResponsavel;	
	private String telFixoResponsavel;	
	private String telCelularResponsavel;	
	private String email;
	
	private static final long serialVersionUID = 1L;
	
	
	public EmpresaDadosIsencao() {
		super();
	}

	public long getIdEmpresaDadosIsencao() {
		return idEmpresaDadosIsencao;
	}

	public void setIdEmpresaDadosIsencao(long idEmpresaDadosIsencao) {
		this.idEmpresaDadosIsencao = idEmpresaDadosIsencao;
	}

	public String getSiglaMinisterio() {
		return siglaMinisterio;
	}

	public void setSiglaMinisterio(String siglaMinisterio) {
		this.siglaMinisterio = siglaMinisterio.toUpperCase();
	}

	public Long getNumCertificado() {
		return numCertificado;
	}

	public void setNumCertificado(Long numCertificado) {
		this.numCertificado = numCertificado;
	}

	public Date getDataEmissaoCertificado() {
		return dataEmissaoCertificado;
	}

	public void setDataEmissaoCertificado(Date dataEmissaoCertificado) {
		this.dataEmissaoCertificado = dataEmissaoCertificado;
	}

	public Date getDataVencimentoCertificado() {
		return dataVencimentoCertificado;
	}

	public void setDataVencimentoCertificado(Date dataVencimentoCertificado) {
		this.dataVencimentoCertificado = dataVencimentoCertificado;
	}

	public Long getNumProtocoloRenovacao() {
		return numProtocoloRenovacao;
	}

	public void setNumProtocoloRenovacao(Long numProtocoloRenovacao) {
		this.numProtocoloRenovacao = numProtocoloRenovacao;
	}

	public Date getDataRenovacao() {
		return dataRenovacao;
	}

	public void setDataRenovacao(Date dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}

	public Date getDataDOU() {
		return dataDOU;
	}

	public void setDataDOU(Date dataDOU) {
		this.dataDOU = dataDOU;
	}

	public int getPaginaDOU() {
		return paginaDOU;
	}

	public void setPaginaDOU(int paginaDOU) {
		this.paginaDOU = paginaDOU;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel.toUpperCase();
	}

	public Long getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(Long cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getTelFixoResponsavel() {
		return telFixoResponsavel;
	}

	public void setTelFixoResponsavel(String telFixoResponsavel) {
		this.telFixoResponsavel = telFixoResponsavel.toUpperCase();
	}

	public String getTelCelularResponsavel() {
		return telCelularResponsavel;
	}

	public void setTelCelularResponsavel(String telCelularResponsavel) {
		this.telCelularResponsavel = telCelularResponsavel.toUpperCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	@Override
	public EmpresaDadosIsencao clone() throws CloneNotSupportedException {
		return (EmpresaDadosIsencao) super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfResponsavel == null) ? 0 : cpfResponsavel.hashCode());
		result = prime * result + ((dataDOU == null) ? 0 : dataDOU.hashCode());
		result = prime * result + ((dataEmissaoCertificado == null) ? 0 : dataEmissaoCertificado.hashCode());
		result = prime * result + ((dataRenovacao == null) ? 0 : dataRenovacao.hashCode());
		result = prime * result + ((dataVencimentoCertificado == null) ? 0 : dataVencimentoCertificado.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idEmpresaDadosIsencao ^ (idEmpresaDadosIsencao >>> 32));
		result = prime * result + ((nomeResponsavel == null) ? 0 : nomeResponsavel.hashCode());
		result = prime * result + ((numCertificado == null) ? 0 : numCertificado.hashCode());
		result = prime * result + ((numProtocoloRenovacao == null) ? 0 : numProtocoloRenovacao.hashCode());
		result = prime * result + paginaDOU;
		result = prime * result + ((siglaMinisterio == null) ? 0 : siglaMinisterio.hashCode());
		result = prime * result + ((telCelularResponsavel == null) ? 0 : telCelularResponsavel.hashCode());
		result = prime * result + ((telFixoResponsavel == null) ? 0 : telFixoResponsavel.hashCode());
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
		EmpresaDadosIsencao other = (EmpresaDadosIsencao) obj;
		if (cpfResponsavel == null) {
			if (other.cpfResponsavel != null)
				return false;
		} else if (!cpfResponsavel.equals(other.cpfResponsavel))
			return false;
		if (dataDOU == null) {
			if (other.dataDOU != null)
				return false;
		} else if (!dataDOU.equals(other.dataDOU))
			return false;
		if (dataEmissaoCertificado == null) {
			if (other.dataEmissaoCertificado != null)
				return false;
		} else if (!dataEmissaoCertificado.equals(other.dataEmissaoCertificado))
			return false;
		if (dataRenovacao == null) {
			if (other.dataRenovacao != null)
				return false;
		} else if (!dataRenovacao.equals(other.dataRenovacao))
			return false;
		if (dataVencimentoCertificado == null) {
			if (other.dataVencimentoCertificado != null)
				return false;
		} else if (!dataVencimentoCertificado.equals(other.dataVencimentoCertificado))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idEmpresaDadosIsencao != other.idEmpresaDadosIsencao)
			return false;
		if (nomeResponsavel == null) {
			if (other.nomeResponsavel != null)
				return false;
		} else if (!nomeResponsavel.equals(other.nomeResponsavel))
			return false;
		if (numCertificado == null) {
			if (other.numCertificado != null)
				return false;
		} else if (!numCertificado.equals(other.numCertificado))
			return false;
		if (numProtocoloRenovacao == null) {
			if (other.numProtocoloRenovacao != null)
				return false;
		} else if (!numProtocoloRenovacao.equals(other.numProtocoloRenovacao))
			return false;
		if (paginaDOU != other.paginaDOU)
			return false;
		if (siglaMinisterio == null) {
			if (other.siglaMinisterio != null)
				return false;
		} else if (!siglaMinisterio.equals(other.siglaMinisterio))
			return false;
		if (telCelularResponsavel == null) {
			if (other.telCelularResponsavel != null)
				return false;
		} else if (!telCelularResponsavel.equals(other.telCelularResponsavel))
			return false;
		if (telFixoResponsavel == null) {
			if (other.telFixoResponsavel != null)
				return false;
		} else if (!telFixoResponsavel.equals(other.telFixoResponsavel))
			return false;
		return true;
	}
	
}
