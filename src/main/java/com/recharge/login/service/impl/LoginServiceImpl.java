package com.recharge.login.service.impl;


import java.util.Optional;

import com.recharge.login.payload.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
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

	public boolean login(LoginDto loginDto) {
		Optional<User> u = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		return u.isPresent();
	}

	@Override
	public User register(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setAdmin(userDto.isAdmin());
		User userCreated = userRepository.save(user);
		userCreated.setPassword("N/A");
		 return userCreated;
	}
}
