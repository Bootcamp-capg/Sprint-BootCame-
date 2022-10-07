package com.example.repository;

import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;
import com.example.entity.Restaurant;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	public Optional<Customer> deleteByName(String name);
	public Customer findByEmailAndPassword(String email,String password);

}
