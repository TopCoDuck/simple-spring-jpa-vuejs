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
import com.example.member.exception.AlreadyBanMember;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
	

@Entity
@Getter
@ToString
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
	
	@Enumerated(EnumType.STRING)
	private MemberState state;
	
	public void join() {
		this.state = MemberState.JOIN;
	}
	
	public void withdrawal() {
		switch(this.state) {
			case BAN:
				throw new AlreadyBanMember("밴처리 된 회원입니다.");
			default : 
				this.state = MemberState.WITHDRAWAL;
		}
		
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
