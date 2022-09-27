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

import com.example.Exception.EnterValidDetailsException;
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
public class FoodController {

	@Autowired
	FoodService foodService;

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartService cartService;
	
	

	@GetMapping("/")
	public ResponseEntity<List<Food>> getAllFoods() {
		List<Food> list = foodService.getAllFoods();
		if (list.isEmpty())
			throw new ListEmptyException("No Food Present");
		return new ResponseEntity<List<Food>>(list, HttpStatus.OK);
	}

	/*
	 * @GetMapping("") public ResponseEntity<List<Employee>> getAllEmployees() {
	 * List<Employee> list = managementService.getAllEmployees(); if
	 * (list.isEmpty()) throw new
	 * EmployeesEmptyException("No Employees Data is present right now"); return new
	 * ResponseEntity<List<Employee>>(list, HttpStatus.OK); }
	 */

	@GetMapping("/{foodId}")
	public ResponseEntity<Food> getByFoodId(@PathVariable int foodId) {
		if (foodId < 0) {
			throw new EnterValidDetailsException("Please Enter Valid Food Id");

		} else {
			if (!foodService.findFoodById(foodId).isPresent()) {
				throw new FoodNotFoundException("Food not found with foodId " + foodId);
			}
			return new ResponseEntity<Food>(foodService.findFoodById(foodId).get(), HttpStatus.FOUND);
		}
	}

	@PostMapping("/add-Food")
	public ResponseEntity<Food> saveFood(@RequestBody Food food) {
		if (food.getFoodId() < 0) {
			throw new EnterValidDetailsException("Please Enter Valid Food Id");}
			else {
				if(foodService.findFoodById(food.getFoodId()).isPresent())
			throw new FoodAlreadyPresentException(
					"Entered id" + food.getFoodId() + "is already Present Please Enter another id");
			}

		foodService.addFood(food);
		return new ResponseEntity<Food> (food,HttpStatus.CREATED);

	}

	@PostMapping("/add/dto")
	ResponseEntity<Food> addDepartment(@RequestBody FoodInputDto food) {
		Food foodDto = foodService.addFoodDto(food);
		return new ResponseEntity<>(foodDto, HttpStatus.OK);
	}

	/*
	 * @PutMapping("/edit-Food") public ResponseEntity<Food> editFood(@RequestBody
	 * Food food) { foodService.editFood(food); return food; }
	 */
	
	@PutMapping("/update")
    public ResponseEntity<Food> updateFoodById(@RequestBody Food food) {
    	Optional<Food> newFood = foodService.findFoodById(food.getFoodId());
    	if(!newFood.isPresent()) {
    		throw new FoodNotFoundException("food does not exist with id "+food.getFoodId());
    	}
    	else {
    		newFood.get().setFoodId(food.getFoodId());
    		newFood.get().setFoodName(food.getFoodName());
    		newFood.get().setFoodPrice(food.getFoodPrice());
    		//newEmployee.get().setEmail(employee.getEmail());
    		return new ResponseEntity<Food>(foodService.addFood(newFood.get()), HttpStatus.OK);
    	}
    }

	@PutMapping("/{foodId}/addresturant/{restaurantId}")
	private ResponseEntity<Food> addRestaurant(@PathVariable int foodId, @PathVariable int restaurantId) {
		if (restaurantId < 0 || foodId < 0) {
			throw new EnterValidDetailsException("Either empId Or managerId Is Invalid Please Enter Correct ");
		} else {
			Food food = foodService.findFoodById(foodId).get();
			Restaurant restaurant = restaurantService.findRestaurantByID(restaurantId).get();
			food.setRestaurant(restaurant);
			return new ResponseEntity<Food>(foodService.addFood(food), HttpStatus.ACCEPTED);
		}

	}
	
	@PutMapping("/{foodId}/addcustomer/{customerId}")
	private ResponseEntity<Food> addCustomer(@PathVariable int foodId, @PathVariable int customerId) {
		if (customerId < 0 || foodId < 0) {
			throw new EnterValidDetailsException("Either empId Or managerId Is Invalid Please Enter Correct ");
		} else {
			Food food = foodService.findFoodById(foodId).get();
			Customer customer = customerService.findCustomerByID(customerId).get();
			food.setCustomer(customer);
			return new ResponseEntity<Food>(foodService.addFood(food), HttpStatus.ACCEPTED);
		}

	}
	
	/*
	 * @PutMapping("/{foodId}/addcart/{cartId}") private ResponseEntity<Food>
	 * addCart(@PathVariable int foodId, @PathVariable int cartId) { if (cartId < 0
	 * || foodId < 0) { throw new
	 * EnterValidDetailsException("Either empId Or managerId Is Invalid Please Enter Correct "
	 * ); } else { Food food = foodService.findFoodById(foodId).get(); Cart cart =
	 * cartService.findCartById(cartId).get(); food.setCart(cart); return new
	 * ResponseEntity<Food>(foodService.addFood(food), HttpStatus.ACCEPTED); }
	 * 
	 * }
	 */
	
	

	@GetMapping("/getbyrestaurentid/{id}")
	public ResponseEntity<List<Food>> getAllByRestaurantId(@PathVariable int id) {
		if (id < 0) {
			throw new EnterValidDetailsException("Please Enter Valid Food Id");}
		return new ResponseEntity<List<Food>>(foodService.findAllFoodByRestaurantId(id), HttpStatus.FOUND);
	}

}
