package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dto.FoodInputDto;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	public Customer editCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Optional<Customer> findCustomerByID(int customerId);
	//public Optional<Customer> findByName(int customerName);
	

}
