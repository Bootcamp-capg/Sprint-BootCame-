package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.dto.CartInputDto;
import com.example.dto.OrdersInputDto;
import com.example.entity.Cart;
import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.entity.Orders;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	public OrderService orderService;

	@Autowired
	public CartService cartService;

	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		return orderService.saveOrder(request);
	}

	@PutMapping("/{ordertId}/addcart/{cartId}")
	private ResponseEntity<Orders> addCart(@PathVariable int orderId, @PathVariable int cartId) {
		if (orderId < 0 || cartId < 0) {
			throw new InvalidIdException("Either cartId Or orderId Is Invalid Please Enter Correct ");
		} else {
			Cart cart = cartService.findCartById(cartId).get();
			Orders order = orderService.findOrderById(orderId).get();
			order.setCart(cart);
			return new ResponseEntity<Orders>(orderService.addOrders(order), HttpStatus.OK);
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
