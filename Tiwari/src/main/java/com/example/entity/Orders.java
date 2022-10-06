package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {

	@Id
	
	private int id;

	private String name;
	@Column(nullable = false)
	private int qty;
	@Column(nullable = false)
	private int price;
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@OneToOne(mappedBy = "orders")
	private Payment payment;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Orders(int id, String name, int qty, int price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public Orders() {

	}
}
