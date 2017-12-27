package br.com.smartems.dmatnet.entities.ClassificacaoFuncional;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.LevAmbientais.GHEEntity;
import br.com.smartems.dmatnet.entities.LocalTrabalho.LocalTrabalhoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Funcao;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.Setor;

@Entity
@Table(name = "tbl_ClassificacaoFuncional")
public class ClassificacaoFuncionalEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	private Date dataTermino;

	@OneToOne
	@JoinColumn(name = "local_ID")
	private LocalTrabalhoEntity local;

	@OneToOne
	@JoinColumn(name = "setor_ID")
	private Setor setor;

	@OneToOne
	@JoinColumn(name = "funcao_ID")
	private Funcao funcao;

	@OneToOne
	@JoinColumn(name = "ghe_ID")
	private GHEEntity ghe;

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

	public GHEEntity getGhe() {
		return ghe;
	}

	public void setGhe(GHEEntity ghe) {
		this.ghe = ghe;
	}

	public LocalTrabalhoEntity getLocal() {
		return local;
	}

	public void setLocal(LocalTrabalhoEntity local) {
		this.local = local;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		ClassificacaoFuncionalEntity other = (ClassificacaoFuncionalEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
