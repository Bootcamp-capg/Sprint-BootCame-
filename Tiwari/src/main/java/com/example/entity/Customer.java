package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	
	private int customerId;
	private String name;
	private String customerAddress;
	private long customerContact;


	@OneToOne()
	@JoinColumn(name = "restaurant_id")
	private  Restaurant  restaurant;
	
	
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
	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", customerAddress="
				+ customerAddress + ", customerContact=" + customerContact + "]";
	}
	
	 
	
	
	

}
