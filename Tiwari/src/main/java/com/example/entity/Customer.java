package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private String customerAddress;
	private long customerContact;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustId(int custId) {
		this.customerId = custId;
	}
	public String getCustName() {
		return getCustName();
	}
	public void setCustName(String custName) {
		this.customerName = custName;
	}
	public String getCustAddress() {
		return customerAddress;
	}
	public void setCustAddress(String custAddress) {
		this.customerAddress = custAddress;
	}
	public long getCustContact() {
		return customerContact;
	}
	public void setCustContact(int custContact) {
		this.customerContact = custContact;
	}
	
	public Customer(int custId, String custName, String custAddress, int custContact) {
		super();
		this.customerId = custId;
		this.customerName = custName;
		this.customerAddress = custAddress;
		this.customerContact = custContact;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
