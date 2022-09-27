package com.example.dto;

public class CustomerInputDto {

	private String name;
	private String customerAddress;
	private long customerContact;
	public String getName() {
		return name;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public long getCustomerContact() {
		return customerContact;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}
}
