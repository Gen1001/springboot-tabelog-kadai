package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.Like;

import jakarta.transaction.Transactional;

@Transactional
public interface LikeRepository extends JpaRepository<Like, Integer> {
	public List<Like> deleteByHouseIdAndUserId(Integer houseId, Integer userId);
	public List<Like> findByUserId(Integer id);
	public List<Like> findByHouseIdAndUserId(Integer houseId, Integer userId);
	public Page<Like> findByUserId(Integer id, Pageable pageable);
	public Like getByUserId(Integer id);
}
