package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	//@Size(min=3, max=15)
	private String foodName;
	//@Min(value=1, message="price must be greater than 0")
	private int foodPrice;
	// @JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	/*
	 * @ManyToOne private Cart cart;
	 */
	/*
	 * public Cart getCart() { return cart; }
	 * 
	 * public void setCart(Cart cart) { this.cart = cart; }
	 */

	@ManyToOne
	private Customer customer;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(int foodId, String foodName, int foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
