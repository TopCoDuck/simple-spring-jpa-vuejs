package com.example.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;
import com.example.order.exception.LackOfQuantityException;
import com.example.order.model.CartItem;
import com.example.order.model.CartItemPk;
import com.example.order.model.CartView;
import com.example.order.repository.CartItemRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * Cart Pk부분에 연관 미사용
 * @author us
 *
 */
@Service
public class CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional
	public void addItem(CartItemPk cartItemPk,int quantity) {
		System.out.println("cartItemPk.getItemCd()"+cartItemPk.getItemCd());
		//상품 검증
		Item item = itemRepository.findOne(cartItemPk.getItemCd());
		if(item.getStock() < quantity)
			throw new LackOfQuantityException("해당 상품의 수량이 부족합니다.");
		
		//수량 추가
		CartItem cartItem = cartItemRepository.findOne(cartItemPk);
		if(cartItem !=null ) {
			cartItem.addAmount(quantity);
		}else{
			cartItem = new CartItem(cartItemPk,quantity);
		}
		cartItemRepository.save(cartItem);
	}
	
	public void chageAmount(CartItemPk cartItemPk ,int quantity) {
		CartItem cartItem = cartItemRepository.findOne(cartItemPk);
		cartItem = new CartItem(cartItemPk,quantity); 
	}
	//TODO:
	public void deleteItem(List<CartItemPk> cartItemPks ,String memberId) {
		
		//cartItemRepository.delete(cartItemPks);
	}
	
	public void deleteItem(CartItemPk cartItemPk) {
		cartItemRepository.delete(cartItemPk);
	}
	
	public List<CartView> getItemList(String memberId){
		return null;
	}
}
