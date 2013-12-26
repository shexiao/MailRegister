package com.haotai.dao;

import java.sql.SQLException;

import com.haotai.model.User;

public class TestUserDAO {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDAO userDAO=new UserDAO();
		//int id=userDAO.queryUserIdByMail("781345593@qq.com");
		//System.out.println(id);
		User user=userDAO.queryUserById(5);
		System.out.println(user.getId());
		System.out.println(user.getMail());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
	}
}
