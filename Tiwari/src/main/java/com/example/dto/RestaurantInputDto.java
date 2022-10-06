package com.example.dto;

public class RestaurantInputDto {
	
	private String restaurantName;
	private String restaurantAddress;
	private int restaurantContact;
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
