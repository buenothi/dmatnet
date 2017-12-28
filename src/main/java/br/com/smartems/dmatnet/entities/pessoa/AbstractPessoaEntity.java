package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractPessoaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPessoa;

	@NotNull
	@Size(min = 3)
	private String nome;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PESSOA_ID")
	private Collection<EnderecoEntity> enderecos;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PESSOA_ID")
	private List<TelefoneEntity> telefones;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PESSOA_ID")
	private List<EmailEntity> emails;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastroPessoa;

	private static final long serialVersionUID = 1L;

	public AbstractPessoaEntity() {
		super();
	}

	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public Collection<EnderecoEntity> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}

	public List<TelefoneEntity> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneEntity> telefones) {
		this.telefones = telefones;
	}

	public List<EmailEntity> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailEntity> emails) {
		this.emails = emails;
	}

	public Date getDataCadastroPessoa() {
		return dataCadastroPessoa;
	}

	public void setDataCadastroPessoa(Date dataCadastroPessoa) {
		this.dataCadastroPessoa = dataCadastroPessoa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PessoaEntity [idPessoa=" + idPessoa + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPessoa ^ (idPessoa >>> 32));
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
		AbstractPessoaEntity other = (AbstractPessoaEntity) obj;
		if (idPessoa != other.idPessoa)
			return false;
		return true;
	}

}
