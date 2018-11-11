package com.example.review.model;


import javax.persistence.Entity;
import javax.persistence.Id;


import com.example.comn.model.CommModel;

import lombok.Getter;

@Entity
@Getter
public class Review extends CommModel{
	
	@Id
	private int reviewSeq;
	
	private String comments;
	
	private String itemCd;

}
