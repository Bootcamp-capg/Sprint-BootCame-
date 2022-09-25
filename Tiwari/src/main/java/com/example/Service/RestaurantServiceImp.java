package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Restaurant;
import com.example.repository.RestaurantRepository;

@Service
public class RestaurantServiceImp implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Override
	public Restaurant editRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Optional<Restaurant> findRestaurantByID(int restaurantId) {
		return restaurantRepository.findById(restaurantId);
	}

}
