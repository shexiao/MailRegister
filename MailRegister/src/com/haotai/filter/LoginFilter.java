package com.haotai.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haotai.dao.UserDAO;
import com.haotai.model.User;


public class LoginFilter implements Filter {

    
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("login filter");
		
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");

		boolean isExisted=validateUser(mail,password);
		if(!isExisted){
			System.out.println("user not existed..");
			HttpSession httpSession=((HttpServletRequest)request).getSession();
			httpSession.setAttribute("mail", mail);
			((HttpServletResponse)response).sendRedirect("index.jsp");
		}else{
			System.out.println("user existed");
			Cookie nameCookie=new Cookie("mail",mail);
			nameCookie.setPath("/");
			nameCookie.setMaxAge(300);
			httpResponse.addCookie(nameCookie);
			Cookie passwordCookie=new Cookie("password",password);
			passwordCookie.setPath("/");
			passwordCookie.setMaxAge(300);
			httpResponse.addCookie(passwordCookie);
			((HttpServletResponse)response).sendRedirect("user/userIndex.jsp");
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {

	}
	
	private boolean validateUser(String mail,String password){
		UserDAO userDAO=new UserDAO();
		User user;
		try {
			List<User> list=userDAO.queryUsers();
			Iterator<User> iterator=list.iterator();
			while(iterator.hasNext()){
				user=iterator.next();
				if(mail.equals(user.getMail()) && password.equals(user.getPassword())){
					return true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
