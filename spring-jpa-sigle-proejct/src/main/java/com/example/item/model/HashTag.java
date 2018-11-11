package com.example.item.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name="HASH_TAG")
@Getter
public class HashTag {
	
	@Id
	@Column(name="HASH_CD")
	private String hashCd;
	@Column(name="HASH_NM")
	private String hashNm;
	
	protected HashTag() {
		
	}
	
	public HashTag(String hashCd, String hashNm) {
		this.hashCd = hashCd;
		this.hashNm = hashNm;
	}
	
}
