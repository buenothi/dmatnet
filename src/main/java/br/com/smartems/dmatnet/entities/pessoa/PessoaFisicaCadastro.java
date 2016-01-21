package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tbl_pessoaFisicaCadastro")
public class PessoaFisicaCadastro implements Serializable {

	@Id
	private long idPessoaCadastro;
	private int sexo;
	private int racaCor;
	private int estadoCivil;
	private int grauInstrucao;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private long codMunicipioNascimento;
	private String ufNascimento;
	private long paisNascimento; //conforme tabela 6 do eSocial
	private long nacionalidade; //conforme tabela 6 do eSocial
	private String nomeMae;
	private String nomePai;
	
	@Embedded
	private PessoaFisicaDocumentosEntity documentos; 
	
	private static final long serialVersionUID = 1L;

	
	public PessoaFisicaCadastro() {
		super();
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getRacaCor() {
		return racaCor;
	}

	public void setRacaCor(int racaCor) {
		this.racaCor = racaCor;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(int grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getMunicipioNascimento() {
		return codMunicipioNascimento;
	}

	public void setMunicipioNascimento(long codMunicipioNascimento) {
		this.codMunicipioNascimento = codMunicipioNascimento;
	}

	public String getUfNascimento() {
		return ufNascimento;
	}

	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}

	public long getPaisNascimento() {
		return paisNascimento;
	}

	public void setPaisNascimento(long paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public long getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(long nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public PessoaFisicaDocumentosEntity getDocumentos() {
		return documentos;
	}

	public void setDocumentos(PessoaFisicaDocumentosEntity documentos) {
		this.documentos = documentos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
