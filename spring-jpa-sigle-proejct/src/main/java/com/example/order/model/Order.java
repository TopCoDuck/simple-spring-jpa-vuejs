package com.example.order.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.comn.model.Address;
import com.example.member.model.Member;

@Entity
public class Order {
	
	@Id
	@Column(name = "ORDER_ID")
	private int id;
	@OneToOne
	private Member member;
	
	@Embedded
	private Address address;

	//@OneToMany
	//private List<OrderItem> orderItem = new ArrayList<OrderItem>();
}
