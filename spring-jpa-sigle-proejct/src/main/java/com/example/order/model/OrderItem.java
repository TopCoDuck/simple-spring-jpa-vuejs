package com.example.order.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.item.model.Item;

import lombok.Getter;
/**
 * ������ ���������� ���
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
	
	private int price;
	
}
