package com.haotai.mail;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haotai.dao.UserDAO;
import com.haotai.model.User;


public class MailBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MailBackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String registerId=request.getParameter("registerId");
		if(registerId==null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return ;
		}
		
		String name=(String)request.getSession().getAttribute(registerId);
		String password=(String)request.getSession().getAttribute("password");
		String mail=(String)request.getSession().getAttribute("mail");
		if(name==null||name.equals("")){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return ;
		}
		
		UserDAO userDAO=new UserDAO();
		User user=new User();
		user.setMail(mail);
		user.setName(name);
		user.setPassword(password);
		try {
			userDAO.addUser(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("name", name);
		request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
