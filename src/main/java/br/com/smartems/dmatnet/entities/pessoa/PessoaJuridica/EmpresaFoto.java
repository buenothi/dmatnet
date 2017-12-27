package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_EmpresaFoto")
public class EmpresaFoto implements Serializable, Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpresaFoto;

	@Lob
	private byte[] fotoFachada;

	private static final long serialVersionUID = 1L;

	public EmpresaFoto() {
	}

	public long getIdEmpresaFoto() {
		return idEmpresaFoto;
	}

	public void setIdEmpresaFoto(long idEmpresaFoto) {
		this.idEmpresaFoto = idEmpresaFoto;
	}

	public byte[] getFotoFachada() {
		return fotoFachada;
	}

	public void setFotoFachada(byte[] fotoFachada) {
		this.fotoFachada = fotoFachada;
	}

	@Override
	public EmpresaFoto clone() throws CloneNotSupportedException {
		return (EmpresaFoto) super.clone();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpresaFoto ^ (idEmpresaFoto >>> 32));
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
		EmpresaFoto other = (EmpresaFoto) obj;
		if (idEmpresaFoto != other.idEmpresaFoto)
			return false;
		return true;
	}

}
