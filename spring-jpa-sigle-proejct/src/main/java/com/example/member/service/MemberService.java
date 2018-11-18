package com.example.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member.model.Member;
import com.example.member.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired 
	private MemberRepository memberRepository;
	
	public Member getMember(String id) {
		return memberRepository.findOne(id);
		
	}
	
	private void join(Member member) {
		memberRepository.save(member);
	}
}
