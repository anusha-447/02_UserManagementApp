package com.app.service;

import java.util.List;

import com.app.model.City;


public interface ICityService {

	
	public List<City> getAllCities();
	public List<City> getByStateId(Integer id);
	
}
