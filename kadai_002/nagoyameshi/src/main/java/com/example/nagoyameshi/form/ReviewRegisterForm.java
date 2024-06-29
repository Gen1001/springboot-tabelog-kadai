package com.example.nagoyameshi.form;

import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRegisterForm {
	private Restaurant restaurantId;
	
	private User userId;
	
	private Integer reviewScore;
	
	@NotNull(message = "コメントを入力してください。")
	private String reviewComment;
}
