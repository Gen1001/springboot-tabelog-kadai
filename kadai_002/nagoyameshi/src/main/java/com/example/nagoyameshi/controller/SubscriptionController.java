package com.example.nagoyameshi.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.event.SubscriptionEventPublisher;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.StripeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {
	private final StripeService stripeService;
	private final SubscriptionEventPublisher subscriptionEventPublisher;
	
	public SubscriptionController(StripeService stripeService, SubscriptionEventPublisher subscriptionEventPublisher) {
		this.stripeService = stripeService;
		this.subscriptionEventPublisher = subscriptionEventPublisher;
	}
	
	@GetMapping("/register")
	public String confirm(HttpServletRequest httpServletRequest, Model model) {
		String sessionId = stripeService.createStripeSession(httpServletRequest);
		
		model.addAttribute("sessionId", sessionId);
		
		return "subscriptions/confirm";
	}
	
	@GetMapping("")
	public String index() {
		
		return "subscriptions/index";
	}
	
	@PostMapping("/sendEmail")
	public String sendEmail(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		User user = userDetailsImpl.getUser();
		String requestUrl = new String(httpServletRequest.getRequestURL());
		subscriptionEventPublisher.publishSubscriptionEvent(user, requestUrl);
		redirectAttributes.addFlashAttribute("successMessage", "ご登録済みのメールアドレスに決済変更のメールを送信しました。メールに記載されているリンクをクリックし、決済情報をご変更ください。");
		
		return "redirect:/subscriptions";
	}
	
}
