package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.repository.MemberRepository;
import com.example.order.repository.OrderViewRepository;
import com.example.security.CurrentUser;

@RestController
public class MyInfoController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private OrderViewRepository orderSummaryRepository;
	
	@RequestMapping("my-info")
	public Map<String,Object> list(){
		Map<String,Object> result = new HashMap<String,Object>();
		String userName = CurrentUser.getUserName();
		System.out.println(memberRepository.findOne(userName));
		result.put("member", memberRepository.findOne(userName));
        result.put("orders", orderSummaryRepository.findOrderSummaryList(userName, 5));
		
		return result;
	}

}
