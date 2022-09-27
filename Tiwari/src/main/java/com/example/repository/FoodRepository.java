package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Food;
import com.example.entity.Restaurant;
@Repository
public interface FoodRepository extends CrudRepository<Food, Integer>{
	public List<Food> findAllFoodByRestaurantId(int restaurantId);
	

}
