package com.example.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.model.CartItem;
import com.example.order.model.CartItemPk;

public interface CartItemRepository extends JpaRepository<CartItem,CartItemPk>{
/*	@Query()
	List<CartView> findByMemberId(String member);*/
}
