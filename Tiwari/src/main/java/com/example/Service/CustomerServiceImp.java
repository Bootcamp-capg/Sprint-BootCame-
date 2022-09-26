package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
		
	}

	@Override
	public Customer editCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
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
