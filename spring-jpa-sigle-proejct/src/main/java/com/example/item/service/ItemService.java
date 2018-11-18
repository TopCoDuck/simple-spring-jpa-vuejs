package com.example.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemReposity;
	//@Transactional
	public Page<Item> getItemList(Specification<Item> itemSpec,Pageable pageable){
		return itemReposity.findAll(itemSpec,pageable);
	}
	
	public Item getItem(String itemCd) {
		return itemReposity.findOne(itemCd);
	}
	
}
