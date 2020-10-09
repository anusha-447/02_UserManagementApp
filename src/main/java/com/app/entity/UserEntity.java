package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_account")
@Data
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer userId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="account_status")
	private String accountStatus;
	@Column(name="gender")
	private String Gender;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="contact_num")
	private String contactNo;
	@Column(name="user_pw")
	private String userPassword;
	@Column(name="dob")
	private String dob;
	@Column(name="state_id")
	private Integer stateId;
	@Column(name="city_id")
	private Integer cityId;
	@Column(name="country_id")
	private Integer countryId;
	@Column(name="created_date")
	private String createdDate;
	@Column(name="updated_date")
	private String updatedDate;

}
