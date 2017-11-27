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

	public void alterarCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			EmpresaLogotipo empresaLogotipo, UsuarioEntity usuarioLogado, EmpresaFAP fap,
			EmpresaCadastroEntity dadosCadastraisAtual) {
		empresa.setUsuarioCriador(usuarioLogado);
		if (fotografiaFachada != null) {
			empresa.setEmpresaFotoFachada(fotografiaFachada);
		}
		if (empresaLogotipo != null) {
			empresa.setEmpresaLogotipo(empresaLogotipo);
		}
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
			throws CloneNotSupportedException {
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

}
