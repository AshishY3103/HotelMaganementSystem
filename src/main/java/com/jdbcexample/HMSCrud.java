package com.jdbcexample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HMSCrud {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        CustomerServices cs = new CustomerServices(); 
        while (true) {
            System.out.println("\n----------------- Hotel Management System -----------------------");
            System.out.println("1. Add Customer ");
            System.out.println("2. Update Customer ");
            System.out.println("3. Delete Customer ");
            System.out.println("4. View All Customers ");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email id: ");
                    String email = sc.nextLine();
                    System.out.print("Enter room id: ");
                    int room = sc.nextInt();
                    System.out.print("Enter payment status (1. Paid / 2. Pending): ");
                    String status = (sc.nextInt() == 1) ? "Paid" : "Pending";
                    sc.nextLine(); 

                    Customer c = new Customer(name, email, room, status);
                    cs.addCustomer(c);
                    break;

                case 2:
                    System.out.print("Enter Customer ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter new room id: ");
                    int newRoom = sc.nextInt();
                    System.out.print("Enter new payment status (1. Paid / 2. Pending): ");
                    String newStatus = (sc.nextInt() == 1) ? "Paid" : "Pending";
                    sc.nextLine();

                    Customer updatedCustomer = new Customer(newName, newEmail, newRoom, newStatus);
                    cs.updateCustomer(updateId,updatedCustomer);
                    System.out.println("Customer Updated Successfully!");
                    break;

                case 3:
                    System.out.print("Enter Customer ID to Delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    cs.deleteCustomer(deleteId);
                    System.out.println("Customer Deleted Successfully!");
                    break;

                case 4:
                    List<Customer> allCustomers = cs.getAllCustomers();
                    System.out.println("\n--- All Customers ---");
                    for (Customer customer : allCustomers) {
                       System.out.println(customer);
                    }
                    break;

                case 0:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid Choice. Please try again.");
            }

            System.out.print("\nDo you want to continue? (yes/no): ");
            String continueChoice = sc.nextLine();
            if (continueChoice.equalsIgnoreCase("no")) {
                System.out.println("Exiting... Thank you!");
                break;
            }
        }

        sc.close();
		

	}

}
