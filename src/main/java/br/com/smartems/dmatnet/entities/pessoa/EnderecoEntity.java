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
	private String enderecoTipo;//conforme tabela 20 do eSocial
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

	public String getEnderecoTipo() {
		return enderecoTipo;
	}

	public void setEnderecoTipo(String enderecoTipo) {
		this.enderecoTipo = enderecoTipo;
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


}
