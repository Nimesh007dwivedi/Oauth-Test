package com.api.postgress.main.files;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAndSignUpService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAndSignUpService.class);
	
	@Autowired private LoginAndSignUpBussiness loginBussiness;

	public UserDetailPO userSignUp(UserDetailPO userDetail) {
		LOGGER.info("....Login Service...");
		return loginBussiness.userSignUp(userDetail);
//		return new org.springframework.security.core.loginBussiness.userSignUp(userDetail);
	}

	public List<UserLoginDO> userLogin(UserDetailPO userDetail) {
		LOGGER.info("....Login Service...");
		return loginBussiness.userLogin(userDetail);
	}

	public UserDetailPO socialLogin(UserDetailPO userDetail) {
		LOGGER.info("....Login Service...");
		return loginBussiness.socialLogin(userDetail);
	}

	public void userDelete(String userId) {
		LOGGER.info("...delete service...");
		 loginBussiness.userDelete(userId);
	}


	
}
