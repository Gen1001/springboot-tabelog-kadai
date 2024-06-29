package com.example.nagoyameshi.controller;

 import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Job;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.JobRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.UserService;

 @Controller
public class HomeController {
	 private final UserService userService;
	 private final RestaurantRepository restaurantRepository;
	 private final UserRepository userRepository;
	 private final JobRepository jobRepository;
	 
	 public HomeController(UserService userService, RestaurantRepository restaurantRepository, UserRepository userRepository, JobRepository jobRepository) {
		 this.userService = userService;
		 this.restaurantRepository = restaurantRepository;
		 this.userRepository = userRepository;
		 this.jobRepository = jobRepository;
	 }
	 
     @GetMapping("/")
     public String index() {
         return "restaurants";
     }   
     
     @GetMapping("/premium")
     public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, RedirectAttributes redirectAttributes, Model model) {
    	 Integer subscribeId = userDetailsImpl.getUser().getId();
    	 
    	 userService.roleChange(subscribeId);
    	 model.addAttribute("successMessage", "決済が完了しました。");
    	 
    	 return "restaurants";
     }
     

 	@GetMapping("/admin")
 	public String index(Model model) {
 		List<Restaurant> restaurant = restaurantRepository.findAll();
 		List<User> userAll = userRepository.findAll();
 		List<User> userGeneral = userRepository.findByRoleId(1);
 		List<User> userPremium = userRepository.findByRoleId(2);
 		List<Job> job = jobRepository.findAll();
 		List<Integer> jobGraph = new ArrayList<Integer>();
 		List<Integer> ageGraph = new ArrayList<>(Collections.nCopies(7, 0));
 		List<Integer> roleGraph = new ArrayList<Integer>();
 		List<Integer> seasonGraph = new ArrayList<>(Collections.nCopies(12, 0));
 		
 		//職種別グラフ
 		for (Job j : job) {
 	        List<User> usersByJob = userRepository.findByJobIdAndRoleId(j.getId(), 2);
 	        if (!usersByJob.isEmpty()) {
 	        	int percentage = (int) ((double) usersByJob.size() / userPremium.size() * 100);
 	        	jobGraph.add(percentage);
 	        } else {
 	        	jobGraph.add(0);
 	        }
 	    }
 		
 		//年齢別グラフ
 		for (User u : userPremium) {
 			LocalDate birthday = u.getBirthday();
 			int age = calculateAge(birthday);
 			if (age >= 70) {
 				int silver = ageGraph.get(6) + 1;
 				ageGraph.set(6, silver);
 			} else {
	 			for (int i = 1; i < ageGraph.size(); i++) {
	 				if (i * 10 <= age && age < (i + 1) * 10) {
	 					int number = ageGraph.get(i - 1) + 1;
	 					ageGraph.set(i - 1, number);
	 				
	 				}
	 			}
 			}
 		}
 		
 		for (int i = 0; i < ageGraph.size(); i++) {
	        int percentage = (int) ((double) ageGraph.get(i) / userPremium.size() * 100);
 			ageGraph.set(i, percentage);
 		}
 		
 		//会員別グラフ
 		int premium = (int) ((double) userPremium.size() / userAll.size() * 100);
 		int general = 100 - premium;
 		
 		roleGraph.add(general);
 		roleGraph.add(premium);
 		
 		//期間別グラフ
 		LocalDate current = LocalDate.now();
 		Integer currentYear = current.getYear();
 		
 		for (User u : userPremium) {
 			LocalDateTime localDateTime = u.getUpdatedAt().toLocalDateTime();
 			
 			int month = localDateTime.getMonthValue();
 			
 			switch(month) {
 			case 1:
 				int number1 = seasonGraph.get(0) + 1;
 				seasonGraph.set(0, number1);
 				break;
 				
 			case 2:
 				int number2 = seasonGraph.get(1) + 1;
 				seasonGraph.set(1, number2);
 				break;
 				
 			case 3:
 				int number3 = seasonGraph.get(2) + 1;
 				seasonGraph.set(2, number3);
 				break;
 				
 			case 4:
 				int number4 = seasonGraph.get(3) + 1;
 				seasonGraph.set(3, number4);
 				break;
 				
 			case 5:
 				int number5 = seasonGraph.get(4) + 1;
 				seasonGraph.set(4, number5);
 				break;
 				
 			case 6:
 				int number6 = seasonGraph.get(5) + 1;
 				seasonGraph.set(5, number6);
 				break;
 				
 			case 7:
 				int number7= seasonGraph.get(6) + 1;
 				seasonGraph.set(6, number7);
 				break;
 				
 			case 8:
 				int number8 = seasonGraph.get(7) + 1;
 				seasonGraph.set(7, number8);
 				break;
 				
 			case 9:
 				int number9 = seasonGraph.get(8) + 1;
 				seasonGraph.set(8, number9);
 				break;
 				
 			case 10:
 				int number10 = seasonGraph.get(8) + 1;
 				seasonGraph.set(9, number10);
 				break;
 				
 			case 11:
 				int number11 = seasonGraph.get(10) + 1;
 				seasonGraph.set(10, number11);
 				break;
 				
 			case 12:
 				int number12 = seasonGraph.get(11) + 1;
 				seasonGraph.set(11, number12);
 				break;
 				
 			}
 		}

 		model.addAttribute("restaurant", restaurant);
 		model.addAttribute("jobGraph", jobGraph);
 		model.addAttribute("job", job);
 		model.addAttribute("ageGraph", ageGraph);
 		model.addAttribute("roleGraph", roleGraph);
 		model.addAttribute("currentYear", currentYear);
 		model.addAttribute("seasonGraph", seasonGraph);
 		
 		return "admin/index";
 	}
 	
 	public int calculateAge(LocalDate birthday) {
 		LocalDate currentDate = LocalDate.now();
 		return Period.between(birthday, currentDate).getYears();
 	}
}
