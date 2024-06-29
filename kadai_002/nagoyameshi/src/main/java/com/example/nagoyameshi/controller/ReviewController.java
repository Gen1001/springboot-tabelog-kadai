package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReviewEditForm;
import com.example.nagoyameshi.form.ReviewRegisterForm;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
	private final ReviewRepository reviewRepository;
	private final RestaurantRepository restaurantRepository;
	private final ReviewService reviewService;
	
	public ReviewController(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository, ReviewService reviewService) {
		this.reviewRepository = reviewRepository;
		this.restaurantRepository = restaurantRepository;
		this.reviewService = reviewService;
	}
	
	@GetMapping("/{id}")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		Page<Review> reviewPage = reviewRepository.findByRestaurantId(id, pageable);
		if (userDetailsImpl != null) {
			User user = userDetailsImpl.getUser();
			model.addAttribute("user", user);
		}
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("reviewPage", reviewPage);
		
		return "reviews/index";
	}
	
	@GetMapping("/{id}/register")
	public String register(@PathVariable(name = "id") Integer id, Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		model.addAttribute("reviewRegisterForm", new ReviewRegisterForm());
		model.addAttribute("restaurant", restaurant);
		return "reviews/register";
	}
	
	@PostMapping("/{id}/create")
	public String create(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, ReviewRegisterForm reviewRegisterForm, BindingResult bindingResult, Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		User user = userDetailsImpl.getUser();
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewRegisterForm", reviewRegisterForm);
			model.addAttribute("restaurant", restaurant);
			return "reviews/register";
		}
		
		reviewRegisterForm.setRestaurantId(restaurant);
		reviewRegisterForm.setUserId(user);
		
		reviewService.create(reviewRegisterForm);
		redirectAttributes.addFlashAttribute("successMessage", "レビューを投稿しました");
		
		return "redirect:/reviews/{id}";
	}
	
	@GetMapping("{id}/edit")
	public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		User user = userDetailsImpl.getUser();
		
		Review review = reviewRepository.getByRestaurantIdAndUserId(restaurant.getId(), user.getId());
		
		ReviewEditForm reviewEditForm = new ReviewEditForm(review.getId(), review.getRestaurant(), review.getUser(), review.getReviewScore(), review.getReviewComment());
		
		model.addAttribute("reviewEditForm", reviewEditForm);
		model.addAttribute("review", review);
		
		return "reviews/edit";
	}
	
	@PostMapping("/{id}/update")
	public String update(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, @ModelAttribute @Validated ReviewEditForm reviewEditForm, BindingResult bindingResult, Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		User user = userDetailsImpl.getUser();
		
		Review review = reviewRepository.getByRestaurantIdAndUserId(restaurant.getId(), user.getId());
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewEditForm", reviewEditForm);
			model.addAttribute("review", review);
			return "reviews/edit";
		}
		
		reviewService.update(reviewEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "レビューを編集しました。");
		
		Integer url = review.getRestaurant().getId();
		String redirectUrl = String.format("redirect:/reviews/%d", url);
		return redirectUrl;
	}
	
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		Review review = reviewRepository.getReferenceById(id);
		Integer url = review.getRestaurant().getId();
		
		reviewRepository.deleteById(id);
		
		redirectAttributes.addFlashAttribute("successMessage", "レビューを削除しました。");
		
		String redirectUrl = String.format("redirect:/reviews/%d", url);
		return redirectUrl;
	}
}
