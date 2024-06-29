package com.example.nagoyameshi.form;

import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;

import lombok.Data;

@Data
public class LikeRegisterForm {
	private Restaurant restaurantId;
	
	private User userId;
}
