package com.example.nagoyameshi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	public Page<Restaurant> findByNameLikeOrKeywordLikeOrderByPriceAsc(String name, String keyword, Pageable pageable);
	public Page<Restaurant> findByNameLikeOrKeywordLikeOrderByCreatedAtDesc(String name, String keyword, Pageable pageable);
	public Page<Restaurant> findByCategoryId(Category id, Pageable pageable);
	public Restaurant getById(Integer id);
	
	public Page<Restaurant> findAllByOrderByPriceAsc(Pageable pageable);
	public Page<Restaurant> findAllByOrderByCreatedAtDesc(Pageable pageable);
	
}