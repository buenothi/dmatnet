package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
@Table(name="tbl_EmpresaCadastro")
public class EmpresaCadastroEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long idEventoEsocial;//identificador para o o eSocial
	private int tipoEvento;
	private int processoEnvioDados;
	private String versaoApp;
	private int tipoInscricao;
	private long numCNPJ;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimCadastro;
	
	private String razaoSocial;
	private int codClassificacaoTributaria; //conforme tabela 8 do eSocial
	private int codNaturezaJuridica; //conforme tabela 25 do eSocial
	private int codIndicativoCooperativa;
	private int codIndicativoConstrucao;
	private int codIndicativoDesoneracaoFolha;
	private int codIndicativoRegEletronico;
	private boolean multiplasTabRubricas;
	
	@OneToOne(mappedBy="empresaCadastro")
	private EmpresaFAP empresaFAP;
	
	@OneToOne(mappedBy="empresaCadastro")
	private EmpresaDadosIsencao empresaDadosIsencao;
	
	@OneToOne(mappedBy="empresaCadastro")
	private EmpresaOrganismoInternacional organismoInternacional;
	
	@OneToMany
	@JoinColumn(name="empresaCadastro_ID")
	private List<EmpresaSoftwareHouse> empresaSoftwareHouse;
	
	@OneToOne(mappedBy="cadastroEmpresa")
	private EmpresaDadosComplementares dadosComplementares;
		
	
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
		this.versaoApp = versaoApp;
	}

	public int getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(int tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public long getNumCNPJ() {
		return numCNPJ;
	}

	public void setNumCNPJ(long numCNPJ) {
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
		this.razaoSocial = razaoSocial;
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

	public List<EmpresaSoftwareHouse> getEmpresaSoftwareHouse() {
		return empresaSoftwareHouse;
	}

	public void setEmpresaSoftwareHouse(List<EmpresaSoftwareHouse> empresaSoftwareHouse) {
		this.empresaSoftwareHouse = empresaSoftwareHouse;
	}

	public EmpresaDadosComplementares getDadosComplementares() {
		return dadosComplementares;
	}

	public void setDadosComplementares(EmpresaDadosComplementares dadosComplementares) {
		this.dadosComplementares = dadosComplementares;
	}
	
}
