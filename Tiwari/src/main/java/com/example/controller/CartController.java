package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.EnterValidDetailsException;
import com.example.Exception.FoodNotFoundException;
import com.example.Service.CartService;
import com.example.Service.CustomerService;
import com.example.entity.Cart;
import com.example.entity.Customer;
import com.example.entity.Food;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	CustomerService customerService;

	@PutMapping("/{cartId}/addcustomer/{customerId}")
	private ResponseEntity<Cart> addCart(@PathVariable int customerId, @PathVariable int cartId) {
		if (cartId < 0 || customerId < 0) {
			throw new EnterValidDetailsException("Either cartId Or customerIdId Is Invalid Please Enter Correct ");
		} else {
			Customer customer = customerService.findCustomerByID(customerId).get();
			Cart cart = cartService.findCartById(cartId).get();
			cart.setCustomer(customer);
			return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.ACCEPTED);
		}

	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getByFoodId(@PathVariable int cartId) {
		if (cartId < 0) {
			throw new EnterValidDetailsException("Please Enter Valid Food Id");

		} else {
			if (!cartService.findCartById(cartId).isPresent()) {
				throw new FoodNotFoundException("Food not found with foodId " + cartId);
			}
			return new ResponseEntity<Cart>(cartService.findCartById(cartId).get(), HttpStatus.FOUND);
		}
	}

}