package com.example.samuraitravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Like;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.form.LikeRegisterForm;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.LikeRepository;
import com.example.samuraitravel.repository.ReviewRepository;
import com.example.samuraitravel.security.UserDetailsImpl;
import com.example.samuraitravel.service.LikeService;

@Controller
public class LikeController {
	private final LikeRepository likeRepository;
	private final HouseRepository houseRepository;
	private final ReviewRepository reviewRepository;
	private final LikeService likeService;
	
	public LikeController(LikeRepository likeRepository, HouseRepository houseRepository, ReviewRepository reviewRepository, LikeService likeService) {
		this.likeRepository = likeRepository;
		this.houseRepository = houseRepository;
		this.reviewRepository = reviewRepository;
		this.likeService = likeService;
	}
	
	//お気に入りチェックを受け取ってデータベースに登録
	@GetMapping("/likes/create/{id}")
	public String register(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, Model model, LikeRegisterForm likeRegisterForm, RedirectAttributes redirectAttributes) {
		House house = houseRepository.getReferenceById(id);
		
		
		//現在のユーザー情報を取得する
		User user = userDetailsImpl.getUser();
		
		likeRegisterForm.setHosueId(house);
		likeRegisterForm.setUserId(user);
			
		likeService.create(likeRegisterForm);
		
		Integer url = house.getId();
		
		String redirectUrl = String.format("redirect:/houses/%d", url);
		
		return redirectUrl;
	}
	
	//お気に入り解除
	@GetMapping("/likes/delete/{houseId}/{userId}")
	public String delete(@PathVariable(name = "houseId") Integer houseId,@PathVariable(name = "userId") Integer userId, Model model, LikeRegisterForm likeRegisterForm, RedirectAttributes redirectAttributes) {
		House house = houseRepository.getReferenceById(houseId);
		Integer url = house.getId();
		
		likeRepository.deleteByHouseIdAndUserId(houseId, userId);
		
		String redirectUrl = String.format("redirect:/houses/%d", url);
		
		return redirectUrl;
	}
	
	//お気に入り一覧ページに遷移
	@GetMapping("/likes")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		
		User user = userDetailsImpl.getUser();
		
		Page<Like> likePage = likeRepository.findByUserId(user.getId(), pageable);
		
		model.addAttribute("user", user);
		model.addAttribute("likePage", likePage);
		
		return "likes/index";
	}
	
	//お気に入り一覧ページドネーション
	@GetMapping("/likes/{id}")
	public String indexPage(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		
		User user = userDetailsImpl.getUser();
		
		Page<Like> likePage = likeRepository.findByUserId(user.getId(), pageable);
		
		model.addAttribute("user", user);
		model.addAttribute("likePage", likePage);
		
		return "likes/index";
	}
	
}
