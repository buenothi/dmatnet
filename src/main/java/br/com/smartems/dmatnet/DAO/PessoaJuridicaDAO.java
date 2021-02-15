package br.com.smartems.dmatnet.DAO;

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
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFAP;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaLogotipo;
import br.com.smartems.dmatnet.util.ReportUtil;
import br.com.smartems.dmatnet.util.filtrosCollection.Filter;
import br.com.smartems.dmatnet.util.filtrosCollection.FiltroEmpresa;

@Stateless
@Local
public class PessoaJuridicaDAO extends AbstractDAO<EmpresaEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public PessoaJuridicaDAO() {
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
			EmpresaCadastroEntity dadosCadastraisAtual) {
		empresa.setUsuarioCriador(usuarioLogado);
		this.atribuirEmpresaFAP(fap, dadosCadastraisAtual);
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

	// Dados Cadastrais da Empresa

	public void salvarDadosCadastraisEmpresa(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaCadastroEntity dadosCadastraisAnterior, EmpresaFAP empresaFap, EmpresaEntity empresaSelecionada)
			throws Exception {
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
			novaEmpresaSelecionada.getCadastros().add(dadosCadastraisAtual);
			this.update(novaEmpresaSelecionada);
		} else {
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
			List<EmpresaCadastroEntity> listaCadastroProvisoria = new ArrayList<EmpresaCadastroEntity>();
			for (EmpresaCadastroEntity cadastro : empresa.getCadastros()) {
				listaCadastroProvisoria.add(cadastro);
			}
			dataMaisRecente = listaCadastroProvisoria.get(0).getDataInicioCadastro();
			dadosCadastraisAtual = listaCadastroProvisoria.get(0);
			for (EmpresaCadastroEntity cadastro : empresa.getCadastros()) {
				if (cadastro.getDataInicioCadastro().compareTo(dataMaisRecente) >= 0
						&& cadastro.getDataFimCadastro() == null) {
					dataMaisRecente = cadastro.getDataInicioCadastro();
					dadosCadastraisAtual = cadastro;
				}
			}
		}
		return dadosCadastraisAtual;
	}

	public List<EmpresaCadastroEntity> selecionarDadosCadastraisHistorico(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaEntity empresaSelecionada) throws Exception {
		List<EmpresaCadastroEntity> dadosCadastraisHistorico = new ArrayList<EmpresaCadastroEntity>();
		if (!empresaSelecionada.getCadastros().isEmpty()) {
			empresaSelecionada.getCadastros().remove(dadosCadastraisAtual);
			List<EmpresaCadastroEntity> listaCadastroProvisoria = new ArrayList<EmpresaCadastroEntity>();
			for (EmpresaCadastroEntity cadastro : empresaSelecionada.getCadastros()) {
				listaCadastroProvisoria.add(cadastro);
			}
			dadosCadastraisHistorico = listaCadastroProvisoria;
		}
		return dadosCadastraisHistorico;
	}

	public void excluirDadoCadastral(EmpresaCadastroEntity dadoCadastral, EmpresaEntity empresaSelecionada)
			throws Exception {
		EmpresaEntity empresaSelecionadaAtual = this.read(empresaSelecionada.getIdPessoa());
		if (empresaSelecionadaAtual.getCadastros().remove(dadoCadastral)) {
			this.update(empresaSelecionadaAtual);
		}
	}

	// Endereços da Empresa

	public void salvarEnderecoEmpresa(EmpresaEntity empresaSelecionada, EnderecoEntity enderecoAtual,
			EnderecoEntity enderecoAnterior) throws Exception {
		if (enderecoAtual.getIdEndereco() == 0) {
			EmpresaEntity novaEmpresaSelecionada = this.read(empresaSelecionada.getIdPessoa());
			for (EnderecoEntity endereco : novaEmpresaSelecionada.getEnderecos()) {
				if (endereco.getIdEndereco() == enderecoAnterior.getIdEndereco()) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(enderecoAtual.getDataInicioEndereco());
					calendar.add(Calendar.DAY_OF_MONTH, -1);
					if (calendar.getTime().compareTo(endereco.getDataInicioEndereco()) <= 0) {
						endereco.setDataTerminoEndereco(endereco.getDataInicioEndereco());
					} else {
						endereco.setDataTerminoEndereco(calendar.getTime());
					}
				}
			}
			novaEmpresaSelecionada.getEnderecos().add(enderecoAtual);
			this.update(novaEmpresaSelecionada);
		} else {
			empresaSelecionada.getEnderecos().add(enderecoAtual);
			empresaSelecionada = this.update(empresaSelecionada);
		}
	}

	public EnderecoEntity selecionarEnderecoAtual(EmpresaEntity empresa) throws Exception {
		Date dataMaisRecente;
		EnderecoEntity enderecoAtual = new EnderecoEntity();
		if (!empresa.getEnderecos().isEmpty()) {
			List<EnderecoEntity> listaEnderecoProvisoria = new ArrayList<EnderecoEntity>();
			for (EnderecoEntity endereco : empresa.getEnderecos()) {
				listaEnderecoProvisoria.add(endereco);
			}
			dataMaisRecente = listaEnderecoProvisoria.get(0).getDataInicioEndereco();
			enderecoAtual = listaEnderecoProvisoria.get(0);
			for (EnderecoEntity endereco : empresa.getEnderecos()) {
				if (endereco.getDataInicioEndereco().compareTo(dataMaisRecente) >= 0
						&& endereco.getDataTerminoEndereco() == null) {
					dataMaisRecente = endereco.getDataInicioEndereco();
					enderecoAtual = endereco;
				}
			}
		}
		return enderecoAtual;
	}

	public List<EnderecoEntity> selecionarEnderecosHistorico(EnderecoEntity enderecoAtual,
			EmpresaEntity empresaSelecionada) throws Exception {
		List<EnderecoEntity> enderecosHistorico = new ArrayList<EnderecoEntity>();
		if (!empresaSelecionada.getEnderecos().isEmpty()) {
			empresaSelecionada.getEnderecos().remove(enderecoAtual);
			List<EnderecoEntity> listaEnderecoProvisoria = new ArrayList<EnderecoEntity>();
			for (EnderecoEntity endereco : empresaSelecionada.getEnderecos()) {
				listaEnderecoProvisoria.add(endereco);
			}
			enderecosHistorico = listaEnderecoProvisoria;
		}
		return enderecosHistorico;
	}

	public void excluirEnderecoEmpresa(EnderecoEntity endereco, EmpresaEntity empresaSelecionada) throws Exception {
		EmpresaEntity empresaSelecionadaAtual = this.read(empresaSelecionada.getIdPessoa());
		if (empresaSelecionadaAtual.getEnderecos().remove(endereco)) {
			this.update(empresaSelecionadaAtual);
		}
	}
}
