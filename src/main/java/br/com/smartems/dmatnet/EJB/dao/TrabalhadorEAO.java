package br.com.smartems.dmatnet.EJB.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
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
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Stateless
@Local
public class TrabalhadorEAO extends AbstractEAO<TrabalhadorEntity, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private PessoaJuridicaEAO pessoaJuridicaEAO;

	public TrabalhadorEAO() {
		super(TrabalhadorEntity.class);
	}

	public TrabalhadorEntity salvarNovoTrabalhador(UsuarioEntity usuario, EmpresaEntity empresaSelecionada,
			TrabalhadorEntity trabalhadorNovo, TrabalhadorCadastroEntity trabalhadorCadastroAtual,
			List<TrabalhadorCadastroEntity> trabalhadorListaCadastroHistorico,
			PessoaFisicaDocumentosEntity trabalhadorDocumentos, EnderecoEntity enderecoAtual,
			List<EnderecoEntity> enderecosHistorico, EmailEntity emailAtual, List<EmailEntity> emailsHistorico,
			List<TelefoneEntity> telefones, List<ClassificacaoFuncionalEntity> classificacoesFuncionais,
			DeficienciaFisicaEntity deficienciaFisica) {
		try {
			if (trabalhadorNovo.getIdPessoa() == 0) {

				Set<TrabalhadorCadastroEntity> cadastrosCombinados = new TreeSet<TrabalhadorCadastroEntity>();
				cadastrosCombinados.addAll(trabalhadorListaCadastroHistorico);
				cadastrosCombinados.add(trabalhadorCadastroAtual);
				trabalhadorNovo.setCadastrosTrabalhador(cadastrosCombinados);

				trabalhadorNovo.setDocumentosPessoais(trabalhadorDocumentos);

				Set<EnderecoEntity> enderecosCombinados = new TreeSet<EnderecoEntity>();
				enderecosCombinados.addAll(enderecosHistorico);
				enderecosCombinados.add(enderecoAtual);
				trabalhadorNovo.setEnderecos(enderecosCombinados);

				Set<EmailEntity> emailsCombinados = new TreeSet<EmailEntity>();
				emailsCombinados.addAll(emailsHistorico);
				emailsCombinados.add(emailAtual);
				trabalhadorNovo.setEmails(emailsCombinados);

				trabalhadorNovo.getTelefones().addAll(telefones);

				trabalhadorNovo.getClassificacoesFuncionais().addAll(classificacoesFuncionais);

				trabalhadorNovo.setDeficienciaFisica(deficienciaFisica);
				
				empresaSelecionada.getTrabalhadores().add(trabalhadorNovo);
				
				this.pessoaJuridicaEAO.update(empresaSelecionada);

			}
			this.create(trabalhadorNovo);
		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return trabalhadorNovo;
	}

}
