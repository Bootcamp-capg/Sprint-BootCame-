package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.FoodInputDto;
import com.example.entity.Food;
import com.example.repository.FoodRepository;

@Service
public class FoodServiceImp implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public Food addFood(Food food) {
		foodRepository.save(food);
		return food;
	}

	

	@Override
	public List<Food> getAllFoods() {
		return (List<Food>) foodRepository.findAll();
	}

	@Override
	public Optional<Food> findFoodById(int foodId) {
		return foodRepository.findById(foodId);
	}

	@Override
	public Food addFoodDto(FoodInputDto foodDto) {
		// create department object
		Food foodInputDto = new Food();
		
		// Update dept name
		foodInputDto.setFoodName(foodDto.getFoodName());
		foodInputDto.setFoodPrice(foodDto.getFoodPrice());
		
		// save dept obj in db 
		return foodRepository.save(foodInputDto);
	}

	@Override
	public List<Food> findAllFoodByRestaurantId(int restaurantId) {
		
		return foodRepository.findAllFoodByRestaurantId(restaurantId);
	}

//	@Override
//	public Optional<Food> findFoodByRestaruantId(int restaurantID) {
//		return foodRepository.findById(restaurantId);
//	}

}