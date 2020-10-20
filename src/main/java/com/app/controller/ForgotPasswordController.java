package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.constants.AppConstants;
import com.app.service.IUserService;

@Controller
public class ForgotPasswordController {
	@Autowired
	private IUserService uservice;
	
	@GetMapping("/forgotpw")
	public String showForgotPwPage() {
		return AppConstants.FORGOT_PW_VIEW;
	}
	/**
	 * to get the password From forgot password screen
	 * @param email
	 * @return
	 */
    @PostMapping("/sendPw")
	public  String handleForgotpwSub(HttpServletRequest req, Model model) {
    	String email=req.getParameter(AppConstants.EMAIL);
    	String recoverPassword=uservice.recoverPassword(email);
    	if(recoverPassword.equals(AppConstants.VALID)) {
    		model.addAttribute(AppConstants.SUCCESS, "Password Sent to Your Email");
    	}
    	else {
    		model.addAttribute(AppConstants.FAILED, "Please Enter Registered Email");
    	}
    	
    	return AppConstants.FORGOT_PW_VIEW;
	}



}