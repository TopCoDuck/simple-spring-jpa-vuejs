package com.example.item.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.example.item.model.Item;



public interface ItemRepository  extends Repository<Item,String>{


	Page<Item> findAll(Pageable pageable);
	
	Page<Item> findAll(Specification<Item> itemSpec,Pageable pageable);
	
	Item findOne(String itemCd);
	
	Item save(Item item);
	
	//void delete(String itemCd);
}
