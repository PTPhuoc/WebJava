package com.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {
	private static Connection connect = null;
	
	public static Connection GetConnect() throws ClassNotFoundException, SQLException{
		if(connect == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoplinhkien","root","012345");
			System.out.print("Success Connected!");
		}
		return connect;
	}
}
