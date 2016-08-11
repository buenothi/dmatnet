package br.com.smartems.dmatnet.entities.cidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_estados")
@NamedQueries({
		@NamedQuery(name = "Estados.listarTodasCidadesPorEstado", 
				query = "SELECT cid FROM CidadeEntity cid WHERE cid.estado=:estado")})
public class EstadoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String estadoSigla;
	private String estadoNome;

	@OneToMany(mappedBy = "estado")
	private List<CidadeEntity> cidades;

	private static final long serialVersionUID = 1L;

	public EstadoEntity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstadoSigla() {
		return estadoSigla;
	}

	public void setEstadoSigla(String estadoSigla) {
		this.estadoSigla = estadoSigla;
	}

	public String getEstadoNome() {
		return estadoNome;
	}

	public void setEstadoNome(String estadoNome) {
		this.estadoNome = estadoNome;
	}

	@Override
	public String toString() {
		return estadoSigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidades == null) ? 0 : cidades.hashCode());
		result = prime * result + ((estadoNome == null) ? 0 : estadoNome.hashCode());
		result = prime * result + ((estadoSigla == null) ? 0 : estadoSigla.hashCode());
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
		EstadoEntity other = (EstadoEntity) obj;
		if (cidades == null) {
			if (other.cidades != null)
				return false;
		} else if (!cidades.equals(other.cidades))
			return false;
		if (estadoNome == null) {
			if (other.estadoNome != null)
				return false;
		} else if (!estadoNome.equals(other.estadoNome))
			return false;
		if (estadoSigla == null) {
			if (other.estadoSigla != null)
				return false;
		} else if (!estadoSigla.equals(other.estadoSigla))
			return false;
		return true;
	}

}
