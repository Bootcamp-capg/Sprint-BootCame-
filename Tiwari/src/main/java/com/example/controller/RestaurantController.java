package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.CustomerAlreadyPresentException;
import com.example.Exception.RestaurantAlreadyPresentException;
import com.example.Service.CustomerService;
import com.example.Service.RestaurantService;
import com.example.entity.Customer;
import com.example.entity.Restaurant;

@RestController
@RequestMapping("/")
public class RestaurantController {

		@Autowired
		RestaurantService restaurantService;
		
		@GetMapping("/")
		public List<Restaurant> getAllRestaurant(){		
			return restaurantService.getRestaurants();
			
		}
		
		@PostMapping("/addRestaurant")
		public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
			if(restaurantService.findRestaurantByID(restaurant.getRestaurantId()).isPresent()) {
				throw new RestaurantAlreadyPresentException("Entered id"+restaurant.getRestaurantId()+"is already present");
			}
			restaurantService.addRestaurant(restaurant);
			return restaurant;
		}
		
		@PutMapping("/edit-Restaurant")
		public Restaurant editRestaurant(@RequestBody Restaurant restaurant) {
			restaurantService.editRestaurant(restaurant);
			return restaurant;
	}

}
