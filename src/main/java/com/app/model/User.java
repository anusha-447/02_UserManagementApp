package com.app.model;

import lombok.Data;

@Data
public class User {
	
	
	private Integer userId;
	
	private String firstName;

	private String lastName;
	
	private String accountStatus;
	
	private String Gender;

	private String userEmail;
	
	private String contactNo;

	private String userPassword;
	
	private String dob;
	
	private Integer stateId;
	
	private Integer cityId;
	
	private Integer countryId;
	
	private String createdDate;
	
	private String updatedDate;

}
