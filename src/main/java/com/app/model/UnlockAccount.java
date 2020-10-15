package com.app.model;

import lombok.Data;

@Data
public class UnlockAccount {

	private Integer accId;
	private String email;
	private String tempPw;
	private String newPw;
	private String confirmPw;
}
