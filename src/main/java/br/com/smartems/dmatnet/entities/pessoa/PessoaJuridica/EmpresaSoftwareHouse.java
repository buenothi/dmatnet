package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_empresaSoftwareHouse")
public class EmpresaSoftwareHouse implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idEmpresaSoftwareHouse;
	
	private Long numCNPJ;
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

	public Long getNumCNPJ() {
		return numCNPJ;
	}

	public void setNumCNPJ(Long numCNPJ) {
		this.numCNPJ = numCNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial.toUpperCase();
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato.toUpperCase();
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo.toUpperCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
   
}
