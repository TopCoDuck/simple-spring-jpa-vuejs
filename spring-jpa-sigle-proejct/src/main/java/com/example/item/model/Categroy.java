package com.example.item.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;


@Entity
@Table(name="CATEGORY")
@Getter
public class Categroy {
	@Id
	@Column(name="CATEGROY_CD")
	private String categroyCd;
	
	@Column(name="CATEGROY_NM")
	private String categroyNm;
	
	protected Categroy() {
		
	}
}
