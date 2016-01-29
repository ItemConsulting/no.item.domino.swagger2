package no.item.domino.swagger.filter;


import javax.servlet.*;
import javax.servlet.http.*;

import no.item.domino.swagger.wink.util.Util;

import java.util.*;

//Implements Filter class
public class LogFilter implements Filter  {

	public void  init(FilterConfig config) throws ServletException{
		// Get init parameter
		//String testParam = config.getInitParameter("test-param");
		//Print the init parameter
		//Util.debug("Test Param: " + testParam, getClass().getName() ,"doFilter(....)" );
	}

	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws java.io.IOException, ServletException {
		long startTime;
		long endTime;
		String path = ((HttpServletRequest) request).getServletPath();
		startTime = System.currentTimeMillis();
		// Get the IP address of client machine.
		String ipAddress = request.getRemoteAddr();
	// Pass request back down the filter chain
		chain.doFilter(request,response);
		endTime = System.currentTimeMillis();
		// Log the IP address and current timestamp.
		Util.debug("IP "+ ipAddress + ", Time " + new Date().toString() + ", Path : " + path + ", ms : " + (endTime - startTime), getClass().getName() ,"doFilter(....)" );
	}

	public void destroy( ){
		/* Called before the Filter instance is removed from service by the web container*/
	}
}