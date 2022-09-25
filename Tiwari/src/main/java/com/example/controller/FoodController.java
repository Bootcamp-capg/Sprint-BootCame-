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

import com.example.Exception.EnterValidDetailsException;
import com.example.Exception.FoodAlreadyPresentException;
import com.example.Exception.FoodNotFoundException;
import com.example.Service.FoodService;
import com.example.entity.Food;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@GetMapping("/")
	public List<Food> getAllFoods(){		
		return foodService.getAllFoods();
		
	}
	
	@GetMapping("/{foodId}")
    public ResponseEntity<Food> getByFoodId(@PathVariable int foodId) {
		if(foodId<0) {
			throw new EnterValidDetailsException("Please Enter Valid Food Id");
			
		}
		else {
    	if(!foodService.findFoodById(foodId).isPresent()) {
			throw new FoodNotFoundException("Food not found with foodId "+ foodId);
		}
		return new ResponseEntity<Food>(foodService.findFoodById(foodId).get(), HttpStatus.FOUND);
    }
}
	
	@PostMapping("/add-Food")
	public Food saveFood(@RequestBody Food food) {	
		if(foodService.findFoodById(food.getFoodId()).isPresent())
			throw new FoodAlreadyPresentException("Entered id"+food.getFoodId()+"is already Present Please Enter another id");
		
		foodService.addFood(food);	
		return food;
		
	}
	
	@PutMapping("/edit-Food")
	public Food editFood(@RequestBody Food food) {
		foodService.editFood(food);
		return food;
}
}