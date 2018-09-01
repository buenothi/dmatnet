package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.smartems.dmatnet.EJB.dao.PessoaJuridicaEAO;
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

@Stateless
@WebService
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
			EmpresaLogotipo empresaLogotipo, UsuarioEntity usuarioLogado) {
		pessoaJuridicaEAO.salvarNovoCadastroEmpresa(empresa, fotografiaFachada, empresaLogotipo, usuarioLogado);
	}

	public void alterarCadastroEmpresa(EmpresaEntity empresa, UsuarioEntity usuarioLogado, EmpresaFAP fap,
			EmpresaDadosIsencao empresaDadosIsencao, EmpresaOrganismoInternacional empresaOrgI8n,
			Set<EmpresaSoftwareHouse> empresasSoftware, EmpresaCadastroEntity dadosCadastraisAtual) {
		pessoaJuridicaEAO.alterarCadastroEmpresa(empresa, usuarioLogado, fap, empresaDadosIsencao, empresaOrgI8n,
				empresasSoftware, dadosCadastraisAtual);
	}

	public void excluirCadastroEmpresa(EmpresaEntity empresa) {
		pessoaJuridicaEAO.excluirCadastroEmpresa(empresa);
	}

	public List<EmpresaEntity> filtrarEmpresas(String nomeEmpresaProcurada, List<EmpresaEntity> empresasDisponiveis)
			throws NullPointerException {
		return pessoaJuridicaEAO.filtrarEmpresas(nomeEmpresaProcurada, empresasDisponiveis);
	}

	public void salvarDadosCadastraisEmpresa(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaCadastroEntity dadosCadastraisAnterior, EmpresaFAP empresaFap,
			EmpresaDadosIsencao empresaDadosIsencao, EmpresaOrganismoInternacional empresaOrgI8n,
			Set<EmpresaSoftwareHouse> empresasSoftwareHouse, EmpresaEntity empresaSelecionada) throws Exception {
		pessoaJuridicaEAO.salvarDadosCadastraisEmpresa(dadosCadastraisAtual, dadosCadastraisAnterior, empresaFap,
				empresaDadosIsencao, empresaOrgI8n, empresasSoftwareHouse, empresaSelecionada);
	}

	public void imprimirDadosCadastrais(List<EmpresaEntity> empresasDisponiveis) {
		pessoaJuridicaEAO.imprimirDadosCadastrais(empresasDisponiveis);
	}

	public EmpresaCadastroEntity selecionarDadosCadastraisAtual(EmpresaEntity empresa) throws Exception {
		return pessoaJuridicaEAO.selecionarDadosCadastraisAtual(empresa);
	}

	public List<EmpresaCadastroEntity> selecionarDadosCadastraisHistorico(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaEntity empresaSelecionada) throws Exception {
		return pessoaJuridicaEAO.selecionarDadosCadastraisHistorico(dadosCadastraisAtual, empresaSelecionada);
	}
	
	public void excluirDadoCadastral(EmpresaCadastroEntity dadoCadastral,
			EmpresaEntity empresaSelecionada) throws Exception {
		pessoaJuridicaEAO.excluirDadoCadastral(dadoCadastral, empresaSelecionada);
	}

	public void salvarEnderecoEmpresa(EmpresaEntity empresaSelecionada, EnderecoEntity enderecoAtual,
			EnderecoEntity enderecoAnterior) throws Exception {
		pessoaJuridicaEAO.salvarEnderecoEmpresa(empresaSelecionada, enderecoAtual, enderecoAnterior);
	}

	public EnderecoEntity selecionarEnderecoAtual(EmpresaEntity empresa) throws Exception {
		return pessoaJuridicaEAO.selecionarEnderecoAtual(empresa);
	}
	
	public List<EnderecoEntity> selecionarEnderecosHistorico(EnderecoEntity enderecoAtual,
			EmpresaEntity empresaSelecionada) throws Exception {
		return pessoaJuridicaEAO.selecionarEnderecosHistorico(enderecoAtual, empresaSelecionada);
	}
	
	public void excluirEnderecoEmpresa(EnderecoEntity endereco,
			EmpresaEntity empresaSelecionada) throws Exception{
		pessoaJuridicaEAO.excluirEnderecoEmpresa(endereco, empresaSelecionada);
	}
	
}
