package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.model.Member;
import com.example.member.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value="/members")
	public void createMember(Member member) {
		System.out.println(member);
		memberService.join(member);
	}
	
	public void withdrawalMember() {
		
	}
}
