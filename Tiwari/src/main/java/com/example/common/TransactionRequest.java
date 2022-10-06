package com.example.common;

import com.example.entity.Orders;
//import com.example.entity.Payment;






public class TransactionRequest {
	
	private Orders orders;
	private Payment payment;
	
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Payment getPayment() {
		return payment;
	}
	public TransactionRequest(Orders orders, Payment payment) {
		super();
		this.orders = orders;
		this.payment = payment;
	}
	public TransactionRequest() {
		super();
	}


}
