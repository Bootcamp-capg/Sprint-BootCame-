package com.example.Service;

import com.example.entity.Payment;

public interface PaymentService {
	public String paymentProcessing();
	public Payment doPayment(Payment payment);
	
	

}
