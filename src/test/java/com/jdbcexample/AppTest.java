package com.jdbcexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static final String URL = "jdbc:mysql://localhost:3306/Hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "Ashish";

    private Connection conn;

    @Before
    public void setUp() throws Exception {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void testAddGuest() throws Exception {
       // String sql = "INSERT INTO customer (name, room_number, check_in_date) VALUES (?, ?, ?)";
    	String sql = "INSERT INTO customer (name, email, roomId, bookingDate, paymentStatus) VALUES (?, ?, ?, NOW(), ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, "John Doe");
        stmt.setString(2, "john@gmail.com");
        stmt.setInt(3, 101);
        stmt.setString(4, "Paid");
        int affectedRows = stmt.executeUpdate();
        
        assertEquals("Guest addition failed!",affectedRows,1);
    }
    
    @Test
    public void deleteGuest() throws SQLException {
    	String sql = "DELETE FROM customer WHERE id = ?";
    	
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, 4);
        
        int affectedRows = stmt.executeUpdate();
        
        assertEquals("Guest addition failed!",affectedRows,1);
    }
    
    @Test
    public void updateCustomer() throws SQLException {
        String query = "UPDATE customer SET name = ?, email = ?, roomId = ?, paymentStatus = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, "Harry Doe");
        stmt.setString(2, "harry@gmail.com");
        stmt.setInt(3, 101);
        stmt.setString(4, "Paid");
        stmt.setInt(5, 7);
        int affectedRows = stmt.executeUpdate();
        
        assertEquals("Guest addition failed!",affectedRows,1);
        
    }
   
}
