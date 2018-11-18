package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.review.model.Review;
import com.example.review.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired 
	private ReviewService reviewService;
	
	@GetMapping("/reviews")
	public List<Review> getReview(String itemCd) {
		return reviewService.findByItemCd(itemCd);
	}
	
	@PostMapping("/reviews")
	public String add(Review review) {
		reviewService.addReview(review);
		return "댓글이 정상적으로 등록되었습니다.";
	}
	
	@DeleteMapping("/reviews")
	public String delete(String review) {
		reviewService.delteReview(review);
		return "댓글이 정상적으로 삭제되었습니다.";
	}
	
}
