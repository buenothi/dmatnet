package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="tbl_endereco")
public class EnderecoEntity implements Serializable {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEndereco;
	private String logradouro;//conforme tabela 20 do eSocial
	private String logradouroNome;
	private int logradouroNumero;
	private String logradouroComplemento;
	private String bairro;
	private String cep;
	private String caixaPostal;
	private String cidade;
	private String estado;
	private String logradouroTipo;
	private String logradouroPais;
	
	private static final long serialVersionUID = 1L;

	
	public EnderecoEntity() {
		super();
	}   
	
	public long getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}   
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.toUpperCase();
	}

	public String getLogradouroNome() {
		return this.logradouroNome;
	}

	public void setLogradouroNome(String logradouroNome) {
		this.logradouroNome = logradouroNome.toUpperCase();
	}   
	
	public int getLogradouroNumero() {
		return this.logradouroNumero;
	}

	public void setLogradouroNumero(int logradouroNumero) {
		this.logradouroNumero = logradouroNumero;
	}   
	
	public String getLogradouroComplemento() {
		return this.logradouroComplemento;
	}

	public void setLogradouroComplemento(String logradouroComplemento) {
		this.logradouroComplemento = logradouroComplemento.toUpperCase();
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCaixaPostal() {
		return caixaPostal;
	}
	
	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado.toUpperCase();
	}
	
	public String getLogradouroTipo() {
		return logradouroTipo;
	}
	
	public void setLogradouroTipo(String logradouroTipo) {
		this.logradouroTipo = logradouroTipo.toUpperCase();
	}
	
	public String getLogradouroPais() {
		return logradouroPais;
	}

	public void setLogradouroPais(String logradouroPais) {
		this.logradouroPais = logradouroPais.toUpperCase();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EnderecoEntity [logradouro=" + logradouro + ", logradouroNome=" + logradouroNome + ", logradouroNumero="
				+ logradouroNumero + ", logradouroComplemento=" + logradouroComplemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", logradouroTipo=" + logradouroTipo
				+ ", getIdEndereco()=" + getIdEndereco() + ", getLogradouro()=" + getLogradouro()
				+ ", getLogradouroNome()=" + getLogradouroNome() + ", getLogradouroNumero()=" + getLogradouroNumero()
				+ ", getLogradouroComplemento()=" + getLogradouroComplemento() + ", getBairro()=" + getBairro()
				+ ", getCep()=" + getCep() + ", getCaixaPostal()=" + getCaixaPostal() + ", getCidade()=" + getCidade()
				+ ", getEstado()=" + getEstado() + ", getLogradouroTipo()=" + getLogradouroTipo()
				+ ", getLogradouroPais()=" + getLogradouroPais() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((caixaPostal == null) ? 0 : caixaPostal.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + (int) (idEndereco ^ (idEndereco >>> 32));
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((logradouroComplemento == null) ? 0 : logradouroComplemento.hashCode());
		result = prime * result + ((logradouroNome == null) ? 0 : logradouroNome.hashCode());
		result = prime * result + logradouroNumero;
		result = prime * result + ((logradouroPais == null) ? 0 : logradouroPais.hashCode());
		result = prime * result + ((logradouroTipo == null) ? 0 : logradouroTipo.hashCode());
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
		EnderecoEntity other = (EnderecoEntity) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (caixaPostal == null) {
			if (other.caixaPostal != null)
				return false;
		} else if (!caixaPostal.equals(other.caixaPostal))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idEndereco != other.idEndereco)
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (logradouroComplemento == null) {
			if (other.logradouroComplemento != null)
				return false;
		} else if (!logradouroComplemento.equals(other.logradouroComplemento))
			return false;
		if (logradouroNome == null) {
			if (other.logradouroNome != null)
				return false;
		} else if (!logradouroNome.equals(other.logradouroNome))
			return false;
		if (logradouroNumero != other.logradouroNumero)
			return false;
		if (logradouroPais == null) {
			if (other.logradouroPais != null)
				return false;
		} else if (!logradouroPais.equals(other.logradouroPais))
			return false;
		if (logradouroTipo == null) {
			if (other.logradouroTipo != null)
				return false;
		} else if (!logradouroTipo.equals(other.logradouroTipo))
			return false;
		return true;
	}
	
}
