package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "empresaFAP_ID")
	private EmpresaFAP empresaFAP;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "empresaDadosIsencao_ID")
	private EmpresaDadosIsencao empresaDadosIsencao;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "organismoInternacional_ID")
	private EmpresaOrganismoInternacional organismoInternacional;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaSoftwareHouse_ID")
	private Set<EmpresaSoftwareHouse> empresaSoftwareHouse;

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

	public Set<EmpresaSoftwareHouse> getEmpresaSoftwareHouse() {
		return empresaSoftwareHouse;
	}

	public void setEmpresaSoftwareHouse(Set<EmpresaSoftwareHouse> empresaSoftwareHouse) {
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
