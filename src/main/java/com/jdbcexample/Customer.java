package com.jdbcexample;

public class Customer {
    int id;
    String name;
    String email;
    int roomId; 
    String bookingDate;
    String paymentStatus;
    
	public Customer(String name, String email, int roomId,  String paymentStatus) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.roomId = roomId;
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", roomId=" + roomId + ", bookingDate="
				+ bookingDate + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
    
    
    
    
}
