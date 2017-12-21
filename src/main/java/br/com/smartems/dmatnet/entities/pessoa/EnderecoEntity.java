package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Entity
@Table(name="tbl_endereco")
public class EnderecoEntity implements Serializable, Cloneable {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEndereco;
	
//	@NotNull
//	@Size(min = 3)
	private String enderecoTipo;//conforme tabela 20 do eSocial
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimCadastro;
	
//	@NotNull
//	@Size(min = 3)
	private String logradouroNome;
	private int logradouroNumero;
	private String logradouroComplemento;
	private String bairro;
	private String cep;
	private String caixaPostal;
	
	@ManyToOne
	@JoinColumn(name="CIDADE_ID")
	private CidadeEntity cidade;
	
	@ManyToOne
	@JoinColumn(name="ESTADO_ID")
	private EstadoEntity estado;
	
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

	public String getEnderecoTipo() {
		return enderecoTipo;
	}

	public void setEnderecoTipo(String enderecoTipo) {
		this.enderecoTipo = enderecoTipo;
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

	public CidadeEntity getCidade() {
		return cidade;
	}

	public void setCidade(CidadeEntity cidade) {
		this.cidade = cidade;
	}

	public EstadoEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoEntity estado) {
		this.estado = estado;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((caixaPostal == null) ? 0 : caixaPostal.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((dataFimCadastro == null) ? 0 : dataFimCadastro.hashCode());
		result = prime * result + ((dataInicioCadastro == null) ? 0 : dataInicioCadastro.hashCode());
		result = prime * result + ((enderecoTipo == null) ? 0 : enderecoTipo.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + (int) (idEndereco ^ (idEndereco >>> 32));
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
		if (enderecoTipo == null) {
			if (other.enderecoTipo != null)
				return false;
		} else if (!enderecoTipo.equals(other.enderecoTipo))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idEndereco != other.idEndereco)
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

	@Override
	public EnderecoEntity clone() throws CloneNotSupportedException {
		return (EnderecoEntity) super.clone();
	}

}
