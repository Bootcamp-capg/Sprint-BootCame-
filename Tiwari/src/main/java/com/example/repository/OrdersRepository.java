package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Orders;
@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer>{

}
