package com.example.item.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.item.model.Item;

public class ItemSpec implements Specification<Item> {

	private String searchType;
	private String searchValue;
	
	protected  ItemSpec() {
		
	}
	
	public ItemSpec(String searchType, String searchValue) {
		this.searchType = searchType;
		this.searchValue = searchValue;
	}
	
	@Override
	public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		switch(searchType) {
		 	case "NAME":
		 		return	cb.like(root.get("itemNm"),"%" + searchValue + "%");
			case "DESC":
				return	cb.like(root.get("itemDesc"), "%" + searchValue + "%");
			default:
				return	cb.or(cb.like(root.get("itemNm"), "%" + searchValue + "%")
						 	,cb.like(root.get("itemDesc"),"%" + searchValue + "%"));
				
		}


	}

}
