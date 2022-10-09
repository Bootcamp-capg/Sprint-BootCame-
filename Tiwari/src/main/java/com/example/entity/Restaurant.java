package com.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;


@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//@NotEmpty(message = "Please enter customer Name")
	
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	private String restaurantName;
	//@NotEmpty(message = "Please enter customer Name")
	
	private String restaurantAddress;
	
	private long restaurantContact;
	private String email;
	private String password;
	
	//private Food restMenu;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	
	public long getRestaurantContact() {
		return restaurantContact;
	}
	public void setRestaurantContact(long restContact) {
		this.restaurantContact = restContact;
	}
	

}
