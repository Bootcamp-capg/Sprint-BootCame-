package com.example.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Order {
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderNumber, Date orderDate, Time orderTime) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}

	private int orderNumber;
	private Date orderDate;
	private Time orderTime;
	
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Time getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}
	
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", orderTime=" + orderTime + "]";
	}
}
