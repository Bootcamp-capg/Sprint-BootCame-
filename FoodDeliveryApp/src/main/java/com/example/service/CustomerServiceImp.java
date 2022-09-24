package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

public class CustomerServiceImp implements CustomerService {
    
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer editCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {		
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerByID(int customerId) {		
		return customerRepository.findById(customerId);
	}

}
