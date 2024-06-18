package com.example.samuraitravel.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.form.ReviewEditForm;
import com.example.samuraitravel.form.ReviewRegisterForm;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.ReviewRepository;
import com.example.samuraitravel.repository.UserRepository;
@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;
	
	public ReviewService(ReviewRepository reviewRepository, HouseRepository houseRepository, UserRepository userRepository) {
		this.reviewRepository = reviewRepository;
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
	}
	
	
	//投稿用
	@Transactional
	public void create(ReviewRegisterForm reviewRegisterForm) {
		Review review = new Review();
		
		LocalDate reviewDate = LocalDate.now();
		
		review.setHouse(reviewRegisterForm.getHouseId());
		review.setUser(reviewRegisterForm.getUserId());
		review.setReviewScore(reviewRegisterForm.getReviewScore());
		review.setReviewDate(reviewDate);
		review.setReviewComment(reviewRegisterForm.getReviewComment());
		
		reviewRepository.save(review);
	}
	
	//編集用
	@Transactional
	public void update(ReviewEditForm reviewEditForm) {
		Review review = reviewRepository.getReferenceById(reviewEditForm.getId());
		
		LocalDate reviewDate = LocalDate.now();
		
		review.setHouse(reviewEditForm.getHouseId());
		review.setUser(reviewEditForm.getUserId());
		review.setReviewScore(reviewEditForm.getReviewScore());
		review.setReviewDate(reviewDate);
		review.setReviewComment(reviewEditForm.getReviewComment());
		
		reviewRepository.save(review);
	}
}