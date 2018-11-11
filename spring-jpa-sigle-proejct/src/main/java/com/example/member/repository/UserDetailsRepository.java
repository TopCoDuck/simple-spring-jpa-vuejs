package com.example.member.repository;

import org.springframework.data.repository.Repository;

import com.example.member.model.SimpleUserDetails;
/**
 * UserDetails 스프링 시큐리티 규약에 따라 명명
 * @author us
 *
 */
public interface UserDetailsRepository extends Repository<SimpleUserDetails,String>{
	
	SimpleUserDetails findOne(String userName);

}
