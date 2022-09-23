package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
//	create connection with DB using this class
	
	static Connection connection;
	
	public static Connection createConnection() {
		try {
			//load Driver
//			Class.forName("com.mysql.jdbc.Driver");
			
			//create connection
			String user="root";
			String url= "jdbc:mysql://localhost:3306/std_mngt";
			String password="8080";
			connection= DriverManager.getConnection(url, user, password);
			
			//shortcut connection in 1 line
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/std_mngt", "root", "8080");
			
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return connection;		
	}
	
	
	public static void closeDbConnection()
	{
		      try
		      {
		        if(connection != null)
		          connection.close();
		        System.out.println("Connection closed !!");
		      }
		      catch (SQLException e) {
		       System.out.println("Error closing connection!!");
		    	  e.printStackTrace();
		      }
	}

	
	
}
