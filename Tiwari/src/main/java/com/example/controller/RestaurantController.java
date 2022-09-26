package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.CustomerAlreadyPresentException;
import com.example.Exception.EnterValidDetailsException;
import com.example.Exception.FoodNotFoundException;
import com.example.Exception.RestaurantAlreadyPresentException;
import com.example.Service.CustomerService;
import com.example.Service.RestaurantService;
import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.entity.Restaurant;

@RestController
@RequestMapping("/restaurant")
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
		@GetMapping("/{restaurantId}")
	    public ResponseEntity<Restaurant> getByFoodId(@PathVariable int restaurantId) {
			if(restaurantId<0) {
				throw new EnterValidDetailsException("Please Enter Valid Food Id");
				
			}
			else {
	    	if(!restaurantService.findRestaurantByID(restaurantId).isPresent()) {
				throw new FoodNotFoundException("Food not found with foodId "+ restaurantId);
			}
			return new ResponseEntity<Restaurant>(restaurantService.findRestaurantByID(restaurantId).get(), HttpStatus.FOUND);
	    }

}
		
}
