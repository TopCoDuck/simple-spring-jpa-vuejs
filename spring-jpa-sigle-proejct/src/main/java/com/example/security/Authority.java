package com.example.security;

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
		return "ROLE_USER";
		//return this.name();
	}
	
	
}
