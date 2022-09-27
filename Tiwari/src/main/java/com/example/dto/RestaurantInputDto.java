package com.example.dto;

public class RestaurantInputDto {
	
	private String restaurantName;
	private String restaurantAddress;
	private int restaurantContact;
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public int getRestaurantContact() {
		return restaurantContact;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public void setRestaurantContact(int restaurantContact) {
		this.restaurantContact = restaurantContact;
	}

}
