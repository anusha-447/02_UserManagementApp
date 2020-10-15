package com.app.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public Boolean saveUser(User user) {
    UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user,userEntity);
		UserEntity userSaved = urepo.save(userEntity);
		return userSaved.getUserId()!=null?true:false; 
		
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
	public Boolean sendRegSuccessEmail(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRegSuccessEmail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTempPassword() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz"; 

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(6); 

		for (int i = 0; i < 6; i++) { 

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index = (int)(AlphaNumericString.length()* Math.random()); 
			// add Character one by one in end of sb 
			sb.append(AlphaNumericString.charAt(index)); 
					 
		} 

		return sb.toString(); 
	}

	@Override
	public Boolean isTempPwdValid(String email, String temPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean unlockAccount(String emial, String tempPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginCheck(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recoverPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecoverPwdEmailBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendPwdToEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}



}
