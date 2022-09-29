package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.FoodAlreadyPresentException;
import com.example.Exception.FoodNotFoundException;
import com.example.Exception.InvalidIdException;
import com.example.Exception.ListEmptyException;
import com.example.dto.FoodInputDto;
import com.example.entity.Food;
import com.example.repository.FoodRepository;

@Service
public class FoodServiceImp implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public Food addFood(Food food) {
		if (food.getFoodId() < 0) {
			throw new InvalidIdException("Please Enter Valid Food Id");
		}
		return foodRepository.save(food);
	
	}

	

	@Override
	public List<Food> getAllFoods() {
		List<Food> list = (List<Food>) foodRepository.findAll();
		if (list.isEmpty())
			throw new ListEmptyException("No Food Present");
		return (List<Food>) foodRepository.findAll();
	}

	@Override
	public Optional<Food> findFoodById(int foodId) {
		if (foodId < 0) {
			throw new InvalidIdException("Please Enter Valid Food Id");

		} 
		return foodRepository.findById(foodId);
	
	}
	@Override
	public Food addFoodDto(FoodInputDto foodDto) {
		
		Food foodInputDto = new Food();
	
		foodInputDto.setFoodName(foodDto.getFoodName());
		foodInputDto.setFoodPrice(foodDto.getFoodPrice());
		
		return foodRepository.save(foodInputDto);
	}

	@Override
	public List<Food> findAllFoodByRestaurantId(int restaurantId) {
		if (restaurantId < 0) {
			throw new InvalidIdException("Please Enter Valid Food Id");
		}
		return foodRepository.findAllFoodByRestaurantId(restaurantId);
	}

}