package com.example.controller;

import java.util.List;

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

import com.example.Exception.CustomerAlreadyPresentException;
import com.example.Exception.EnterValidDetailsException;
import com.example.Exception.FoodNotFoundException;
import com.example.Service.CustomerService;
import com.example.entity.Customer;
import com.example.entity.Restaurant;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public List<Customer> getAllCustomers(){		
		return customerService.getCustomers();
		
	}
	
	@PostMapping("/add-Customer")
	public Customer saveCustomer(@RequestBody Customer customer) {	
		if(customerService.findCustomerByID(customer.getCustomerId()).isPresent())
			throw new CustomerAlreadyPresentException("Entered id"+customer.getCustomerId()+"is already Present Please Enter another id");
		
		customerService.addCustomer(customer);	
		return customer;
		
	}
	
	@PutMapping("/edit-Customer")
	public Customer editCustomer(@RequestBody Customer customer) {
		customerService.editCustomer(customer);
		return customer;
}
	@GetMapping("/{name}")
    public  Customer getByCustomerName(@PathVariable("name") String name) {
		return customerService.findCustomerByName(name);		
		
    	
	
    
}
}
