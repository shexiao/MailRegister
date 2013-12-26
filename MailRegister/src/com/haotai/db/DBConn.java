package com.haotai.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		Connection conn=null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/";
		String db="mail_register";
		String username="root";
		String password="123456";
		
		Class.forName(driver);
		conn=DriverManager.getConnection(url+db,username,password);
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement ptmt,ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(ptmt!=null){
			ptmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
