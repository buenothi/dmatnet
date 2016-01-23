package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_trabalhadorCadastro")
public class TrabalhadorCadastroEntity extends AbstractPessoaFisicaCadastro implements Serializable {

	private long idEventoEsocial;
	private long numNIS;
	private long numCTPS;
	private long numCTPSSerie;
	private String ufCTPS;
	private String numOrgaoClasse;

	@OneToOne(mappedBy="trabalhador")
	private TrabalhadorEstrangeiroEntity trabalhadorEstrageiro;
	
	@OneToOne(mappedBy="trabalhador")
	private TrabalhadorDeficienteEntity trabalhadorDeficiente;
	
	@OneToMany
	@JoinColumn(name="TRABALHADOR_ID")
	private List<LocaisTrabalho> locaisTrabalho;
	
	@OneToMany
	@JoinColumn(name="TRABALHADOR_ID")
	private List<TrabalhadorAfastamentoEntity> afastamentos;
	
	private static final long serialVersionUID = 1L;

	
	public TrabalhadorCadastroEntity() {
		super();
	}

	public long getIdEventoEsocial() {
		return idEventoEsocial;
	}

	public void setIdEventoEsocial(long idEventoEsocial) {
		this.idEventoEsocial = idEventoEsocial;
	}

	public long getNumNIS() {
		return numNIS;
	}

	public void setNumNIS(long numNIS) {
		this.numNIS = numNIS;
	}

	public long getNumCTPS() {
		return numCTPS;
	}

	public void setNumCTPS(long numCTPS) {
		this.numCTPS = numCTPS;
	}

	public long getNumCTPSSerie() {
		return numCTPSSerie;
	}

	public void setNumCTPSSerie(long numCTPSSerie) {
		this.numCTPSSerie = numCTPSSerie;
	}

	public String getUfCTPS() {
		return ufCTPS;
	}

	public void setUfCTPS(String ufCTPS) {
		this.ufCTPS = ufCTPS;
	}

	public String getNumOrgaoClasse() {
		return numOrgaoClasse;
	}

	public void setNumOrgaoClasse(String numOrgaoClasse) {
		this.numOrgaoClasse = numOrgaoClasse;
	}

	public TrabalhadorEstrangeiroEntity getTrabalhadorEstrageiro() {
		return trabalhadorEstrageiro;
	}

	public void setTrabalhadorEstrageiro(TrabalhadorEstrangeiroEntity trabalhadorEstrageiro) {
		this.trabalhadorEstrageiro = trabalhadorEstrageiro;
	}

	public TrabalhadorDeficienteEntity getTrabalhadorDeficiente() {
		return trabalhadorDeficiente;
	}

	public void setTrabalhadorDeficiente(TrabalhadorDeficienteEntity trabalhadorDeficiente) {
		this.trabalhadorDeficiente = trabalhadorDeficiente;
	}

	public List<LocaisTrabalho> getLocaisTrabalho() {
		return locaisTrabalho;
	}

	public void setLocaisTrabalho(List<LocaisTrabalho> locaisTrabalho) {
		this.locaisTrabalho = locaisTrabalho;
	}

	public List<TrabalhadorAfastamentoEntity> getAfastamentos() {
		return afastamentos;
	}

	public void setAfastamentos(List<TrabalhadorAfastamentoEntity> afastamentos) {
		this.afastamentos = afastamentos;
	}
	
}
