package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	public List<Review> findFirst6ByRestaurantIdOrderByCreatedAtDesc(Integer id);
	public List<Review> findByRestaurantIdAndUserId(Integer restaurantId, Integer userId);
	public Page<Review> findByRestaurantId(Integer id, Pageable pageable);
	public Review getByRestaurantId(Integer id);
	public Review getByRestaurantIdAndUserId(Integer restaurantId, Integer userId);
}
