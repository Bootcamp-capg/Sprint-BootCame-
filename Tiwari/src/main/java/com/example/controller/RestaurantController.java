package com.example.controller;

import java.util.List;
import java.util.Optional;

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


import com.example.Exception.InvalidIdException;

import com.example.Exception.FoodNotFoundException;
import com.example.Exception.ListEmptyException;
import com.example.Exception.RestaurantAlreadyPresentException;
import com.example.Exception.RestaurantNotFoundException;
import com.example.Service.RestaurantService;
import com.example.dto.RestaurantInputDto;
import com.example.entity.Food;
import com.example.entity.Restaurant;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@GetMapping("/")
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {	
		return new ResponseEntity<List<Restaurant>>(restaurantService.getRestaurants(),HttpStatus.OK);

	}
	

	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
		return new ResponseEntity<Restaurant> (restaurantService.addRestaurant(restaurant),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {
			return new ResponseEntity<Restaurant>(restaurantService.editRestaurant(restaurant), HttpStatus.OK);
		
		
	}

	@PutMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> getByFoodId(@PathVariable int restaurantId) {
		
			return new ResponseEntity<Restaurant>(restaurantService.findRestaurantByID(restaurantId).get(),
					HttpStatus.FOUND);
		
	}

	@GetMapping("/getbyaddress/{restaurantaddress}")
	public ResponseEntity<Optional<Restaurant>> getByRestaurantAddress(@PathVariable("restaurantaddress") String restaurantAddress) {
		return new ResponseEntity<Optional<Restaurant>> (restaurantService.findByRestaurantAddress(restaurantAddress), HttpStatus.FOUND);

	}
	
	@PostMapping("/add/dto")
	ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantInputDto restaurantInputDto) {
		
		return new ResponseEntity<Restaurant>(restaurantService.addRestaurantDto(restaurantInputDto), HttpStatus.OK);
	}

}
