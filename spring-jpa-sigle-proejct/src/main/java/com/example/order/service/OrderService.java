package com.example.order.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;
import com.example.member.model.Member;
import com.example.member.repository.MemberRepository;
import com.example.order.exception.NoHasItemException;
import com.example.order.model.Order;
import com.example.order.model.OrderItem;
import com.example.order.model.OrderedItem;
import com.example.order.model.ReciverInfo;
import com.example.order.repository.OrderRepository;
import com.example.payment.model.Payment;

@Service
public class OrderService {
	
    @Autowired 
    MemberRepository memberRepository;    

    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    ItemRepository itemRepository;
    
    @Transactional
	public void purchase(String orderer, ReciverInfo reciverInfo ,List<OrderedItem>  orderedItems, Payment payment) {
		
		Member member = memberRepository.findOne(orderer);
		
		List<OrderItem> orderItems = orderedItems.stream().map( o -> {
			 						 Item item = itemRepository.findOne(o.getItemCd());
			 						 if(item == null) throw  new NoHasItemException("해당 상품이 존재하지 않습니다.");
			 						 return OrderItem.createItem(item, o.getAmount(), o.getSum());
			 						}
								 ).collect(Collectors.toList());
		
         Order order  = new Order(member,reciverInfo, orderItems);
         orderRepository.save(order);
		
	}
    
	public Order getOrder(long orderId){
	   Order order = orderRepository.findOne(orderId);
	   return order;
	}

}
