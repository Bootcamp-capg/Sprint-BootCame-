package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.dto.RestaurentOutputDto;
import com.example.entity.Food;
import com.example.entity.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant);
	public Restaurant editRestaurant(Restaurant restaurant);
	public List<Restaurant> getRestaurants();
	public Optional<Restaurant> findRestaurantByID(int restaurantId);
	//public List<RestaurentOutputDto> getAllFoodDto(int restaurantId);
	//public Optional<Restaurant> findRestaurantById(int restaurantId);
}
