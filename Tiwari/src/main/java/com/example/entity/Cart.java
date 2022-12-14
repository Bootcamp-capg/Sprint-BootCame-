package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private int finalPrice;
	@Column(nullable=false)
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	@OneToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne(mappedBy = "cart")
	private Orders orders;

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
