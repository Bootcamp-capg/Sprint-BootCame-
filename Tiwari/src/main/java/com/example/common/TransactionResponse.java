package com.example.common;

import com.example.entity.Orders;
public class TransactionResponse {

	 public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 private Orders orders;
	 private String transactionId;
	 private int amount;
	 private String message;
	 
	 public TransactionResponse() {
		super();
	}
	public TransactionResponse(Orders orders, String transactionId, int amount, String message) {
		super();
		this.orders = orders;
		this.transactionId = transactionId;
		this.amount = amount;
		this.message = message;
	}

}
