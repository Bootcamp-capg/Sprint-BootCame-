package com.example.entity;

import javax.persistence.Entity;


@Entity
public class Customer {
	
	private int custId;
	private String custName;
	private String custAddress;
	private int custContact;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public int getCustContact() {
		return custContact;
	}
	public void setCustContact(int custContact) {
		this.custContact = custContact;
	}
	
	public Customer(int custId, String custName, String custAddress, int custContact) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custContact = custContact;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
