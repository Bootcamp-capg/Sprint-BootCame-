package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.CartService;
import com.example.Service.OrdersService;

@RestController
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	OrdersService orderService;
	
	@Autowired
	CartService cartService;

}
