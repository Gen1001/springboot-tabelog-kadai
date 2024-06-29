package com.example.nagoyameshi.form;

import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewEditForm {
	@NotNull
	private Integer id;
	
	private Restaurant restaurantId;
	
	private User userId;
	
	private Integer reviewScore;
	
	@NotNull(message = "コメントを入力してください。")
	private String reviewComment;
}
