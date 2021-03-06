package br.com.smartems.dmatnet.JSF.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.smartems.dmatnet.Service.TrabalhadorServiceLocal;
import br.com.smartems.dmatnet.entities.ClassificacaoFuncional.ClassificacaoFuncionalEntity;
import br.com.smartems.dmatnet.entities.LevAmbientais.GHEEntity;
import br.com.smartems.dmatnet.entities.LocalTrabalho.LocalTrabalhoEntity;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.DeficienciaFisicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.FuncaoEntity;

@Named
@SessionScoped
public class CadastroEmpregadoMB implements Serializable {

	@Inject
	private UsuarioMB usuarioMB;

	@Inject
	private PrincipalMB principalMB;

	@Inject
	private CadastroEmpresaMB cadastroEmpresaMB;

	@EJB
	private TrabalhadorServiceLocal trabalhadorFachada;

	private static final long serialVersionUID = 1L;

	public CadastroEmpregadoMB() {

	}

	private List<TrabalhadorEntity> listaEmpregadosEmpresaSelecionada;

	private String filtroEmpregadosEmpresaSelecionada = "Ativo";

	private String nomeEmpregadoProcurado;

	private boolean mensagemSelecionarEmpregado;
	private boolean mensagemHasEmpregado;
	private boolean exibirDadosCadastraisEmpregadoBloco;
	private boolean exibirDadosCadastraisEmpregado = true;

	private TrabalhadorEntity trabalhadorSelecionado;
	private TrabalhadorCadastroEntity trabalhadorSelecionadoCadastroAtual;
	private List<TrabalhadorCadastroEntity> trabalhadorSelecionadoListaCadastroHistorico;

	private boolean isDisabledCancelar;
	private boolean isDisabledEditar;
	private boolean isDisabledImprimir;
	private boolean isDisabledNovo;
	private boolean isDisabledSalvar;

	private boolean isEditarDadosCadastrais;
	private boolean isExibirDadosCadastrais;

	private PessoaFisicaDocumentosEntity trabalhadorDocumentos;

	private boolean isDadosUsuarioCTPS;
	private boolean isDadosUsuarioCNH;
	private boolean isDadosUsuarioCPF;
	private boolean isDadosUsuarioNIS;
	private boolean isDadosUsuarioRG;
	private boolean isDadosUsuarioRIC;
	private boolean isDadosUsuarioRNE;

	private boolean isExibirFormEditar;
	private boolean isEditarFormEditar;

	private boolean hasCNH;
	private boolean hasCTPS;
	private boolean hasCPF;
	private boolean hasNIS;
	private boolean hasRG;
	private boolean hasRIC;
	private boolean hasRNE;

	private boolean isMensagemSelecionarTrabalhadorRendered;

	private boolean enderecoRendered;

	private EnderecoEntity enderecoAtual;

	private List<EnderecoEntity> enderecoHistorico;

	private boolean hasEndereco;
	private boolean hasPessoaSelecionada;

	private boolean desativarCancelarEndereco;

	private boolean isEmailRendered;
	private boolean isTelefoneRendered;

	private boolean hasEmail;
	private boolean hasTelefone;

	private boolean isEditarContato;
	private boolean isExibirContato;

	private EmailEntity emailPrincipal;
	private List<EmailEntity> emailsTrabalhadores;
	private TelefoneEntity telefonePrincipal;
	private List<TelefoneEntity> telefonesTrabalhadores;

	private boolean disabledBotaoAddEmail;
	private boolean disabledBotaoNovoEmail;

	private boolean isEditarClassFuncionalRendered;
	private boolean hasClassFuncional;
	private boolean classFuncionalBlocoRendered;

	private List<ClassificacaoFuncionalEntity> classificacoesFuncionais;
	private List<FuncaoEntity> funcoes;
	private List<GHEEntity> ghes;
	private List<LocalTrabalhoEntity> locais;

	private ClassificacaoFuncionalEntity novaClassificacaoFuncional;

