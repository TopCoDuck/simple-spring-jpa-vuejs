package com.example.member.model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "MEMBER")
public class SimpleUserDetails implements UserDetails {
	
	protected SimpleUserDetails() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="NICK_NAME")
	private String nickName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Authority role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+role.getAuthority()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}
	
	public String getNickName() {
		return nickName;
	}
	//TODO: 수정 작업 필요
	@Override
	@Deprecated
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	@Deprecated
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@Deprecated
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
