package com.app.service;


import java.util.List;
import java.util.Map;


import com.app.model.User;

public interface IUserService {
	//registration screen methods
	
	public Boolean saveUser(User user);
	
	public Boolean isUniqueEmail(String email);
	
//	public Boolean updateUser(User user);
	
	public Map<Integer,String> loadAllCountries();
	
	public Map<Integer,String> getStatesByCountryId(Integer countryId);
	
	public Map<Integer,String> getCitiesByStateId(Integer stateId);
	
	public Boolean sendRegSuccessEmail(User user);
	
    public String getRegSuccessEmail(String to,String subject,String body);
    
    public String generateTempPassword();
    //unlock screen methods
   
    public Boolean isTempPwdValid(String email,String temPwd);
    
    public Boolean unlockAccount(String emial,String tempPwd);
	//Sign-In screen methods
	
	public String loginCheck(String email,String pwd);
	
	//forgot password screen methods
	public String recoverPassword(String email);
	
	public String getRecoverPwdEmailBody();
	
	public String sendPwdToEmail(String email);

}
