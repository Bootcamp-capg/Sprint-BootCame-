package com.example.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@Autowired
	private OrderService orderService;

	/*
	 * @PostMapping("/doPayment") public Payment doPayment(@RequestBody Payment
	 * payment) { return paymentService.doPayment(payment);
	 * 
	 * }
	 */

	@GetMapping("/getpayment/{paymentid}")
	private ResponseEntity<Optional<Payment>> getOrders(@PathVariable int paymentId){
		return new ResponseEntity<Optional<Payment>>(paymentService.findPaymentById(paymentId),HttpStatus.OK);
	}
	

	
	  @PostMapping("/add/dto") ResponseEntity<Payment> addOrders(@RequestBody  PaymentInputDto paymentInputDto) 
	  { Payment paymentDto =  paymentService.addPaymentDto(paymentInputDto); 
	  return new  ResponseEntity<Payment>(paymentDto, HttpStatus.OK); 
	  }
	  
	  @PutMapping("/{ordersId}/addorders/{paymentId}") 
	  private  ResponseEntity<Payment> addOrder(@PathVariable int paymentId, @PathVariable int ordersId) {
	  
	  Orders orders = orderService.findOrderById(ordersId).get(); 
	  Payment payment =  paymentService.findPaymentById(paymentId).get();
	  payment.setPaymentStatus(paymentService.paymentProcessing());
	  payment.setTransactionId(UUID.randomUUID().toString());
	  
	  int price =orders.getCart().getFinalPrice();
	  payment.setAmount(price);
	  
	  payment.setOrders(orders); 
	  return new  ResponseEntity<Payment>(paymentService.addPayment(payment), HttpStatus.OK);
	  
	  
	  }
	  
		/*
		 * @PutMapping("/{paymentId}") public ResponseEntity<Payment>
		 * addCartPrice(@PathVariable int paymentId) {
		 * 
		 * Payment payment = paymentService.findPaymentById(paymentId).get(); int price
		 * = payment.getOrders().getPrice();
		 * 
		 * payment.setAmount(price); return new
		 * ResponseEntity<Payment>(paymentService.addPayment(payment), HttpStatus.OK);
		 * 
		 * }
		 */
	 
}
