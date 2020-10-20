package com.app.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.constants.AppConstants;
import com.app.entity.CityEntity;
import com.app.entity.CountryEntity;
import com.app.entity.StateEntity;
import com.app.entity.UserEntity;
import com.app.model.User;
import com.app.repo.CityRepository;
import com.app.repo.CountryRepository;
import com.app.repo.StateRepository;
import com.app.repo.UserRepository;
import com.app.service.IUserService;
import com.app.util.EmailUtil;


@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private CountryRepository crepo;
	@Autowired 
	private StateRepository srepo;
	@Autowired 
	private CityRepository cityrepo;
	@Autowired
	private UserRepository urepo;
	@Autowired
	private EmailUtil emailUtil;
	@Override
	public Boolean saveUser(User user) {
		Boolean isSentSuccess=false;
		user.setAccountStatus(AppConstants.LOCKED);
		user.setUserPassword(generateTempPassword());
        UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user,userEntity);
		
		UserEntity userSaved = urepo.save(userEntity);
		if(userSaved.getUserId()!=null) {
			
		isSentSuccess=getRegSuccessEmail(user.getUserEmail(),AppConstants.SUBJECT,sendRegSuccessEmail(user));
		}
		return isSentSuccess;
		
	}

	@Override
	public Boolean isUniqueEmail(String email) {
		// TODO Auto-generated method stub
		UserEntity userObj=urepo.findByUserEmail(email);
		return userObj!=null?true:false;
	}

	@Override

	public Map<Integer, String> loadAllCountries() {
		Map<Integer,String> countries=new HashMap<Integer,String>();
		List<CountryEntity> countryEntities=crepo.findAll();
        countryEntities.forEach(entity->{
        countries.put(entity.getCountryId(),entity.getCountryName());

		});

		return countries;
	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {
		Map<Integer,String> countries=new HashMap<Integer,String>();
		List<StateEntity> statesEntities=srepo.findByCountryId(countryId);
		statesEntities.forEach(entity->{
        countries.put(entity.getStateId(),entity.getStateName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {
		Map<Integer,String> cities=new HashMap<Integer,String>();
		List<CityEntity> cityEntities=cityrepo.findByStateId(stateId);
		cityEntities.forEach(entity->{
        cities.put(entity.getCityId(),entity.getCityName());
		});
        return cities;
	}

	@Override
	public String sendRegSuccessEmail(User user) {
		String mailBody=null;
		List<String> replacedLines=null;
		try {
			
			Stream<String> fileData = Files.lines(Paths.get("UNLOCK-MSG"));
			replacedLines=fileData.map(line->
			line.replace("{FNAME}",user.getFirstName())
			.replace("{LNAME}", user.getLastName())
			.replace("{TEMP-PWD}",user.getUserPassword())
			.replace("{EMAIL}", user.getUserEmail())).collect(Collectors.toList());
			mailBody = String.join("", replacedLines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mailBody;
	}

	@Override
	public Boolean getRegSuccessEmail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		
		return emailUtil.sendMail(to, subject, body) ;
	}

	@Override
	public String generateTempPassword() {
		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(AppConstants.PW_LENGHT); 

		for (int i = 0; i < AppConstants.PW_LENGHT; i++) { 

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index = (int)(AppConstants.ALPHA_NUMERIC_STRING.length()* Math.random()); 
			// add Character one by one in end of sb 
			sb.append(AppConstants.ALPHA_NUMERIC_STRING.charAt(index)); 
					 
		} 

		return sb.toString(); 
	}

	@Override
	public Boolean isTempPwdValid(String email, String temPwd) {
		UserEntity getUser=urepo.findByUserEmailAndUserPassword(email,temPwd);
		return getUser!=null?true:false;
	}

	@Override
	public Boolean unlockAccountForUser(String email, String pwd) {
		UserEntity entity=urepo.findByUserEmail(email);
		entity.setAccountStatus(AppConstants.UN_LOCKED);
		entity.setUserPassword(pwd);
		UserEntity getUser=urepo.save(entity);
		return getUser.getUserId()!=null?true:false;
	}

	@Override
	public String loginCheck(String email, String pwd) {
		UserEntity entity=urepo.findByUserEmailAndUserPassword(email, pwd);
		if(entity==null) {
			return AppConstants.IN_VALID;
		}
		else if(entity!=null && (entity.getAccountStatus()).equals(AppConstants.LOCKED)) {
			return AppConstants.LOCKED;
		}
	
	    else {
		return AppConstants.VALID;
	}
	}
	@Override
	public String recoverPassword(String email) {
		UserEntity userEntity=urepo.findByUserEmail(email);
		
		if(userEntity!=null) {
			
			User user=new User();
			BeanUtils.copyProperties(userEntity,user);
			
		    sendPwdToEmail(email, AppConstants.SUBJECT_FOR_RECOVERPW,getRecoverPwdEmailBody(user));
			return AppConstants.VALID;
		}
		else 
		{
		return AppConstants.IN_VALID;
		}
	}

	@Override
	public String getRecoverPwdEmailBody(User user) {
		String mailBody=null;
		List<String> replacedLines=null;
		try {
			
			Stream<String> fileData = Files.lines(Paths.get("FORGOT-PASSWORD"));
			replacedLines=fileData.map(line->
			line.replace("{FNAME}",user.getFirstName())
			.replace("{LNAME}", user.getLastName())
			.replace("{PWD}",user.getUserPassword()))
			.collect(Collectors.toList());
			mailBody = String.join("", replacedLines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mailBody;
		
		
  
		
	}

	@Override
	public Boolean sendPwdToEmail(String to,String subject,String body) {
		// TODO Auto-generated method stub
		return emailUtil.sendMail(to, subject, body);
	}

public String disableLinkToAfterUnlock(String email) {
	UserEntity userEntity=urepo.findByUserEmail(email);
	if((userEntity.getAccountStatus()).equals(AppConstants.UN_LOCKED )) {
		return AppConstants.UN_LOCKED;
	}
	else {
		return AppConstants.LOCKED;
	}
	
}

}
