package com.example.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review.model.Review;
import com.example.review.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepostiory;
	
	
	public List<Review> findByItemCd(String itemCd){
		return reviewRepostiory.findByItemCd(itemCd);
	}
}
