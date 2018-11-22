package com.example.item.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.item.model.Item;



public interface ItemRepository  extends JpaRepository<Item,String>{

	Page<Item> findAll(Pageable pageable);
	
	@EntityGraph(attributePaths = {"categroy", "hashTage"})
	Page<Item> findAll(Specification<Item> itemSpec,Pageable pageable);
	
	@EntityGraph(attributePaths = {"categroy", "hashTage"})
	Item findOne(String itemCd);
	
	Item save(Item item);
	
}
//CartItemRepository