package com.example.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member.exception.DuplicationMemberId;
import com.example.member.model.Member;
import com.example.member.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired 
	private MemberRepository memberRepository;
	
	public Member getMember(String id) {
		return memberRepository.findOne(id);
	}
	

	public void join(Member member) {
		if(memberRepository.existsByUserName(member.getUserName())) {
			throw new DuplicationMemberId("이미 존재하는 아이디 입니다.");
		}else {
				member.join();
				memberRepository.save(member);
		}
	}
	

	public void withdrawal(String userName) {
		Member member = memberRepository.findOne(userName);
		member.withdrawal();
		memberRepository.save(member);
	}
}
