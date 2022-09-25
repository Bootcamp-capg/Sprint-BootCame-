package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurant {
	@Id
	private int restaurantId;
	private String restaurantName;
	private String restaurantAddress;
	private int restaurantContact;
	//private Food restMenu;
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restId) {
		this.restaurantId = restId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restName) {
		this.restaurantName = restName;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestauranttAddress(String restAddress) {
		this.restaurantAddress = restAddress;
	}
	public int getRestaurantContact() {
		return restaurantContact;
	}
	public void setRestaurantContact(int restContact) {
		this.restaurantContact = restContact;
	}

}
