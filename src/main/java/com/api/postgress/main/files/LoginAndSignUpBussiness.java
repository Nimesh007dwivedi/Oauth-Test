package com.api.postgress.main.files;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("loginAndSignUpBussiness")
public class LoginAndSignUpBussiness {


	//private static final Logger LOGGER = LoggerFactory.getLogger(LoginAndSignUpBussiness.class);
	
//	private static final String  workingDir = System.getProperty("user.dir");
	
	@Autowired private UserDetailDAO userDetailDAO;
	

	public UserDetailPO userSignUp(UserDetailPO userDetail) {
	//	UserLoginDO userData= new UserLoginDO();
		UserDetailPO resp = new UserDetailPO();
//		if(userDetail.getUserId()==null) {
//			if(userDetailDAO.isEmailIdExist(userDetail.getEmailId())) {
//				return resp;
//			}else {
//				String userId = CommonUtility.randomAlphaNumeric(12);
//				userDetail.setUserId(userId);
//			}
		UserLoginDO userData = ApplicationObjectFactory.getUserLoginDOFromPO(userDetail);	
//		} else {
//			UserLoginDO userLoginDetail = userDetailDAO.getUserLoginDetailByUserId(userDetail.getUserId());
//			if(userLoginDetail!=null) {
//				if(userDetail.getUserName()!=null) {
//					userLoginDetail.setUserName(userDetail.getUserName());
//					userLoginDetail.setPassword(userDetail.getPassword());
//					userLoginDetail.setEmailId(userDetail.getEmailId());
//					userLoginDetail.setMobileNumber(userDetail.getMobileNumber());
//					
//					userData=userLoginDetail;
//				}
	//			 userData = ApplicationObjectFactory.getUserLoginDOFromPO(userDetail);	
		
//	}
//		}
		if(userData!=null) {
			userDetailDAO.saveUserLoginDetail(userData);
			return userDetail;
		}

			return resp;
	}
	
	
	public List<UserLoginDO> userLogin(UserDetailPO userDetail) {
//		UserDetailPO resp = new UserDetailPO();
		List<UserLoginDO> userData = userDetailDAO.getUserLoginDetailByUserNamePassword(userDetail.getUserName(),userDetail.getPassword());
		return userData;
//		if(userData!=null) {
//			resp = ApplicationObjectFactory.getUserDetailPOFromDO(userData);
//		}
//		return resp;
	}
	public UserDetailPO socialLogin(UserDetailPO userDetail) {
		UserDetailPO resp = new UserDetailPO();
		if(userDetailDAO.isEmailIdExist(userDetail.getEmailId())) {
			return ApplicationObjectFactory.getUserDetailPOFromDO(userDetailDAO.getUserLoginDetailByEmail(userDetail.getEmailId()));
		}
		return resp;
	}


	public void userDelete(String userId) {
		 userDetailDAO.userDelete(userId);

	}
}
