package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.constants.AppConstants;
import com.app.model.UnlockAccount;
import com.app.service.IUserService;

@Controller
public class UnlockAccountCntroller {
	@Autowired
	private  IUserService userService;

	@GetMapping("/unlock")
	public String showUnlockAccountPage(@RequestParam("email") String email,Model model) {
		String isLocked=userService.disableLinkToAfterUnlock(email);
		if(isLocked.equals(AppConstants.LOCKED)) {
		UnlockAccount unlock=new UnlockAccount(); 
		unlock.setEmail(email);
		model.addAttribute(AppConstants.USERACCOUNT,unlock);
		return AppConstants.UNLOCK_ACC_VIEW;
		}
		else {
			return AppConstants.SHOW_INFO;
		}
		
	}
	@PostMapping("/unlockAccountUser")
	public  String  handleUnlockAccount(@ModelAttribute("userAcc")UnlockAccount userAcc ,String email, String tempPwd,Model model) {
		
		Boolean isPwdValid=userService.isTempPwdValid(userAcc.getEmail(), userAcc.getTempPw());
		
		if(isPwdValid) {
			userService.unlockAccountForUser(userAcc.getEmail(), userAcc.getNewPw());
			model.addAttribute(AppConstants.SUCCESS, "Please login" );
			
		
			return "redirect:/loadLogin";
			
		}
		else {
			model.addAttribute(AppConstants.FAILED, "Please Enter Yout Temporary password");
			

		}
		return AppConstants.UNLOCK_ACC_VIEW;
	}
}
