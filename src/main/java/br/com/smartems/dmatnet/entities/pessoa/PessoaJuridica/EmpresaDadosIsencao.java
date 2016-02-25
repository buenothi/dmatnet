package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tbl_empresaDadosIsencao")
public class EmpresaDadosIsencao implements Serializable{
	
	@Id
	private long idEmpresaDadosIsencao;
	private String siglaMinisterio;
	private long numCertificado;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissaoCertificado;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimentoCertificado;
	
	private long numProtocoloRenovacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataRenovacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDOU;
	
	private int paginaDOU;	
	private String nomeResponsavel;	
	private long cpfResponsavel;	
	private String telFixoResponsavel;	
	private String telCelularResponsavel;	
	private String email;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private EmpresaCadastroEntity empresaCadastro;
	
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
		this.siglaMinisterio = siglaMinisterio;
	}

	public long getNumCertificado() {
		return numCertificado;
	}

	public void setNumCertificado(long numCertificado) {
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

	public long getNumProtocoloRenovacao() {
		return numProtocoloRenovacao;
	}

	public void setNumProtocoloRenovacao(long numProtocoloRenovacao) {
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
		this.nomeResponsavel = nomeResponsavel;
	}

	public long getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(long cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getTelFixoResponsavel() {
		return telFixoResponsavel;
	}

	public void setTelFixoResponsavel(String telFixoResponsavel) {
		this.telFixoResponsavel = telFixoResponsavel;
	}

	public String getTelCelularResponsavel() {
		return telCelularResponsavel;
	}

	public void setTelCelularResponsavel(String telCelularResponsavel) {
		this.telCelularResponsavel = telCelularResponsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmpresaCadastroEntity getEmpresaCadastro() {
		return empresaCadastro;
	}

	public void setEmpresaCadastro(EmpresaCadastroEntity empresaCadastro) {
		this.empresaCadastro = empresaCadastro;
	}
	
}
