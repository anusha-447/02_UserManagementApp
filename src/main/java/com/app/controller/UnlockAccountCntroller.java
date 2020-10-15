package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.UnlockAccount;

@Controller
public class UnlockAccountCntroller {

	@GetMapping("/unlock")
	public String showUnlockAccountPage(@RequestParam("email") String email) {
		return "UnlockAccount";
		
	}
	@PostMapping("/")
	public  String  handleUnlockAccount(UnlockAccount unlock) {
		return "UnlockAccount";
	}
}
