package com.example.member.repository;

import org.springframework.data.repository.Repository;

import com.example.member.model.SimpleUserDetails;
/**
 * UserDetails ������ ��ť��Ƽ �Ծ࿡ ���� ���
 * @author us
 *
 */
public interface UserDetailsRepository extends Repository<SimpleUserDetails,String>{
	
	SimpleUserDetails findOne(String userName);

}
