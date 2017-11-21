package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.PessoaJuridicaEAO;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFAP;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;

@Stateless
public class PessoaJuridicaFacade implements PessoaJuridicaFacadeLocal {

	@EJB
	private PessoaJuridicaEAO pessoaJuridicaEAO;

	public PessoaJuridicaFacade() {
	}

	@Override
	public EmpresaEntity read(long pk) {
		return pessoaJuridicaEAO.read(pk);
	}

	@Override
	public void create(EmpresaEntity entity) {
		pessoaJuridicaEAO.create(entity);
	}

	@Override
	public EmpresaEntity update(EmpresaEntity entity) {
		return pessoaJuridicaEAO.update(entity);
	}

	@Override
	public void delete(EmpresaEntity entity) {
		pessoaJuridicaEAO.delete(entity);
	}

	@Override
	public List<EmpresaEntity> findAll() {
		return pessoaJuridicaEAO.findAll();
	}

	@Override
	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado) {
		return pessoaJuridicaEAO.listarEmpresas(usuarioLogado);
	}

	public void salvarNovoCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			UsuarioEntity usuarioLogado) {
		pessoaJuridicaEAO.salvarNovoCadastroEmpresa(empresa, fotografiaFachada, usuarioLogado);
	}

	public void alterarCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			UsuarioEntity usuarioLogado, EmpresaFAP fap, EmpresaCadastroEntity dadosCadastraisAtual) {
		pessoaJuridicaEAO.alterarCadastroEmpresa(empresa, fotografiaFachada, usuarioLogado, fap, dadosCadastraisAtual);
	}
	

	public void excluirCadastroEmpresa(EmpresaEntity empresa) {
		pessoaJuridicaEAO.excluirCadastroEmpresa(empresa);
	}

	public void salvarDadosCadastraisEmpresa(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaCadastroEntity dadosCadastraisAnterior, EmpresaFAP empresaFap, EmpresaEntity empresaSelecionada)
			throws CloneNotSupportedException {
		pessoaJuridicaEAO.salvarDadosCadastraisEmpresa(dadosCadastraisAtual, dadosCadastraisAnterior, empresaFap,
				empresaSelecionada);
	}
	
	public void imprimirDadosCadastrais(List<EmpresaEntity> empresasDisponiveis) {
		pessoaJuridicaEAO.imprimirDadosCadastrais(empresasDisponiveis);
	}
	
	public EmpresaCadastroEntity selecionarDadosCadastraisAtual(EmpresaEntity empresa) throws Exception {
		return pessoaJuridicaEAO.selecionarDadosCadastraisAtual(empresa);
	}

	@Override
	public List<EmpresaCadastroEntity> selecionarDadosCadastraisHistorico(
			EmpresaCadastroEntity dadosCadastraisAtual, EmpresaEntity empresaSelecionada) throws Exception {
		return pessoaJuridicaEAO.selecionarDadosCadastraisHistorico(dadosCadastraisAtual, empresaSelecionada);
	}
	
	
	
}
