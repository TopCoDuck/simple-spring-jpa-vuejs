package com.example.item.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.order.exception.LackOfQuantityException;

import lombok.Getter;

@Entity
@Table(name="ITEM")
@Getter
public class Item {
	
	@Id
	private String itemCd;
	
	@ManyToOne
	@JoinColumn(name="CATEGROY_CD")
	private Categroy categroy;
	
	private String itemNm;

	private String itemDesc;
	
	private int stock;
	
	private int price;
	
	protected Item() {
		
	}
	
	@ManyToMany
	@JoinTable(name="hash_join",
		joinColumns = @JoinColumn(name="item_cd"),
		inverseJoinColumns = @JoinColumn(name="hash_cd")
	)
	private Set<HashTag> hashTage = new HashSet<HashTag>();
	
	public void removeStock(int amount) {
		 if(this.stock < amount) {
			 throw new LackOfQuantityException("해당 상품의 수량이 부족합니다.");
		 }
		this.stock -= amount;
	}

}
