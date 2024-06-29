package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Job;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.UserEditForm;
import com.example.nagoyameshi.repository.JobRepository;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	private final UserRepository userRepository;
	private final UserService userService;
	private final JobRepository jobRepository;
	
	public AdminUserController(UserRepository userRepository, UserService userService, JobRepository jobRepository) {
		this.userRepository = userRepository;
		this.userService = userService;
		this.jobRepository = jobRepository;
	}
	
	@GetMapping("")
	public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword) {
		Page<User> userPage;
		
		if (keyword != null && !keyword.isEmpty()) {
			userPage = userRepository.findByNameLike("%" + keyword + "%", pageable);
		} else {
			userPage = userRepository.findAll(pageable);
		}
		
		model.addAttribute("userPage", userPage);
		model.addAttribute("keyword", keyword);
		
		return "admin/user/index";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		User user = userRepository.getReferenceById(id);
		UserEditForm userEditForm = new UserEditForm(user.getId(), user.getName(), user.getRuby(), user.getPostNumber(), user.getAddress(), user.getPhoneNumber(), user.getBirthday(), user.getJob(), user.getEmail());
		List<Job> job = jobRepository.findAll();
		
		model.addAttribute("userEditForm", userEditForm);
		model.addAttribute("job", job);
		
		return "admin/user/edit";
	}
	
	@PostMapping("/{id}/update")
	public String update(@ModelAttribute @Validated UserEditForm userEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "admin/user/edit";
		}
		
		userService.update(userEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "店舗を編集しました。");
		
		return "redirect:/admin/user";
	}
	
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		userRepository.deleteById(id);
		
		redirectAttributes.addFlashAttribute("successMessage", "店舗を削除しました。");
		
		return "redirect:/admin/user";
	}
}