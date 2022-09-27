package com.example.entity;

import java.util.List;

import javax.persistence.Entity;
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
	
	@OneToOne(mappedBy = "cart")
	private Orders orders;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/*
	 * @OneToMany(mappedBy="restaurant") private List<Food> food;
	 */

	public int getId() {
		return id;
	}

	/*
	 * public List<Food> getFood() { return food; }
	 */

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public void setFood(List<Food> food) { this.food = food; }
	 */

}
