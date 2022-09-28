package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.OrderService;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	public OrderService orderService;
	
	
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request)
	{
		return orderService.saveOrder(request);
	}

}
