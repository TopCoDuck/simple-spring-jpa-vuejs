package com.example.order.model;

import javax.persistence.Embeddable;

import com.example.comn.model.Address;
import com.example.comn.model.PhoneNumber;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class ReciverInfo {
	
	private String name;
	
	private Address address;
	
	//private PhoneNumber phoneNumber;
	
}
