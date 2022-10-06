package com.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	//@Size(min=3,max=20)
	private String name;
	//@Size(min=3,max=20)
	private String customerAddress;
	//@Size(min=10, max=10)
	private long customerContact;
	private String email;
	private String password;
	
	


	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToOne()
	@JoinColumn(name = "restaurant_id")
	private  Restaurant  restaurant;
	
	@OneToOne(mappedBy = "customer")
	private Cart cart;
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	@OneToMany(mappedBy="customer")
	private List<Food> food;
	
	
	  public Customer(int customerId, String name, String customerAddress,long customerContact) {
		  super(); this.customerId = customerId;
	  this.name = name; this.customerAddress = customerAddress;
	  this.customerContact = customerContact; 
	  }
	  public Customer()
		 {} 
	 
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getname() {
		return name;
	}
	public void setCustomerName(String customerName) {
		this.name = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public long getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(long contact) {
		this.customerContact = contact;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", customerAddress="
				+ customerAddress + ", customerContact=" + customerContact + "]";
	}
	
	 
	
	
	

}
