package com.recharge.login.Controller;

import com.recharge.login.entity.User;
import com.recharge.login.payload.LoginDto;
import com.recharge.login.payload.LoginResponseDto;
import com.recharge.login.payload.UserDto;
import com.recharge.login.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class LoginController {
	private final LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	// Build Login rest Api
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
		LoginResponseDto loginResponseDto = loginService.login(loginDto);
		if (loginResponseDto.getLoginMessage().equals("Authorized")) {
			return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	}

	// Build Register rest api
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody UserDto userDto) {
		User userCreated = loginService.register(userDto);
		if (userCreated != null) {
			return new ResponseEntity<User>(userCreated, HttpStatus.OK);
		} else {
			User user=new User();
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

	}

}
