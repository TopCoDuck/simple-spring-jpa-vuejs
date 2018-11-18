package com.example.member.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.example.comn.model.Address;
import com.example.comn.model.PhoneNumber;
import com.example.comn.model.PhoneNumberConverter;

import lombok.Getter;
	

@Entity
@Getter
public class Member {
	
	@Id
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="NICK_NAME")
	private String nickName;
	
	private String password;	
	
	@Enumerated(EnumType.STRING)
	private Authority role = Authority.USER;
	

	private String email;
	
	@Convert(converter=PhoneNumberConverter.class)
	private PhoneNumber phoneNumber;
	
	@Embedded
	private Address address;
	
	

}
