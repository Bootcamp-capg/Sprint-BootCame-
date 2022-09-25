package com.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Restaurant {
	@Id
	private int id;
	private String restaurantName;
	private String restaurantAddress;
	private int restaurantContact;
	//private Food restMenu;
	
	@JsonIgnore
	@OneToOne(mappedBy = "restaurant")
	private Customer customer;
	
	@OneToMany(mappedBy="restaurant")
	private List<Food> food;
	
	public int getRestaurantId() {
		return id;
	}
	public void setRestaurantId(int restaurantId) {
		this.id = restaurantId;
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
