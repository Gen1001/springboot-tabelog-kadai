package com.example.samuraitravel.form;

import java.time.LocalDate;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRegisterForm {
	private House houseId;
	
	private User userId;
	
	private Integer reviewScore;
	
	private LocalDate reviewDate;
	
	@NotNull(message = "コメントを入力してください。")
	private String reviewComment;
}
