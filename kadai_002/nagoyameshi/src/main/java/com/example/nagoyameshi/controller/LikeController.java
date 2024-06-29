package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Like;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.LikeRegisterForm;
import com.example.nagoyameshi.repository.LikeRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.LikeService;

@Transactional
@Controller
@RequestMapping("/likes")
public class LikeController {
	private final LikeRepository likeRepository;
	private final RestaurantRepository restaurantRepository;
	private final LikeService likeService;
	
	public LikeController(LikeRepository likeRepository, RestaurantRepository restaurantRepository, LikeService likeService) {
		this.likeRepository = likeRepository;
		this.restaurantRepository = restaurantRepository;
		this.likeService = likeService;
	}
	
	@GetMapping("/create/{id}")
	public String register(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, Model model, LikeRegisterForm likeRegisterForm, RedirectAttributes redirectAttributes) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		User user = userDetailsImpl.getUser();
		
		likeRegisterForm.setRestaurantId(restaurant);
		likeRegisterForm.setUserId(user);
		
		likeService.create(likeRegisterForm);
		
		Integer url = restaurant.getId();
		
		String redirectUrl = String.format("redirect:/restaurants/detail/%d", url);
		
		return redirectUrl;
	}
	
	@GetMapping("/delete/{restaurantId}/{userId}")
	public String delete(@PathVariable(name = "restaurantId") Integer restaurantId, @PathVariable(name = "userId") Integer userId, Model model, LikeRegisterForm likeRegisterForm, RedirectAttributes redirectAttributes) {
		Restaurant restaurant = restaurantRepository.getReferenceById(restaurantId);
		Integer url = restaurant.getId();
		
		likeRepository.deleteByRestaurantIdAndUserId(restaurantId, userId);
		
		String redirectUrl = String.format("redirect:/restaurants/detail/%d", url);
		
		return redirectUrl;
	}
	
	@GetMapping("")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		
		User user = userDetailsImpl.getUser();
		
		Page<Like> likePage = likeRepository.findByUserId(user.getId(), pageable);
		
		model.addAttribute("user", user);
		model.addAttribute("likePage", likePage);
		
		return "likes/index";
	}
	
	@GetMapping("/{id}")
	public String indexPage(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		
		User user = userDetailsImpl.getUser();
		
		Page<Like> likePage = likeRepository.findByUserId(user.getId(), pageable);
		
		model.addAttribute("user", user);
		model.addAttribute("likePage", likePage);
		
		return "likes/index";
	}
}
