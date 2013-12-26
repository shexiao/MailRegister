package com.haotai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.haotai.db.DBConn;
import com.haotai.model.User;

public class UserDAO {
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public void addUser(User user) throws ClassNotFoundException, SQLException{
		conn=DBConn.getConn();
		String sql="insert into user(name,mail,password) values(?,?,?)";
		
		ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, user.getName());
		ptmt.setString(2, user.getMail());
		ptmt.setString(3, user.getPassword());
		ptmt.execute();
		DBConn.close(conn, ptmt, rs);
	}
	
	public List<User> queryUsers() throws ClassNotFoundException, SQLException{
		List<User> list=new LinkedList<User>();
		User user;
		String sql="select * from user";
		conn=DBConn.getConn();
		ptmt=conn.prepareStatement(sql);
		rs=ptmt.executeQuery();
		while(rs.next()){
			user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setMail(rs.getString(3));
			user.setPassword(rs.getString(4));
			list.add(user);
		}
		return list;
	}
	
	public User queryUserById(int id) throws ClassNotFoundException, SQLException{
		User user=null;
		conn=DBConn.getConn();
		String sql="select * from user where id="+id;
		ptmt=conn.prepareStatement(sql);
		rs=ptmt.executeQuery();
		while(rs.next()){
			user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setMail(rs.getString(3));
			user.setPassword(rs.getString(4));
		}
		DBConn.close(conn, ptmt, rs);
		return user;
	}
	
	public int queryUserIdByMail(String mail) throws ClassNotFoundException, SQLException{
		int id=0;
		conn=DBConn.getConn();
		String sql="select id from user where mail='"+mail+"'";
		System.out.println(sql);
		ptmt=conn.prepareStatement(sql);
		rs=ptmt.executeQuery();
		while(rs.next()){
			id=rs.getInt(1);
		}
		return id;
	}
	
}
