package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerInputDto;
import com.example.dto.RestaurantInputDto;
import com.example.dto.RestaurentOutputDto;
import com.example.entity.Customer;
import com.example.entity.Food;
import com.example.entity.Restaurant;
import com.example.repository.FoodRepository;
import com.example.repository.RestaurantRepository;

@Service
public class RestaurantServiceImp implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Override
	public Restaurant editRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	
	  @Override public Optional<Restaurant> findRestaurantByID(int restaurantId) {
	  return restaurantRepository.findById(restaurantId); }

	@Override
	public List<Restaurant> findByRestaurantAddress(String restaurantAddress) {
		
		return restaurantRepository.findByRestaurantAddress(restaurantAddress);
	}

	@Override
	public Restaurant addRestaurantDto(RestaurantInputDto restaurantDto) {
		Restaurant restaurantInputDto = new Restaurant();
		
		// Update dept name
		restaurantInputDto.setRestaurantName(restaurantDto.getRestaurantName());
		restaurantInputDto.setRestauranttAddress(restaurantDto.getRestaurantAddress());
		restaurantInputDto.setRestaurantContact(restaurantDto.getRestaurantContact());
		// save dept obj in db 
		return restaurantRepository.save(restaurantInputDto);
	}

	
	

	
	
	

	/*
	 * @Override public List<RestaurentOutputDto> findFoodByRestaurantId(int
	 * restaurantId) {
	 * 
	 * return restaurantRepository. }
	 */
	 

	/*
	 * @Override public List<RestaurentOutputDto> getAllFoodDto(int restaurantId) {
	 * List<Restaurant> departments = restaurantRepository.findAll();
	 * 
	 * 
	 * // create List<DeptOutDto> List<DepartmentOutputDto> deptDtoList= new
	 * ArrayList<>();
	 * 
	 * // for, foreach, while, Iterator, ListIterator for( Department
	 * dept:departments) { // create dto obj DepartmentOutputDto dto = new
	 * DepartmentOutputDto();
	 * 
	 * // read data from dept obj and update dto obj
	 * dto.setDeptId(dept.getDeptId()); dto.setDeptName(dept.getDeptName());
	 * 
	 * // add dto obj into the dto List. deptDtoList.add(dto); } // return dto list
	 * return deptDtoList; }
	 */

	/*
	 * @Override public Optional<Restaurant> findRestaurantById(int restaurantId) {
	 * return restaurantRepository.findById(restaurantId);
	 * 
	 * }
	 */

	

}
