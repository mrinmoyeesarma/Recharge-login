package com.recharge.login.service.impl;

import java.util.Optional;

import com.recharge.login.payload.LoginDto;
import com.recharge.login.payload.LoginResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recharge.login.entity.User;
import com.recharge.login.payload.UserDto;
import com.recharge.login.repository.UserRepository;
import com.recharge.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepository userRepository;

//	public LoginServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}

	public LoginResponseDto login(LoginDto loginDto) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<User> u = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if (u.isPresent()) {
			User user = u.get();
			loginResponseDto.setLoginMessage("Authorized");
			loginResponseDto.setAdmin(user.isAdmin());
		} else {
			loginResponseDto.setLoginMessage("UnAuthorized");
			loginResponseDto.setAdmin(false);
		}
		return loginResponseDto;
	}

	@Override
	public User register(UserDto userDto) {
		if (userRepository.findByUsername(userDto.getUsername()).isEmpty()) {
			User user = new User();
			user.setName(userDto.getName());
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			user.setAdmin(userDto.isAdmin());
			User userCreated = userRepository.save(user);
			userCreated.setPassword("N/A");
			return userCreated;
		}
		else {
		      User user = null;
			  return user;

		}
		
	}
}
