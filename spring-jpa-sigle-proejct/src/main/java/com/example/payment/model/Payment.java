package com.example.payment.model;

import lombok.Data;

@Data
public class Payment {
	
	private String paymentId;
	
	private String orderId;
	
	private String nameOnCard;
	
	private String cardNumber;
	
	private int expiration;
	
	private int cvv;
	
	private int totalSum;
}
