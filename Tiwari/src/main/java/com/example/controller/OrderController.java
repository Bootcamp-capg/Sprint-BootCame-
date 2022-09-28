package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.InvalidIdException;
import com.example.Service.CartService;
import com.example.Service.OrderService;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.dto.OrdersInputDto;
import com.example.entity.Cart;

import com.example.entity.Orders;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;

	@Autowired
	CartService cartService;

	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		return orderService.saveOrder(request);
	}
	@GetMapping("/getOrder/{orderId}")
	private ResponseEntity<Optional<Orders>> getOrders(@PathVariable int orderId){
		return new ResponseEntity<Optional<Orders>>(orderService.findOrderById(orderId),HttpStatus.FOUND);
	}

	@PutMapping("/{cartId}/addcart/{orderId}")
	private ResponseEntity<Orders> addCart(@PathVariable int ordersId, @PathVariable int cartId) {
		if (ordersId < 0 || cartId < 0) {
			throw new InvalidIdException("Either cartId Or orderId Is Invalid Please Enter Correct ");
		} else {
			Cart cart = cartService.findCartById(cartId).get();
			Orders orders = orderService.findOrderById(ordersId).get();
			orders.setCart(cart);
			return new ResponseEntity<Orders>(orderService.addOrders(orders), HttpStatus.OK);
		}

	}

	@PutMapping("/{OrdersId}")
	public ResponseEntity<Orders> addCartPrice(@PathVariable int ordersId) {
		if (ordersId < 0)
			throw new InvalidIdException("Please Enter Valid cart Id");
		else {
			Orders orders = orderService.findOrderById(ordersId).get();
			int price = orders.getCart().getFinalPrice();
			int qyt = orders.getCart().getQuantity();

			orders.setPrice(price);
			orders.setQty(qyt);

			return new ResponseEntity<Orders>(orderService.addOrders(orders), HttpStatus.OK);
		}
	}
	@PostMapping("/add/dto")
	ResponseEntity<Orders> addOrders(@RequestBody OrdersInputDto ordersInputDto) {
		Orders ordersDto = orderService.addOrdersDto(ordersInputDto);
		return new ResponseEntity<Orders>(ordersDto, HttpStatus.OK);
	}

}
