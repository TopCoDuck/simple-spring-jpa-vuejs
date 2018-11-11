package com.example.order.model;

import javax.persistence.Column;
import javax.persistence.Id;

import com.example.item.model.Item;

public class OrderItem {
	
	private Item item;
	
	private int amount;
	///
	private int itemPerPrice;
}
