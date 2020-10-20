package com.app.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.constants.AppConstants;
import com.app.model.User;
import com.app.service.IUserService;



@Controller
public class UserRegistrationController {
	@Autowired
	private IUserService uservice;
	
	@ModelAttribute
	public void loadForm(Model model) {
		User user=new User();
		model.addAttribute(AppConstants.USER,user);
		
		model.addAttribute(AppConstants.COUNTRIES,uservice.loadAllCountries());
	}
	@GetMapping("/showPage")
	public String showRegistrationPage(Model model) {
		
	 return AppConstants.REGISTRATION_VIEW;
	}
	/**
	 * for validating email
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping("/isUniqueMail")
	public @ResponseBody String validateEmail(@RequestParam("email")String email) {
		return uservice.isUniqueEmail(email)==true?AppConstants.EXISTED:AppConstants.NOT_EXISTED;
	}
	/**
	 *  
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String saveUser(User user,RedirectAttributes model) {
    Boolean isSaved=uservice.saveUser(user);
		if(isSaved) {
			model.addFlashAttribute(AppConstants.SUCCESS,"User Registerd successfully..Please Check Your Email");
			
		}
		else {
			model.addFlashAttribute(AppConstants.FAILED,"something went wrong");
		}
		return "redirect:/showPage";
		
	}
	/**
	 * to get states by country id
	 * @param countryId
	 * @return
	 */
	@GetMapping("/countryChange")
	public @ResponseBody Map<Integer,String> handleCountryChangeEvent(@RequestParam("countryId") Integer countryId) {
		
		Map<Integer,String> stateslist= uservice.getStatesByCountryId(countryId);
		
		return stateslist;
		 
	}
	/**
	 * to get cities based on stateid
	 * @param stateId
	 * @return
	 */
	@GetMapping("/stateChange")
	public @ResponseBody Map<Integer,String> handleStateChangeEvent(@RequestParam("stateId") Integer stateId) {
		 Map<Integer,String> cities=uservice.getCitiesByStateId(stateId);
		return cities;
	}
}
