package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.entity.Like;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.LikeRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	private final RestaurantRepository restaurantRepository;
	private final CategoryRepository categoryRepository;
	private final ReviewRepository reviewRepository;
	private final LikeRepository likeRepository;
	
	public RestaurantController(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, ReviewRepository reviewRepository, LikeRepository likeRepository) {
		this.restaurantRepository = restaurantRepository;
		this.categoryRepository = categoryRepository;
		this.reviewRepository = reviewRepository;
		this.likeRepository = likeRepository;
	}
	
	@GetMapping
	public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword, @RequestParam(name = "order", required = false) String order) {
		Page<Restaurant> restaurantPage;
		List<Category> category = categoryRepository.findAll();
		
		if (keyword != null && !keyword.isEmpty()) {
			String likePattern = "%" + keyword + "%";
			if (order != null && order.equals("priceAsc")) {
				restaurantPage = restaurantRepository.findByNameLikeOrKeywordLikeOrderByPriceAsc(likePattern, likePattern, pageable);
			} else {
				restaurantPage = restaurantRepository.findByNameLikeOrKeywordLikeOrderByCreatedAtDesc(likePattern, likePattern, pageable);
			}
		} else {
			if (order != null && order.equals("priceAsc")) {
				restaurantPage = restaurantRepository.findAllByOrderByPriceAsc(pageable);
			} else {
				restaurantPage = restaurantRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
				
		}
		
		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("category", category);
		
		return "restaurants/index";
	}
	
	@GetMapping("/{id}")
	public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword, @PathVariable(name = "id") Category id) {
		Page<Restaurant> restaurantPage = restaurantRepository.findByCategoryId(id, pageable);
		List<Category> category = categoryRepository.findAll();
		
		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("category", category);
		
		return "restaurants/index";
	}
	
	
	@GetMapping("/detail/{id}")
	public String show(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model, @PathVariable(name = "id") Integer id) {
		Restaurant restaurant = restaurantRepository.getById(id);
		List<Review> review = reviewRepository.findFirst6ByRestaurantIdOrderByCreatedAtDesc(id);
		List<Review> reviewAll = reviewRepository.findAll();
		
		if (userDetailsImpl != null) {
			User user = userDetailsImpl.getUser();
			model.addAttribute("user", user);
			
			List<Like> like = likeRepository.findByRestaurantIdAndUserId(restaurant.getId(), user.getId());
			
			if (like.isEmpty()) {
				Boolean likeRegister = true;
				model.addAttribute("likeRegister", likeRegister);
			} else {
				Boolean likeDelete = true;
				model.addAttribute("likeDelete", likeDelete);
			}
			List<Review> reviewDone = reviewRepository.findByRestaurantIdAndUserId(restaurant.getId(), user.getId());
			
			Boolean done = reviewDone.isEmpty();
			model.addAttribute("done", done);
		}
		
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("review", review);
		
		return "restaurants/show";
	}
}
