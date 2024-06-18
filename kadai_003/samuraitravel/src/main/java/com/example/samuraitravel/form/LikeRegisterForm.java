package com.example.samuraitravel.form;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.User;

import lombok.Data;

@Data
public class LikeRegisterForm {
	private House hosueId;
	
	private User userId;
}
