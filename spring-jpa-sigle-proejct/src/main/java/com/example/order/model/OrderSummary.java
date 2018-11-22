package com.example.order.model;

import java.math.BigInteger;

import lombok.Data;


@Data
public class OrderSummary {

	private long orderId;
	
	private String userName;
	
	private long sumTotal;
	
	private String representItemNm;

	private int  totalAmount;

	public OrderSummary(BigInteger  orderId, String userName, BigInteger  sumTotal, String representItemNm, Integer  totalAmount) {
		this.orderId = orderId.longValue();
		this.userName = userName;
		this.sumTotal = sumTotal.longValue();
		this.representItemNm = representItemNm;
		this.totalAmount = totalAmount;
	}
	

}
