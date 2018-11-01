package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Entity
@Table(name = "tbl_Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractPessoaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPessoa;

	private String nome;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PESSOA_ID")
	private Set<EnderecoEntity> enderecos;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PESSOA_ID")
	private Set<TelefoneEntity> telefones;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PESSOA_ID")
	private Set<EmailEntity> emails;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastroPessoa;

	@ManyToOne
	@JoinColumn(name = "usuarioCriador_ID")
	private UsuarioEntity usuarioCriador;

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

	public Set<EnderecoEntity> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<TelefoneEntity> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<TelefoneEntity> telefones) {
		this.telefones = telefones;
	}

	public Set<EmailEntity> getEmails() {
		return emails;
	}

	public void setEmails(Set<EmailEntity> emails) {
		this.emails = emails;
	}

	public Date getDataCadastroPessoa() {
		return dataCadastroPessoa;
	}

	public void setDataCadastroPessoa(Date dataCadastroPessoa) {
		this.dataCadastroPessoa = dataCadastroPessoa;
	}

	public UsuarioEntity getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(UsuarioEntity usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
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
