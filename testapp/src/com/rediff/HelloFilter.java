package com.rediff;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HelloFilter
 */
@WebFilter(urlPatterns={"/TestFilterServlet"})
public class HelloFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long sTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long eTime = System.currentTimeMillis();
		
		System.out.println("TT :: " + (eTime-sTime));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void destroy() {
	}

}
