package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.model.Member;
import com.example.member.service.MemberService;
import com.example.order.model.OrderedItem;
import com.example.order.model.OrderedItemList;
import com.example.order.model.ReciverInfo;
import com.example.order.repository.OrderViewRepository;
import com.example.order.service.OrderService;
import com.example.payment.model.Payment;
import com.example.security.CurrentUser;

@RestController
public class OrderController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderViewRepository orderViewRepository;
	
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
		
		for(OrderedItem  orderedItem: orderedItems.getOrderedItems()) {
			System.out.println(orderedItem);
		}		

		orderService.purchase(CurrentUser.getUserName()
								,reciverInfo
								,orderedItems.getOrderedItems()
							    , payment);

	}
	
	@GetMapping("/orders/{orderId}")
	public Map<String,Object> getOrderDetail(@PathVariable long orderId) {
		System.out.println(orderId+"orderId:");
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("order", orderService.getOrder(orderId));
		result.put("orderItems", orderViewRepository.findOrderItemDetail(orderId));
		return result;
	}
	
}
