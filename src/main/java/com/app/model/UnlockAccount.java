package com.app.model;

import lombok.Data;

@Data
public class UnlockAccount {

	
	private String email;
	private String tempPw;
	private String newPw;
	private String confirmPw;
}
