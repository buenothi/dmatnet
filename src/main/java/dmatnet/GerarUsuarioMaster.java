package dmatnet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuariosGrupoEntity;

@WebServlet("/GerarUsuarioMaster")
public class GerarUsuarioMaster extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@PersistenceUnit(unitName = "dmatnet-pu")
	EntityManagerFactory emf;

	@Resource
	UserTransaction tx;

	public GerarUsuarioMaster() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuarioEntity um = new UsuarioEntity();
		UsuariosGrupoEntity grupo = new UsuariosGrupoEntity();
		
		List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();

		try {
			
			tx.begin();
			EntityManager em = emf.createEntityManager();

			usuarios = (List<UsuarioEntity>) em.createNamedQuery("Usuario.listarUsuariosMaster").getResultList();

			if (usuarios.isEmpty()) {
				
				grupo.setNomeGrupo("master");

				um.setNome("Thiago Gonçalves Bueno");
				um.setSenha("Tgb6878");
				
				um.setGrupo(grupo);

				TelefoneEntity telefone = new TelefoneEntity();
				telefone.setNumeroTelefone("11974802701");
				telefone.setTipoTelefone("celular");
				List<TelefoneEntity> telefones = new ArrayList<>();
				telefones.add(telefone);

				um.setTelefones(telefones);

				EmailEntity emailPrincipal = new EmailEntity();
				emailPrincipal.setNomeEmail("bueno_thiago@outlook.com");
				emailPrincipal.setTipoEmail("comercial");
				List<EmailEntity> emails = new ArrayList<>();
				emails.add(emailPrincipal);

				um.setEmails(emails);
				um.setLogin("thiago.bueno");

				EnderecoEntity enderecoComercial = new EnderecoEntity();
				enderecoComercial.setLogradouroTipo("Avenida");
				enderecoComercial.setLogradouro("Paulista");
				enderecoComercial.setLogradouroNumero(509);
				enderecoComercial.setLogradouroComplemento("sala 28");
				enderecoComercial.setBairro("Bela Vista");
				enderecoComercial.setCep("01311000");
				enderecoComercial.setCidade("São Paulo");
				enderecoComercial.setEstado("SP");
				enderecoComercial.setLogradouroNome("comercial");

				List<EnderecoEntity> enderecos = new ArrayList<>();
				enderecos.add(enderecoComercial);

				um.setEnderecos(enderecos);
				
				em.persist(grupo);
				em.persist(um);

				response.getWriter().append("O usuário Master \"" + um.getNome() + "\" criado com sucesso");
				
			} else {
				response.getWriter().append("Usuário Master já cadastrado!");
				System.out.println("Usuário Master já cadastrado!");
			}
			tx.commit();
			em.close();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
