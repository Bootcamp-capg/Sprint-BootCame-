package com.example.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.common.Payment;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.dto.OrdersInputDto;
import com.example.entity.Cart;
import com.example.entity.Orders;
import com.example.repository.OrdersRepository;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	private RestTemplate template;

	@Override
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response = "";
		Orders orders = request.getOrder();
		Payment payment = request.getPayment();

		payment.setOrderId(orders.getId());
		payment.setAmount(orders.getPrice());
		ordersRepository.save(orders);
		// rest call
		Payment paymentResponse = template.postForObject("http://localhost:1234/payment/doPayment", payment,
				Payment.class);

		response = paymentResponse.getPaymentStatus().equals("success")
				? "payment processing successfull and order placed"
				: "there is a failure in payment api, order added to cart";

		return new TransactionResponse(orders, paymentResponse.getTransactionId(), paymentResponse.getAmount(),
				response);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public Optional<Orders> findOrderById(int ordersId) {
		return ordersRepository.findById(ordersId);
	}

	@Override
	public Orders addOrders(Orders orders) {
		return ordersRepository.save(orders);
	}

	@Override
	public Orders addOrdersDto(OrdersInputDto ordersDto) {
		Orders ordersInputDto = new Orders();

		ordersInputDto.setId(ordersDto.getId());
		return ordersRepository.save(ordersInputDto);
	}

}
