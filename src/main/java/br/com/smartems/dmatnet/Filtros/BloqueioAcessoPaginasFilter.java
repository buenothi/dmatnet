package br.com.smartems.dmatnet.Filtros;

import java.io.IOException;

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

import br.com.smartems.dmatnet.ManagedBeans.UsuarioManagedBean;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/aplicacaoWeb/*" })
public class BloqueioAcessoPaginasFilter implements Filter {

	private UsuarioManagedBean usuarioMB = new UsuarioManagedBean();

	public BloqueioAcessoPaginasFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		this.usuarioMB.isLogado = false;
		System.out.println("passagem pelo filtro na ida");
		usuarioMB = (UsuarioManagedBean) ((HttpServletRequest) request).getSession().getAttribute("usuarioManagedBean");

		if (usuarioMB.isLogado) {
			System.out.println(usuarioMB.isLogado);
			chain.doFilter(request, response);
		} else {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/index.jsf");
			System.out.println("usuário não está logado");
		}

		System.out.println("passagem pelo filtro na volta");

	}

	public void init(FilterConfig Config) throws ServletException {

	}

}
