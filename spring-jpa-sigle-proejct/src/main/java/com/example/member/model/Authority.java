package com.example.member.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority{
	USER("유저"), 
	ADMIN("관리자");
	
	String authority;
	Authority(String authority){
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name();
	}
	
	
}
