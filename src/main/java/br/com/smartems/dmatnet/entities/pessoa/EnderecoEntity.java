package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Entity
@Table(name="tbl_endereco")
public class EnderecoEntity implements Serializable {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEndereco;
	
	@NotNull
	@Size(min = 3)
	private String enderecoTipo;//conforme tabela 20 do eSocial
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimCadastro;
	
	@NotNull
	@Size(min = 3)
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


}
