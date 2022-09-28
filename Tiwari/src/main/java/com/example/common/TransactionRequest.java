package com.example.common;

import com.example.entity.Orders;





public class TransactionRequest {
	
	

	private Orders order;
	private Payment payment;
	
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Orders getOrder() {
		return order;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Payment getPayment() {
		return payment;
	}
	public TransactionRequest(Orders order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}
	public TransactionRequest() {
		super();
	}


}
