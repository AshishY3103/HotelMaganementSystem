package com.jdbcexample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServices {
    private Connection conn;

    public CustomerServices() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Ashish");
    }

    // Add Customer
    public void addCustomer(Customer c) throws SQLException {
        String query = "INSERT INTO customer (name, email, roomId, bookingDate, paymentStatus) VALUES (?, ?, ?, NOW(), ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, c.name);
        ps.setString(2, c.email);
        ps.setInt(3, c.roomId);
        ps.setString(4, c.paymentStatus);

        int r = ps.executeUpdate();
        if (r == 1) {
            System.out.println("Customer Added Successfully");
        } else {
            System.out.println("Failed to Add Customer");
        }
    }

    // Update Customer
    public void updateCustomer(int id, Customer c) throws SQLException {
        String query = "UPDATE customer SET name = ?, email = ?, roomId = ?, paymentStatus = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, c.name);
        ps.setString(2, c.email);
        ps.setInt(3, c.roomId);
        ps.setString(4, c.paymentStatus);
        ps.setInt(5, id);

        int r = ps.executeUpdate();
        if (r == 1) {
            System.out.println("Customer Updated Successfully");
        } else {
            System.out.println("Customer Not Found or Update Failed");
        }
    }

    // Delete Customer
    public void deleteCustomer(int id) throws SQLException {
        String query = "DELETE FROM customer WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        int r = ps.executeUpdate();
        if (r == 1) {
            System.out.println("Customer Deleted Successfully");
        } else {
            System.out.println("Customer Not Found");
        }
    }

    // Get All Customers
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Customer c = new Customer(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("roomId"),
                    rs.getString("paymentStatus")
            );
            c.id = rs.getInt("id");
            c.bookingDate = rs.getString("bookingDate");

            customers.add(c);
        }

        return customers;
    }
}
