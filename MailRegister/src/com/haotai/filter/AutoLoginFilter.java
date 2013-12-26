package com.haotai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AutoLoginFilter implements Filter {


    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		
		String mail=null;
		String password=null;
		Cookie[] cookies=httpRequest.getCookies();
		for(Cookie cookie:cookies){
			if("name".equals(cookie.getName())){
				mail=cookie.getValue();
			}
			if("password".equals(cookie.getName())){
				password=(cookie.getValue());
			}
		}
		*/
		chain.doFilter(request, response);
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
