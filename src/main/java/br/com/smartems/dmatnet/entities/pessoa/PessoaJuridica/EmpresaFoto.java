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
public class EmpresaFoto implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

}
