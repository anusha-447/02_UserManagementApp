package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	
	@GetMapping("/loadLogin")
	public String loginCheck() {
		return "Login";
	}
    @PostMapping("/login")
	public String subLoginDetails(HttpServletRequest req, Model model) {
		return "Login";
	}
	
}
