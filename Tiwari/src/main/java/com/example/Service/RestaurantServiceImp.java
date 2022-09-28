package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.FoodNotFoundException;
import com.example.Exception.InvalidIdException;
import com.example.Exception.ListEmptyException;
import com.example.Exception.RestaurantAlreadyPresentException;
import com.example.Exception.RestaurantNotFoundException;
import com.example.dto.RestaurantInputDto;
import com.example.entity.Restaurant;
import com.example.repository.RestaurantRepository;

@Service
public class RestaurantServiceImp implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		if(restaurant.getId()<0) {
			 throw new InvalidIdException("Please Enter Valid Restaurant Id");
		}
		else {
		if (restaurantRepository.findById(restaurant.getId()).isPresent()) {
			throw new RestaurantAlreadyPresentException(
					"Entered id" + restaurant.getId() + "is already present");
		}
		return restaurantRepository.save(restaurant);
		}
		
	}

	@Override
	public Restaurant editRestaurant(Restaurant restaurant) {
		Optional<Restaurant> newRestaurant = restaurantRepository.findById(restaurant.getId());
		if(!newRestaurant.isPresent()) {
			throw new RestaurantNotFoundException("restaurant does not exist with id"+restaurant.getId());
		}
		else {
			return restaurantRepository.save(restaurant);
		}
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
		if (restaurantId < 0) {
			throw new InvalidIdException("Please Enter Valid Food Id");

		} else {
			if (!restaurantRepository.findById(restaurantId).isPresent()) {
				throw new FoodNotFoundException("Food not found with foodId " + restaurantId);
			}
		
		return restaurantRepository.findById(restaurantId);
		}
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
