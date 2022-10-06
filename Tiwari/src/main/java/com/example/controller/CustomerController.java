package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.InvalidIdException;
import com.example.Service.CustomerService;
import com.example.Service.RestaurantService;
import com.example.dto.CustomerInputDto;
import com.example.entity.Customer;
import com.example.entity.Restaurant;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
	}

	@PostMapping("/add-Customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		

		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);

	}
	
	@PostMapping("/add/dto")
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerInputDto customerInputDto) {
		
		return new ResponseEntity<Customer>(customerService.addCustomerDto(customerInputDto), HttpStatus.OK);
	}

	@PutMapping("/edit-Customer")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
		
		return new ResponseEntity<Customer>(customerService.editCustomer(customer), HttpStatus.ACCEPTED);
	}

	
	
	@DeleteMapping("deletebyname/{name}")
	public ResponseEntity<Optional<Customer>> deleteByName(@PathVariable("name") String name){
		return new ResponseEntity<Optional<Customer>>(customerService.deleteByName(name),HttpStatus.OK);
	}
	
	@PutMapping("/{customerId}/addresturant/{restaurantId}")
	private ResponseEntity<Customer> addRestaurant(@PathVariable int customerId, @PathVariable int restaurantId) {
		if (customerId < 0 || restaurantId < 0) {
			throw new InvalidIdException("Either customerId Or restaurantId Is Invalid Please Enter Correct ");
		} else {
			Customer customer = customerService.findCustomerByID(customerId).get();
			Restaurant restaurant = restaurantService.findRestaurantByID(restaurantId).get();
			customer.setRestaurant(restaurant);
			return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.ACCEPTED);
		}

	}
}