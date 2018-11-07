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

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public TrabalhadorEAO() {
		super(TrabalhadorEntity.class);
	}

	@EJB
	private PessoaJuridicaEAO pessoaJuridicaEAO;

	public void salvarNovoTrabalhador(UsuarioEntity usuario, EmpresaEntity empresaSelecionada,
			TrabalhadorEntity trabalhadorNovo, TrabalhadorCadastroEntity trabalhadorCadastroAtual,
			List<TrabalhadorCadastroEntity> trabalhadorListaCadastroHistorico,
			PessoaFisicaDocumentosEntity trabalhadorDocumentos, EnderecoEntity enderecoAtual,
			List<EnderecoEntity> enderecosHistorico, EmailEntity emailAtual, List<EmailEntity> emailsHistorico,
			TelefoneEntity telefonePrincipal, List<TelefoneEntity> telefones,
			List<ClassificacaoFuncionalEntity> classificacoesFuncionais, DeficienciaFisicaEntity deficienciaFisica) {
		try {
			if (trabalhadorNovo.getIdPessoa() == 0) {

				EmpresaEntity novaEmpresaSelecionada = pessoaJuridicaEAO.read(empresaSelecionada.getIdPessoa());

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

				Set<TelefoneEntity> telefonesCombinados = new TreeSet<TelefoneEntity>();
				telefonesCombinados.addAll(telefones);
				telefonesCombinados.add(telefonePrincipal);
				trabalhadorNovo.getTelefones().addAll(telefonesCombinados);

				trabalhadorNovo.getClassificacoesFuncionais().addAll(classificacoesFuncionais);

				trabalhadorNovo.setDeficienciaFisica(deficienciaFisica);

				trabalhadorNovo.setUsuarioCriador(usuario);

				novaEmpresaSelecionada.getTrabalhadores().add(trabalhadorNovo);

				this.pessoaJuridicaEAO.update(novaEmpresaSelecionada);

			}
		} catch (Exception excp) {
			excp.printStackTrace();
		}
	}

}
