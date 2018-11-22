package com.example.member.repository;

import org.springframework.data.repository.Repository;

import com.example.member.model.Member;

public interface MemberRepository extends Repository<Member,String>{
	
	Member findOne(String id);
	
	Member save(Member member);
	
	boolean existsByUserName(String userName); 
	
	void delete(String id);
	
}
