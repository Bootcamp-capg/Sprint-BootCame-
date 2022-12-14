package com.example.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Exception.FoodNotFoundException;
import com.example.Exception.InvalidIdException;
import com.example.Exception.OrderAlreadyPresentException;
import com.example.Exception.OrderNotFoundException;
import com.example.Exception.RestaurantAlreadyPresentException;
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
		Orders orders = request.getOrders();
		Payment payment = request.getPayment();

		payment.setOrderId(orders.getId());
		payment.setAmount(orders.getPrice());
		//ordersRepository.save(orders);
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
	public Optional<Orders> findOrderById(int orderId) {
		if (orderId < 0 ) {
			throw new InvalidIdException("Either cartId Or orderId Is Invalid Please Enter Correct ");
		}
		return ordersRepository.findById(orderId);
		
	}

	@Override
	public Orders addOrders(Orders orders) {
		if(orders.getId()<0) {
			 throw new InvalidIdException("Please Enter Valid order Id");
		}
		else {
		return ordersRepository.save(orders);
		}
	}

	@Override
	public Orders addOrdersDto(OrdersInputDto ordersDto) {
		Orders ordersInputDto = new Orders();
		ordersInputDto.setQty(ordersDto.getQty());
		ordersInputDto.setPrice(ordersDto.getPrice());
		
		//ordersInputDto.setId(ordersDto.getId());
		return ordersRepository.save(ordersInputDto);
	}

}
