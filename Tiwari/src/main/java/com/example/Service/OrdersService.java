package com.example.Service;


import com.example.entity.Orders;

public interface OrdersService {
	
	public Orders addOrder(Orders order);
	public Orders findByCartId(int cartId);
}
