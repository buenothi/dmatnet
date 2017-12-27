package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tbl_empresaSoftwareHouse")
public class EmpresaSoftwareHouse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpresaSoftwareHouse;

	private String numCNPJ;
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

	public String getNumCNPJ() {
		return numCNPJ;
	}

	public void setNumCNPJ(String numCNPJ) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpresaSoftwareHouse ^ (idEmpresaSoftwareHouse >>> 32));
		result = prime * result + ((numCNPJ == null) ? 0 : numCNPJ.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
		EmpresaSoftwareHouse other = (EmpresaSoftwareHouse) obj;
		if (idEmpresaSoftwareHouse != other.idEmpresaSoftwareHouse)
			return false;
		if (numCNPJ == null) {
			if (other.numCNPJ != null)
				return false;
		} else if (!numCNPJ.equals(other.numCNPJ))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}

}
