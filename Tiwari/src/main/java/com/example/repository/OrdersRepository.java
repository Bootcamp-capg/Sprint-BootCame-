package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{

}
