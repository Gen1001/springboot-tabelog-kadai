package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.Like;
import com.example.samuraitravel.form.LikeRegisterForm;
import com.example.samuraitravel.repository.LikeRepository;

import jakarta.transaction.Transactional;

@Service
public class LikeService {
	private final LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	@Transactional
	public void create(LikeRegisterForm likeRegisterForm) {
		Like like = new Like();
		
		like.setHouse(likeRegisterForm.getHosueId());
		like.setUser(likeRegisterForm.getUserId());
		
		likeRepository.save(like);
	}
}
