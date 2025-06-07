package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null ;
         conn = DriverManager.getConnection("jdbc:mysql://localhost/companydb","root","Ashish");
//         System.out.print("Connection Establish");
         
         Statement st = conn.createStatement();
         
         ResultSet rs = null ;
         
         
         String query = "Delete from employees where id = 106";
         
         System.out.println(st.executeUpdate(query));
         
         System.out.println("Deleted Successfully");
         
         rs = st.executeQuery("Select * from employees");
         
         System.out.println("No of records : ");
         
         while(rs.next()) {
        	 System.out.println("Id : "+rs.getString("id")+
        			 "\n Name : "+rs.getString("name") +
        			 "\n Gender : "+rs.getString("gender") +
        			 "\n Salary : "+rs.getDouble("salary") +
        			 "\n Department : "+ rs.getString("department")+
        			 "\n Experience : "+rs.getInt("experience"));
        	 
        	 System.out.println();
         }
          
         
         
         
        
    }
}
