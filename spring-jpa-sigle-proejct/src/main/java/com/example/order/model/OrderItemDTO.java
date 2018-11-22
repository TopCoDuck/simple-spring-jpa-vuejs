package com.example.order.model;

import lombok.Data;

@Data
public class OrderItemDTO {
	private String itemCd;
	private String itemNm;
	private int amount;
	private long orderPrice;
	
	public OrderItemDTO(String itemCd, String itemNm, int amount, long orderPrice) {
		super();
		this.itemCd = itemCd;
		this.itemNm = itemNm;
		this.amount = amount;
		this.orderPrice = orderPrice;
	}
	
	
}
