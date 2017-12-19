package br.com.smartems.dmatnet.EJB.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaDadosIsencao;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFAP;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaLogotipo;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaOrganismoInternacional;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaSoftwareHouse;
import br.com.smartems.dmatnet.util.ReportUtil;
import br.com.smartems.dmatnet.util.filtrosCollection.Filter;
import br.com.smartems.dmatnet.util.filtrosCollection.FiltroEmpresa;

@Stateless
@Local
public class PessoaJuridicaEAO extends AbstractEAO<EmpresaEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public PessoaJuridicaEAO() {
		super(EmpresaEntity.class);
	}

	@EJB
	private ReportUtil reportUtil;

	@SuppressWarnings("unchecked")
	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado) throws NoResultException {
		Query query = entityManager.createNamedQuery("Empresa.listarEmpresasPorUsuario", EmpresaEntity.class);
		query.setParameter("idUsuario", usuarioLogado.getIdPessoa());
		return (List<EmpresaEntity>) query.getResultList();
	}

	// Empresa

	public void salvarNovoCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			EmpresaLogotipo empresaLogotipo, UsuarioEntity usuarioLogado) {
		try {
			if (empresa.getIdPessoa() == 0) {
				empresa.setUsuarioCriador(usuarioLogado);
				if (fotografiaFachada != null) {
					empresa.setEmpresaFotoFachada(fotografiaFachada);
				}
				if (empresaLogotipo != null) {
					empresa.setEmpresaLogotipo(empresaLogotipo);
				}
				this.create(empresa);
				empresa = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarCadastroEmpresa(EmpresaEntity empresa, UsuarioEntity usuarioLogado, EmpresaFAP fap,
			EmpresaDadosIsencao empresaDadosIsencao, EmpresaOrganismoInternacional empresaOrgI8n,
			List<EmpresaSoftwareHouse> empresasSoftware, EmpresaCadastroEntity dadosCadastraisAtual) {
		empresa.setUsuarioCriador(usuarioLogado);
		this.atribuirEmpresaFAP(fap, dadosCadastraisAtual);
		this.atribuirEmpresaDadosIsencao(empresaDadosIsencao, dadosCadastraisAtual);
		this.atribuirEmpresaOrgI8n(empresaOrgI8n, dadosCadastraisAtual);
		this.atribuirEmpresaSoftware(empresasSoftware, dadosCadastraisAtual);
		this.update(empresa);
	}

	private void atribuirEmpresaFAP(EmpresaFAP empresaFap, EmpresaCadastroEntity dadosCadastraisAtual) {
		if (empresaFap != null) {
			EmpresaFAP novoFap = new EmpresaFAP();
			try {
				novoFap = empresaFap.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			novoFap.setIdEmpresaFAP(0);
			dadosCadastraisAtual.setEmpresaFAP(novoFap);
		}

	}

	private EmpresaFAP retornarEmpresaFAP(EmpresaFAP empresaFap) throws CloneNotSupportedException {
		EmpresaFAP novoFap = new EmpresaFAP();
		if (empresaFap != null) {
			novoFap = empresaFap.clone();
			novoFap.setIdEmpresaFAP(0);
		}
		return novoFap;
	}

	private void atribuirEmpresaDadosIsencao(EmpresaDadosIsencao empresaDadosIsencao,
			EmpresaCadastroEntity dadosCadastraisAtual) {
		if (empresaDadosIsencao != null) {
			EmpresaDadosIsencao novoEmpresaDadosIsencao = new EmpresaDadosIsencao();
			try {
				novoEmpresaDadosIsencao = empresaDadosIsencao.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			novoEmpresaDadosIsencao.setIdEmpresaDadosIsencao(0);
			dadosCadastraisAtual.setEmpresaDadosIsencao(novoEmpresaDadosIsencao);
		}
	}

	private EmpresaDadosIsencao retornarEmpresaDadosIsencao(EmpresaDadosIsencao empresaDadosIsencao)
			throws CloneNotSupportedException {
		EmpresaDadosIsencao novoDadosIsencao = new EmpresaDadosIsencao();
		if (empresaDadosIsencao != null) {
			novoDadosIsencao = empresaDadosIsencao.clone();
			novoDadosIsencao.setIdEmpresaDadosIsencao(0);
		}
		return novoDadosIsencao;
	}
	
	private void atribuirEmpresaOrgI8n(EmpresaOrganismoInternacional empresaOrgI8n,
			EmpresaCadastroEntity dadosCadastraisAtual) {
		if (empresaOrgI8n != null) {
			EmpresaOrganismoInternacional novoEmpresaOrgI8n = new EmpresaOrganismoInternacional();
			try {
				novoEmpresaOrgI8n = empresaOrgI8n.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			novoEmpresaOrgI8n.setIdEmpresaOrgInternacional(0);
			dadosCadastraisAtual.setOrganismoInternacional(novoEmpresaOrgI8n);
		}
	}

	private EmpresaOrganismoInternacional retornarEmpresaOrgI8n(EmpresaOrganismoInternacional empresaOrgI8n)
			throws CloneNotSupportedException {
		EmpresaOrganismoInternacional novoOrgI8n = new EmpresaOrganismoInternacional();
		if (empresaOrgI8n != null) {
			novoOrgI8n = empresaOrgI8n.clone();
			novoOrgI8n.setIdEmpresaOrgInternacional(0);
		}
		return novoOrgI8n;
	}

	private void atribuirEmpresaSoftware(List<EmpresaSoftwareHouse> empresasSoftware,
			EmpresaCadastroEntity dadosCadastraisAtual) {
		if (empresasSoftware != null) {
			List<EmpresaSoftwareHouse> novoEmpresasSoftware = new ArrayList<>(empresasSoftware);
			try {
				novoEmpresasSoftware = empresasSoftware;
			} catch (Exception e) {
				e.printStackTrace();
			}
			dadosCadastraisAtual.setEmpresaSoftwareHouse(novoEmpresasSoftware);
		}
	}

	public void excluirCadastroEmpresa(EmpresaEntity empresa) throws NullPointerException {
		EmpresaEntity empresaDeletada = this.read(empresa.getIdPessoa());
		this.delete(empresaDeletada);
	}

	public List<EmpresaEntity> filtrarEmpresas(String nomeEmpresaProcurada, List<EmpresaEntity> empresasDisponiveis)
			throws NullPointerException {
		Filter<EmpresaEntity> filtroEmpresa = new FiltroEmpresa();
		List<EmpresaEntity> empresasFiltradas = new ArrayList<EmpresaEntity>();
		if (nomeEmpresaProcurada != null) {
			for (EmpresaEntity empresa : empresasDisponiveis)
				if (filtroEmpresa.match(empresa, nomeEmpresaProcurada))
					empresasFiltradas.add(empresa);
		}
		return empresasFiltradas;
	}

	// regras de negócio de Dados Cadastrais

	public void salvarDadosCadastraisEmpresa(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaCadastroEntity dadosCadastraisAnterior, EmpresaFAP empresaFap,
			EmpresaDadosIsencao empresaDadosIsencao, EmpresaOrganismoInternacional empresaOrgI8n,
			List<EmpresaSoftwareHouse> empresasSoftwareHouse, EmpresaEntity empresaSelecionada) throws Exception {
		if (dadosCadastraisAtual.getId() == 0) {
			EmpresaEntity novaEmpresaSelecionada = this.read(empresaSelecionada.getIdPessoa());
			for (EmpresaCadastroEntity dadoCadastral : novaEmpresaSelecionada.getCadastros()) {
				if (dadoCadastral.getId() == dadosCadastraisAnterior.getId()) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(dadosCadastraisAtual.getDataInicioCadastro());
					calendar.add(Calendar.DAY_OF_MONTH, -1);
					if (calendar.getTime().compareTo(dadoCadastral.getDataInicioCadastro()) <= 0) {
						dadoCadastral.setDataFimCadastro(dadoCadastral.getDataInicioCadastro());
					} else {
						dadoCadastral.setDataFimCadastro(calendar.getTime());
					}
				}
			}
			dadosCadastraisAtual.setEmpresaFAP(this.retornarEmpresaFAP(empresaFap));
			dadosCadastraisAtual.setEmpresaDadosIsencao(this.retornarEmpresaDadosIsencao(empresaDadosIsencao));
			dadosCadastraisAtual.setOrganismoInternacional(this.retornarEmpresaOrgI8n(empresaOrgI8n));
			dadosCadastraisAtual.setEmpresaSoftwareHouse(empresasSoftwareHouse);
			novaEmpresaSelecionada.getCadastros().add(dadosCadastraisAtual);
			this.update(novaEmpresaSelecionada);
		} else {
			dadosCadastraisAtual.setEmpresaSoftwareHouse(empresasSoftwareHouse);
			empresaSelecionada.getCadastros().add(dadosCadastraisAtual);
			empresaSelecionada = this.update(empresaSelecionada);
		}
	}

	public void imprimirDadosCadastrais(List<EmpresaEntity> empresasDisponiveis) {
		reportUtil.GerarRelatorio(empresasDisponiveis, "/report/CadastroEmpresa.jasper", "dadosClientes");
	}

	public EmpresaCadastroEntity selecionarDadosCadastraisAtual(EmpresaEntity empresa) throws Exception {
		Date dataMaisRecente;
		EmpresaCadastroEntity dadosCadastraisAtual = new EmpresaCadastroEntity();
		if (!empresa.getCadastros().isEmpty()) {
			dataMaisRecente = empresa.getCadastros().get(0).getDataInicioCadastro();
			dadosCadastraisAtual = empresa.getCadastros().get(0);
			for (EmpresaCadastroEntity dadoCadastral : empresa.getCadastros()) {
				if (dadoCadastral.getDataInicioCadastro().compareTo(dataMaisRecente) >= 0
						&& dadoCadastral.getDataFimCadastro() == null) {
					dataMaisRecente = dadoCadastral.getDataInicioCadastro();
					dadosCadastraisAtual = dadoCadastral;
				}
			}
		}
		return dadosCadastraisAtual;
	}

	public List<EmpresaCadastroEntity> selecionarDadosCadastraisHistorico(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaEntity empresaSelecionada) throws Exception {
		List<EmpresaCadastroEntity> dadosCadastraisHistorico = new ArrayList<EmpresaCadastroEntity>();
		empresaSelecionada.getCadastros().remove(dadosCadastraisAtual);
		dadosCadastraisHistorico = empresaSelecionada.getCadastros();
		return dadosCadastraisHistorico;
	}
	
	//regras de negócio do endereço
	
	public EnderecoEntity selecionarEnderecoAtual(EmpresaEntity empresa) throws Exception {
		Date dataMaisRecente;
		EmpresaEntity empresaNova = this.read(empresa.getIdPessoa());
		EnderecoEntity enderecoAtual = new EnderecoEntity();
		if (!empresaNova.getCadastros().isEmpty()) {
			dataMaisRecente = empresaNova.getCadastros().get(0).getDataInicioCadastro();
			enderecoAtual = empresaNova.getEnderecos().get(0);
			for (EnderecoEntity endereco : empresaNova.getEnderecos()) {
				if (endereco.getDataInicioCadastro().compareTo(dataMaisRecente) >= 0
						&& endereco.getDataFimCadastro() == null) {
					dataMaisRecente = endereco.getDataInicioCadastro();
					enderecoAtual = endereco;
				}
			}
		}
		return enderecoAtual;
	}

	public List<EnderecoEntity> selecionarEnderecoHistorico(EnderecoEntity enderecoAtual,
			EmpresaEntity empresaSelecionada) throws Exception {
		EmpresaEntity empresaNova = this.read(empresaSelecionada.getIdPessoa());
		List<EnderecoEntity> enderecoHistorico = new ArrayList<EnderecoEntity>();
		empresaNova.getEnderecos().remove(enderecoAtual);
		enderecoHistorico = empresaSelecionada.getEnderecos();
		return enderecoHistorico;
	}

}
