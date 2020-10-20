package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.constants.AppConstants;
import com.app.model.User;
import com.app.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private IUserService uservice;
	
	@GetMapping("/loadLogin")
	public String loginCheck(Model model) {
		User user=new User();
		model.addAttribute(AppConstants.USER,user);
		return AppConstants.VIEW_LOGIN;
	}
    @PostMapping("/login")
	public String subLoginDetails(HttpServletRequest req, Model model) {
    	String email=req.getParameter("userEmail");
    	String passwrd=req.getParameter("userPassword");
    	String loginCheck=uservice.loginCheck(email, passwrd);
    	
    	if(loginCheck.equals(AppConstants.LOCKED)) {
    		model.addAttribute(AppConstants.LOCKED,"Please Unlock Your Account");
    		return AppConstants.VIEW_LOGIN;    	}
    	else if(loginCheck.equals(AppConstants.IN_VALID)) {
    		System.out.println(loginCheck);
    		model.addAttribute(AppConstants.IN_VALID,"Please enter valid Credentials");
    		return AppConstants.VIEW_LOGIN;
    	}
    	else {
    		
    		return AppConstants.DASHBOARD;
    	}
		
	}
	
}
