package com.app.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.User;
import com.app.service.IUserService;



@Controller
public class UserRegistrationController {
	@Autowired
	private IUserService uservice;
	
	@GetMapping("/showPage")
	public String showRegistrationPage(Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("countries",uservice.loadAllCountries());
	
	
		
        return "UserRegistration";
	}
	/**
	 * for validating email
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/isUniqueMail")
	public @ResponseBody String validateEmail(@RequestParam("email")String email) {
		String resp="";
		return resp;
	}
	/**
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String saveUser(User user,Model model) {
		user.setAccountStatus("LOCKED");
		user.setUserPassword(uservice.generateTempPassword());
		uservice.saveUser(user);
		
		return "UserRegistration";
	}
	/**
	 * to get states by country id
	 * @param countryId
	 * @return
	 */
	@GetMapping("/countryChange")
	public @ResponseBody Map<Integer,String> handleCountryChangeEvent(@RequestParam("countryId") Integer countryId) {
		 Map<Integer,String> states=uservice.getStatesByCountryId(countryId);
		 states.forEach((k, v) -> {
				System.out.println("Key: " + k + ", Value: " + v);
			});
					return states;
		 
	}
	/**
	 * to get cities based on stateid
	 * @param stateId
	 * @return
	 */
	@GetMapping("/stateChange")
	public @ResponseBody Map<Integer,String> handleStateChangeEvent(@RequestParam("stateId") Integer stateId) {
		 Map<Integer,String> sates=new HashMap<Integer,String>();
		return sates;
	}
}
