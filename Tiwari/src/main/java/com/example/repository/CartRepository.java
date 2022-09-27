package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>{

}
