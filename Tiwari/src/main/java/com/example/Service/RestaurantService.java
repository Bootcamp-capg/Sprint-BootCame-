package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.dto.CustomerInputDto;
import com.example.dto.RestaurantInputDto;

import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.entity.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant);
	
	public Restaurant editRestaurant(Restaurant restaurant);
	
	public List<Restaurant> getRestaurants();
	
	public Optional<Restaurant> findRestaurantByID(int restaurantId);
	
	public Optional<Restaurant> findByRestaurantAddress(String restaurantAddress);
	
	public Optional<Restaurant> findByRestaurantName(String restaurantName);
	
	public Optional<Restaurant> deleteByRestaurantName(String restaurantName);
	
	public Restaurant addRestaurantDto(RestaurantInputDto restaurantDto);
}
