package com.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;


@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String restaurantName;
	private String restaurantAddress;
	private int restaurantContact;
	//private Food restMenu;
	
	public Customer getCustomer() {
		return customer;
	}
	@JsonIgnore
	public List<Food> getFood() {
		return food;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	@JsonIgnore
	@OneToOne(mappedBy = "restaurant")
	private Customer customer;
	
	@OneToMany(mappedBy="restaurant")
	private List<Food> food;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
