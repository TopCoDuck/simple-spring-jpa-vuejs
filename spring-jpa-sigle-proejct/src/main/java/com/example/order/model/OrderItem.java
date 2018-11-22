package com.example.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.item.model.Item;

import lombok.Getter;
/**
 * 연관을 적극적으로 사용
 * @author us
 *
 */
@Entity
@Getter
public class OrderItem implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ITEM_CD")
	private Item item;

	private int amount;
	
	private long orderPrice;
	
	public static OrderItem createItem(Item item,int amount ,long orderPrice) {
		
        OrderItem orderItem = new OrderItem();
        orderItem.item = item;
        orderItem.amount = amount;
        orderItem.orderPrice = orderPrice;
        
        item.removeStock(amount);
        
		return orderItem;
	}
	
	public void addOrder(Order order) {
		this.order = order;
	}
	
	
	
}
