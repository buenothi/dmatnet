package br.com.smartems.dmatnet.Filtros;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartems.dmatnet.ManagedBeans.UsuarioMB;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/aplicacaoWeb/*" })
public class BloqueioAcessoPaginasFilter implements Filter {

	@Inject
	private UsuarioMB usuarioMB;

	public BloqueioAcessoPaginasFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("-----------------------------------\n" + "passagem pelo filtro na ida");
		
		//a função abaixo é usada para obter atributos na requisição http, quando utilizado pelo ManagedBean (Deprecado)
		//usuarioMB = (UsuarioMB) ((HttpServletRequest) request).getSession().getAttribute("usuarioMB");

		try {
			if (usuarioMB.isLogado()) {
				System.out.println("O usuário logado é: \"" + usuarioMB.getUsuarioLogado().getNome() + "\"");
				chain.doFilter(request, response);
			} else {
				String contextPath = ((HttpServletRequest) request).getContextPath();
				((HttpServletResponse) response).sendRedirect(contextPath);
				System.out.println("usuário não está logado");
			}
		} catch (Exception ex) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath);
			System.out.println("usuário não está logado");
		}

		System.out.println("passagem pelo filtro na volta\n" + "-----------------------------------");

	}

	public void init(FilterConfig Config) throws ServletException {

	}

}
