package com.api.postgress.main.files;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAndSignUpController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAndSignUpController.class);
	
	@Autowired private LoginAndSignUpService loginService;
	
	@PostMapping("/signUp")
	public ResponseEntity<UserDetailPO> userSignUp(@RequestBody UserDetailPO userDetail){
		LOGGER.info("...LoginAndSignUpController...");
		LOGGER.info("...userSignUp...");
		UserDetailPO detail = loginService.userSignUp(userDetail);
		return new ResponseEntity<UserDetailPO>(detail,HttpStatus.OK);
	}
	
	
	@PostMapping("/Login")
	public ResponseEntity<List<UserLoginDO>> userLogin(@RequestBody UserDetailPO userDetail){
		LOGGER.info("...LoginAndSignUpController...");
		LOGGER.info("...userLogin...");
		List<UserLoginDO> detail = loginService.userLogin(userDetail);
		return new ResponseEntity<List<UserLoginDO>>(detail,HttpStatus.OK);
	}
	@PostMapping("/SocialLogin")
	public ResponseEntity<UserDetailPO> socialLogin(@RequestBody UserDetailPO userDetail){
		LOGGER.info("...LoginAndSignUpController...");
		LOGGER.info("...userLogin...");
		UserDetailPO detail = loginService.socialLogin(userDetail);
		return new ResponseEntity<UserDetailPO>(detail,HttpStatus.OK);
	}
	@GetMapping("/delete")
	public @ResponseBody ResponseEntity<String> userDelete(@RequestParam String userId ) {
		loginService.userDelete(userId);
	    return new ResponseEntity<String>("Chosen user Id Deleted", HttpStatus.OK);
	}
	

	
}