package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.OrderService;
import com.example.Service.PaymentService;
import com.example.dto.PaymentInputDto;
import com.example.entity.Cart;
import com.example.entity.Orders;
import com.example.entity.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment)
	{
		return paymentService.doPayment(payment);
		
	}
	
	@PostMapping("/add/dto")
	ResponseEntity<Payment> addOrders(@RequestBody PaymentInputDto paymentInputDto) {
		Payment paymentDto = paymentService.addPaymentDto(paymentInputDto);
		return new ResponseEntity<Payment>(paymentDto, HttpStatus.OK);
	}

	@PutMapping("/{ordersId}/addorders/{paymentId}")
	private ResponseEntity<Payment> addOrder(@PathVariable int paymentId, @PathVariable int ordersId) {
		
			Orders orders = orderService.findOrderById(ordersId).get();
			Payment payment = paymentService.findPaymentById(paymentId).get();
			int price =orders.getPayment().getOrders().getPrice();
			payment.setAmount(price);
			return new ResponseEntity<Payment>(paymentService.addPayment(payment), HttpStatus.OK);
		

	}

}

