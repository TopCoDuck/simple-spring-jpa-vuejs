package com.example.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.member.model.SimpleUserDetails;

@EnableWebSecurity
public class SimpleAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	SimpleUserDetailsService simpleUserDetailsService;
	
	@Autowired
	PasswordManger passwordManger;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		SimpleUserDetails simpleUserDetails = (SimpleUserDetails)simpleUserDetailsService.loadUserByUsername(username);
		if(passwordManger.matches(password, simpleUserDetails.getPassword()))
				throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		if(null != simpleUserDetails.getAuthorities()) {
			List<SimpleGrantedAuthority> list  = (List<SimpleGrantedAuthority>) simpleUserDetails.getAuthorities();
			for(SimpleGrantedAuthority el :list) {
				
				System.out.println(el.getAuthority());
			}
		}
		return new UsernamePasswordAuthenticationToken(simpleUserDetails, password, simpleUserDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
