package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.item.model.Item;
import com.example.item.service.ItemService;
import com.example.item.spec.ItemSpec;
import com.example.review.service.ReviewService;


@RestController
public class ItemController {
	
	@Autowired 
	ItemService itemService;
	
	@Autowired 
	ReviewService reviewService;
	
	@RequestMapping("/items")
	public Page<Item> getList(@RequestParam(defaultValue="ALL")String searchType
							, @RequestParam(defaultValue="")String searchValue
							, @RequestParam(defaultValue="0")int page){
		System.out.println(searchType+ " "+ searchValue  + " " + page);
		Page<Item> items= itemService.getItemList(new ItemSpec(searchType,searchValue),new PageRequest(page, 10));
		System.out.println(items.getSize());
		return items;
	}
	
	
	@RequestMapping("/items/{itemCd}")
	public Map<String,Object> getOne(@PathVariable String itemCd) {
		Map<String,Object> result  = new HashMap<>();
		result.put("item", itemService.getItem(itemCd));
		result.put("reviews", reviewService.findByItemCd(itemCd));
		return result;
	}
	

	
}
