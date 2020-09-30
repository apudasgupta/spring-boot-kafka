package com.iatl.lt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Apu Das Gupta
 *
 */

public class SecurityServletFilter extends HttpFilter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8301925462087972860L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("==> Request URL :" + request.getRequestURL().toString());
		System.out.println("==> Request QueryString :" + request.getQueryString());
		
		
		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
		}else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // HTTP 401.
            return;
		}
		chain.doFilter(request, response);
	}

}
