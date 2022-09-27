package com.example.Service;

//import java.util.List;
import java.util.Optional;

import com.example.dto.CartInputDto;
import com.example.dto.FoodInputDto;
import com.example.entity.Cart;
//import com.example.entity.Food;
//import com.google.common.base.Optional;
//import com.example.entity.Food;
import com.example.entity.Food;

public interface CartService {
	public Optional<Cart> findCartById(int cartId);

	public Cart addCart(Cart cart);
	public Cart addCartDto(CartInputDto cartDto);
	
	//public Cart getCartByCartId(int cartId);

}
