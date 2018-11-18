package com.example.review.repository;

import java.util.List;

import org.springframework.data.repository.Repository;
import com.example.review.model.Review;
/**
 * ¸®ºä repository
 * @author us
 *
 */
public interface ReviewRepository extends Repository<Review,String>{
	
	Review findOne(String reviewSeq);
	
	List<Review> findByItemCd(String itemCd);

	Review save(Review reivew);

	int delete(String reviewSeq);
	
}
