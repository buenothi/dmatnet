package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_EmpresaCadastro")
public class EmpresaCadastroEntity implements Serializable, Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idEventoEsocial;// identificador para o eSocial
	private int tipoEvento;
	private int processoEnvioDados;
	private String versaoApp;
	private int tipoInscricao;
	private String numCNPJ;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimCadastro;

	private String razaoSocial;
	private int codClassificacaoTributaria; // conforme tabela 8 do eSocial
	private int codNaturezaJuridica; // conforme tabela 25 do eSocial
	private int codIndicativoCooperativa;
	private int codIndicativoConstrucao;
	private int codIndicativoDesoneracaoFolha;
	private int codIndicativoRegEletronico;
	private boolean multiplasTabRubricas;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaFAP_ID")
	private EmpresaFAP empresaFAP;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaDadosIsencao_ID")
	private EmpresaDadosIsencao empresaDadosIsencao;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "organismoInternacional_ID")
	private EmpresaOrganismoInternacional organismoInternacional;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaSoftwareHouse_ID")
	private Collection<EmpresaSoftwareHouse> empresaSoftwareHouse;

	private static final long serialVersionUID = 1L;

	public EmpresaCadastroEntity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdEventoEsocial() {
		return idEventoEsocial;
	}

	public void setIdEventoEsocial(long idEventoEsocial) {
		this.idEventoEsocial = idEventoEsocial;
	}

	public int getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(int tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getProcessoEnvioDados() {
		return processoEnvioDados;
	}

	public void setProcessoEnvioDados(int processoEnvioDados) {
		this.processoEnvioDados = processoEnvioDados;
	}

	public String getVersaoApp() {
		return versaoApp;
	}

	public void setVersaoApp(String versaoApp) {
		this.versaoApp = versaoApp.toUpperCase();
	}

	public int getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(int tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public String getNumCNPJ() {
		return numCNPJ;
	}

	public void setNumCNPJ(String numCNPJ) {

		this.numCNPJ = numCNPJ;
	}

	public Date getDataInicioCadastro() {
		return dataInicioCadastro;
	}

	public void setDataInicioCadastro(Date dataInicioCadastro) {
		this.dataInicioCadastro = dataInicioCadastro;
	}

	public Date getDataFimCadastro() {
		return dataFimCadastro;
	}

	public void setDataFimCadastro(Date dataFimCadastro) {
		this.dataFimCadastro = dataFimCadastro;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial.toUpperCase();
	}

	public int getCodClassificacaoTributaria() {
		return codClassificacaoTributaria;
	}

	public void setCodClassificacaoTributaria(int codClassificacaoTributaria) {
		this.codClassificacaoTributaria = codClassificacaoTributaria;
	}

	public int getCodNaturezaJuridica() {
		return codNaturezaJuridica;
	}

	public void setCodNaturezaJuridica(int codNaturezaJuridica) {
		this.codNaturezaJuridica = codNaturezaJuridica;
	}

	public int getCodIndicativoCooperativa() {
		return codIndicativoCooperativa;
	}

	public void setCodIndicativoCooperativa(int codIndicativoCooperativa) {
		this.codIndicativoCooperativa = codIndicativoCooperativa;
	}

	public int getCodIndicativoConstrucao() {
		return codIndicativoConstrucao;
	}

	public void setCodIndicativoConstrucao(int codIndicativoConstrucao) {
		this.codIndicativoConstrucao = codIndicativoConstrucao;
	}

	public int getCodIndicativoDesoneracaoFolha() {
		return codIndicativoDesoneracaoFolha;
	}

	public void setCodIndicativoDesoneracaoFolha(int codIndicativoDesoneracaoFolha) {
		this.codIndicativoDesoneracaoFolha = codIndicativoDesoneracaoFolha;
	}

	public int getCodIndicativoRegEletronico() {
		return codIndicativoRegEletronico;
	}

	public void setCodIndicativoRegEletronico(int codIndicativoRegEletronico) {
		this.codIndicativoRegEletronico = codIndicativoRegEletronico;
	}

	public boolean isMultiplasTabRubricas() {
		return multiplasTabRubricas;
	}

	public void setMultiplasTabRubricas(boolean multiplasTabRubricas) {
		this.multiplasTabRubricas = multiplasTabRubricas;
	}

	public EmpresaFAP getEmpresaFAP() {
		return empresaFAP;
	}

	public void setEmpresaFAP(EmpresaFAP empresaFAP) {
		this.empresaFAP = empresaFAP;
	}

	public EmpresaDadosIsencao getEmpresaDadosIsencao() {
		return empresaDadosIsencao;
	}

	public void setEmpresaDadosIsencao(EmpresaDadosIsencao empresaDadosIsencao) {
		this.empresaDadosIsencao = empresaDadosIsencao;
	}

	public EmpresaOrganismoInternacional getOrganismoInternacional() {
		return organismoInternacional;
	}

	public void setOrganismoInternacional(EmpresaOrganismoInternacional organismoInternacional) {
		this.organismoInternacional = organismoInternacional;
	}

	public Collection<EmpresaSoftwareHouse> getEmpresaSoftwareHouse() {
		return empresaSoftwareHouse;
	}

	public void setEmpresaSoftwareHouse(Collection<EmpresaSoftwareHouse> empresaSoftwareHouse) {
		this.empresaSoftwareHouse = empresaSoftwareHouse;
	}
	
	@Override
	public EmpresaCadastroEntity clone() throws CloneNotSupportedException {
		return (EmpresaCadastroEntity) super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codClassificacaoTributaria;
		result = prime * result + codIndicativoConstrucao;
		result = prime * result + codIndicativoCooperativa;
		result = prime * result + codIndicativoDesoneracaoFolha;
		result = prime * result + codIndicativoRegEletronico;
		result = prime * result + codNaturezaJuridica;
		result = prime * result + ((dataFimCadastro == null) ? 0 : dataFimCadastro.hashCode());
		result = prime * result + ((dataInicioCadastro == null) ? 0 : dataInicioCadastro.hashCode());
		result = prime * result + ((empresaDadosIsencao == null) ? 0 : empresaDadosIsencao.hashCode());
		result = prime * result + ((empresaFAP == null) ? 0 : empresaFAP.hashCode());
		result = prime * result + ((empresaSoftwareHouse == null) ? 0 : empresaSoftwareHouse.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idEventoEsocial ^ (idEventoEsocial >>> 32));
		result = prime * result + (multiplasTabRubricas ? 1231 : 1237);
		result = prime * result + ((numCNPJ == null) ? 0 : numCNPJ.hashCode());
		result = prime * result + ((organismoInternacional == null) ? 0 : organismoInternacional.hashCode());
		result = prime * result + processoEnvioDados;
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + tipoEvento;
		result = prime * result + tipoInscricao;
		result = prime * result + ((versaoApp == null) ? 0 : versaoApp.hashCode());
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
		EmpresaCadastroEntity other = (EmpresaCadastroEntity) obj;
		if (codClassificacaoTributaria != other.codClassificacaoTributaria)
			return false;
		if (codIndicativoConstrucao != other.codIndicativoConstrucao)
			return false;
		if (codIndicativoCooperativa != other.codIndicativoCooperativa)
			return false;
		if (codIndicativoDesoneracaoFolha != other.codIndicativoDesoneracaoFolha)
			return false;
		if (codIndicativoRegEletronico != other.codIndicativoRegEletronico)
			return false;
		if (codNaturezaJuridica != other.codNaturezaJuridica)
			return false;
		if (dataFimCadastro == null) {
			if (other.dataFimCadastro != null)
				return false;
		} else if (!dataFimCadastro.equals(other.dataFimCadastro))
			return false;
		if (dataInicioCadastro == null) {
			if (other.dataInicioCadastro != null)
				return false;
		} else if (!dataInicioCadastro.equals(other.dataInicioCadastro))
			return false;
		if (empresaDadosIsencao == null) {
			if (other.empresaDadosIsencao != null)
				return false;
		} else if (!empresaDadosIsencao.equals(other.empresaDadosIsencao))
			return false;
		if (empresaFAP == null) {
			if (other.empresaFAP != null)
				return false;
		} else if (!empresaFAP.equals(other.empresaFAP))
			return false;
		if (empresaSoftwareHouse == null) {
			if (other.empresaSoftwareHouse != null)
				return false;
		} else if (!empresaSoftwareHouse.equals(other.empresaSoftwareHouse))
			return false;
		if (id != other.id)
			return false;
		if (idEventoEsocial != other.idEventoEsocial)
			return false;
		if (multiplasTabRubricas != other.multiplasTabRubricas)
			return false;
		if (numCNPJ == null) {
			if (other.numCNPJ != null)
				return false;
		} else if (!numCNPJ.equals(other.numCNPJ))
			return false;
		if (organismoInternacional == null) {
			if (other.organismoInternacional != null)
				return false;
		} else if (!organismoInternacional.equals(other.organismoInternacional))
			return false;
		if (processoEnvioDados != other.processoEnvioDados)
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (tipoEvento != other.tipoEvento)
			return false;
		if (tipoInscricao != other.tipoInscricao)
			return false;
		if (versaoApp == null) {
			if (other.versaoApp != null)
				return false;
		} else if (!versaoApp.equals(other.versaoApp))
			return false;
		return true;
	}

}
