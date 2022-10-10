package com.example.dto;

public class FoodInputDto {
	
	private String foodName;
	private int foodPrice;
	private int id;
	public String getFoodName() {
		return foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

}
