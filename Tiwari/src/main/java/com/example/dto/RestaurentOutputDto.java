package com.example.dto;

public class RestaurentOutputDto {
	private int foodId;
	private String foodName;
	private int foodPrice;
	public int getFoodId() {
		return foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

}
