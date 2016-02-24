package br.com.smartems.dmatnet.entities.ClassificacaoFuncional;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.LevAmbientais.GHE;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Funcao;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Setor;

@Entity
@Table(name="tbl_ClassificacaoFuncional")
public class ClassificacaoFuncionalEntity implements Serializable {

	@Id
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	
	@OneToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="setor_ID")
	private Setor setor;
	
	@OneToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="funcao_ID")
	private Funcao funcao;
	
	@OneToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="ghe_ID")
	private GHE ghe;
	
	private static final long serialVersionUID = 1L;

	public ClassificacaoFuncionalEntity() {
		super();
	}   
	
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public GHE getGhe() {
		return ghe;
	}

	public void setGhe(GHE ghe) {
		this.ghe = ghe;
	}

}