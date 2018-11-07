package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.Local;

import br.com.smartems.dmatnet.entities.ClassificacaoFuncional.ClassificacaoFuncionalEntity;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.DeficienciaFisicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Local
public interface TrabalhadorFacadeLocal extends AbstractFacade<TrabalhadorEntity>{

	public void salvarNovoTrabalhador(UsuarioEntity usuario, EmpresaEntity empresaSelecionada,
			TrabalhadorEntity trabalhadorNovo, TrabalhadorCadastroEntity trabalhadorCadastroAtual,
			List<TrabalhadorCadastroEntity> trabalhadorListaCadastroHistorico,
			PessoaFisicaDocumentosEntity trabalhadorDocumentos, EnderecoEntity enderecoAtual,
			List<EnderecoEntity> enderecosHistorico, EmailEntity emailAtual, List<EmailEntity> emailsHistorico,
			TelefoneEntity telefonePrincipal, List<TelefoneEntity> telefones, List<ClassificacaoFuncionalEntity> classificacoesFuncionais,
			DeficienciaFisicaEntity deficienciaFisica) throws Exception;
}