	private DeficienciaFisicaEntity deficienciaFisica;
	private boolean hasDeficienciaFisica;

	/* getters e setter */

	public PrincipalMB getPrincipalMB() {
		return principalMB;
	}

	public void setPrincipalMB(PrincipalMB principalMB) {
		this.principalMB = principalMB;
	}

	public CadastroEmpresaMB getCadastroEmpresaMB() {
		return cadastroEmpresaMB;
	}

	public void setCadastroEmpresaMB(CadastroEmpresaMB cadastroEmpresaMB) {
		this.cadastroEmpresaMB = cadastroEmpresaMB;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<TrabalhadorEntity> getListaEmpregadosEmpresaSelecionada() {
		if (this.listaEmpregadosEmpresaSelecionada == null) {
			this.listaEmpregadosEmpresaSelecionada = new ArrayList<TrabalhadorEntity>();
		}
		return listaEmpregadosEmpresaSelecionada;
	}

	public void setListaEmpregadosEmpresaSelecionada(List<TrabalhadorEntity> listaEmpregadosEmpresaSelecionada) {
		this.listaEmpregadosEmpresaSelecionada = listaEmpregadosEmpresaSelecionada;
	}

	public String getFiltroEmpregadosEmpresaSelecionada() {
		return filtroEmpregadosEmpresaSelecionada;
	}

	public void setFiltroEmpregadosEmpresaSelecionada(String filtroEmpregadosEmpresaSelecionada) {
		this.filtroEmpregadosEmpresaSelecionada = filtroEmpregadosEmpresaSelecionada;
	}

	public boolean isExibirDadosCadastraisEmpregado() {
		return exibirDadosCadastraisEmpregado;
	}

	public void setExibirDadosCadastraisEmpregado(boolean exibirDadosCadastraisEmpregado) {
		this.exibirDadosCadastraisEmpregado = exibirDadosCadastraisEmpregado;
	}

	public String getNomeEmpregadoProcurado() {
		return nomeEmpregadoProcurado;
	}

	public void setNomeEmpregadoProcurado(String nomeEmpregadoProcurado) {
		this.nomeEmpregadoProcurado = nomeEmpregadoProcurado;
	}

	public boolean isMensagemSelecionarEmpregado() {
		return mensagemSelecionarEmpregado;
	}

	public void setMensagemSelecionarEmpregado(boolean mensagemSelecionarEmpregado) {
		this.mensagemSelecionarEmpregado = mensagemSelecionarEmpregado;
	}

	public boolean isMensagemHasEmpregado() {
		return mensagemHasEmpregado;
	}

	public void setMensagemHasEmpregado(boolean mensagemHasEmpregado) {
		this.mensagemHasEmpregado = mensagemHasEmpregado;
	}

	public boolean isExibirDadosCadastraisEmpregadoBloco() {
		return exibirDadosCadastraisEmpregadoBloco;
	}

	public void setExibirDadosCadastraisEmpregadoBloco(boolean exibirDadosCadastraisEmpregadoBloco) {
		this.exibirDadosCadastraisEmpregadoBloco = exibirDadosCadastraisEmpregadoBloco;
	}

	public TrabalhadorEntity getTrabalhadorSelecionado() {
		if (this.trabalhadorSelecionado == null) {
			this.trabalhadorSelecionado = new TrabalhadorEntity();
		}
		return trabalhadorSelecionado;
	}

	public void setTrabalhadorSelecionado(TrabalhadorEntity trabalhadorSelecionado) {
		this.trabalhadorSelecionado = trabalhadorSelecionado;
	}

	public TrabalhadorCadastroEntity getTrabalhadorSelecionadoCadastroAtual() {
		if (this.trabalhadorSelecionadoCadastroAtual == null) {
			this.trabalhadorSelecionadoCadastroAtual = new TrabalhadorCadastroEntity();
		}
		return trabalhadorSelecionadoCadastroAtual;
	}

	public void setTrabalhadorSelecionadoCadastroAtual(TrabalhadorCadastroEntity trabalhadorSelecionadoCadastroAtual) {
		this.trabalhadorSelecionadoCadastroAtual = trabalhadorSelecionadoCadastroAtual;
	}

	public List<TrabalhadorCadastroEntity> getTrabalhadorSelecionadoListaCadastroHistorico() {
		if (this.trabalhadorSelecionadoListaCadastroHistorico == null) {
			trabalhadorSelecionadoListaCadastroHistorico = new ArrayList<TrabalhadorCadastroEntity>();
		}
		return trabalhadorSelecionadoListaCadastroHistorico;
	}

	public void setTrabalhadorSelecionadoListaCadastroHistorico(
			List<TrabalhadorCadastroEntity> trabalhadorSelecionadoListaCadastroHistorico) {
		this.trabalhadorSelecionadoListaCadastroHistorico = trabalhadorSelecionadoListaCadastroHistorico;
	}

	public boolean isDisabledCancelar() {
		return isDisabledCancelar;
	}

	public void setDisabledCancelar(boolean isDisabledCancelar) {
		this.isDisabledCancelar = isDisabledCancelar;
	}

	public boolean isDisabledEditar() {
		return isDisabledEditar;
	}

	public void setDisabledEditar(boolean isDisabledEditar) {
		this.isDisabledEditar = isDisabledEditar;
	}

	public boolean isDisabledImprimir() {
		return isDisabledImprimir;
	}

	public void setDisabledImprimir(boolean isDisabledImprimir) {
		this.isDisabledImprimir = isDisabledImprimir;
	}

	public boolean isDisabledNovo() {
		return isDisabledNovo;
	}

	public void setDisabledNovo(boolean isDisabledNovo) {
		this.isDisabledNovo = isDisabledNovo;
	}

	public boolean isDisabledSalvar() {
		return isDisabledSalvar;
	}

	public void setDisabledSalvar(boolean isDisabledSalvar) {
		this.isDisabledSalvar = isDisabledSalvar;
	}

	public boolean isEditarDadosCadastrais() {
		return isEditarDadosCadastrais;
	}

	public void setEditarDadosCadastrais(boolean isEditarDadosCadastrais) {
		this.isEditarDadosCadastrais = isEditarDadosCadastrais;
	}

	public boolean isExibirDadosCadastrais() {
		return isExibirDadosCadastrais;
	}

	public void setExibirDadosCadastrais(boolean isExibirDadosCadastrais) {
		this.isExibirDadosCadastrais = isExibirDadosCadastrais;
	}

	public PessoaFisicaDocumentosEntity getTrabalhadorDocumentos() {
		if (this.trabalhadorDocumentos == null) {
			this.trabalhadorDocumentos = new PessoaFisicaDocumentosEntity();
		}
		return trabalhadorDocumentos;
	}

	public void setTrabalhadorDocumentos(PessoaFisicaDocumentosEntity trabalhadorDocumentos) {
		this.trabalhadorDocumentos = trabalhadorDocumentos;
	}

	public boolean isDadosUsuarioCTPS() {
		return isDadosUsuarioCTPS;
	}

	public void setDadosUsuarioCTPS(boolean isDadosUsuarioCTPS) {
		this.isDadosUsuarioCTPS = isDadosUsuarioCTPS;
	}

	public boolean isDadosUsuarioCNH() {
		return isDadosUsuarioCNH;
	}

	public void setDadosUsuarioCNH(boolean isDadosUsuarioCNH) {
		this.isDadosUsuarioCNH = isDadosUsuarioCNH;
	}

	public boolean isDadosUsuarioCPF() {
		return isDadosUsuarioCPF;
	}

	public void setDadosUsuarioCPF(boolean isDadosUsuarioCPF) {
		this.isDadosUsuarioCPF = isDadosUsuarioCPF;
	}

	public boolean isDadosUsuarioNIS() {
		return isDadosUsuarioNIS;
	}

	public void setDadosUsuarioNIS(boolean isDadosUsuarioNIS) {
		this.isDadosUsuarioNIS = isDadosUsuarioNIS;
	}

	public boolean isDadosUsuarioRG() {
		return isDadosUsuarioRG;
	}

	public void setDadosUsuarioRG(boolean isDadosUsuarioRG) {
		this.isDadosUsuarioRG = isDadosUsuarioRG;
	}

	public boolean isDadosUsuarioRIC() {
		return isDadosUsuarioRIC;
	}

	public void setDadosUsuarioRIC(boolean isDadosUsuarioRIC) {
		this.isDadosUsuarioRIC = isDadosUsuarioRIC;
	}

	public boolean isDadosUsuarioRNE() {
		return isDadosUsuarioRNE;
	}

	public void setDadosUsuarioRNE(boolean isDadosUsuarioRNE) {
		this.isDadosUsuarioRNE = isDadosUsuarioRNE;
	}

	public boolean isExibirFormEditar() {
		return isExibirFormEditar;
	}

	public void setExibirFormEditar(boolean isExibirFormEditar) {
		this.isExibirFormEditar = isExibirFormEditar;
	}

	public boolean isEditarFormEditar() {
		return isEditarFormEditar;
	}

	public void setEditarFormEditar(boolean isEditarFormEditar) {
		this.isEditarFormEditar = isEditarFormEditar;
	}

	public boolean isHasCNH() {
		return hasCNH;
	}

	public void setHasCNH(boolean hasCNH) {
		this.hasCNH = hasCNH;
	}

	public boolean isHasCTPS() {
		return hasCTPS;
	}

	public void setHasCTPS(boolean hasCTPS) {
		this.hasCTPS = hasCTPS;
	}

	public boolean isHasCPF() {
		return hasCPF;
	}

	public void setHasCPF(boolean hasCPF) {
		this.hasCPF = hasCPF;
	}

	public boolean isHasNIS() {
		return hasNIS;
	}

	public void setHasNIS(boolean hasNIS) {
		this.hasNIS = hasNIS;
	}

	public boolean isHasRG() {
		return hasRG;
	}

	public void setHasRG(boolean hasRG) {
		this.hasRG = hasRG;
	}

	public boolean isHasRIC() {
		return hasRIC;
	}

	public void setHasRIC(boolean hasRIC) {
		this.hasRIC = hasRIC;
	}

	public boolean isHasRNE() {
		return hasRNE;
	}

	public void setHasRNE(boolean hasRNE) {
		this.hasRNE = hasRNE;
	}

	public boolean isMensagemSelecionarTrabalhadorRendered() {
		return isMensagemSelecionarTrabalhadorRendered;
	}

	public void setMensagemSelecionarTrabalhadorRendered(boolean isMensagemSelecionarTrabalhadorRendered) {
		this.isMensagemSelecionarTrabalhadorRendered = isMensagemSelecionarTrabalhadorRendered;
	}

	public boolean isEnderecoRendered() {
		return enderecoRendered;
	}

	public void setEnderecoRendered(boolean enderecoRendered) {
		this.enderecoRendered = enderecoRendered;
	}

	public EnderecoEntity getEnderecoAtual() {
		if (this.enderecoAtual == null) {
			this.enderecoAtual = new EnderecoEntity();
		}
		return enderecoAtual;
	}

	public void setEnderecoAtual(EnderecoEntity enderecoAtual) {
		this.enderecoAtual = enderecoAtual;
	}

	public List<EnderecoEntity> getEnderecoHistorico() {
		if (this.enderecoHistorico == null) {
			this.enderecoHistorico = new ArrayList<EnderecoEntity>();
		}
		return enderecoHistorico;
	}

	public void setEnderecoHistorico(List<EnderecoEntity> enderecoHistorico) {
		this.enderecoHistorico = enderecoHistorico;
	}

	public boolean isHasEndereco() {
		return hasEndereco;
	}

	public void setHasEndereco(boolean hasEndereco) {
		this.hasEndereco = hasEndereco;
	}

	public boolean isHasPessoaSelecionada() {
		return hasPessoaSelecionada;
	}

	public void setHasPessoaSelecionada(boolean hasPessoaSelecionada) {
		this.hasPessoaSelecionada = hasPessoaSelecionada;
	}

	public boolean isDesativarCancelarEndereco() {
		return desativarCancelarEndereco;
	}

	public void setDesativarCancelarEndereco(boolean desativarCancelarEndereco) {
		this.desativarCancelarEndereco = desativarCancelarEndereco;
	}

	public boolean isEmailRendered() {
		return isEmailRendered;
	}

	public void setEmailRendered(boolean isEmailRendered) {
		this.isEmailRendered = isEmailRendered;
	}

	public boolean isTelefoneRendered() {
		return isTelefoneRendered;
	}

	public void setTelefoneRendered(boolean isTelefoneRendered) {
		this.isTelefoneRendered = isTelefoneRendered;
	}

	public boolean isHasEmail() {
		return hasEmail;
	}

	public void setHasEmail(boolean hasEmail) {
		this.hasEmail = hasEmail;
	}

	public boolean isHasTelefone() {
		return hasTelefone;
	}

	public void setHasTelefone(boolean hasTelefone) {
		this.hasTelefone = hasTelefone;
	}

	public boolean isEditarContato() {
		return isEditarContato;
	}

	public void setEditarContato(boolean isEditarContato) {
		this.isEditarContato = isEditarContato;
	}

	public boolean isExibirContato() {
		return isExibirContato;
	}

	public void setExibirContato(boolean isExibirContato) {
		this.isExibirContato = isExibirContato;
	}

	public EmailEntity getEmailPrincipal() {
		if (this.emailPrincipal == null) {
			this.emailPrincipal = new EmailEntity();
		}
		return emailPrincipal;
	}

	public void setEmailPrincipal(EmailEntity emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}

	public List<EmailEntity> getEmailsTrabalhadores() {
		if (this.emailsTrabalhadores == null) {
			this.emailsTrabalhadores = new ArrayList<EmailEntity>();
		}
		return emailsTrabalhadores;
	}

	public void setEmailsTrabalhadores(List<EmailEntity> emailsTrabalhadores) {
		this.emailsTrabalhadores = emailsTrabalhadores;
	}

	public TelefoneEntity getTelefonePrincipal() {
		if (this.telefonePrincipal == null) {
			this.telefonePrincipal = new TelefoneEntity();
		}
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(TelefoneEntity telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public List<TelefoneEntity> getTelefonesTrabalhadores() {
		if (this.telefonesTrabalhadores == null) {
			this.telefonesTrabalhadores = new ArrayList<TelefoneEntity>();
		}
		return telefonesTrabalhadores;
	}

	public void setTelefonesTrabalhadores(List<TelefoneEntity> telefonesTrabalhadores) {
		this.telefonesTrabalhadores = telefonesTrabalhadores;
	}

	public boolean isDisabledBotaoAddEmail() {
		return disabledBotaoAddEmail;
	}

	public void setDisabledBotaoAddEmail(boolean disabledBotaoAddEmail) {
		this.disabledBotaoAddEmail = disabledBotaoAddEmail;
	}

	public boolean isDisabledBotaoNovoEmail() {
		return disabledBotaoNovoEmail;
	}

	public void setDisabledBotaoNovoEmail(boolean disabledBotaoNovoEmail) {
		this.disabledBotaoNovoEmail = disabledBotaoNovoEmail;
	}

	public boolean isEditarClassFuncionalRendered() {
		return isEditarClassFuncionalRendered;
	}

	public void setEditarClassFuncionalRendered(boolean isEditarClassFuncionalRendered) {
		this.isEditarClassFuncionalRendered = isEditarClassFuncionalRendered;
	}

	public boolean isHasClassFuncional() {
		return hasClassFuncional;
	}

	public void setHasClassFuncional(boolean hasClassFuncional) {
		this.hasClassFuncional = hasClassFuncional;
	}

	public boolean isClassFuncionalBlocoRendered() {
		return classFuncionalBlocoRendered;
	}

	public void setClassFuncionalBlocoRendered(boolean classFuncionalBlocoRendered) {
		this.classFuncionalBlocoRendered = classFuncionalBlocoRendered;
	}

	public List<ClassificacaoFuncionalEntity> getClassificacoesFuncionais() {
		if (this.classificacoesFuncionais == null) {
			this.classificacoesFuncionais = new ArrayList<ClassificacaoFuncionalEntity>();
		}
		return classificacoesFuncionais;
	}

	public void setClassificacoesFuncionais(List<ClassificacaoFuncionalEntity> classificacoesFuncionais) {
		this.classificacoesFuncionais = classificacoesFuncionais;
	}

	public List<FuncaoEntity> getFuncoes() {
		if (this.funcoes == null) {
			this.funcoes = new ArrayList<FuncaoEntity>();
		}
		return funcoes;
	}

	public void setFuncoes(List<FuncaoEntity> funcoes) {
		this.funcoes = funcoes;
	}

	public List<GHEEntity> getGhes() {
		return ghes;
	}

	public void setGhes(List<GHEEntity> ghes) {
		if (this.ghes == null) {
			this.ghes = new ArrayList<GHEEntity>();
		}
		this.ghes = ghes;
	}

	public List<LocalTrabalhoEntity> getLocais() {
		if (this.locais == null) {
			this.locais = new ArrayList<LocalTrabalhoEntity>();
		}
		return locais;
	}

	public void setLocais(List<LocalTrabalhoEntity> locais) {
		this.locais = locais;
	}

	public ClassificacaoFuncionalEntity getNovaClassificacaoFuncional() {
		if (this.novaClassificacaoFuncional == null) {
			this.novaClassificacaoFuncional = new ClassificacaoFuncionalEntity();
		}
		return novaClassificacaoFuncional;
	}

	public void setNovaClassificacaoFuncional(ClassificacaoFuncionalEntity novaClassificacaoFuncional) {
		this.novaClassificacaoFuncional = novaClassificacaoFuncional;
	}

	public DeficienciaFisicaEntity getDeficienciaFisica() {
		if (this.deficienciaFisica == null) {
			this.deficienciaFisica = new DeficienciaFisicaEntity();
		}
		return deficienciaFisica;
	}

	public void setDeficienciaFisica(DeficienciaFisicaEntity deficienciaFisica) {
		this.deficienciaFisica = deficienciaFisica;
	}

	public boolean isHasDeficienciaFisica() {
		return hasDeficienciaFisica;
	}

	public void setHasDeficienciaFisica(boolean hasDeficienciaFisica) {
		this.hasDeficienciaFisica = hasDeficienciaFisica;
	}

	public void mudarTipoFiltroListaEmpregados(AjaxBehaviorEvent evt) {

		// teste abaixo ok
		System.out.println(this.filtroEmpregadosEmpresaSelecionada.toString());
	}

	public void filtrarEmpregados(ActionEvent evt) {

	}

	public void removerFiltroEmpresa(ActionEvent evt) {
		this.initEmpregado();
		this.nomeEmpregadoProcurado = null;
		this.listaEmpregadosEmpresaSelecionada = null;
	}

	public void editarTrabalhadorSelecionado(ActionEvent evt) {
		this.isDisabledCancelar = false;
		this.isDisabledEditar = true;
		this.isDisabledImprimir = true;
		this.isDisabledNovo = true;
		this.isDisabledSalvar = false;

		this.mensagemHasEmpregado = false;
		this.exibirDadosCadastraisEmpregadoBloco = true;
		this.mensagemSelecionarEmpregado = false;
		this.exibirDadosCadastraisEmpregado = true;

		this.exibirDadosCadastraisEmpregadoBloco = true;

		this.isEditarDadosCadastrais = true;
		this.isExibirDadosCadastrais = false;

		this.hasCNH = false;
		this.hasCTPS = false;
		this.hasCPF = false;
		this.hasNIS = false;
		this.hasRG = false;
		this.hasRIC = false;
		this.hasRNE = false;

		this.isDadosUsuarioCTPS = true;
		this.isDadosUsuarioCNH = true;
		this.isDadosUsuarioCPF = true;
		this.isDadosUsuarioNIS = true;
		this.isDadosUsuarioRG = true;
		this.isDadosUsuarioRIC = true;
		this.isDadosUsuarioRNE = true;

		this.isExibirFormEditar = false;
		this.isEditarFormEditar = true;

		this.isMensagemSelecionarTrabalhadorRendered = false;

		this.enderecoRendered = true;
		this.hasEndereco = false;
		this.hasPessoaSelecionada = false;
		this.desativarCancelarEndereco = true;

		this.isMensagemSelecionarTrabalhadorRendered = false;

		this.isEmailRendered = true;
		this.isTelefoneRendered = true;

		this.isEditarContato = true;
		this.isExibirContato = false;

		this.hasClassFuncional = false;
		this.classFuncionalBlocoRendered = true;

		this.isEditarClassFuncionalRendered = true;

	}

	public void cancelarTrabalhadorSelecionado(ActionEvent evt) {
		this.initEmpregado();
	}

	public void salvarTrabalhadorSelecionado(ActionEvent evt) {
		try {
			this.trabalhadorFachada.salvarNovoTrabalhador(this.usuarioMB.getUsuarioLogado(),
					this.cadastroEmpresaMB.getEmpresaSelecionada(), this.trabalhadorSelecionado,
					this.trabalhadorSelecionadoCadastroAtual, this.trabalhadorSelecionadoListaCadastroHistorico,
					this.trabalhadorDocumentos, this.enderecoAtual, this.enderecoHistorico, this.emailPrincipal,
					this.emailsTrabalhadores, this.telefonePrincipal, this.telefonesTrabalhadores, this.deficienciaFisica);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.initEmpregado();
	}

	public void novoTrabalhadorSelecionado(ActionEvent evt) {
		this.editarTrabalhadorSelecionado(evt);
		this.trabalhadorSelecionado = new TrabalhadorEntity();
		this.trabalhadorDocumentos = new PessoaFisicaDocumentosEntity();
		this.trabalhadorSelecionadoCadastroAtual = new TrabalhadorCadastroEntity();
		this.enderecoAtual = new EnderecoEntity();
		this.enderecoHistorico = new ArrayList<EnderecoEntity>();
		this.emailPrincipal = new EmailEntity();
		this.emailsTrabalhadores = new ArrayList<EmailEntity>();
		this.telefonesTrabalhadores = new ArrayList<TelefoneEntity>();
		this.novaClassificacaoFuncional = new ClassificacaoFuncionalEntity();
		this.locais = new ArrayList<LocalTrabalhoEntity>();
		this.classificacoesFuncionais = new ArrayList<ClassificacaoFuncionalEntity>();
		this.funcoes = new ArrayList<FuncaoEntity>();
		this.ghes = new ArrayList<GHEEntity>();
		this.deficienciaFisica = new DeficienciaFisicaEntity();
	}

	public void imprimirTrabalhadorSelecionado(ActionEvent evt) {

	}

	public void excluirTrabalhadorSelecionado(ActionEvent evt) {

	}

	public void onSelectionEmpregado(Object obj) {
		try {
			if (obj instanceof SelectEvent) {
				SelectEvent evt = (SelectEvent) obj;
				this.trabalhadorSelecionado = (TrabalhadorEntity) evt.getObject();
				this.exibirDadosCadastraisEmpregado = true;
			} else if (obj instanceof TrabalhadorEntity) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adicionarEmailEmpregado(ActionEvent evt) {
		this.emailsTrabalhadores.add(emailPrincipal);
		this.emailPrincipal = new EmailEntity();
		this.disabledBotaoAddEmail = true;
		this.disabledBotaoNovoEmail = false;
	}

	public void novoEmailEmpregado(ActionEvent evt) {
		this.emailPrincipal = new EmailEntity();
		this.disabledBotaoAddEmail = false;
		this.disabledBotaoNovoEmail = true;
	}

	public void removerEmailLista(ActionEvent evt) {

	}

	public void adicionarTelefoneEmpregado(ActionEvent evt) {
		this.telefonesTrabalhadores.add(telefonePrincipal);
	}

	public void removerTelefoneLista(ActionEvent evt) {

	}

	public void adicionarClassFuncional(ActionEvent evt) {

	}

	public void cancelarClassFuncional(ActionEvent evt) {

	}

	public void removerClassFuncionalLista(ActionEvent evt) {

	}

	@PostConstruct
	public void initEmpregado() {
		this.listaEmpregadosEmpresaSelecionada = null;
		this.filtroEmpregadosEmpresaSelecionada = "Ativo";
		this.nomeEmpregadoProcurado = null;
		this.mensagemHasEmpregado = false;
		this.exibirDadosCadastraisEmpregadoBloco = true;
		this.mensagemSelecionarEmpregado = true;
		this.exibirDadosCadastraisEmpregado = false;
		this.trabalhadorSelecionado = null;
		this.trabalhadorSelecionadoCadastroAtual = null;
		this.trabalhadorSelecionadoListaCadastroHistorico = null;

		this.isDisabledCancelar = true;
		this.isDisabledEditar = false;
		this.isDisabledImprimir = false;
		this.isDisabledNovo = false;
		this.isDisabledSalvar = true;

		this.exibirDadosCadastraisEmpregadoBloco = false;

		this.isEditarDadosCadastrais = false;
		this.isExibirDadosCadastrais = false;

		this.trabalhadorDocumentos = null;

		this.isDadosUsuarioCTPS = false;
		this.isDadosUsuarioCNH = false;
		this.isDadosUsuarioCPF = false;
		this.isDadosUsuarioNIS = false;
		this.isDadosUsuarioRG = false;
		this.isDadosUsuarioRIC = false;
		this.isDadosUsuarioRNE = false;

		this.isExibirFormEditar = false;
		this.isEditarFormEditar = false;

		this.hasCNH = false;
		this.hasCTPS = false;
		this.hasCPF = false;
		this.hasNIS = false;
		this.hasRG = false;
		this.hasRIC = false;
		this.hasRNE = false;

		this.isMensagemSelecionarTrabalhadorRendered = true;

		this.enderecoRendered = false;
		this.enderecoAtual = null;
		this.enderecoHistorico = null;
		this.hasEndereco = false;
		this.hasPessoaSelecionada = true;
		this.desativarCancelarEndereco = true;

		this.isEmailRendered = false;
		this.isTelefoneRendered = false;

		this.isMensagemSelecionarTrabalhadorRendered = true;

		this.hasEmail = false;
		this.hasTelefone = false;

		this.isEditarContato = false;
		this.isExibirContato = false;

		this.emailPrincipal = null;
		this.emailsTrabalhadores = null;
		this.telefonePrincipal = null;
		this.telefonesTrabalhadores = null;

		this.disabledBotaoAddEmail = true;
		this.disabledBotaoNovoEmail = false;

		this.isEditarClassFuncionalRendered = false;
		this.hasClassFuncional = false;
		this.classFuncionalBlocoRendered = false;

		this.classificacoesFuncionais = null;
		this.funcoes = null;
		this.ghes = null;
		this.locais = null;
		this.novaClassificacaoFuncional = null;
		this.deficienciaFisica = null;

	}

}
