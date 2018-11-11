package com.example.member.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.comn.model.Address;
import com.example.comn.model.PhoneNumber;
	

@Entity
public class Member {
	
	@Id
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="NICK_NAME")
	private String nickName;
	
	@Column(name="PASSWORD")
	private String password;	
	
	@Enumerated(EnumType.STRING)
	private Authority role = Authority.USER;
	
	@Column(name="EMAIl")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private PhoneNumber phoneNumber;
	
	@Embedded
	private Address address;
	
	

}
