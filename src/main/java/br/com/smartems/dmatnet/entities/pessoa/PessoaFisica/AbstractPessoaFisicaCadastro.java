package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractPessoaFisicaCadastro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPessoaCadastro;
	private char sexo;
	private int racaCor;
	private int estadoCivil;
	private int grauInstrucao;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimCadastro;

	private long codMunicipioNascimento;
	private String ufNascimento;
	private long paisNascimento; // conforme tabela 6 do eSocial
	private long nacionalidade; // conforme tabela 6 do eSocial
	private String nomeMae;
	private String nomePai;

	@Embedded
	private PessoaFisicaDocumentosEntity documentos;

	private static final long serialVersionUID = 1L;

	public AbstractPessoaFisicaCadastro() {
		super();
	}

	public long getIdPessoaCadastro() {
		return idPessoaCadastro;
	}

	public void setIdPessoaCadastro(long idPessoaCadastro) {
		this.idPessoaCadastro = idPessoaCadastro;
	}

	public long getCodMunicipioNascimento() {
		return codMunicipioNascimento;
	}

	public void setCodMunicipioNascimento(long codMunicipioNascimento) {
		this.codMunicipioNascimento = codMunicipioNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPessoaCadastro ^ (idPessoaCadastro >>> 32));
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
		AbstractPessoaFisicaCadastro other = (AbstractPessoaFisicaCadastro) obj;
		if (idPessoaCadastro != other.idPessoaCadastro)
			return false;
		return true;
	}

}
