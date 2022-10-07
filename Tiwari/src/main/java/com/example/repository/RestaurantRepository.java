package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;
import com.example.entity.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
	public Optional<Restaurant> findByRestaurantAddress(String restaurantAddress);
	public Optional<Restaurant> findByRestaurantName(String restaurantName);
	public Optional<Restaurant> deleteByRestaurantName(String restaurantName);
	public Optional<Restaurant> findByEmail(String email);
	public Restaurant findByEmailAndPassword(String email,String password);
	
}
	
	

