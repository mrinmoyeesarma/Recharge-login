package com.recharge.login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.login.entity.User;
import com.recharge.login.payload.UserDto;
import com.recharge.login.service.LoginService;
import com.recharge.login.service.impl.LoginServiceImpl;

@RestController
@RequestMapping("api/login")
public class LoginController {
//	@Autowired
//	private LoginService loginService;
	@Autowired
	private LoginServiceImpl loginService;

//	public LoginController(LoginService loginService) {
//		this.loginService = loginService;
//	}

//	 Build Login rest Api
	@PostMapping("/login")
	public String login(@RequestBody UserDto user) {
		return loginService.login(user);

	}

	// Build Register rest api
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody UserDto userDto) {
		User userCreated = loginService.register(userDto);
		return new ResponseEntity<>(userCreated, HttpStatus.CREATED);

	}
}
