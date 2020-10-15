package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForgotPasswordController {
	
	@GetMapping("/forgotpw")
	public String showForgotPwPage() {
		return "ForgotPassword";
	}
	/**
	 * to get the password From forgot password screen
	 * @param email
	 * @return
	 */
    @PostMapping("/sendPw")
	public  String handleForgotpwSub(@RequestParam("email") String email) {
		return "";
	}



}