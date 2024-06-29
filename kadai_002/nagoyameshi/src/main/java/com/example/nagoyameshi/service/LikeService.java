package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Like;
import com.example.nagoyameshi.form.LikeRegisterForm;
import com.example.nagoyameshi.repository.LikeRepository;

@Service
public class LikeService {
	private final LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	@Transactional
	public void create(LikeRegisterForm likeRegisterForm) {
		Like like = new Like();
		
		like.setRestaurant(likeRegisterForm.getRestaurantId());
		like.setUser(likeRegisterForm.getUserId());
		
		likeRepository.save(like);
	}
}
