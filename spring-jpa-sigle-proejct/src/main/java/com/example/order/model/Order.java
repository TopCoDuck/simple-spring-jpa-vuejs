package com.example.order.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.example.comn.model.Address;
import com.example.member.model.Member;

@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@Column(name = "ORDER_ID")
	private int id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NAME")
	private Member reciver;
	
	@Embedded
	private Address reciveAddress;
    
	@ElementCollection
	@CollectionTable(name="order_item",
					joinColumns = @JoinColumn(name="ORDER_ID"))
	@OrderColumn(name="order_seq")
	List<OrderItem> orderItems;
	
	int sumTotal;
	
	
}
