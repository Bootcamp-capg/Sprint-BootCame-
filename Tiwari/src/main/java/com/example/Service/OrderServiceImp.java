package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.common.Payment;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.entity.Orders;
import com.example.repository.OrdersRepository;
@Service
public class OrderServiceImp implements OrderService{

	@Autowired
	OrdersRepository orderRepository;
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response="";
		Orders orders = request.getOrder();
		Payment payment = request.getPayment();
		
		
		payment.setOrderId(orders.getId());
		payment.setAmount(orders.getPrice());
		orderRepository.save(orders);
		//rest call
		Payment paymentResponse = template.postForObject("http://localhost:1234/payment/doPayment", payment, Payment.class);
		
		
		
		response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successfull and order placed":"there is a failure in payment api, order added to cart";
		
		return new TransactionResponse(orders, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
	    return builder.build();
	}

}
