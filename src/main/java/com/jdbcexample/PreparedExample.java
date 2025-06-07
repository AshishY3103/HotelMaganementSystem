package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/companydb","root","Ashish");
			
			//Insert Operation
			System.out.println("\nInsert Operation");
			PreparedStatement ps = conn.prepareStatement("Insert into person values (?,?,?)");
			
			ps.setInt(1,5);
			ps.setString(2,"Amol");
			ps.setString(3,"2011-08-10");
			
			System.out.println("Row affected : "+ps.executeUpdate());
			
			//Select 
			System.out.println("\nSelect Operation");
			ResultSet rs =  ps.executeQuery("Select * from person");
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" - "+rs.getString("name")+" - "+rs.getString("dob"));
			}
			
			//Update Operation
			System.out.println("\nUpdate Oeration");
			ps = conn.prepareStatement("Update employees set salary = (?), department = (?) , experience = (?) where id = (?) ");
			ps.setInt(1, 23000);
			ps.setString(2, "Anant");
			ps.setInt(3, 6);
			ps.setInt(4, 101);
			
			System.out.println("Row affected : "+ps.executeUpdate());
			
			
			//Delete Operation
			System.out.println("\nDelete Operation");
			ps = conn.prepareStatement("Delete from person where id = (?)");
			ps.setInt(1, 5);
			System.out.println("Row affected : "+ps.executeUpdate());
			
			
			
			
			

	}

}
