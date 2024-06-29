package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.form.ReviewEditForm;
import com.example.nagoyameshi.form.ReviewRegisterForm;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;
	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;
	
	public ReviewService(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
		this.reviewRepository = reviewRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}
	
	
	//投稿用
	@Transactional
	public void create(ReviewRegisterForm reviewRegisterForm) {
		Review review = new Review();
		
		review.setRestaurant(reviewRegisterForm.getRestaurantId());
		review.setUser(reviewRegisterForm.getUserId());
		review.setReviewScore(reviewRegisterForm.getReviewScore());
		review.setReviewComment(reviewRegisterForm.getReviewComment());
		
		reviewRepository.save(review);
	}
	
	//編集用
	@Transactional
	public void update(ReviewEditForm reviewEditForm) {
		Review review = reviewRepository.getReferenceById(reviewEditForm.getId());
		
		review.setRestaurant(reviewEditForm.getRestaurantId());
		review.setUser(reviewEditForm.getUserId());
		review.setReviewScore(reviewEditForm.getReviewScore());
		review.setReviewComment(reviewEditForm.getReviewComment());
		
		reviewRepository.save(review);
	}
}