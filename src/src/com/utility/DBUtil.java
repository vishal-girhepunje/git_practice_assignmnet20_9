package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection connectToDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/sb101_b23";
		String username="root";
		String pass="6809";		
		
		Connection conn=null;
		try {
			conn= DriverManager.getConnection(url,username,pass);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}

}
