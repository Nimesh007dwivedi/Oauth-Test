package com.api.postgress.main.files;

public class ApplicationObjectFactory {
	public static UserLoginDO getUserLoginDOFromPO(UserDetailPO userDetail) {
		UserLoginDO resp = new UserLoginDO();
//	    resp.setId(userDetail.getId());
		resp.setEmailId(userDetail.getEmailId());
		resp.setFullName(userDetail.getFullName());
		resp.setMobileNumber(userDetail.getMobileNumber());
		resp.setMobileVerified(false);
		resp.setPassword(userDetail.getPassword());
		resp.setUserId(userDetail.getUserId());
		resp.setUserName(userDetail.getUserName());
	
		return resp;
	}

	public static UserDetailPO getUserDetailPOFromDO(UserLoginDO userData) {
		UserDetailPO resp = new UserDetailPO();
		resp.setEmailId(userData.getEmailId());
		resp.setFullName(userData.getFullName());
		
		
		resp.setPassword(userData.getPassword());
		resp.setUserId(userData.getUserId());
		resp.setUserName(userData.getUserName());
		return resp;
	}
}
