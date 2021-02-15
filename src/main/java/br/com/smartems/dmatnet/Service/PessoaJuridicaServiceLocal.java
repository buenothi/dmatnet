package br.com.smartems.dmatnet.Service;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFAP;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaLogotipo;

@Local
public interface PessoaJuridicaServiceLocal extends AbstractService<EmpresaEntity> {

	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado);

	public void salvarNovoCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			EmpresaLogotipo empresaLogotipo, UsuarioEntity usuarioLogado);

	public void alterarCadastroEmpresa(EmpresaEntity empresa, UsuarioEntity usuarioLogado, EmpresaFAP fap,
			EmpresaCadastroEntity dadosCadastraisAtual);

	public void excluirCadastroEmpresa(EmpresaEntity empresa);

	public List<EmpresaEntity> filtrarEmpresas(String nomeEmpresaProcurada, List<EmpresaEntity> empresasDisponiveis)
			throws NullPointerException;

	public void salvarDadosCadastraisEmpresa(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaCadastroEntity dadosCadastraisAnterior, EmpresaFAP empresaFap, EmpresaEntity empresaSelecionada)
			throws Exception;

	public void imprimirDadosCadastrais(List<EmpresaEntity> empresasDisponiveis);

	public EmpresaCadastroEntity selecionarDadosCadastraisAtual(EmpresaEntity empresa) throws Exception;

	public List<EmpresaCadastroEntity> selecionarDadosCadastraisHistorico(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaEntity empresaSelecionada) throws Exception;

	public void excluirDadoCadastral(EmpresaCadastroEntity dadoCadastral, EmpresaEntity empresaSelecionada)
			throws Exception;

	public void salvarEnderecoEmpresa(EmpresaEntity empresaSelecionada, EnderecoEntity enderecoAtual,
			EnderecoEntity enderecoAnterior) throws Exception;

	public EnderecoEntity selecionarEnderecoAtual(EmpresaEntity empresa) throws Exception;

	public List<EnderecoEntity> selecionarEnderecosHistorico(EnderecoEntity enderecoAtual,
			EmpresaEntity empresaSelecionada) throws Exception;

	public void excluirEnderecoEmpresa(EnderecoEntity endereco, EmpresaEntity empresaSelecionada) throws Exception;

}
