package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaDadosIsencao;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFAP;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaFoto;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaLogotipo;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaOrganismoInternacional;

@Local
public interface PessoaJuridicaFacadeLocal extends AbstractFacade<EmpresaEntity> {

	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado);

	public void salvarNovoCadastroEmpresa(EmpresaEntity empresa, EmpresaFoto fotografiaFachada,
			EmpresaLogotipo empresaLogotipo, UsuarioEntity usuarioLogado);

	public void alterarCadastroEmpresa(EmpresaEntity empresa, UsuarioEntity usuarioLogado, EmpresaFAP fap,
			EmpresaDadosIsencao empresaDadosIsencao, EmpresaOrganismoInternacional empresaOrgI8n,
			EmpresaCadastroEntity dadosCadastraisAtual);

	public void excluirCadastroEmpresa(EmpresaEntity empresa);

	public List<EmpresaEntity> filtrarEmpresas(String nomeEmpresaProcurada, List<EmpresaEntity> empresasDisponiveis)
			throws NullPointerException;

	public void salvarDadosCadastraisEmpresa(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaCadastroEntity dadosCadastraisAnterior, EmpresaFAP empresaFap,
			EmpresaDadosIsencao empresaDadosIsencao, EmpresaOrganismoInternacional empresOrgI8n,
			EmpresaEntity empresaSelecionada) throws CloneNotSupportedException;

	public void imprimirDadosCadastrais(List<EmpresaEntity> empresasDisponiveis);

	public EmpresaCadastroEntity selecionarDadosCadastraisAtual(EmpresaEntity empresa) throws Exception;

	public List<EmpresaCadastroEntity> selecionarDadosCadastraisHistorico(EmpresaCadastroEntity dadosCadastraisAtual,
			EmpresaEntity empresaSelecionada) throws Exception;

}
