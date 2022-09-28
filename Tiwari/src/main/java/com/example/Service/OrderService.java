package com.example.Service;

import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;

public interface OrderService {
	public TransactionResponse saveOrder(TransactionRequest request);
}
