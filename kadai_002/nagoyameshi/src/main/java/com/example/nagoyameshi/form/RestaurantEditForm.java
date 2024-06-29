package com.example.nagoyameshi.form;

import java.time.LocalTime;

import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyameshi.entity.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantEditForm {
	@NotNull
	private Integer id;
	
	@NotNull(message = "カテゴリ名を選択してください。")
	private Category categoryId;
	
	@NotBlank(message = "店舗名を入力してください。")
	private String name;
	
	private MultipartFile imageFile;
	
	@NotBlank(message = "説明を入力してください。")
	private String description;
	
	@NotNull(message = "平均料金を入力してください。")
	@Min(value = 1, message = "平均料金は1円以上に設定してください。")
	private Integer price;
	
	@NotBlank(message = "郵便番号を入力してください。")
	private String postNumber;
	
	@NotBlank(message = "住所を入力してください。")
	private String address;
	
	@NotBlank(message = "電話番号を入力してください。")
	private String phoneNumber;
	
	@NotNull(message = "始業時間を入力してください。")
	private LocalTime openTime;
	
	@NotNull(message = "終業時間を入力してください。")
	private LocalTime closeTime;
	
	@NotNull(message = "座席数を入力してください。")
	@Min(value = 1, message = "座席数は1席以上に設定してください。")
	private Integer capacity;
	
	private String holiday;
	
	private String keyword;

}