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
import com.example.Exception.FoodAlreadyPresentException;
import com.example.Exception.FoodNotFoundException;
import com.example.Exception.ListEmptyException;
import com.example.Service.CartService;
import com.example.Service.CustomerService;
import com.example.Service.FoodService;
import com.example.Service.RestaurantService;
import com.example.dto.FoodInputDto;
import com.example.entity.Cart;
import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.entity.Restaurant;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {

	@Autowired
	FoodService foodService;

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	CustomerService customerService;

	@GetMapping("/")
	public ResponseEntity<List<Food>> getAllFoods() {
		return new ResponseEntity<List<Food>>(foodService.getAllFoods(), HttpStatus.OK);
	}

	@GetMapping("/{foodId}")
	public ResponseEntity<Food> getByFoodId(@PathVariable int foodId) {
		return new ResponseEntity<Food>(foodService.findFoodById(foodId).get(), HttpStatus.FOUND);
	}

	@PostMapping("/add-Food")
	public ResponseEntity<Food> saveFood(@RequestBody Food food) {
		return new ResponseEntity<Food>(foodService.addFood(food), HttpStatus.CREATED);

	}

	@PostMapping("/add/dto")
	ResponseEntity<Food> addFood(@RequestBody FoodInputDto food) {

		return new ResponseEntity<>(foodService.addFoodDto(food), HttpStatus.OK);
	}

	@PutMapping("/{foodId}/addresturant/{restaurantId}")
	private ResponseEntity<Food> addRestaurant(@PathVariable int foodId, @PathVariable int restaurantId) {

		Food food = foodService.findFoodById(foodId).get();
		Restaurant restaurant = restaurantService.findRestaurantByID(restaurantId).get();
		food.setRestaurant(restaurant);
		return new ResponseEntity<Food>(foodService.addFood(food), HttpStatus.OK);

	}

	@PutMapping("/{foodId}/addcustomer/{customerId}")
	private ResponseEntity<Food> addCustomer(@PathVariable int foodId, @PathVariable int customerId) {
		Food food = foodService.findFoodById(foodId).get();
		Customer customer = customerService.findCustomerByID(customerId).get();
		food.setCustomer(customer);
		return new ResponseEntity<Food>(foodService.addFood(food), HttpStatus.ACCEPTED);

	}

	@GetMapping("/getbyrestaurentid/{id}")
	public ResponseEntity<List<Food>> getAllByRestaurantId(@PathVariable int id) {

		return new ResponseEntity<List<Food>>(foodService.findAllFoodByRestaurantId(id), HttpStatus.OK);
	}

	@GetMapping("/getbycustomerid/{id}")
	public ResponseEntity<List<Food>> getAllByCustomerId(@PathVariable int id) {

		return new ResponseEntity<List<Food>>(foodService.findAllFoodByCustomerCustomerId(id), HttpStatus.OK);
	}

	@DeleteMapping("deletebyid/{id}")
	public void deleteByName(@PathVariable int id) {
		foodService.deleteByFoodId(id);
	}
}
