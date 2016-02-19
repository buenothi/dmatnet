package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tbl_EmpresaGrupo")
public class EmpresaGrupoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idGrupo;
	private String nomeGrupo;
	private String descricaoGrupo;
	
	@OneToMany(mappedBy="grupo")
	private List<EmpresaEntity> empresas;
	
	private static final long serialVersionUID = 1L;

	public EmpresaGrupoEntity() {
		super();
	}
	
	
	public long getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
	}   
	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}   
	public String getDescricaoGrupo() {
		return this.descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
	}
	
	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}
	
	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}
   
}
