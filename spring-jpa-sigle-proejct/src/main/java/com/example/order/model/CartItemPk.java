package com.example.order.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CartItemPk  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String memberId;
	
	String itemCd;
	
	protected CartItemPk() {
		
	}
	
	public CartItemPk(String memberId, String itemCd) {
		this.memberId = memberId;
		this.itemCd= itemCd;
	}
}
