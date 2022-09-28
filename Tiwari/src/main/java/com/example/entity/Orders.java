package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Orders {

	@Id
	private int id;
	@NotEmpty(message = "Please enter customer Name")
	private String name;
	@Min(value=1, message="quantity can't be 0")
	private int qty;
	@Min(value=1, message="price can't be 0")
	private int price;
	
	@OneToOne()
	@JoinColumn(name = "cart_id")
	private  Cart cart;
	
	
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
