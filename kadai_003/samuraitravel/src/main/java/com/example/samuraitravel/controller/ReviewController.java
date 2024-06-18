package com.example.samuraitravel.controller;

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

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.form.ReviewEditForm;
import com.example.samuraitravel.form.ReviewRegisterForm;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.ReviewRepository;
import com.example.samuraitravel.security.UserDetailsImpl;
import com.example.samuraitravel.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
	private final ReviewRepository reviewRepository;
	private final HouseRepository houseRepository;
	private final ReviewService reviewService;
	
	public ReviewController(ReviewRepository reviewRepository, HouseRepository houseRepository, ReviewService reviewService) {
		this.reviewRepository = reviewRepository;
		this.houseRepository = houseRepository;
		this.reviewService = reviewService;
	}
	
	//レビュー一覧へ遷移
	@GetMapping("/{id}")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, Model model,  @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		House house = houseRepository.getReferenceById(id);
		
		Page<Review> reviewPage = reviewRepository.findByHouseId(id, pageable);
		if (userDetailsImpl != null) {
			User user = userDetailsImpl.getUser();
			model.addAttribute("user", user);
		}
		model.addAttribute("house", house);
		model.addAttribute("reviewPage", reviewPage);
		
		return "reviews/index";
	}

	//レビュー投稿画面へ遷移
	@GetMapping("/{id}/register")
	public String register(@PathVariable(name = "id") Integer id, Model model) {
		House house = houseRepository.getReferenceById(id);
		
		model.addAttribute("reviewRegisterForm", new ReviewRegisterForm());
		model.addAttribute("house", house);
		return "reviews/register";
	}
	
	//投稿結果をデータベースに譲渡
	@PostMapping("/{id}/create")
	public String create(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, @ModelAttribute @Validated ReviewRegisterForm reviewRegisterForm, BindingResult bindingResult, Model model)  {
		House house = houseRepository.getReferenceById(id);
		User user = userDetailsImpl.getUser();
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("reviewRegisterForm", reviewRegisterForm);
			model.addAttribute("house", house);
			return "reviews/register";
		}
		
		reviewRegisterForm.setHouseId(house);
		reviewRegisterForm.setUserId(user);
		
		reviewService.create(reviewRegisterForm);
		redirectAttributes.addFlashAttribute("successMessage", "レビューを投稿しました。");
		
		return "redirect:/reviews/{id}";
	}
	
	//レビュー編集画面へ遷移
		@GetMapping("{id}/edit")
		public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id, Model model) {
			House house = houseRepository.getReferenceById(id);
			
			User user = userDetailsImpl.getUser();
			
			Review review = reviewRepository.getByHouseIdAndUserId(house.getId(), user.getId());
			
			ReviewEditForm reviewEditForm = new ReviewEditForm(review.getId(), review.getHouse(), review.getUser(), review.getReviewScore(), review.getReviewDate(), review.getReviewComment());
			
			model.addAttribute("reviewEditForm", reviewEditForm);
			model.addAttribute("review", review);
			
			return "reviews/edit";
		}
	
	//編集結果をデータベースに譲渡
		@PostMapping("/{id}/update")
		public String update(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, @ModelAttribute @Validated ReviewEditForm reviewEditForm, BindingResult bindingResult, Model model) {
			
			Review review = reviewRepository.getByHouseId(id);
			
			if (bindingResult.hasErrors()) {
				model.addAttribute("reviewEditForm", reviewEditForm);
				model.addAttribute("review", review);
				return "reviews/edit";
			}
			
			reviewService.update(reviewEditForm);
			redirectAttributes.addFlashAttribute("successMessage", "レビューを編集しました。");
			
			Integer url = review.getHouse().getId();
			String redirectUrl = String.format("redirect:/reviews/%d", url);
			return redirectUrl;
		}
	
	//レビューを削除
	@PostMapping("{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		Review review = reviewRepository.getReferenceById(id);
		Integer url = review.getHouse().getId();
		
		reviewRepository.deleteById(id);
		
		redirectAttributes.addFlashAttribute("successMessage", "レビューを削除しました。");
		
		String redirectUrl = String.format("redirect:/reviews/%d", url);
		return redirectUrl;
	}
	
} 