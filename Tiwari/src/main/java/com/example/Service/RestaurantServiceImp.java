package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.EmailOrPasswordException;
import com.example.Exception.FoodNotFoundException;
import com.example.Exception.InvalidIdException;
import com.example.Exception.ListEmptyException;
import com.example.Exception.RestaurantAlreadyPresentException;
import com.example.Exception.RestaurantNotFoundException;
import com.example.dto.RestaurantInputDto;
import com.example.entity.Customer;
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

		} 
		
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
		restaurantInputDto.setRestaurantAddress(restaurantDto.getRestaurantAddress());
		restaurantInputDto.setRestaurantContact(restaurantDto.getRestaurantContact());
		restaurantInputDto.setEmail(restaurantDto.getEmail());
		restaurantInputDto.setPassword(restaurantDto.getPassword());
	
		return restaurantRepository.save(restaurantInputDto);
	}

	@Override
	public Optional<Restaurant> findByRestaurantName(String restaurantName) {
		return restaurantRepository.findByRestaurantName(restaurantName);
	}

	@Override
	public void deleteById(int id) {
		restaurantRepository.deleteById(id);
	}

	@Override
	public Optional<Restaurant> findByEmail(String email) {
		return restaurantRepository.findByEmail(email);
	}
	
	@Override
	public Restaurant findByEmailAndPassword(String email, String password) {
		Restaurant result=restaurantRepository.findByEmailAndPassword(email,password);
		if(result==null)
		   throw new EmailOrPasswordException("error in ur passsword or email");
		return restaurantRepository.findByEmailAndPassword(email, password);
	}

	

}
