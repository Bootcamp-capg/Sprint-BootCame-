package com.example.dto;

import java.util.List;

import com.example.entity.Food;

public class RestaurentOutputDto {
	List<Food> foodList;

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

}
