package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Food;

public interface FoodService {
	
	public Food addFood(Food food);
	public Food editFood(Food food);
	public List<Food> getAllFoods();
	public Optional<Food> findFoodById(int foodId);
//	public Optional<Food> findFoodByRestaruantId(int restaurantID);
	//public Optional<Customer> findByName(int customerName);
	
	

}
