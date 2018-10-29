package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.ClassificacaoFuncional.ClassificacaoFuncionalEntity;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.DeficienciaFisicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@Stateless
@Local
public class TrabalhadorEAO extends AbstractEAO<TrabalhadorEntity, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	public TrabalhadorEAO() {
		super(TrabalhadorEntity.class);
	}

	public UsuarioEntity salvarNovoTrabalhador(UsuarioEntity usuario, TrabalhadorEntity trabalhadorNovo,
			TrabalhadorCadastroEntity trabalhadorCadastroAtual,
			List<TrabalhadorCadastroEntity> trabalhadorListaCadastroHistorico,
			PessoaFisicaDocumentosEntity trabalhadorDocumentos, EnderecoEntity enderecoAtual,
			List<EnderecoEntity> enderecosHistorico, EmailEntity emailAtual, List<EmailEntity> emailsHistorico,
			List<TelefoneEntity> telefones, List<ClassificacaoFuncionalEntity> classificacoesFuncionais,
			DeficienciaFisicaEntity deficienciaFisica) {
		try {
			if (trabalhadorNovo.getIdPessoa() == 0) {
				
			}
			this.create(trabalhadorNovo);
		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return usuario;
	}

}
