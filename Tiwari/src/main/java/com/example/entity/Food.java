package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.catalina.Manager;

@Entity
public class Food {
	 @Id
		private int id;
		private String foodName;
		private int foodPrice;
	
		@ManyToOne
		private Restaurant restaurant;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(int foodId, String foodName, int foodPrice) {
		super();
		this.id = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}
   
	
	
	public int getFoodId() {
		return id;
	}
	public void setFoodId(int foodId) {
		this.id = foodId;
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
	
	@Override
	public String toString() {
		return "Food [foodId=" + id + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

}
