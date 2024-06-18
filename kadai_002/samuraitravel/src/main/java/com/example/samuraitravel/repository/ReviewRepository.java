package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	public List<Review> findFirst6ByHouseIdOrderByCreatedAtDesc(Integer id);
	public Page<Review> findByHouseId(Integer id, Pageable pageable);
	public List<Review> findByHouseId(Integer id);
	public List<Review> findByUserId(Integer id);
	public List<Review> findByHouseIdAndUserId(Integer houseId, Integer userId);
	public Review getByHouseIdAndUserId(Integer hosueId, Integer userId);
	public Review getByHouseId(Integer id);
}
