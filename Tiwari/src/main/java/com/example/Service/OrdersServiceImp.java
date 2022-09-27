package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Orders;
import com.example.repository.OrdersRepository;
@Service
public class OrdersServiceImp implements OrdersService {

	@Autowired
	OrdersRepository ordersRespository;
	
	@Override
	public Orders addOrder(Orders orders) {
		ordersRespository.save(orders);
		return orders;
	}

	@Override
	public Orders findByCartId(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}


}
