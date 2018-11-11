package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.member.repository.UserDetailsRepository;

@Service
public class SimpleUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails= userDetailsRepository.findOne(username);
		if(userDetails == null) throw new UsernameNotFoundException(username + "가 존재하지 않습니다");
		return userDetails;
	}

}
