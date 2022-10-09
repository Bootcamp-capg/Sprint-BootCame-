package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.entity.Restaurant;
import com.example.entity.UserLogin;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:3000")
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
	public ResponseEntity<Restaurant> getByRestaurantId(@PathVariable int restaurantId) {
		
			return new ResponseEntity<Restaurant>(restaurantService.findRestaurantByID(restaurantId).get(),
					HttpStatus.FOUND);
		
	}

	@PostMapping("/getbyaddress/{restaurantaddress}")
	public ResponseEntity<List<Restaurant>> getByRestaurantAddress(@PathVariable("restaurantaddress") String restaurantAddress) {
		return new ResponseEntity<List<Restaurant>> (restaurantService.findAllByRestaurantAddress(restaurantAddress), HttpStatus.FOUND);

	}
	/*
	 * @GetMapping("/login/{restaurantemail}/{password}") public
	 * ResponseEntity<Optional<Restaurant>> login(@PathVariable("restaurantemail")
	 * String email,@PathVariable("password") String password) { Restaurant
	 * rest=restaurantService.findByEmail(email).get();
	 * if(rest.getPassword().equals(password)) {
	 * 
	 * return new ResponseEntity<Optional<Restaurant>>
	 * (restaurantService.findByEmail(email), HttpStatus.FOUND); } else return null;
	 * 
	 * }
	 */
	
	@PostMapping("/login")
	public ResponseEntity<Restaurant> checkLogin(@RequestBody UserLogin userLogin) {
		return new ResponseEntity<Restaurant>(restaurantService.findByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword()), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public void delateByRestaurantId(@PathVariable int id){
		restaurantService.deleteById(id);
	}
	
	@PostMapping("/add/dto")
	ResponseEntity<Restaurant> addRestaurantDto(@RequestBody RestaurantInputDto restaurantInputDto) {
		
		return new ResponseEntity<Restaurant>(restaurantService.addRestaurantDto(restaurantInputDto), HttpStatus.OK);
	}
	
	@GetMapping("/getbyemail/{restaurantemail}/{password}")
	public ResponseEntity<Restaurant> getByRestaurantEmail(@PathVariable("restaurantemail") String email,@PathVariable("password") String password) {
		Restaurant rest=restaurantService.findByEmail(email).get();
		if(rest.getPassword().equals(password)) {
			
		return new ResponseEntity<Restaurant> (restaurantService.findByEmail(email).get(), HttpStatus.OK);
		}
		else
			throw new RestaurantNotFoundException("Invalid Credentials");

	}

}
