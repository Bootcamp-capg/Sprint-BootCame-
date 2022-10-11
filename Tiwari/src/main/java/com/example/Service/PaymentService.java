package com.example.Service;

import java.util.Optional;

import com.example.dto.PaymentInputDto;
import com.example.entity.Orders;
import com.example.entity.Payment;

public interface PaymentService {
	public String paymentProcessing();
	public Payment doPayment(Payment payment);
	public Payment addPaymentDto(PaymentInputDto payment);
	public Payment addPayment(Payment payment);
	//public Optional<Orders> findPaymentById(int orderId);
	public Optional<Payment> getByPaymentId(int paymentId);

}
