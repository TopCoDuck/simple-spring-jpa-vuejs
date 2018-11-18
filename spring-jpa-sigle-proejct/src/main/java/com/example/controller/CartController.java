package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.model.CartItemPk;
import com.example.order.model.CartView;
import com.example.order.service.CartItemService;
import com.example.security.CurrentUser;

@RestController
public class CartController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@PostMapping("/cart/add")
	private void addItem(String itemCd
							,int quantity) {
		cartItemService.addItem(new CartItemPk(CurrentUser.getUserName(),itemCd), quantity);
	}
	
	@PostMapping("/cart/change")
	private String exchangeItemAmount() {
		return null;
	}
	
	@PostMapping("/cart/delete")
	private String deleteItem() {
		return null;
	}
	
	@PostMapping("/cart")
	private List<CartView> getCartItemList(){
		
		return null;
	}
	
}
