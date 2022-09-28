package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ListEmptyException;
import com.example.dto.RestaurantInputDto;
import com.example.entity.Restaurant;
import com.example.repository.RestaurantRepository;

@Service
public class RestaurantServiceImp implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Override
	public Restaurant editRestaurant(Restaurant restaurant) {
		Optional<Restaurant> newRestaurant = restaurantRepository.findById(restaurant.getId());
		newRestaurant.get().setId(restaurant.getId());
		newRestaurant.get().setRestaurantName(restaurant.getRestaurantName());
		newRestaurant.get().setRestaurantContact(restaurant.getRestaurantContact());
		// newEmployee.get().setEmail(employee.getEmail());
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		List<Restaurant> rest= (List<Restaurant>) restaurantRepository.findAll();;
		if(rest.isEmpty())
			throw new ListEmptyException("No Restaurant present");
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	@Override
	public Optional<Restaurant> findRestaurantByID(int restaurantId) {
		
		return restaurantRepository.findById(restaurantId);
	}

	@Override
	public Optional<Restaurant> findByRestaurantAddress(String restaurantAddress) {

		return restaurantRepository.findByRestaurantAddress(restaurantAddress);
	}

	@Override
	public Restaurant addRestaurantDto(RestaurantInputDto restaurantDto) {
		
		Restaurant restaurantInputDto = new Restaurant();

		restaurantInputDto.setRestaurantName(restaurantDto.getRestaurantName());
		restaurantInputDto.setRestauranttAddress(restaurantDto.getRestaurantAddress());
		restaurantInputDto.setRestaurantContact(restaurantDto.getRestaurantContact());
	
		return restaurantRepository.save(restaurantInputDto);
	}

	

}
