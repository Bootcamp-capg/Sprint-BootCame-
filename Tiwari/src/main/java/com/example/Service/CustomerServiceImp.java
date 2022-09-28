package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.Exception.CustomerAlreadyPresentException;
import com.example.dto.CustomerInputDto;
import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		if (customerRepository.findById(customer.getCustomerId()).isPresent())
			throw new CustomerAlreadyPresentException(
					"Entered id" + customer.getCustomerId() + "is already Present Please Enter another id");
		return customerRepository.save(customer);
		
		
	}

	@Override
	public Customer editCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		return (List<Customer>) customerRepository.findAll();
		
	}

	@Override
	public Optional<Customer> findCustomerByID(int customerId) {
		return customerRepository.findById(customerId);
		
	}

	@Override
	public Customer findCustomerByName(String name) {
	return	customerRepository.findCustomerByName(name);
		
	}

	@Override
	public Customer addCustomerDto(CustomerInputDto customerDto) {
		// create department object
				Customer customerInputDto = new Customer();
				
				// Update dept name
				customerInputDto.setCustomerName(customerDto.getName());
				customerInputDto.setCustomerAddress(customerDto.getCustomerAddress());
				customerInputDto.setCustomerContact(customerDto.getCustomerContact());
				
				
				// save dept obj in db 
				return customerRepository.save(customerInputDto);
		
	}

}
