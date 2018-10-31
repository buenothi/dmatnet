package br.com.smartems.dmatnet.EJB.Facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.EJB.dao.TrabalhadorEAO;
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

@Stateless
public class TrabalhadorFacade implements TrabalhadorFacadeLocal {

	@EJB
	private TrabalhadorEAO trabalhadorEAO;

	public TrabalhadorFacade() {
	}

	@Override
	public TrabalhadorEntity salvarNovoTrabalhador(UsuarioEntity usuario, EmpresaEntity empresaSelecionada,
			TrabalhadorEntity trabalhadorNovo, TrabalhadorCadastroEntity trabalhadorCadastroAtual,
			List<TrabalhadorCadastroEntity> trabalhadorListaCadastroHistorico,
			PessoaFisicaDocumentosEntity trabalhadorDocumentos, EnderecoEntity enderecoAtual,
			List<EnderecoEntity> enderecosHistorico, EmailEntity emailAtual, List<EmailEntity> emailsHistorico,
			List<TelefoneEntity> telefones, List<ClassificacaoFuncionalEntity> classificacoesFuncionais,
			DeficienciaFisicaEntity deficienciaFisica) throws Exception {
		return trabalhadorEAO.salvarNovoTrabalhador(usuario, empresaSelecionada, trabalhadorNovo,
				trabalhadorCadastroAtual, trabalhadorListaCadastroHistorico, trabalhadorDocumentos, enderecoAtual,
				enderecosHistorico, emailAtual, emailsHistorico, telefones, classificacoesFuncionais,
				deficienciaFisica);
	}

}
