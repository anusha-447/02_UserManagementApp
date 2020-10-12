package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.app.model.User;



@Controller
public class UserController {
	
	@GetMapping("/showPage")
	public String showRegistrationPage() {
		

		System.out.println("=================");
		return "UserRegistration";
	}
	
	@GetMapping("/welcome")
	public String showRegistrationPage2() {
		
		
		System.out.println("=================");
		return "hello";
	}
	
}
