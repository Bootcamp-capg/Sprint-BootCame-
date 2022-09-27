package com.example.Service;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Cart;
import com.example.entity.Food;
//import com.example.entity.Food;
import com.example.repository.CartRepository;
@Service
public class CartServiceImp implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Optional<Cart> findCartById(int cartId) {
		return cartRepository.findById(cartId);
	}

	@Override
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}

}
