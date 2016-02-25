package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_empresaSoftwareHouse")
public class EmpresaSoftwareHouse implements Serializable {

	@Id
	private long idEmpresaSoftwareHouse;
	
	private long numCNPJ;
	private String razaoSocial;
	private String nomeContato;
	private String telFixo;
	private String email;
	
	private static final long serialVersionUID = 1L;
	

	public EmpresaSoftwareHouse() {
		super();
	}

	public long getIdEmpresaSoftwareHouse() {
		return idEmpresaSoftwareHouse;
	}

	public void setIdEmpresaSoftwareHouse(long idEmpresaSoftwareHouse) {
		this.idEmpresaSoftwareHouse = idEmpresaSoftwareHouse;
	}

	public long getNumCNPJ() {
		return numCNPJ;
	}

	public void setNumCNPJ(long numCNPJ) {
		this.numCNPJ = numCNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
