package br.com.smartems.dmatnet.EJB.dao;

import java.util.Calendar;
import java.util.List;

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

@Stateless
@Local
public class PessoaJuridicaEAO extends AbstractEAO<EmpresaEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public PessoaJuridicaEAO() {
		super(EmpresaEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado) throws NoResultException {
		Query query = entityManager.createNamedQuery("Empresa.listarEmpresasPorUsuario", EmpresaEntity.class);
		query.setParameter("idUsuario", usuarioLogado.getIdPessoa());
		return (List<EmpresaEntity>) query.getResultList();
	}

	public void salvarNovoCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			UsuarioEntity usuarioLogado) {
		try {
			if (empresa.getIdPessoa() == 0) {
				empresa.setUsuarioCriador(usuarioLogado);
				if (fotografiaFachada != null) {
					empresa.setEmpresaFotoFachada(fotografiaFachada);
				}
				this.create(empresa);
				empresa = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			UsuarioEntity usuarioLogado, EmpresaFAP fap, EmpresaCadastroEntity dadosCadastraisAtual) {
		empresa.setUsuarioCriador(usuarioLogado);
		if (fotografiaFachada != null) {
			empresa.setEmpresaFotoFachada(fotografiaFachada);
		}
		this.atribuirEmpresaFAP(fap, dadosCadastraisAtual);
		this.update(empresa);
	}

	public void atribuirEmpresaFAP(EmpresaFAP empresaFap, EmpresaCadastroEntity dadosCadastraisAtual) {
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

	public void salvarDadosCadastraisEmpresa(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaCadastroEntity dadosCadastraisAnterior, EmpresaFAP empresaFap, EmpresaEntity empresaSelecionada) {
		if (dadosCadastraisAtual.getId() == 0) {
			EmpresaEntity novaEmpresaSelecionada = this.read(empresaSelecionada.getIdPessoa());
			for (EmpresaCadastroEntity dadoCadastral : novaEmpresaSelecionada.getCadastros()) {
				if (dadoCadastral.getId
						() == dadosCadastraisAnterior.getId()) {
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
			dadosCadastraisAtual.setEmpresaFAP(this.atribuirEmpresaFAP(empresaFap));
			novaEmpresaSelecionada.getCadastros().add(dadosCadastraisAtual);
			this.update(novaEmpresaSelecionada);
		} else {
			empresaSelecionada.getCadastros().add(dadosCadastraisAtual);
			empresaSelecionada = this.update(empresaSelecionada);
		}
	}
	
	public EmpresaFAP atribuirEmpresaFAP(EmpresaFAP empresaFap) {
		EmpresaFAP novoFap = new EmpresaFAP();
		if (empresaFap != null) {
			try {
				novoFap = empresaFap.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			novoFap.setIdEmpresaFAP(0);
			return novoFap;
		}
		return null;
	}

}
