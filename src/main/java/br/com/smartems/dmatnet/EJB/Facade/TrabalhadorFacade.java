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

	public TrabalhadorFacade() {
	}

	@EJB
	private TrabalhadorEAO trabalhadorEAO;

	@Override
	public TrabalhadorEntity read(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(TrabalhadorEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public TrabalhadorEntity update(TrabalhadorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TrabalhadorEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TrabalhadorEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarNovoTrabalhador(UsuarioEntity usuario, EmpresaEntity empresaSelecionada,
			TrabalhadorEntity trabalhadorNovo, TrabalhadorCadastroEntity trabalhadorCadastroAtual,
			List<TrabalhadorCadastroEntity> trabalhadorListaCadastroHistorico,
			PessoaFisicaDocumentosEntity trabalhadorDocumentos, EnderecoEntity enderecoAtual,
			List<EnderecoEntity> enderecosHistorico, EmailEntity emailAtual, List<EmailEntity> emailsHistorico,
			TelefoneEntity telefonePrincipal, List<TelefoneEntity> telefones,
			List<ClassificacaoFuncionalEntity> classificacoesFuncionais, DeficienciaFisicaEntity deficienciaFisica)
			throws Exception {
		trabalhadorEAO.salvarNovoTrabalhador(usuario, empresaSelecionada, trabalhadorNovo, trabalhadorCadastroAtual,
				trabalhadorListaCadastroHistorico, trabalhadorDocumentos, enderecoAtual, enderecosHistorico, emailAtual,
				emailsHistorico, telefonePrincipal, telefones, classificacoesFuncionais, deficienciaFisica);
	}

}
