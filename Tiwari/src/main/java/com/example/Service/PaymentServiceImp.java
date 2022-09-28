package com.example.Service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Payment;
import com.example.repository.PaymentRepository;
@Service
public class PaymentServiceImp implements PaymentService{

	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment)
	{
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	public String paymentProcessing()
	{
		return new Random().nextBoolean()?"success":"Failure";
	}


}
