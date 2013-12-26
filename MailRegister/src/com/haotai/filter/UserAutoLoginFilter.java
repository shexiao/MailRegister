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

/**
 * Servlet Filter implementation class UserAutoLoginFilter
 */
@WebFilter("/UserAutoLoginFilter")
public class UserAutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserAutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("user auto login....");
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		
		String mail=null;
		String password=null;
		Cookie[] cookies=httpRequest.getCookies();
		for(Cookie cookie:cookies){
			if("mail".equals(cookie.getName())){
				mail=cookie.getValue();
				System.out.println(mail);
			}
			if("password".equals(cookie.getName())){
				password=cookie.getValue();
			}
		}
		
		if(mail==null && password==null){
			httpResponse.sendRedirect("/MailRegister/index.jsp");
		}
		request.setAttribute("mail", mail);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
