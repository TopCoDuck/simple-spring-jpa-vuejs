package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.model.Member;
import com.example.member.service.MemberService;
import com.example.order.model.OrderedItem;
import com.example.order.model.OrderedItemList;
import com.example.order.model.ReciverInfo;
import com.example.payment.model.Payment;
import com.example.security.CurrentUser;

@RestController
public class OrderController {
	
	@Autowired
	private MemberService memberService;
	@PostMapping("/order/check")
	public void orderCheck(OrderedItemList reqItemList) {
		
	}
	@PostMapping("/order/page")
	public Map<String,Object> orderPage() {
		Map<String,Object> result = new HashMap<String,Object>();
	 	
		Member member = memberService.getMember(CurrentUser.getUserName());

		result.put("userInfo",member);
		
		return result;
	}
	
	
	@PostMapping("/order/purchase")
	public void purchase(ReciverInfo reciverInfo
						,OrderedItemList orderedItems
						,Payment payment) {
		System.out.println(reciverInfo);
		for(OrderedItem  orderedItem: orderedItems.getOrderedItems()) {
			System.out.println(orderedItem);
		}
		System.out.println(payment);
		//°áÁ¦ ¹× Save
	}
//	
//	@PostMapping("/order/save")
//	public void order() {
//		
//	}
	
}
