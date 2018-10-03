package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import br.com.smartems.dmatnet.entities.pessoa.AbstractPessoaEntity;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractPessoaFisicaEntity extends AbstractPessoaEntity implements Serializable {
	
	private int genero;
	
	private int raca;
	
	private int estadoCivil;
	
	private PessoaFisicaDocumentosEntity documentosPessoais;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private static final long serialVersionUID = 1L;
	
	public AbstractPessoaFisicaEntity() {
		super();
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getRaca() {
		return raca;
	}

	public void setRaca(int raca) {
		this.raca = raca;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public PessoaFisicaDocumentosEntity getDocumentosPessoais() {
		return documentosPessoais;
	}

	public void setDocumentosPessoais(PessoaFisicaDocumentosEntity documentosPessoais) {
		this.documentosPessoais = documentosPessoais;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((documentosPessoais == null) ? 0 : documentosPessoais.hashCode());
		result = prime * result + genero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPessoaFisicaEntity other = (AbstractPessoaFisicaEntity) obj;
		if (documentosPessoais == null) {
			if (other.documentosPessoais != null)
				return false;
		} else if (!documentosPessoais.equals(other.documentosPessoais))
			return false;
		if (genero != other.genero)
			return false;
		return true;
	}

}
