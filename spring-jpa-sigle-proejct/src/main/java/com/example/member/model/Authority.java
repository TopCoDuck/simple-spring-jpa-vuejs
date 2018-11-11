package com.example.member.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority{
	USER("����"), 
	ADMIN("������");
	
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
