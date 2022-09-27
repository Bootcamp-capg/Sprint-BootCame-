package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	@Id
	private int orderId;
	private String OrderDate;
	private String OrderTime;
	
	@OneToOne()
	@JoinColumn(name = "cart_id")
	private  Customer  cart;
	
	public Customer getCart() {
		return cart;
	}
	public void setCart(Customer cart) {
		this.cart = cart;
	}
	public Orders(int orderId, String orderDate, String orderTime) {
		super();
		this.orderId = orderId;
		OrderDate = orderDate;
		OrderTime = orderTime;
	}
	public Orders() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	
	
}
