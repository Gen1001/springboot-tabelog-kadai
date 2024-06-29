package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {
	public List<Like> deleteByRestaurantIdAndUserId(Integer restaurantId, Integer userId);
	public List<Like> findByRestaurantIdAndUserId(Integer restaurantId, Integer userId);
	public Page<Like> findByUserId(Integer id, Pageable pageable);
}