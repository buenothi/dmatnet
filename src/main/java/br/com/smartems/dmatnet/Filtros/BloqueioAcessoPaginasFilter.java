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

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/aplicacaoWeb/*" })
public class BloqueioAcessoPaginasFilter implements Filter {

	public BloqueioAcessoPaginasFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("passagem pelo filtro na ida");

		chain.doFilter(request, response);
		
		System.out.println("passagem pelo filtro na volta");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
