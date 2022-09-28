package com.example.Service;

import java.util.Optional;

import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
//import com.example.dto.FoodInputDto;
import com.example.dto.OrdersInputDto;
//import com.example.entity.Food;
import com.example.entity.Orders;

public interface OrderService {
	public TransactionResponse saveOrder(TransactionRequest request);
	public Optional<Orders> findOrderById(int orderId);
	public Orders addOrders(Orders orders);
	public Orders addOrdersDto(OrdersInputDto ordersDto);

}
