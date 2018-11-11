package com.example.review.repository;

import java.util.List;

import org.springframework.data.repository.Repository;
import com.example.review.model.Review;

public interface ReviewRepository extends Repository<Review,String>{
	List<Review> findByItemCd(String itemCd);
}
