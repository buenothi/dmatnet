package br.com.smartems.dmatnet.EJB.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

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

@Stateful
@Local
public class TrabalhadorEAO extends AbstractEAO<TrabalhadorEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu", type = PersistenceContextType.EXTENDED)
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

		if (trabalhadorNovo.getIdPessoa() == 0) {

			try {
				List<TrabalhadorCadastroEntity> cadastrosCombinados = new ArrayList<TrabalhadorCadastroEntity>();
				cadastrosCombinados.addAll(trabalhadorListaCadastroHistorico);
				cadastrosCombinados.add(trabalhadorCadastroAtual);
				trabalhadorNovo.setCadastrosTrabalhador(cadastrosCombinados);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				trabalhadorNovo.setDocumentosPessoais(trabalhadorDocumentos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Set<EnderecoEntity> enderecosCombinados = new TreeSet<EnderecoEntity>();
				enderecosCombinados.addAll(enderecosHistorico);
				enderecosCombinados.add(enderecoAtual);
				trabalhadorNovo.setEnderecos(enderecosCombinados);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Set<EmailEntity> emailsCombinados = new TreeSet<EmailEntity>();
				emailsCombinados.addAll(emailsHistorico);
				emailsCombinados.add(emailAtual);
				trabalhadorNovo.setEmails(emailsCombinados);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Set<TelefoneEntity> telefonesCombinados = new TreeSet<TelefoneEntity>();
				telefonesCombinados.addAll(telefones);
				telefonesCombinados.add(telefonePrincipal);
				trabalhadorNovo.getTelefones().addAll(telefonesCombinados);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				trabalhadorNovo.getClassificacoesFuncionais().addAll(classificacoesFuncionais);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				trabalhadorNovo.setDeficienciaFisica(deficienciaFisica);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				trabalhadorNovo.setUsuarioCriador(usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				EmpresaEntity novaEmpresaSelecionada;
				novaEmpresaSelecionada = pessoaJuridicaEAO.read(empresaSelecionada.getIdPessoa());
				novaEmpresaSelecionada.getTrabalhadores().add(trabalhadorNovo);
				this.pessoaJuridicaEAO.update(novaEmpresaSelecionada);
			} catch (NoResultException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
