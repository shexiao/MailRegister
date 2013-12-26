package com.haotai.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConn {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Connection conn=DBConn.getConn();
		if(conn!=null){
			System.out.println("db connect succeeded..");
			conn.close();
		}else{
			System.out.println("db connect failed..");
		}
	}
}
