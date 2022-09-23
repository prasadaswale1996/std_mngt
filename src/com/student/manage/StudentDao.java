package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

// CRUD operation code	
	public static boolean insertStudentToDb(Student std) {
		
		boolean flag=false;
		
		try {
			Connection connetion = ConnectionProvider.createConnection();
			
			String querry= "insert into students() values(?,?,?,?)";
			//prepared statement
			PreparedStatement pstmt= connetion.prepareStatement(querry);
			//set the values of parameters
			pstmt.setInt(1, std.getStudentId());
			pstmt.setString(2, std.getStudentName());
			pstmt.setString(3, std.getStudentPhone());
			pstmt.setString(4, std.getStudentCity());
			
			//execute query
			pstmt.executeUpdate();
			flag=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
	}

	public static boolean deleteStudentFromDb(int stdid) {
		
		boolean flag=false;
		
		try {
			Connection connetion = ConnectionProvider.createConnection();
			
			String querry= "delete from students where sid=?";
			//prepared statement
			PreparedStatement pstmt= connetion.prepareStatement(querry);
			//set the values of parameters
			pstmt.setInt(1, stdid);
						
			//execute query
			pstmt.executeUpdate();
			flag=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
		
	}

	public static void showAllStudents() {
		boolean flag=false;
		
		try {
			Connection connetion = ConnectionProvider.createConnection();
			
			String query= "select * from students";
			// statement query - no need of parameterised 
			Statement stmt = connetion.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			//execute query will return result set
			
			while(rs.next()) {
				
				int id= rs.getInt(1);
				String name= rs.getString(2);
				String phone= rs.getString(3);
				String city= rs.getString("scity");
				
				System.out.println("ID : "+id);
				System.out.println("NAME : "+name);
				System.out.println("Phone : ");
				System.out.println("City : "+city);
				
				System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4));
				System.out.println("----------------------------------");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
