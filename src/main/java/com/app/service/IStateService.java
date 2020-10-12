package com.app.service;

import java.util.List;

import com.app.model.State;

public interface IStateService {
	
	public List<State> getAllStates();
	public List<State> getStatesByCountryId(Integer id);

}
