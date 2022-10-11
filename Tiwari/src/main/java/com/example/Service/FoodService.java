package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.dto.FoodInputDto;
import com.example.entity.Food;

public interface FoodService {
	
	public Food addFood(Food food);
	//public Food editFood(Food food);
	public List<Food> getAllFoods();
	public Optional<Food> findFoodById(int foodId);
//	public Optional<Food> findFoodByRestaruantId(int restaurantID);
	//public Optional<Customer> findByName(int customerName);
	public Food addFoodDto(FoodInputDto foodDto);
	public List<Food> findAllFoodByRestaurantId(int restaurantId);
	public void deleteByFoodId(int foodId);
	public List<Food> findAllFoodByCustomerCustomerId(int customerId);
	
	

}
