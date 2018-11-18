package com.example.order.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name="CART_ITEM")
public class CartItem{
	
	@EmbeddedId
    private CartItemPk cartItemPk;
	    
	private int amount;
	
	protected CartItem() {
		
	}
	
	public CartItem(CartItemPk cartItemPk ,int quantity) {
		this.cartItemPk = cartItemPk;
		this.amount = quantity;
	}
	
	public void addAmount(int quantity) {
		this.amount += quantity;
	}
	
}
