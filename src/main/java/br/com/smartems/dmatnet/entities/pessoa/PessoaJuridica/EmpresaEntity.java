package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.smartems.dmatnet.entities.LocalTrabalho.LocalTrabalhoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Entity
@Table(name = "tbl_Empresa")
@NamedQueries({
		@NamedQuery(name = "Empresa.listarEmpresasPorUsuario", query = "SELECT empresa FROM EmpresaEntity empresa inner join empresa.usuarioCriador usuario WHERE usuario.idPessoa in :idUsuario") })
public class EmpresaEntity extends AbstractPessoaJuridicaEntity implements Serializable {

	private long codESocialEmpresa;

	@ManyToOne
	@JoinColumn(name = "grupo_ID")
	private EmpresaGrupoEntity grupo;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_ID")
	private Set<EmpresaCadastroEntity> cadastros;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_ID")
	private Set<LocalTrabalhoEntity> locais;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_ID")
	private Set<TrabalhadorEntity> trabalhadores;

	@ManyToMany(mappedBy = "empresasGerenciadas", fetch = FetchType.EAGER)
	private List<UsuarioEntity> usuarios;

	@ManyToOne
	@JoinColumn(name = "usuarioCriador_ID")
	private UsuarioEntity usuarioCriador;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaFoto_ID")
	private EmpresaFoto empresaFotoFachada;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaLogotipo_ID")
	private EmpresaLogotipo empresaLogotipo;

	private String tipoEstabelecimento;

	private static final long serialVersionUID = 1L;

	public EmpresaEntity() {
		super();
	}

	public long getCodESocialEmpresa() {
		return this.codESocialEmpresa;
	}

	public void setCodESocialEmpresa(long codESocialEmpresa) {
		this.codESocialEmpresa = codESocialEmpresa;
	}

	public EmpresaGrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(EmpresaGrupoEntity grupo) {
		this.grupo = grupo;
	}

	public Set<EmpresaCadastroEntity> getCadastros() {
		return cadastros;
	}

	public void setCadastros(Set<EmpresaCadastroEntity> cadastros) {
		this.cadastros = cadastros;
	}

	public Set<LocalTrabalhoEntity> getLocais() {
		return locais;
	}

	public void setLocais(Set<LocalTrabalhoEntity> locais) {
		this.locais = locais;
	}

	public Set<TrabalhadorEntity> getTrabalhadores() {
		return trabalhadores;
	}

	public void setTrabalhadores(Set<TrabalhadorEntity> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}

	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioEntity getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(UsuarioEntity usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public EmpresaFoto getEmpresaFotoFachada() {
		return empresaFotoFachada;
	}

	public void setEmpresaFotoFachada(EmpresaFoto empresaFotoFachada) {
		this.empresaFotoFachada = empresaFotoFachada;
	}

	public EmpresaLogotipo getEmpresaLogotipo() {
		return empresaLogotipo;
	}

	public void setEmpresaLogotipo(EmpresaLogotipo empresaLogotipo) {
		this.empresaLogotipo = empresaLogotipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
