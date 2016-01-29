package no.item.domino.swagger.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CORSFilter implements Filter {
	
	public CORSFilter() { }

	public void init(FilterConfig fConfig) throws ServletException { }

	public void destroy() {	}

	public void doFilter(
		ServletRequest request, ServletResponse response, 
		FilterChain chain) throws IOException, ServletException {

		((HttpServletResponse)response).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse)response).addHeader("Access-Control-Allow-Credentials", "true");
		//((HttpServletResponse)response).addHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,DELETE,PUT,OPTIONS,PATCH" );
		((HttpServletResponse)response).addHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS" );
		((HttpServletResponse)response).addHeader("Access-Control-Allow-Headers", "Content-Type");
		((HttpServletResponse)response).addHeader("Access-Control-Max-Age", "86400");
		//((HttpServletResponse)response).addHeader("Allow", "GET,HEAD,OPTIONS");
		((HttpServletResponse)response).setHeader("Allow", "GET,HEAD,OPTIONS");

		String url = ((HttpServletRequest)request).getRequestURL().toString();
		String queryString = ((HttpServletRequest)request).getQueryString();
		System.out.println("INN CORSFILTER url : " + url );
		System.out.println("INN CORSFILTER queryString : " + queryString );
		String contType = ((HttpServletResponse)response).getContentType();
		System.out.println("UT CORSFILTER ContentType : " + contType );
		
		((HttpServletResponse)response).setCharacterEncoding("UTF-8");
		
		if(((HttpServletRequest)request).getMethod().equals("OPTIONS")){
			System.out.println("OPTIONS");
			String ct = ((HttpServletResponse)response).getContentType();
			System.out.println(ct);
			if (ct.startsWith("text/html")){
				((HttpServletResponse)response).setContentType("application/vnd.sun.wadl+xml");
			}
		}
		chain.doFilter(request, response);
	}
}