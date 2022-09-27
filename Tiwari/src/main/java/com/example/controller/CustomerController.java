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
import com.example.Service.RestaurantService;
import com.example.dto.CustomerInputDto;
import com.example.dto.FoodInputDto;
import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.entity.Restaurant;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	RestaurantService restaurantService;

	@GetMapping("/")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomers();

	}

	@PostMapping("/add-Customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		if (customerService.findCustomerByID(customer.getCustomerId()).isPresent())
			throw new CustomerAlreadyPresentException(
					"Entered id" + customer.getCustomerId() + "is already Present Please Enter another id");

		customerService.addCustomer(customer);
		return customer;

	}
	
	@PostMapping("/add/dto")
	ResponseEntity<Customer> addCustomer(@RequestBody CustomerInputDto customerInputDto) {
		Customer customerDto = customerService.addCustomerDto(customerInputDto);
		return new ResponseEntity<Customer>(customerDto, HttpStatus.OK);
	}

	@PutMapping("/edit-Customer")
	public Customer editCustomer(@RequestBody Customer customer) {
		customerService.editCustomer(customer);
		return customer;
	}

	@GetMapping("/{name}")
	public Customer getByCustomerName(@PathVariable("name") String name) {
		return customerService.findCustomerByName(name);

	}
	
	@PutMapping("/{customerId}/addresturant/{restaurantId}")
	private ResponseEntity<Customer> addRestaurant(@PathVariable int customerId, @PathVariable int restaurantId) {
		if (customerId < 0 || restaurantId < 0) {
			throw new EnterValidDetailsException("Either customerId Or restaurantId Is Invalid Please Enter Correct ");
		} else {
			Customer customer = customerService.findCustomerByID(customerId).get();
			Restaurant restaurant = restaurantService.findRestaurantByID(restaurantId).get();
			customer.setRestaurant(restaurant);
			return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.ACCEPTED);
		}

	}
}
