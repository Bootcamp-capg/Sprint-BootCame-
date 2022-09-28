package com.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	private int id;
	
	private int finalPrice;
	
	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	@OneToOne()
	@JoinColumn(name = "customer_id")
	private  Customer  customer;
	
	
	
	
	

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public void setFood(List<Food> food) { this.food = food; }
	 */

}
