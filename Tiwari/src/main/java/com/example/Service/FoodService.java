package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Customer;
import com.example.entity.Food;

public interface FoodService {
	
	public Food addFood(Food food);
	public Food editFood(Food food);
	public List<Food> getFood();
	public Optional<Food> findFoodByID(int FoodId);
	//public Optional<Customer> findByName(int customerName);
	
	

}
